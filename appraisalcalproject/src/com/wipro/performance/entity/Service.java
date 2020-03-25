package com.wipro.performance.entity;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.wipro.performance.bean.EmployeeBean;
import com.wipro.performance.exception.InvalidADIDException;
import com.wipro.performance.exception.InvalidBUException;
import com.wipro.performance.exception.InvalidCurrentSalaryException;
import com.wipro.performance.exception.InvalidDOJException;

public class Service {

SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd"); 


float hike1;
float hike2;String updatedsalary;String detail=null;String salary=null;

	public String validateData(EmployeeBean ebean) throws InvalidADIDException, InvalidBUException, InvalidCurrentSalaryException, InvalidDOJException, ParseException {

		Date date = format.parse(format.format(new Date()));
		if(ebean.getADID().matches("^[A-Za-z0-9]{6}$")==false)
			throw new InvalidADIDException();	
		else if (!ebean.getbusinessUnit().matches("(?i:.*JAVA|ORACLE|BIGDATA.*)"))
			throw new InvalidBUException();	
		else if((ebean.getdateOfJoining().equals(date))|(ebean.getdateOfJoining().after(date)))
			throw new InvalidDOJException();
		else if (ebean.getcurrentSalary()<50000)
			throw new InvalidCurrentSalaryException();
		else
		return "success";
		
	}
	
	public String computeAppraisal(EmployeeBean ebean) throws InvalidADIDException, InvalidBUException, InvalidCurrentSalaryException, InvalidDOJException, ParseException {
		
			
				if(validateData(ebean).toString().equals("success")){
					if(ebean.gettotalAttendance()>200)
						return "Invalid Attendance" ;
					else if(ebean.getmanagerRating()>5)
						return "Invalid Rating" ;
					else
					{
					if((ebean.gettotalAttendance()>=0)&&(ebean.gettotalAttendance()<=100))
						hike1=(ebean.getcurrentSalary()*0)/100;
					else if((ebean.gettotalAttendance()>=101)&&(ebean.gettotalAttendance()<=150))
						hike1=(ebean.getcurrentSalary()*5)/100;
					else 
						hike1=(ebean.getcurrentSalary()*6)/100;
					
					if(ebean.getmanagerRating()==0)
						hike2=(ebean.getcurrentSalary()*0)/100;
					else if(ebean.getmanagerRating()==1)
						hike2=(ebean.getcurrentSalary()*6)/100;
					else if(ebean.getmanagerRating()==2)
						hike2=(ebean.getcurrentSalary()*7)/100;
					else if(ebean.getmanagerRating()==3)
						hike2=(ebean.getcurrentSalary()*8)/100;
					else if(ebean.getmanagerRating()==4)
						hike2=(ebean.getcurrentSalary()*9)/100;
					else
							hike2=(ebean.getcurrentSalary()*10)/100;
float finalhike= hike1+hike2;
updatedsalary= String.valueOf(finalhike + ebean.getcurrentSalary());
					}
				}
			
		
		return updatedsalary;
		
	}
	
	public String  getAppraisalDetails(EmployeeBean ebean) throws NumberFormatException, InvalidADIDException, InvalidBUException, InvalidCurrentSalaryException, InvalidDOJException, ParseException {
		float updatedsalary;
		
		try {
			
			updatedsalary = Float.parseFloat(computeAppraisal(ebean));
			if((updatedsalary)>ebean.currentSalary) {
				((EmployeeBean) ebean).setupdatedsalary(computeAppraisal(ebean));
				detail=ebean.getupdatedsalary();
				}else {
					detail="Same as current salary";
				}
			
			
		}  catch (InvalidADIDException e) {
			// TODO Auto-generated catch block
			detail=e.toString();
		} catch (InvalidBUException e) {
			// TODO Auto-generated catch block
			detail=e.toString();
		} catch (InvalidCurrentSalaryException e) {
			// TODO Auto-generated catch block
			detail=e.toString();
		} catch (InvalidDOJException e) {
			// TODO Auto-generated catch block
			detail=e.toString();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			detail=e.toString();
		}
		salary=ebean.ADID+" : "+detail;
		return salary;
	}
}
