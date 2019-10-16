package net.codejava;

import java.text.SimpleDateFormat;
import java.util.Scanner;

public class EmployeeWorkingHours {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println();	
		
		Scanner input = new Scanner(System.in);		
System.out.print(" Program to Calculate the working hours of an employee\n");
System.out.print("\n Enter Employee Id:\n");
String empId=input.nextLine();

System.out.print("Enter date in yyyy/MM/dd format :\n");
String currentDate =input.nextLine();

//Swipe in time
System.out.print("Enter Swipe-in Time  in HH:mm:ss format :\n");

String date1 = input.nextLine();

//Swipe out time
System.out.print("enter  Swipe out time in HH:mm:ss format: \n");
String date2 = input.nextLine();

//Print Swipe in and Swipe out time
System.out.print("Swipe in Time of"+currentDate +"" +date1+ "\n");
System.out.println("Swipe out Time of " + currentDate+ " is "+date2+"\n");
//System.out.println();

//logic to get the time from data entered
SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
java.util.Date d1 = null;
java.util.Date d2 = null;
try {
    d1 = format.parse(date1);
    d2 = format.parse(date2);

} catch (Exception e) {
    e.printStackTrace();
}
//function to find the working hours
String workingHours = getWorkingHours(d1, d2);

//function to find the over hours
String overHours = getOverHours(d1, d2);
System.out.println("Total Working Hours of Employee Id: "+empId+" on "+currentDate+" is :"+workingHours+"\n");
System.out.println("Over hours worked by Employee Id:"+empId+" on  "+currentDate +" :  "+overHours+"\n");
input.close();
System.exit(0);

}
//Function to calculate the working hours of an employee
private static String getWorkingHours(java.util.Date d1, java.util.Date d2) {

String workingHours = null;
long diff = d2.getTime() - d1.getTime();
diff = diff / 1000;

long days = diff / (24 * 60 * 60);
long hours = diff / (60 * 60) % 24;
long minutes = diff / 60 % 60;
long seconds = diff % 60;

workingHours = days + " days ";
workingHours += hours + " hours ";
workingHours += minutes + " minutes ";
workingHours += seconds + " seconds.";

//returns the working hours
return workingHours;

}

private static String getOverHours(java.util.Date t1, java.util.Date t2) {
	
	String overhours = null;
	long maxHoursPermitted= 9;
	long maxminute=0;
	long diff = t2.getTime() - t1.getTime();


	diff = diff / 1000;

	long days = diff / (24 * 60 * 60);
	long hours = diff / (60 * 60) % 24;
	long minutes = diff / 60 % 60;
	long seconds = diff % 60;


	String idealWorkingHours=null;
	idealWorkingHours="0"+maxHoursPermitted+":";
	idealWorkingHours+=maxminute+"0";
	System.out.println("ideal Working Hours daily :"+maxHoursPermitted+"hours");

	String totalHoursWorked=null;
	if(hours>9) {
		
		if( minutes >9) 
		{
			totalHoursWorked=hours+":";
			totalHoursWorked+=minutes;}
		else {

			totalHoursWorked=hours+":"+"0";
			totalHoursWorked+=minutes;
		}
		
	}
	else {
		if( minutes >9) {
			totalHoursWorked="0"+hours+":";
			totalHoursWorked+=minutes;}
		else {
			totalHoursWorked="0"+hours+":"+"0";
			totalHoursWorked+=minutes;}
	}
	
	
if (hours>9) {
	String getTimeIn = idealWorkingHours;

	
	String getTimeOut = totalHoursWorked;

	// Process data
	String sHourIn = getTimeIn.substring(0, 2);
	String sMinuteIn = getTimeIn.substring(3, 5);
	String sHourOut = getTimeOut.substring(0, 2);
	String sMinuteOut = getTimeOut.substring(3, 5);

	int sumHour = Integer.parseInt(sHourIn) - Integer.parseInt(sHourOut);
	int sumMinute = Integer.parseInt(sMinuteIn) - Integer.parseInt(sMinuteOut);

	if(sumHour < 0) {
	    sumHour =-sumHour;
	}

	if(sumMinute < 0) {
	    sumMinute =- sumMinute;
	}
overhours= sumHour +"hour(s)";
overhours+=sumMinute+"minute";
	//Display Output
	return overhours;
}
else { String conclusion="no over hours";
	return conclusion;}
}

}

