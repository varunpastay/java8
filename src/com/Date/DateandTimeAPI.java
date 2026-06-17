package com.Date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class DateandTimeAPI {
public static void main(String[] args) {

	System.out.println("\nDATE & TIME API\n");
    
    LocalDate ld = LocalDate.now();
    System.out.println("Date is "+ld);
    System.out.println("Year of date is "+ld.getYear());
    System.out.println("Month number of date is "+ld.getMonthValue());
    System.out.println("Month name of date is "+ld.getMonth());
    System.out.println("Day of date is "+ld.getDayOfMonth());
    
    LocalTime lt = LocalTime.now();
    System.out.println("\nOverall Time is "+lt);
    System.out.println("Hour of time "+lt.getHour());
    System.out.println("Minute of time "+lt.getMinute());
    System.out.println("Seconds of time "+lt.getSecond());
    
    LocalDateTime ldt = LocalDateTime.now();
    System.out.println("\nEntire Date with Time "+ldt);
    
    System.out.println("\nTo accept date from user format and convert it into req fromat");
    String date = "20-10-2026";
    DateTimeFormatter formated = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    LocalDate convertedDate = LocalDate.parse(date, formated);
    System.out.println(convertedDate);
    
    System.out.println("\nObtain the difference b/w two days");
    Period p1 = Period.between(ld, convertedDate);
    Integer days = p1.getDays();
    System.out.println(days);
}
}
