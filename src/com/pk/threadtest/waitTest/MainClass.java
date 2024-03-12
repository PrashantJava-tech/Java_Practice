package com.pk.threadtest.waitTest;

public class MainClass {
	
	public static void main(String[] args) {
		
		System.out.println("Main thread started.");
		MyThread t1 = new MyThread();
		System.out.println("Child thread started.");
		t1.start();
		synchronized(t1) {
			try {
				System.out.println("Main thread waits child to finish.");

				t1.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Main thread total="+t1.total);
		}
	}

}
