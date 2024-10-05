package com.pk.DefinedPrograms;

public class SwapNumbersApi {
	
	public static void main(String[] args) {
		
		
		// way - 1, without temp variable (2 variables)
		int x= 10;
		int y = 20;
		System.out.println("Before swap, x="+x +", y="+y);		
		x = x+y;
		y=x-y;
		x=x-y;
		System.out.println("After swap, x="+x +", y="+y);

		System.out.println("======================================");

		// way - 2, with temp variable, (3 variables)
		int a1= 100;
		int b1 = 200;
		System.out.println("Before swap, a="+a1 +", b="+b1);
		
		int temp = a1;
		a1 = b1;
		b1= temp;
		System.out.println("After swap, a="+a1 +", b="+b1);

		
		// Way - 3 - Swapping a and b using XOR
		int a= 500;
		int b = 600;
		System.out.println("Before swap, a="+a +", b="+b);

        a = a ^ b;
		System.out.println("a^b="+a);
        b = a ^ b;
		System.out.println("a^b="+b);
        a = a ^ b;
		System.out.println("a^b="+a);

		System.out.println("After swap, a="+a +", b="+b);

	}

}
