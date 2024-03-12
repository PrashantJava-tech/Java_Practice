package com.pk.NewJavaFeatures9_11_17;

import java.util.List;
import java.util.function.Predicate;

public class PredicateNotRunnerJava11 {

	public static void main(String[] args) {
		//if we want to find oddnumbers from list
		//way1 - we can wrte predicate and use negate() methods from it
		List<Integer> numbers = List.of(1, 2, 3,4,5,6,7);
		Predicate<Integer> evenNumberPredicate = number -> number%2 == 0;
		System.out.println("even no:");
		numbers.stream().filter(evenNumberPredicate).forEach(System.out::println);		
		System.out.println("Odd no:");
		numbers.stream().filter(evenNumberPredicate.negate()).forEach(System.out::println);
		
		//way2 use predicate.not();
		System.out.println("even no:");
		numbers.stream().filter(PredicateNotRunnerJava11::isEven).forEach(System.out::println);
		System.out.println("Odd no: with predicate.not()");
		numbers.stream().filter(Predicate.not(PredicateNotRunnerJava11::isEven)).forEach(System.out::println);

	}

	private static boolean isEven(Integer integer1) {
		return integer1 %2 == 0;
	}
}
