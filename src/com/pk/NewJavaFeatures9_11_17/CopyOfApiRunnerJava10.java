package com.pk.NewJavaFeatures9_11_17;

import java.util.ArrayList;
import java.util.List;

public class CopyOfApiRunnerJava10 {
	
	public static void main(String[] args) {
		
		List<String> names = new ArrayList<String>();
		names.add("Prashant");
		names.add("kadam");
		
		doChange(names); // modifiable list, in other method we can modify it
		System.out.println(names);
		
		List<String> copyOfList = List.copyOf(names);
		doNotChange(copyOfList); // it is un modifiable list, and throws unsupportedOperation exception
		System.out.println(copyOfList);
	}
	
	private static void doChange(List<String> names) {
		names.add("Pune");
	}

	private static void doNotChange(List<String> names) {
		names.add("Mumbai");
	}
}
