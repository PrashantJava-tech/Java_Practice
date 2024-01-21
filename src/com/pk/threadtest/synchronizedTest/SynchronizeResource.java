package com.pk.threadtest.synchronizedTest;

import java.util.Iterator;

public class SynchronizeResource {

	
	public synchronized void displayResource(String name) {
		for (int i = 0; i < 10; i ++) {
			System.out.println("Hello world ");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(name);
		}
	}
}
