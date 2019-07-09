package com.restAssuredDocker.restAssuredDemoTest;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployeePojo {
	
	/*
	 * {
        "emplId": 94,
        "dob": 90,
        "emplName": "Calon"
       
    }

	 */
	@JsonProperty("emplId")
	private int emplId;
	@JsonProperty("dob")
	private int dob;
	@JsonProperty("emplName")
	private String emplName;
	public int getEmplId() {
		return emplId;
	}
	public void setEmplId(int emplId) {
		this.emplId = emplId;
	}
	public int getDob() {
		return dob;
	}
	public void setDob(int dob) {
		this.dob = dob;
	}
	public String getEmplName() {
		return emplName;
	}
	public void setEmplName(String emplName) {
		this.emplName = emplName;
	}
	public EmployeePojo(int emplId, int dob, String emplName) {
		
		this.emplId = emplId;
		this.dob = dob;
		this.emplName = emplName;
	}
	
	public EmployeePojo() {}
	
	public String toString() {
		return "Employee id: " + this.emplId + "/ Employee dob; " + this.dob + "/ Employee name; " + this.emplName;
	}

}
