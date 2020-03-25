package com.wipro.performance.bean;

import java.util.Date;

public class EmployeeBean {
	public String ADID; 
	public String empName;
	public String businessUnit;
	public Date dateOfJoining;
	public float currentSalary;
	public float totalAttendance;
	public float managerRating; 
	private String computeAppraisal;
	
	public String getADID() {
		return ADID;

	}
	public void setADID(String ADID) {
		this.ADID = ADID;
	}
	public String getempName() {
		return empName;

	}
	public void setempName(String empName) {
		this.empName = empName;
	}
	public String getbusinessUnit() {
		return businessUnit;

	}
	public void setbusinessUnit(String businessUnit) {
		this.businessUnit = businessUnit;
	}
	public Date getdateOfJoining() {
		return dateOfJoining;

	}
	public void setdateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
	public float getcurrentSalary() {
		return currentSalary;

	}
	public void setcurrentSalary(float currentSalary) {
		this.currentSalary = currentSalary;
	}

	public float gettotalAttendance() {
		return totalAttendance;

	}
	public void settotalAttendance(float totalAttendance) {
		this.totalAttendance = totalAttendance;
	}
	public float getmanagerRating() {
		return managerRating;

	}
	public void setmanagerRating(float managerRating) {
		this.managerRating = managerRating;
	}
	public String getupdatedsalary() {
		return computeAppraisal;

	}

	public void setupdatedsalary(String computeAppraisal) {
		// TODO Auto-generated method stub
		this.computeAppraisal=computeAppraisal;
		
	}
	

	
}
