package com.pk.java8;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Java8Test {

	public static void main(String[] args) {

		countWords();
		countWordsFromString();
		reverseWords();
		findCharectersAndItsCount();
		groupingByObjectsOnBasisOfParameter();
		sortingOnBasisOfCriteria();
		numbersIntegerOper();
		mergeArray();
		LCM();
        ListToMapCOnvert();

	}

	private static void LCM() {
		
		System.out.println();
		System.out.println("========** Find LCM(Least common multiple) of two numbers**");
		// Numbers
        int a = 12, b = 10;
        // Checking for the larger Number between them
        int bigNumber = (a > b) ? a : b;
        System.out.println("smallNumber="+bigNumber);
        // Checking for a smallest number that
        // can de divided by both numbers
        while (true) {
            if (bigNumber % a == 0 && bigNumber % b == 0)
                break;
            System.out.println("ans="+bigNumber);
            bigNumber++;

        }
        // Printing the Result
        System.out.println("LCM of " + a + " and " + b+ " : " + bigNumber);
		
	}

	private static void mergeArray() {
		System.out.println("========Merging two unsorted arrays into single sorted array without duplicate calues =========================================");
		int arr[] = {7, 8,9 , 1, 2, 3, 4, 5}; 
		int brr[] = {11, 3,11 , 2, 1, 90}; 
		
		int sortedArray[] = IntStream.concat(Arrays.stream(arr), Arrays.stream(brr)).sorted().distinct().toArray();
		Arrays.stream(sortedArray).forEach(System.out::print);
	}

	private static void reverseWords() {
		
		System.out.println("=================================================");
		System.out.println("Revers each word of given string");
		String sentence = "Hi i am very good person";
		System.out.println(Arrays.stream(sentence.split(" "))
			.map(w -> new StringBuffer(w).reverse())
			.collect(Collectors.joining(" ")));
		
	//========== USing StringUtils, need to add library
		/**
		String reversed = StringUtils.reverseDelimited(StringUtils.reverse(input), ' ');
		System.out.println("Using StringUtils ="+reversed);
		*/
		
	System.out.println("==================Revers words of given string");

		List<String> listData = Arrays.stream(sentence.split(" "))
						.collect(Collectors.toList());
		Collections.reverse(listData);
		System.out.println(listData.stream().collect(Collectors.joining(" ")));
		
	}

	private static void numbersIntegerOper() {
		
		List<Person> personList = List.of(new Person( 15, "prashant" , "pune", 10000L), new Person( 20, "vishal" , "pune", 20000L),
				new Person( 10, "priyom" , "USA", 30000L), new Person( 25, "Monika" , "UK", 40000L));

		
		System.out.println("=================================================");
		System.out.println("***4. write list of odd numbers from 1 to 10");
		
		IntStream.of(1,2,3,4,5,6,7,8,9,10).filter(e -> e%2 != 0)
											.forEach(s -> System.out.println(s));
		
		
		System.out.println("============Filter and Sum of even numbers=====================================");
		int sum = IntStream.of(1, 2, 3, 4)
	              .filter(e -> e%2 ==0 )
	              .peek(e -> System.out.println("Filtered value: " + e))
	              .sum();
		System.out.println("sum="+sum);
		
		System.out.println("=================================================");
		System.out.println("Print natural numbers using Random");
		Random random = new Random();
		System.out.println("random.nextBoolean()="+random.nextBoolean());
		//random.ints(1, 11).forEach(System.out:: println); // generates continuously

		System.out.println("=================================================");
		System.out.println("Print even numbers using java8-");
		IntStream.of(1,2,3,4,5,6,7,8,9,10).filter(e -> e%2 != 0)
		.forEach(s -> System.out.println(s));

		System.out.println("=================================================");
		System.out.println("Seperate even & Odd numbers using java8- partitioningBy-");
		Map<Boolean, List<Integer>> data = Arrays.asList(1,2,3,4,5,6,7,8,9,10).stream()
			.collect(Collectors.partitioningBy(e -> e % 2 == 0));

		data.entrySet().stream().forEach(item -> 
							System.out.println("key ="+item.getKey() + ", value="+item.getValue())
						);
		
		System.out.println("Seperate even & Odd numbers using java8- groupingBy and count");
		Map<Object, Long> countWithDetails1 =Arrays.asList(1,2,3,4,5,6,7,8,9,10).stream()
			.collect(Collectors.groupingBy((e-> e%2 == 0), Collectors.counting()));
		System.out.println(countWithDetails1);

		System.out.println("==============Find Min & Max===================================");
		System.out.println("Find Max  from list-"+ 
				IntStream.of(1,2,3,4,5,6,7,8,9,10).max().getAsInt());
		
		System.out.println("Find Min from list-"+ 
				IntStream.of(1,2,3,4,5,6,7,8,9,10).min().getAsInt());
	
		System.out.println("==============Find Min & Max from arrayLIst using min/max operator  & COllectors.naturalorder===================================");
		List<Integer> numberLIst = new ArrayList<Integer>();
		numberLIst.add(10);
		numberLIst.add(15);
		numberLIst.add(5);
		System.out.println("Find Max  from list-"+ 
				numberLIst.stream().max(Comparator.naturalOrder()).get());
		System.out.println("Find Min  from list-"+ 
				numberLIst.stream().min(Comparator.naturalOrder()).get());
		
		
		System.out.println("=================================================");
		System.out.println("avg sal way 1="+personList.stream()
									.collect( Collectors.averagingLong(c-> c.getSalary())));
		
		System.out.println("=================================================");
		/** average of Employee salaries with DoubleStream average method */
	      System.out.printf("avg sal way 2: %.1f%n",
	    		  personList.stream()
	             .mapToDouble(Person::getSalary)
	             .average()
	             .getAsDouble());   

	}

	private static void sortingOnBasisOfCriteria() {

		List<Person> personList = List.of(new Person( 15, "prashant" , "pune", 10000L), new Person( 20, "vishal" , "pune", 20000L),
				new Person( 10, "priyom" , "USA", 30000L), new Person( 25, "Monika" , "UK", 40000L));

		System.out.println("=================================================");
		System.out.println("***Sorted person on basis of age");
		personList.stream()
					.sorted(
								Comparator.comparingInt(Person::getAge)
							)
					.forEach(person -> System.out.println("person ="+person));
				
		System.out.println("=================================================");
		System.out.println("***Sorted person on basis of  name ");
		personList.stream()
		.sorted(
					(o1, o2) -> {
                					return o1.getName().compareTo(o2.getName());
        						}
				)
		.forEach(person -> System.out.println("person ="+person));

		System.out.println("=================================================");
		System.out.println("***Sorted person on basis of age and then on basis of name incase of same age");
		personList.stream()
		.sorted((o1, o2) -> {
            if(o1.getAge() == o2.getAge())
                return o1.getName().compareTo(o2.getName());
            else if(o1.getAge() > o2.getAge())
                return 1;
            else return -1;
        }).forEach(person -> System.out.println("person ="+person));

	}

	private static void groupingByObjectsOnBasisOfParameter() {
		System.out.println("=================================================");
		System.out.println("*** way 1. grouping person on basis of city");
		List<Person> personList = List.of(new Person( 15, "prashant" , "pune", 10000L), new Person( 20, "vishal" , "pune", 20000L),
				new Person( 10, "priyom" , "USA", 30000L), new Person( 25, "Monika" , "UK", 40000L));

		Map<String, List<Person>> personDetails0 = personList.stream()
														.collect(Collectors.groupingBy(Person::getCity));

		personDetails0.forEach((k,v) -> System.out.println("k="+k+", v="+v));
		/** k=USA, v=[Person [age=10, name=priyom, city=USA, salary=30000]]
			k=UK, v=[Person [age=25, name=Monika, city=UK, salary=40000]]
			k=pune, v=[Person [age=15, name=prashant, city=pune, salary=10000], Person [age=20, name=vishal, city=pune, salary=20000]]
		 */

		System.out.println("=================================================");
		System.out.println("***way 2. grouping count persons on basis of city");
		Map<String, Long> personDetails = personList.stream()
													.collect(Collectors.groupingBy(
																				Person::getCity,
																				Collectors.counting()
															));
		personDetails.forEach((k,v) -> System.out.println("k="+k+", v="+v));
		/** k=USA, v=1
			k=UK, v=1
			k=pune, v=2*/	
		
		System.out.println("=================================================");
		long sal = 1000;
		System.out.println("***3. finding person names only,  from list of persons on basis of city");
		List<Person> personList1 = List.of(new Person( 15, "prashant" , "pune", 10000L), new Person( 15, "Jon" , "pune", 10000L), new Person( 20, "vishal" , "pune", 20000L),
										new Person( 10, "priyom" , "USA", 30000L), new Person( 25, "Monika" , "UK", 40000L));
		Map<String, List<String>> personDetails1 = personList1.stream()
			.collect(Collectors.groupingBy(
									Person::getCity, 
								  	Collectors.mapping(Person::getName, Collectors.toList())) 
									// --- to map/convert object into getName  
					);
		personDetails1.forEach((k,v) -> System.out.println("k="+k+", v="+v));
		/** k=USA, v=[priyom]
		k=UK, v=[Monika]
		k=pune, v=[prashant, vishal]*/


	}

	private static void countWords() {
		String nameStringCountWords = "prashant has good son has good daughter";
		long count = Arrays.stream(nameStringCountWords.split(" ")).count();
		System.out.println("word counts ="+count);
		
	}

	private static void countWordsFromString() {
		System.out.println("=================================================");
		System.out.println("***1.1 finding out word and its count from string");
		String nameString = "prashant has good son has good daughter";
		Map<Object, Long> word = Arrays.stream(nameString.split(" "))
				.collect(Collectors.groupingBy(c -> c, Collectors.counting()));
		word.forEach((s, v) -> System.out.println("k="+s +", v="+v));
		
	}

	private static void findCharectersAndItsCount() {
		System.out.println("***1. finding out each charcater and its count from name");
		String name = "prashantp";
		Map<Object, Long> countWithDetails = Arrays.stream(name.split(""))
				.collect(Collectors.groupingBy(c -> c, Collectors.counting()));
		
		countWithDetails.forEach((s, v) -> System.out.println("k="+s +", v="+v));
		/** k=p, v=2, ....*/
		
		System.out.println("=================================================");
		System.out.println("***1.2 other way-> finding out word and its count from string");
		String nameString1 = "prashant has good son has good daughter";
		Map<Object, Long> word1 = Arrays.stream(nameString1.split(" "))
				.collect(Collectors.groupingBy(Function.identity() , Collectors.counting()));
		word1.forEach((s, v) -> System.out.println("k="+s +", v="+v));

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
	
	public static void ListToMapCOnvert() {
		
		List<Person> personList = new ArrayList<Person>();
		personList.add(new Person(10, "Prashant", "Pune", 4000000l));
		personList.add(new Person(15, "Priyom", "Mumbai", 6000000l));
		personList.add(new Person(20, "Prisha", "USA", 7000000l));
		personList.add(new Person(25, "Monika", "Pune", 5000000l));
		
		Map<String, Long> personMap = personList.stream()
					.sorted(Comparator.comparingLong(Person::getSalary).reversed())
					.collect(Collectors.toMap(Person::getName, Person::getSalary));
		
		System.out.println(personMap);
		
	}
	
	
	
}

class Person {
	
	int age;
	String name;
	String city;
	Long salary;
	
	public Person(int age, String name, String city, Long salary) {
		super();
		this.age = age;
		this.name = name;
		this.city = city;
		this.salary = salary;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Long getSalary() {
		return salary;
	}
	public void setSalary(Long salary) {
		this.salary = salary;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((salary == null) ? 0 : salary.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (age != other.age)
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (salary == null) {
			if (other.salary != null)
				return false;
		} else if (!salary.equals(other.salary))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Person [age=" + age + ", name=" + name + ", city=" + city + ", salary=" + salary + "]";
	}
	
	

}
