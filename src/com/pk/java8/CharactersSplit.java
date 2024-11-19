package com.pk.java8;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CharactersSplit {

	public static void main(String[] args) {
		//find out each characters with its count, and print only those chars who are repetative withs count. 
		
		String name ="abcdedde";
		
		Map<String, Long> chars = Stream.of(name.split(""))
										.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println("Map = "+chars);
		
		chars.entrySet().stream().filter(x -> x.getValue() > 1).forEach( x -> {
			System.out.println(x.getKey() +" =  "+x.getValue());
		});
		
	}
}
