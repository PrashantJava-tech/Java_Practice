package com.pk.threadtest.javaString;

public class StringTest {
	
	public static void main(String[] args) {
		String s1="abc";
		String s2= new String("abc");
		String s3="abc";
		String s4= new String("abc");
		String s5="  abc  ";
		
		System.out.println("=================================================");
	  System.out.println("s1==s2"+s1==s2);
	  System.out.println("s1.equals(s2)"+s1.equals(s2));
	  System.out.println("s1==s3"+s1==s3);
	  System.out.println("s2==s4"+s2==s4);
	  System.out.println("s2.equals(s4)"+s2.equals(s4));
	  System.out.println("s5.strip()"+s5.strip());
	  


	}

}
