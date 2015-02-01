package edu.stevens.cs548.clinic.service.dto;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.bind.DatatypeConverter;

public class DateAdopter {
	public static Date parseDate (String s){
		return DatatypeConverter.parseDate(s).getTime();
	}
	
	public static String printDate (Date d){
		Calendar cal =new GregorianCalendar();
		cal.setTime(d);
		return DatatypeConverter.printDate(cal);
	}
}
