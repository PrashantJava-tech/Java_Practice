package com.pk.java8;

import java.util.List;

import org.springframework.util.CollectionUtils;
//import com.amazonaws.util.CollectionUtils;


public class StreamAPi {
	
	public static void main(String[] args) {

		//Can check the list is empty or null using aws utility class. 
		List<String> fileNames = null;

		if(!CollectionUtils.isEmpty(fileNames))
			fileNames.stream().forEach(x -> System.out.println("Value -"+x));
		else
			System.out.println("collection is empty.");
			
	}

}
