package com.pk.NewJavaFeatures9_11_17;

public class TextBlocksRunner {
	
	public static void main(String[] args) {
		
		String str = """
				Line 1
				"Line 2"
					Line 3
				""";
		System.out.print(str);
		
		// String str1 = """Line 1 Line 3"""; not allowed
		
		System.out.println("===========Text blocks with formated...");
		String strData = """
				Line 1: %s
				Line 2: %s
				Line 3
				""".formatted("Prashant", "kadam");
		System.out.print(strData);
		
	}

}
