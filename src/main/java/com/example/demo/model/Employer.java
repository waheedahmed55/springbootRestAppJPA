package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Employer {
	
	private String EmplName;
	@Id
	private int EmplId;
	private int DOB;
	public Employer() {
		
	}
	public Employer(String empName, int empId, int empDob) {
		this.EmplName = empName;
		this.EmplId = empId;
		this.DOB =  empDob;
	}

	public String getEmplName() {
		return EmplName;
	}

	public void setEmplName(String emplName) {
		EmplName = emplName;
	}

	public int getEmplId() {
		return EmplId;
	}

	public void setEmplId(int emplId) {
		EmplId = emplId;
	}

	public int getDOB() {
		return DOB;
	}

	public void setDOB(int dOB) {
		DOB = dOB;
	}
	@Override
	public String toString() {
		return "Employer [EmplName=" + EmplName + ", EmplId=" + EmplId + ", DOB=" + DOB + "]";
	}
	

}
