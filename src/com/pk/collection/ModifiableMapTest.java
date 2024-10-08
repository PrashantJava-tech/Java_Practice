package com.pk.collection;

import java.util.ArrayList;
import java.util.List;

public class ModifiableMapTest {

	public static void main(String[] args) {
		
		List<String> names = new ArrayList<String>();
		names.add("Prashant");
		names.add("kadam");
		
		doNotChange(names); // modifiable list, in other method we can modify it
		// we can use here unmodifiableMap()
		
		System.out.println(names);
	}

	private static void doNotChange(List<String> names) {
		names.add("Pune");
	}
}
