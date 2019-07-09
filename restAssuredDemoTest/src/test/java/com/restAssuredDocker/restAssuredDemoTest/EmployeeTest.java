package com.restAssuredDocker.restAssuredDemoTest;


import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.restassured.RestAssured;
import io.restassured.config.HttpClientConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.ContentType;


public class EmployeeTest extends BaseTest{
	
	
	EmployeePojo empl = new EmployeePojo(59,45,"Boyle");
	
	@Test(priority=1)
	public void SaveEmployeeTest() throws InterruptedException 
	{

		System.out.println("Create test case");

		given(validRequest).contentType(ContentType.JSON)
		.body(empl)
		.when().post("/save")
		.then().statusCode(200)
		.log().all();
		Thread.sleep(10000);
	}
	@Test(priority=2)
	public void UpdateEmployeeTest() throws InterruptedException 
	{
		
		Thread.sleep(100000);
		System.out.println("Update test case");
		//change dob and name
		empl.setDob(67);
		empl.setEmplName("Rack");
		
		given(validRequest).contentType(ContentType.JSON)
		.body(empl)
		.when()
		.put("/update")
		.then().statusCode(200)
		.log().all();
		
		List<EmployeePojo> employees = given(validRequest)
		.when()
		.get("/getAll").then().extract().body().jsonPath().getList("",EmployeePojo.class);
		
		System.out.println("employee after update: " + empl.toString());
		
		Assertions.assertThat(employees).usingFieldByFieldElementComparator().contains(empl);	
		Thread.sleep(10000);
	}
	@Test(priority=3)
	public void GetAllEmployees() throws InterruptedException
	{
		Thread.sleep(100000);
		System.out.println("GET all employees test case");
		List<EmployeePojo> employees = given(validRequest)
				.when()
				.get("/getAll").then().extract().body().jsonPath().getList("",EmployeePojo.class);
		
		EmployeePojo firstEmployee =new EmployeePojo(1,22,"ahmed");
		
		Assertions.assertThat(employees).usingFieldByFieldElementComparator().contains(firstEmployee);
		Thread.sleep(10000);
	}
	
	@Test(priority=4)
	public void DeleteEmployeeById() throws InterruptedException {
		Thread.sleep(100000);
		given(validRequest)
		.when()
		.delete("/delete/"+empl.getEmplId())
		.then().statusCode(200);
		
		List<EmployeePojo> employees = given(validRequest)
				.when()
			
				.get("/getAll").then().extract().body().jsonPath().getList("",EmployeePojo.class);
		
		Assertions.assertThat(employees).usingFieldByFieldElementComparator().doesNotContain(empl);
	}
	
}
