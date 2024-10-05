package com.pk.thread;

public class MultiThreadingTest implements Runnable{
	
	
	public int update(int x,int y)
	  {
		//int x=a;
		//int y=b;
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//business logic and update x and y.
		return x + y;
	  }

	
	@Override
	public void run() {
		System.out.println("Thred="+Thread.currentThread().getName()+", value = "+this.update(1, 2));
		
	} 
	
	public static void main(String[] args) {
		MultiThreadingTest t1 = new MultiThreadingTest();
		MultiThreadingTest t2 = new MultiThreadingTest();
		
		Thread te1= new Thread(t1);
		Thread te2= new Thread(t2);
		te1.start();
		te2.start();
		
		
	}
}

