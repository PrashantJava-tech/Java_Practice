package com.pk.java8;

import java.util.Optional;

public class OptionalHandling {
	
	
	
	public static void main(String[] args) {
		String ss ="";
		OptionalHandling handling = new OptionalHandling();
		Student s = handling. new Student("", "12");
		
		Optional<String> OptSs = Optional.empty();
		
		if(OptSs.isPresent()) {
			System.out.println("present");
		} else {
			System.out.println("absent");
		}
		
		/** 
		 * This will throw null pointer exception at Optional.of(ssNull); line

		String ssNull =null;
		
		Optional<String> OptSsNull = Optional.of(ssNull);
		
		if(OptSsNull.isPresent()) {
			System.out.println("present");
		} else {
			System.out.println("absent");
		} 
		**/
		
		Optional<String> ssOfNullable = Optional.empty();
		//String ssOfNullable = null		
		//Optional<String> OptssOfNullable = Optional.of(ssOfNullable); //--- wont work
		
		if(ssOfNullable.isPresent()) {
			System.out.println("present");
		} else {
			System.out.println("absent");
		}
		
		
		//=================
		 // create a Optional 
        Optional<Integer> op  = Optional.empty();//Optional.of(new Integer(10));
  
        // print value 
        System.out.println("Optional: "+ op); 
        try { 
            // apply ifPresentOrElse 
            op.ifPresentOrElse( (value) -> { System.out.println( "Value is present, its: "+ value); }, 
            					() -> { System.out.println("Value is empty"); }
            				  ); 
        } 
        catch (Exception e) { 
            System.out.println(e); 
        } 
	}
	
	class Student{
		String name;
		String age;
		
		public Student(String name, String age) {
			this.name = name;
			this.age = age;
		}
		public String getAge() {
			return age;
		}
		public String getName() {
			return name;
		}
		
	}

}
