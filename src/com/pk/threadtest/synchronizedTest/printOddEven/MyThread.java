package com.pk.threadtest.synchronizedTest.printOddEven;

public class MyThread extends Thread{
	
	PrintOddEvenTest prnEvenTest;
	boolean isEvenOdd;
	
	public MyThread(PrintOddEvenTest prnEvenTest) {
		super();
		this.prnEvenTest = prnEvenTest;
	}
	int value = 1;
	@Override
	public void run() {
		for(int i = 0 ; i < 100; i ++) {
			if(i%2 == 0) {
				prnEvenTest.printEven(i);
			} else {
				prnEvenTest.printOdd(i);
			}
		}
	}
}
