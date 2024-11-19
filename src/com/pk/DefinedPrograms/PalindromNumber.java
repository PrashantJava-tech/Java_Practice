package com.pk.DefinedPrograms;

import java.util.stream.IntStream;

public class PalindromNumber {
	
	public static void main(String[] args) {
		
		int number = 23432;
		
		boolean result = isPalindrom(number);
		if(result) {
			System.out.println("number is palindrom");
		}else {
			System.out.println("number is not palindrom");

		}
	}

	private static boolean isPalindrom(int number) {
		/**
			//will give intCounser range from 1 to length -- here 1, 2, 3,4 5
			IntStream.rangeClosed(1, originalString.length())
	
			//will give intCounser range from 0 to length -- here 1, 2, 3,4
			IntStream.range(1, originalString.length())
		*/
		
		String originalString = String.valueOf(number);
		String reversed = IntStream.rangeClosed(1, originalString.length())
									.mapToObj(i -> originalString.charAt(originalString.length()-i))
									.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
									.toString();
				
		System.out.println("Original="+originalString +", reversedString ="+reversed);
		System.out.println("Using compareTo() = "+originalString.compareTo(reversed));

		return originalString.equals(reversed);
	}

}
