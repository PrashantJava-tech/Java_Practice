package com.pk.PriorityQueueTEst;

import java.util.PriorityQueue;

public class PriorityQueueTest {

	
	public static void main(String[] args) {
		PriorityQueue queue = new PriorityQueue(15, new MyComparator());
		
		queue.offer("A");
		queue.offer("Z");
		queue.offer("L");
		queue.offer("B");
		
		System.out.println(queue); //[Z, B, L, A] with s2.compareTo(s1)
		System.out.println(queue); //[A, B, L, Z] with s1.compareTo(s2) in MyComparator class
 
	}
}
