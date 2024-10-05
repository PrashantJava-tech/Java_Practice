package com.pk.collection;

import java.util.Arrays;

public class StringArrays {

	public static void main(String[] args) {
		String strArray[] = {"123","456","789","abc","pqr","stu","vwx"};
		
		Arrays.stream(strArray).skip(4).forEachOrdered(x -> System.out.println(x));;
	}
}
