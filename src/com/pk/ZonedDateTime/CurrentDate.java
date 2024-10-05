package com.pk.ZonedDateTime;

import java.time.LocalDate;
import java.time.LocalTime;

public class CurrentDate {
	
	public static void main(String[] args) {
		LocalDate date = LocalDate.now();
	    System.out.println("the current date is "+
	                        date);
	   
	    System.out.println("the current monht ="+
	    		 date.getMonth() +"monthvalue ="+date.getMonthValue());
	    
	    if(date.getMonthValue()  < 6) {
	    	System.out.println(date.getYear());
	    } else {
	    	System.out.println(String.valueOf(date.getYear() + 1));
	    }
	  
	  
	    // the current time
	    LocalTime time = LocalTime.now();
	    System.out.println("the current time is "+
	                        time);
	}

}
