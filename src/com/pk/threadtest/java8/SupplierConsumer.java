package com.pk.threadtest.java8;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class SupplierConsumer {
	
	static int supliedQuantity = 0;
	
	public static void main(String[] args) {
		
		System.out.println("=============Supplier Cnnsumer with Integers===================");

		//bydefault lambdas are lazy. hence unless it gets execute variables does not modified.
		//lambda1
		Supplier<Integer> supplier = ()-> supliedQuantity++;
		System.out.println("before calling lambda, supliedQuantity="+supliedQuantity); // here it is 0
		//at this point supliedQuantity ==0 only
		
		//Lambda2
		Consumer<Integer> consumer = (consumedQunatity) -> System.out.println("consumedQunatity + supliedQuantity++=>"+consumedQunatity + supliedQuantity++);
		// a. at this point supliedQuantity ==0 only, as lambda is not executed. 
			//  b. now post call to lambda function, consumedQunatity = 1, supliedQuantity=4 so output => 5
		
		System.out.println("supplier.get()="+supplier.get());  // here it is 0, and later it increses its value
		System.out.println("post calling lambda, supliedQuantity="+supliedQuantity); // here it is 1
		System.out.println("supplier.get()="+supplier.get()); // here it is 1, and later it increases value
		System.out.println("supliedQuantity="+supliedQuantity); // here it is 2

		System.out.println("supplier.get()="+supplier.get());  // here it is 2, and later it increases value
		System.out.println("supliedQuantity + supplier.get()=>"+supliedQuantity + supplier.get());  // here 3 + 3, and later it increases value
		
		consumer.accept(1); // here it gives clal to above lambda function. 
		
		
		System.out.println("=============Supplier Consumer with Objects===================");
		Supplier<Person> personSupplier = () -> new Person(10, "Prashant", "Pune", 19000L);
		
		Consumer<Person> personConsumer = (p) -> System.out.print( p.age +", "+p.name);
		
		personConsumer.accept(personSupplier.get());
		
		System.out.println("=============With Arrays to print values - as Sysout===================");
		List<Integer> list = Arrays.asList(2, 4, 1, 6, 9, 3, 8);
		Consumer<Integer> c1 = x -> System.out.println(x);  // or x -> System.out::println;
		list.forEach(c1);

		System.out.println("=============Biconsumer with Map to print===================");
		Map<String, Integer> map = new HashMap<>();
		map.put("k1", 100);
		map.put("k2", 200);
		map.put("k3", 300);

		BiConsumer<String, Integer> biConsumer = (x, y) -> System.out.println(x + ":" + (y * 3));
		map.forEach(biConsumer);
		
		System.out.println("=============Consumer andThen()===================");
		List<Integer> list1 = Arrays.asList(2, 4, 1, 6, 9, 3, 8);
		Consumer<Integer> c11 = x -> System.out.print(x + ":");
		Consumer<Integer> c2 = x -> System.out.print(x * 5 + "-");
		Consumer<Integer> c3 = x -> System.out.println("Hello ");
		list1.forEach(c11.andThen(c2).andThen(c3));
		
		System.out.println("=============Supplier ===================");
		Supplier<String> s1 = () -> "Hello";     // lambda expression
		System.out.println(s1.get());
		Supplier<LocalDate> s2 = LocalDate::now; // method referencing
		System.out.println(s2.get());

	}

}
