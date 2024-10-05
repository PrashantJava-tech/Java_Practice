package com.pk.DefinedPrograms;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

public class IntegerArrayTests {
	
	static void print(int a[]){
	      System.out.print("Array after segregation is: ");
	      for (int i = 0; i < a.length; ++i) {
	         System.out.print(a[i] + " ");
	      }
	      System.out.println();
	   }
	   public static void main(String[] args){
		 //Way 1 - holding left index and swapping using temp varibale,
	      int a[] = { 1, 1, 0, 0, 0, 0, 1, 1 };
	      swapUsingLeftIndex(a, a.length);
	      print(a);
	      
	    //way 2 - using segregation of values and then inserting it. 
	      int a1[] = { 7, 5, 7, 5, 5, 7, 5, 5 };
	      segregating0sand1s(a1, a1.length);
	      print(a1);
	   }
	   
	   //Way 1 - holding left index and swapping using temp varibale, 
	      //this is main index holder for 0 values
	   static void swapUsingLeftIndex(int a[], int n){
	      int left = 0;
	      for (int i = 0; i < a.length; ++i) {
	    	  System.out.println(" i="+i +",left="+left +", a[i]="+a[i]+", a[left]="+a[left]);
	    	  if(a[i] == 0 ) {
	    		  int temp = a[left];   //tmp = 1
	    		  a[left] = a[i];  //a[left]=0
	    		  a[i]=temp;  //a[i]=1
	    		  ++left;
	    	  }
	      }
	   }
	   
	   
	   //way 2 - using segregation of values and then inserting it. 
	   static void segregating0sand1s(int arr[], int n){
		      int count = 0; //count no of zeros in array
		      for (int i = 0; i < n; i++) {
		      	if (arr[i] == 5)
		            count++;
		     }
		 
		     for (int i = 0; i < count; i++)
		      	arr[i] = 5; // fill the array with 0 until termination
		     for (int i = count; i < n; i++)
		      	arr[i] = 7; // fill remaining array with 1 until termination
		   }
	   

}
