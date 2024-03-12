package com.pk.NewJavaFeatures9_11_17;

public class StringUpdatesRunnerJava11 {
	
	public static void main(String[] args) {
		
		
		System.out.println(" ".isBlank());
		System.out.println("".isBlank());
		System.out.println(" LR ".strip());
		System.out.println(" LR ".stripLeading());
		System.out.println(" LR ".stripTrailing());
		"lines\nwithData\nhavingnumbers\nisgood".lines().forEach(System.out::println);

		System.out.println("UPPER".transform(s -> s.substring(2)));
		System.out.println("my name is%s, i am %d old".formatted("prashant", 25));
		
		String names= null;
		System.out.println(names.isBlank()); // givees details exception message with variable name
		/**
		 * Exception in thread "main" java.lang.NullPointerException: 
		 * Cannot invoke "String.isBlank()" because "names" is null
		 * at ThreadPractice/com.pk.NewJavaFeatures9_11_17.StringUpdatesRunnerJava11.main
		 * 	(StringUpdatesRunnerJava11.java:19)
		 */

	}

}
