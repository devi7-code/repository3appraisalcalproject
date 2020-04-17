package com.wipro.performance.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import com.wipro.performance.bean.EmployeeBean;
import com.wipro.performance.entity.Service;
import com.wipro.performance.exception.InvalidADIDException;
import com.wipro.performance.exception.InvalidBUException;
import com.wipro.performance.exception.InvalidCurrentSalaryException;
import com.wipro.performance.exception.InvalidDOJException;

public class MainClass {
	
	public static void main(String[] args) throws ParseException   {
		// TODO Auto-generated method stub
		Date datetakeinput=null;
		SimpleDateFormat formatter1=new SimpleDateFormat("yyyy-MM-dd");
	Service obj1=new Service();	
EmployeeBean ebean=new EmployeeBean();
Scanner input =new Scanner(System.in);
//getting all input values
int a=10;
System.out.println("Enter the ADID:");
ebean.ADID=input.nextLine();
System.out.println("Enter the empName:");
ebean.empName=input.nextLine();
System.out.println("Enter the businessUnit:");
ebean.businessUnit=input.nextLine();
System.out.println("Enter the dateOfJoining:");
String datetake=input.nextLine();
ebean.setdateOfJoining(formatter1.parse(datetake));
System.out.println("Enter the currentSalary:");
ebean.currentSalary=input.nextFloat();
System.out.println("Enter the totalAttendance:");
ebean.totalAttendance=input.nextFloat();
System.out.println("Enter the managerRating:");
ebean.managerRating=input.nextFloat();
	// getting appraisal for all employees
		try {
			System.out.println(obj1.getAppraisalDetails(ebean));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
