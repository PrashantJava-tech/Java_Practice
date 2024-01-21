package com.pk.threadtest.java8;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Java8Test {

	public static void main(String[] args) {
		
		System.out.println("***1. finding out each charcater and its count from name");
		String name = "prashantp";
		Map<Object, Long> countWithDetails = Arrays.stream(name.split(""))
				.collect(Collectors.groupingBy(c-> c, Collectors.counting()));
		countWithDetails.forEach((s, v) -> System.out.println("k="+s +", v="+v));
		/** k=p, v=2, ....*/

		System.out.println("=================================================");
		System.out.println("***2. grouping person on basis of city");
		List<Person> personList = List.of(new Person( 15, "prashant" , "pune", 10000L), new Person( 20, "vishal" , "pune", 20000L),
										new Person( 10, "priyom" , "USA", 30000L), new Person( 25, "Monika" , "UK", 40000L));
		Map<String, Long> personDetails = personList.stream()
			.collect(Collectors.groupingBy(Person::getCity, Collectors.counting()));
		personDetails.forEach((k,v) -> System.out.println("k="+k+", v="+v));
		/** k=USA, v=1
		k=UK, v=1
		k=pune, v=2*/		
		System.out.println("=================================================");
		System.out.println("***2. grouping person on basis of city");

		Map<String, List<Person>> personDetails0 = personList.stream()
			.collect(Collectors.groupingBy(Person::getCity));
		personDetails0.forEach((k,v) -> System.out.println("k="+k+", v="+v));
		/** k=USA, v=[Person [age=10, name=priyom, city=USA, salary=30000]]
			k=UK, v=[Person [age=25, name=Monika, city=UK, salary=40000]]
			k=pune, v=[Person [age=15, name=prashant, city=pune, salary=10000], Person [age=20, name=vishal, city=pune, salary=20000]]
*/

		long sal = 1000;
		System.out.println("=================================================");
		System.out.println("***3. finding person names only,  from list of persons on basis of city");
		List<Person> personList1 = List.of(new Person( 15, "prashant" , "pune", 10000L), new Person( 15, "Jon" , "pune", 10000L), new Person( 20, "vishal" , "pune", 20000L),
										new Person( 10, "priyom" , "USA", 30000L), new Person( 25, "Monika" , "UK", 40000L));
		Map<String, List<String>> personDetails1 = personList1.stream()
			.collect(Collectors.groupingBy(Person::getCity, 
					  	Collectors.mapping(Person::getName, Collectors.toList())) // --- to map/convert object into getName  
					);
		personDetails1.forEach((k,v) -> System.out.println("k="+k+", v="+v));
		/** k=USA, v=[priyom]
		k=UK, v=[Monika]
		k=pune, v=[prashant, vishal]*/
		
		System.out.println("=================================================");
		System.out.println("***Sorted person on basis of age");
		personList1.stream()
					.sorted(Comparator.comparingInt(Person::getAge))
					.forEach(person -> System.out.println("person ="+person));
		
		System.out.println("=================================================");
		System.out.println("***Sorted person on basis of  name ");
		personList1.stream()
		.sorted((o1, o2) -> {
                return o1.getName().compareTo(o2.getName());
        }).forEach(person -> System.out.println("person ="+person));

		System.out.println("=================================================");
		System.out.println("***Sorted person on basis of age and then on basis of name incase of same age");
		personList1.stream()
		.sorted((o1, o2) -> {
            if(o1.getAge() == o2.getAge())
                return o1.getName().compareTo(o2.getName());
            else if(o1.getAge() > o2.getAge())
                return 1;
            else return -1;
        }).forEach(person -> System.out.println("person ="+person));
	
	
		System.out.println("=================================================");
		System.out.println("***4. write list of odd numbers from 1 to 10");
		
		IntStream.of(1,2,3,4,5,6,7,8,9,10).filter(e -> e%2 != 0)
											.forEach(s -> System.out.println(s));
		
		
		System.out.println("=================================================");
		int sum = IntStream.of(1, 2, 3, 4)
	              .filter(e -> e%2 ==0 )
	              .peek(e -> System.out.println("Filtered value: " + e))
	              //.map(e -> e * e)
	              .peek(e -> System.out.println("Mapped value: " + e))
	              .sum();
		System.out.println("sum="+sum);
		
		System.out.println("=================================================");
		System.out.println("Print natural numbers using Random");
		Random random = new Random();
		//random.ints(1, 11).forEach(System.out:: println);

		System.out.println("=================================================");
		System.out.println("Print even numbers using java8-");
		IntStream.of(1,2,3,4,5,6,7,8,9,10).filter(e -> e%2 != 0)
		.forEach(s -> System.out.println(s));

		System.out.println("=================================================");
		System.out.println("Seperate even & Odd numbers using java8-");
		Map<Boolean, List<Integer>> data = Arrays.asList(1,2,3,4,5,6,7,8,9,10).stream()
			.collect(Collectors.partitioningBy(e -> e % 2 == 0));
		data.entrySet().stream().forEach(item -> System.out.println("key ="+item.getKey() + ", value="+item.getValue()));

		System.out.println("=================================================");
		System.out.println("Find Max  from list-"+ IntStream.of(1,2,3,4,5,6,7,8,9,10)
			.max());
		System.out.println("Find Min from list-"+ IntStream.of(1,2,3,4,5,6,7,8,9,10)
		.min());
	

		System.out.println("=================================================");
		System.out.println("***5. finding out word and its count from string");
		String nameString = "prashant has good son has good daughter";
		Map<Object, Long> word = Arrays.stream(nameString.split(" "))
				.collect(Collectors.groupingBy(c -> c, Collectors.counting()));
		word.forEach((s, v) -> System.out.println("k="+s +", v="+v));
		

		System.out.println("=================================================");
		System.out.println("***5.1. other way-> finding out word and its count from string");
		String nameString1 = "prashant has good son has good daughter";
		Map<Object, Long> word1 = Arrays.stream(nameString1.split(" "))
				.collect(Collectors.groupingBy(Function.identity() , Collectors.counting()));
		word1.forEach((s, v) -> System.out.println("k="+s +", v="+v));
		
		
		// avg(10000+20000+30000+40000) = 100000/4 = 25000
		/**	
		public static int compare(long x, long y) {
		        return (x < y) ? -1 : ((x == y) ? 0 : 1);
		}
		Example:	
		Long x = new Long(1);
		Long y = new Long(1);
		if (Long.compare(x,y) == 0) {
		  System.out.println(values of x and y are same);
		}
		*/
		System.out.println("=================================================");
		System.out.println("avg sal way 1="+personList1.stream()
									.collect( Collectors.averagingLong(c-> c.getSalary())));
		
		System.out.println("=================================================");
		/** average of Employee salaries with DoubleStream average method */
	      System.out.printf("avg sal way 2: %.1f%n",
	    		  personList1.stream()
	             .mapToDouble(Person::getSalary)
	             .average()
	             .getAsDouble());   

		System.out.println("=================================================");
		System.out.println("Revers each word of given string");
		String sentence = "Hi am very good person";
		System.out.println(Arrays.stream(sentence.split(" "))
			.map(w -> new StringBuffer(w).reverse())
			.collect(Collectors.joining(" ")));

		
		int x = 1000;
		int y = 1000;
		System.out.println("compare INT 1000 values, (x == y) true->"+ (x==y));

		Integer x1 = 1000;
		Integer y1 = 1000;
		System.out.println("compare INTEGER 1000 values, (x1.equals(y1)) true->"+ (x1.equals(y1)));
		System.out.println("compare INTEGER 1000 values, (x == y) false->"+ (x1==y1));


		
		/** Find LCM of two numbers**/
		// Numbers
        int a = 12, b = 10;
        // Checking for the smaller
        // Number between them
        int ans = (a > b) ? a : b;
        // Checking for a smallest number that
        // can de divided by both numbers
        while (true) {
            if (ans % a == 0 && ans % b == 0)
                break;
            System.out.println("ans="+ans);
            ans++;

        }
        // Printing the Result
        System.out.println("LCM of " + a + " and " + b+ " : " + ans);
		
        // Printing the Result
        System.out.println("====================== Method Overloading");

	}

	public void method1() {
        System.out.println("====================== Method Overloading");

	}
	public void method1(int x) {
        System.out.println("====================== Method Overloading");
	}
	/** NOt allowed different return type
	public int method1() {
        System.out.println("====================== Method Overloading");
        return 10;
	}
	*/
	private void method1(int x, float y) {
        System.out.println("====================== Method Overloading");
	}
	public void method1(int x, int y) throws IOException {
        System.out.println("====================== Method Overloading");
	}
	
	
	
}
