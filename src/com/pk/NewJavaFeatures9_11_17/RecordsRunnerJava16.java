package com.pk.NewJavaFeatures9_11_17;

public class RecordsRunnerJava16 {
	
	record Person (String name, String email, String phoneNUmber) {}

	record Animal (String name, String type) {
		//way 1
		Animal(String name, String type){
			this.name = name;
			this.type = type;
		}
		//way 2 compact constructor
		//Animal{}
		
		static {
			System.out.println("Inside static intilizers..");
		}
		
		//not allowed
		// int number;
		
		static int number = 10;
		
		void printData(){
			System.out.println("Inside instance methods...="+name);
		}
	}
	
	public static void main(String[] args) {
		
		Person person = new Person("Prashant", "abc@gmail.com", "9075644226");
		System.out.println("person"+person);
		
		Person person1 = new Person("Prashant", "abc@gmail.com", "9075644226");
		System.out.println("person.equals(person1)="+person.equals(person1));

		Person person2 = new Person("Prashant1", "abc@gmail.com", "9075644226");
		System.out.println("person.equals(person2)="+person.equals(person2));
		
		
		Animal animal = new Animal("Tiger", "wild");
		animal.printData();

	}

}
