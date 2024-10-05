package com.pk.collection;

import java.util.HashMap;
import java.util.WeakHashMap;

public class WeakHashMapTest {
	
	public static void main(String[] args) throws InterruptedException {
		WeakHashMap m = new WeakHashMap();
		Temp t = new Temp();
		m.put(t, "Prashant");
		System.out.println("Demo = WeakHashMap");
		System.out.println("before key cleard by gc, m="+m);
		
		t=null;
		System.gc();
		Thread.sleep(5000);
		System.out.println("after making key as null, m="+m);

		
		System.out.println("*******Demo = HashMap, it dominates GC");
		HashMap m1 = new HashMap();
		Temp t1 = new Temp();
		m1.put(t1, "Prashant1");
		System.out.println("Demo = HashMap");
		System.out.println("before key cleard by gc, m="+m1);
		
		t1=null;
		System.gc();
		Thread.sleep(5000);
		
		System.out.println("after making key as null, m="+m1);

	}

}
class Temp{
	Temp(){}
}