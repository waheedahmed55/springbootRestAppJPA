package com.restAssuredDocker.restAssuredDemoTest;

import org.testng.annotations.BeforeMethod;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.RestAssuredConfig;
import io.restassured.specification.RequestSpecification;

public class BaseTest {
	
	protected RequestSpecBuilder builder;
	protected RequestSpecification validRequest;
	RestAssuredConfig config;
	
	@BeforeMethod
	public void setUp() {
		
		builder = new RequestSpecBuilder();
		builder.setBaseUri("http://localhost:8081");
		validRequest = builder.build();
	}
	
	

}
