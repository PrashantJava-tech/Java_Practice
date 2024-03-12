package com.pk.ZonedDateTime;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class ZonedDateTimeTest {

    public static void main(String[] args) {
        String text = "2021-09-23T15:39:12.677-04:00[America/New_York]";

        // Creating a new ZonedDateTime object
        ZonedDateTime zone = ZonedDateTime.parse(text);
        // printing the zone of this zonedDateTime object\
        /**
         * Output ===>
         * zone.getZone() 				->> America/New_York
         * zone.getOffset() 			--> -04:00
         * zone.toOffsetDateTime()		--> 2021-09-23T15:39:12.677-04:00
         * zone.format(DATETIME_FORMATTER)--> 20210923 15:39:12
         * Date.from(zone.toInstant())	--> Thu Sep 23 15:39:12 EDT 2021
         * zone.toInstant() 			--> 2021-09-23T19:39:12.677Z
         */
        System.out.println(zone.getZone());
        System.out.println(zone.getOffset());
        System.out.println(zone.toOffsetDateTime());

        final DateTimeFormatter DATETIME_FORMATTER = DateTimeFormatter.ofPattern("yyyyMMdd HH:mm:ss");
        System.out.println(zone.format(DATETIME_FORMATTER));
        System.out.println(Date.from(zone.toInstant()));
        System.out.println(zone.toInstant());
        
        /**
         *  2011-10-02T14:45:30.123456789+05:30[Asia/Kolkata]
			2011-08-02T14:45:30.123456789+05:30[Asia/Kolkata]
			2011-12-02T14:45:30.123456789+05:30[Asia/Kolkata]
         */
        // printing value of this ZonedDateTime
        System.out.println(zone);
        // object after subtracting two months
        System.out.println(zone.minus(Period.ofMonths(2)));        
        // object after adding two months
        System.out.println(zone.plus(Period.ofMonths(2)));        

        // getting current date
        LocalDate date = LocalDate.now(); System.out.println(date);
        // getting current time
        LocalTime time = LocalTime.now();  System.out.println(time);
        // getting system default zone id
        ZoneId zoneId = ZoneId.systemDefault(); System.out.println(zoneId);
        // creating a new ZonedDateTime object
        ZonedDateTime zonedatetime
            = ZonedDateTime.of(date, time, zoneId);
        System.out.println(zonedatetime);

    }

}
