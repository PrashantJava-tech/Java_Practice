package com.pk.threadtest.synchronizedTest.printOddEven;

public class PrintOddEvenTest {

	private boolean isEvenTurn = true;
	
	public void printEven(int value) {
		synchronized (this) {
			while(isEvenTurn == false) {
				try {
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("Even="+value);
			this.isEvenTurn = false;
			this.notifyAll();
		}
	}
	public void printOdd(int value) {
		synchronized (this) {
			while(isEvenTurn == true) {
				try {
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("Odd="+value);
			this.isEvenTurn = true;
			this.notifyAll();
		}
	}
	public static void main(String[] args) {
		PrintOddEvenTest printOddEvenTest = new PrintOddEvenTest();
		//printOddEvenTest.isOdd = true;
		MyThread oddthread = new MyThread(printOddEvenTest);
		oddthread.setName("ODD_THREAD");
		//oddthread.isEvenOdd = false;
		MyThread eventhread = new MyThread(printOddEvenTest);
		eventhread.setName("EVEN_THREAD");
		//eventhread.isEvenOdd = true;
		
		oddthread.start();
		eventhread.start();
	

	}
}
