package com.pk.OopsDesign;

class Person{
	
	//public int age;	---> bad practice, as public members, we can access it directly from other class
	private int age;
	
	public Person() {
	}
	
	public Person(int age) {
		this.age = age;
	}
	
	public int getAge() {
		return this.age;
	}

}

public class ClassVariblesDesignApi {
	
	public static void main(String[] args) {
		
		
		Person p = new Person();
		/**- 
		 * private members we cant access from other class directly.
		 * but public members we can access. (bad practice to keep members as public) 
		 * should access using only setters and getters. 
		 * 
		 * p.setAge(10);
		 */
		// p.age = 10;		
		System.out.println(p.getAge());;
		
	}
}
