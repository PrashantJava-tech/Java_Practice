package com.pk.threadtest.waitTest;

public class MainClass {
	
	public static void main(String[] args) {
		
		MyThread t1 = new MyThread();
		t1.start();
		synchronized(t1) {
			try {
				t1.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Main thread calling child thread.");
			System.out.println("Main thread total="+t1.total);
		}
	}

}
