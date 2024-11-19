package com.pk.thread.synchronizedTest;

public class MyThread extends Thread{

	SynchronizeResource synchronizeResource;
	String name;
		
	public MyThread(SynchronizeResource synchronizeResource, String name) {
		this.synchronizeResource = synchronizeResource;
		this.name = name;
	}

	@Override
	public void run() {
		synchronizeResource.displayResource(name);
	}
}
