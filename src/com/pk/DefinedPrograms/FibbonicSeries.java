package com.pk.DefinedPrograms;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class FibbonicSeries {

	public static void main(String[] args) {
		fibbo();
	}
	
	private static void fibbo() {
		int n, firstNum = 0, secNum = 1, nextNum = 0;
		ArrayList<Integer> array = new ArrayList<Integer>();

		for(int i = 1; i <= 10; i++)
        {
            System.out.println (firstNum+" ");
            nextNum = firstNum + secNum;
            firstNum = secNum;
            secNum = nextNum;
            array.add(firstNum);
        }		
		System.out.println ("Print only even numbers from fibbonicci");
		array.stream().filter(i -> i %2 ==0 ).forEach(i -> System.out.print(" "+i));

		//multiple options to add integers from Array . 
		
		int value = array.stream().filter(x -> x %2 == 0).reduce(0, (x, y) -> x+ y);
		int value1 = array.stream().filter(x -> x %2 == 0).reduce(0, Integer::sum);
		int value2 = array.stream().filter(x -> x %2 == 0).reduce(0, FibbonicSeries::add);
		int value3 = array.stream().filter(x -> x %2 == 0).collect(Collectors.summingInt(Integer::intValue));
		int value4 = array.stream().filter(x -> x %2 == 0).mapToInt(Integer:: intValue).sum();
		System.out.println ();
		System.out.println ("Print addition of all even numbers from fibbo..");
		System.out.println("value = "+value);
		System.out.println("value1 = "+value1);
		System.out.println("value2 = "+value2);
		System.out.println("value3 = "+value3);
		System.out.println("value4 = "+value4);
	}
	
	 public static int add(int a, int b) {
	        return a + b;
	 }
	
}
