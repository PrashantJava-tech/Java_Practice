package com.pk.NewJavaFeatures9_11_17;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FIleReadWriteRunnerJava11 {
	
	public static void main(String[] args) throws IOException {
		
		Path path = Paths.get("./resoruces/sample.txt");
		String fileContenet = Files.readString(path);		
		System.out.println(fileContenet);		
		
		//this will create new file with replaces content.
		String newContent = fileContenet.replace("line", "newLine");
		Path newPath = Paths.get("./resoruces/sample-new.txt");
		Files.writeString(newPath, newContent);
		
		System.out.println("new content --->");	
		String fileContenet1 = Files.readString(newPath);		
		System.out.println(fileContenet1);		
		
	}

}
