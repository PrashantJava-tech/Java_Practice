package com.pk.DefinedPrograms.Array;

import java.util.Arrays;
import java.util.stream.Stream;

public class PrintArrayWay {
	
	
	public static void main(String[] args) {
		System.out.println("Print Array ways--> ");
		
		String array[] = {"one", "two", "three", "four"};
		
		//ways.
		Arrays.asList(array).forEach(elm -> System.out.print(" "+elm ));

		System.out.println("");
		Arrays.stream(array).forEach(System.out::print);
		
		System.out.println("");
		Stream.of(array).forEach(System.out::print);
		
		System.out.println("");
		for(String ss: array) {
			System.out.print(" "+ss);
		}
	}
}

