package com.pk.javaBasics;

public class TypeOfVariables {
	
	String instanceField;
	static String staticField;
	
	public void instanceMethod() {
		System.out.println("instanceFIeld="+this.instanceField);
		System.out.println("staticField="+this.staticField);
	}
	
	public static void staticMethod() {
		//Below are not accessible in static methods
		//System.out.println("instanceFIeld="+this.instanceField);
		//System.out.println("staticField="+this.staticField);
		//System.out.println("instanceFIeld="+instanceField);

		TypeOfVariables type = new TypeOfVariables();
		System.out.println("instanceFIeld="+type.instanceField);
		
		System.out.println("staticField="+staticField);
	}

	public void localMethod() {
		//private/public/protected/static/volatile/transient int localy; - invalid modifier

		final int localx;
				
		//cant use like below, unless we initilize it, compiletime exception
		//System.out.println("localx="+localx);
		
		localx = 10;	// We need to initilize local variable before use
		System.out.println("localx="+localx);
	}

	public static void main(String[] args) {
		//Default values are null..
		TypeOfVariables type = new TypeOfVariables();
		type.instanceMethod();
		staticMethod();
		
		type.localMethod();
	}
	

}
