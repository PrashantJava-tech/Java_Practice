package com.pk.DefinedPrograms;

import java.util.Scanner;

/**
 * LCM (i.e. Least Common Multiple) is the largest of the two stated numbers that can be divided by both 
 * the given numbers. In this article, we will write a program to find the LCM in Java

 * 
 * GCD is the greatest common divisor
 * Using Greatest Common Divisor
 * Below given formula for finding the LCM of two numbers ‘u’ and ‘v’ gives an efficient solution.

 */
public class LcmGcdProgram {
	
	public static void main(String[] args) {

		System.out.println("Progarem to print LCM of given number");
		System.out.println("Enter 1st number for which we want to LCM = ");
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		System.out.println("Enter 2nd number for which we want to LCM = ");
		int b = sc.nextInt();
		System.out.println("Entered number are,  = "+a +", & " + b);

		// Numbers
        //int a = 15, b = 25;
        // Checking for the smaller
        // Number between them
        int ans = (a > b) ? a : b; 
        // Checking for a smallest number that
        // can de divided by both numbers
        while (true) {
            if (ans % a == 0 && ans % b == 0)
                break;
            ans++;
        }
        // Printing the Result
        System.out.println("LCM of " + a + " and " + b
                           + " : " + ans);
	}

}
