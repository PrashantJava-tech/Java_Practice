package com.pk.DefinedPrograms.Array;

import java.util.stream.IntStream;

public class PrintAlternateNUmbersFromArray {
	
	public static void main(String[] args) {
		
		
		int [] array = {1,2,3,4,5,6,7,8,9,10};
		System.out.println("Print 1, 3, 5, 7, 9 ---> ");
		IntStream.range(0, array.length).filter(i -> i%2 == 0 ).map(i -> array[i]).forEach(System.out::print);

		System.out.println();
		
		System.out.println("Print 2,4,6,8,10 ---> ");
		IntStream.range(0, array.length).filter(i -> i%2 != 0 ).map(i -> array[i]).forEach(System.out::print);

	
	}
	

}
