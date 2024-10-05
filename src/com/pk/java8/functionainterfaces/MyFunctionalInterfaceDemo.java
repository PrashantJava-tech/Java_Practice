package com.pk.java8.functionainterfaces;


//functional interface
@FunctionalInterface
interface MyFunctionaInterface{
	void simpleOPeration();
}

//Refernce class
class Test{
	
	public static void testMethodRefernce() {
		System.out.println("Hello Logging system..");
	}
}

//client class
public class MyFunctionalInterfaceDemo {
	
	public static void main(String[] args) {
		
		MyFunctionaInterface myFunctionaInterface = Test :: testMethodRefernce;		
		myFunctionaInterface.simpleOPeration();
	}
}

