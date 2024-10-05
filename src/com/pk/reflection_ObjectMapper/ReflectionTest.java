package com.pk.reflection_ObjectMapper;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

public class ReflectionTest {
	
	public static void main(String[] args) {
		String filedName = "name";
		/**
		PropertyDescriptor pd = new PropertyDescriptor(filedName, Student.class);
		Method getter = pd.getReadMethod();
		Object f = getter.invoke(getter, null);
*/
	}

}


class Student{
	
	
	String name; 
	int age;
	String div;
	float fees;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getDiv() {
		return div;
	}
	public void setDiv(String div) {
		this.div = div;
	}
	public float getFees() {
		return fees;
	}
	public void setFees(float fees) {
		this.fees = fees;
	}
	
	
}
