package com.cognizant.truyum.util;
import java.util.*;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class DateUtil {
	public static Date convertToDate(String s) {
		
		SimpleDateFormat df=new SimpleDateFormat("dd/MM/yyyy");
		Date d1;
		try {
			
			d1=df.parse(s);
			return d1;
		}
		catch(ParseException e) {
			
			e.printStackTrace();
		}
		return null;
	}
}
