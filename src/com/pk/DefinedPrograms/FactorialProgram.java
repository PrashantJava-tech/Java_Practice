package com.pk.DefinedPrograms;

import java.util.Scanner;

public class FactorialProgram {
	
	public static void main(String[] args) {
		
		System.out.println("Progarem to print factorial ofr given number");
		System.out.println("Enter number for which we want to calculate factorial = ");
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		System.out.println("Entered number is = "+number);
		
		int factorial = number;
		if(number!= 0) {
			for (int i = number; i > 1; i--) {				
				factorial *= (i -1);  //factorial = factorial * (i -1);
				System.out.println("intermediate factorial is = "+factorial);
				System.out.println("i = "+i);
			}
		} else {
			factorial = 0;
		}
		System.out.println("Its factorial is = "+factorial);
	}

}
