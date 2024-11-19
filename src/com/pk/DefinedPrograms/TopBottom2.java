package com.pk.DefinedPrograms;


class Top {
	
	/** to resolve compile time issue , solution 1
	 public Top() 
	{ 
		System.out.print("B");
	}*/
	
	public Top(String s) 
	{ 
		System.out.print("B");
	}
}
 
public class TopBottom2 extends Top {

	public TopBottom2(String s) 
	{ 
		super(s);    //<--- Solution 2
		System.out.print("D");
	}
	public static void main(String [] args)
	{
		/**
		 * What is the result?
			A. BD
			B. DB
			C. BDC
			D. DBC
			E. Compilation fails  <---- THis is answer
			F. run time error
		 */
		new TopBottom2("C");
		System.out.println(" ");
	}
 
}
