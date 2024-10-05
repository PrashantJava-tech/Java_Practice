package com.pk.ZonedDateTime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FIndingDateFormatPattern {
	
	
	
	private  String formatter = "yyyy-mm-dd'T'hh:mm:ss";
	private static final String PATTERN_19_DIGIT = "^\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}$";

	private static Pattern pattern;

	 public static void main(String[] args) {  
		 String dateStrings = "2024-03-21T14:21:10";

		 pattern = Pattern.compile(PATTERN_19_DIGIT);

		 Matcher matcher = pattern.matcher(dateStrings);
		 if (matcher.matches()) {
        	 System.out.println("success");
         }else {
             System.out.println("Validation: For Language preference - modified date is not in 19 digits number format:" + dateStrings);

         }
		 
		 ZonedDateTime effectiveDateTime = ZonedDateTime.parse(dateStrings.concat(".000Z"));
		 System.out.println(effectiveDateTime);
		
		 //-------------------------------------------------------------

		 String tdsModifiedDateFormat = "uuuu-MM-dd'T'HH:mm:ss";
		 try {
				DateTimeFormatter format = DateTimeFormatter.ofPattern(tdsModifiedDateFormat).withResolverStyle(ResolverStyle.STRICT);
		        
				//ZonedDateTime
				LocalDateTime ld = LocalDateTime.parse(dateStrings,format);
				effectiveDateTime = ZonedDateTime.of(ld, ZoneId.systemDefault());
				System.out.println("Effective Date format = "+effectiveDateTime);
			} catch(Exception e) {
				System.out.println(e.getMessage());//In case of any exceptions also, set date to current date
				System.out.println("Unable to parse/format the date field. Exception msg:"+e.getMessage());
			}
	}  
}
