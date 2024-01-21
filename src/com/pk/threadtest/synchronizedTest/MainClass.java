package com.pk.threadtest.synchronizedTest;

public class MainClass {
	
	public static void main(String[] args) {
		
		SynchronizeResource synchronizeResource = new SynchronizeResource();
		
		MyThread t1 = new MyThread(synchronizeResource, "Dhoni");
		MyThread t2 = new MyThread(synchronizeResource, "Virat");
		
		t1.start();
		t2.start();
	}

}
