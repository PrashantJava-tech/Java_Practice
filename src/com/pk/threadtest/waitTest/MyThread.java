package com.pk.threadtest.waitTest;

public class MyThread extends Thread{

	int total = 0;
	
	@Override
	public void run() {
		
		synchronized (this) {
			System.out.println("child thread startes calculation.");
			for(int i = 0; i <=100; i++) {
				total = total + i;
			}
			System.out.println("total="+total);
			System.out.println("child thread calculation completed.");
			//this.notify();
		}
	}
}
