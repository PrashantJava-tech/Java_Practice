package com.pk.thread.synchronizedTest;

import java.util.Iterator;

public class SynchronizeResource {

	
	public synchronized void displayResource(String name) {
		for (int i = 0; i < 5; i ++) {
			System.out.println("Hello world ");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(name);
		}
	}
}
