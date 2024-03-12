package com.pk.NewJavaFeatures9_11_17;

import java.util.ArrayList;

public class TypeInferencesRunnerJava10 {
	
	public static void main(String[] args) {
		
		var names = new ArrayList<String>();
		names.add("prashant");
		names.add("kadam");
		
		names.forEach(System.out::println);
	}

}
