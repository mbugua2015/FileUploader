package com.fileuploader;

import java.text.*;
import java.util.Locale;
import java.util.Date;

public class Formatter {
	
	public static String FormatCurrency(double currency){
		
		String pattern="###,###.00";
		
		DecimalFormat myFormatter= new DecimalFormat(pattern);
		
		return myFormatter.format(currency);
		
	}
	
	public static String formatDateToISOFormat(String date){
		
		if(date==null)
			return "";
		//date passed in form dd/mm/yyyy
		String[] dateParts= date.split("/");
		
		return dateParts[2]+ "-" + dateParts[1]+ "-"+dateParts[0];
	}
	
	public static String formatToMonthDayYear(String date){
		//date passed in form dd/mm/yyyy
		
		if(date==null)
			return "";
		
		String[] dateParts= date.split("/");
		
		return dateParts[1]+ "/" + dateParts[0]+ "/"+dateParts[2];
	}
	
	public static String formatDateForRepresentation(Date d){
		
		if(d==null)
			return "";
		
		SimpleDateFormat formatter= new SimpleDateFormat("d MMM yyyy");
		return formatter.format(d);
	}
	
	public static String FormatDateToISOFormat(Date d){
		if(d==null)
			return "";
		
		SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
		return formatter.format(d);
	}
	
	
	public static String FormatDateTimeToISOFormat(Date d){
		if(d==null)
			return "";
		
		SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		return formatter.format(d);
	}
	
	public static String formatDateToDayMonthYearWithHyphens(Date d){
		if(d==null){
			return "";
		}
		
		SimpleDateFormat formatter= new SimpleDateFormat("dd-MM-yyyy");
		return formatter.format(d);
	}
	
	public static String formatDateToDayMonthYearWithStrokes(Date d){
		if(d==null){
			return "";
		}
		
		SimpleDateFormat formatter= new SimpleDateFormat("dd/MM/yyyy");
		return formatter.format(d);
	}
	
	public static Date parseDateInIsoFormat(String date)
			throws ParseException {
		
		if(date==null){
			return null;
		}
		
		SimpleDateFormat formatter= new SimpleDateFormat("dd-MM-yyyy HH:mm");
		return formatter.parse(date);
	}
	
	public static Date getDateFromIsoString(String isoDate){
		
		try{
			SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
			return dateFormatter.parse(isoDate);
		}
		catch(Exception ex){
			Utility.logStackTrace(ex);
			return null;
		}
	}
	
	public static String formatDateTimeToISOFormat(Date d){
		
		if(d==null)
			return "";
		
		SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd HH:mm");
		return formatter.format(d);
	}
	
	public static String formatToTwoDecimalPlaces(double number){
		
		Locale locale= new Locale("en","UK");
		String pattern="###,###.00";
		
		DecimalFormat decFormat=(DecimalFormat)
				NumberFormat.getInstance(locale);
		
		decFormat.applyPattern(pattern);
		
		return decFormat.format(number);
	}
	
	public static Date parseDateInDayMonthYearFormat(String date)
			throws ParseException{
		
		if(date==null)
			return null;
		
		DateFormat f= new SimpleDateFormat("dd/MM/yyyy");
		
		return f.parse(date);
	}
	
	public static String formatDateTime(Date d){
		
		if(d==null)
			return "";
		
		DateFormat f= new SimpleDateFormat("dd MMM yyyy hh:mm a");
		
		return f.format(d);
	}
	
	public static Date parseDateInDayShortMonthYear(String date)
			throws ParseException{
		
		DateFormat dateFormat= new SimpleDateFormat("dd MMM yyyy");
		return dateFormat.parse(date);
	}
	
	public static String formatDateToDayShortMonthYear(Date date){
		DateFormat dateFormat= new SimpleDateFormat("dd MMM yyyy");
		return dateFormat.format(date);
	}
	
	public static Date parseLongDate(String date){
		if(date==null)
			return null;
		
		DateFormat f= new SimpleDateFormat("dd MMM yyyy hh:mm a");
		
		try{
			return f.parse(date);
		}
		catch(Exception e){
			return null;
		}
	}
	
	public static String formatTime(Date d){
		if(d==null)
			return "";
		
		DateFormat f= new SimpleDateFormat("hh:mm a");
		
		return f.format(d);
	}
	
	public static Date parseDateTime(String date)
			throws ParseException{
		
		if(date==null)
			return null;
		
		DateFormat df= new SimpleDateFormat("yyyy/MM/dd HH:mm");
		
		return df.parse(date);
	}
	
	public static Date parseDateInDayMonthYear(String date)
			throws ParseException{
		
		if(date==null)
			return null;
		
		DateFormat df= new SimpleDateFormat("dd/MM/yyyy");
		
		return  df.parse(date);
		
	}
	
	public static Date parseDateTimeInLocalTime(String date)
			throws ParseException{
		
		if(date==null)
			return null;
		
		DateFormat df= new SimpleDateFormat("dd/MM/yyyy hh:mm a");
		
		return  df.parse(date);
	}
	
	public static Date getDateFromRepresentation(String date)
	{
		
		try{
			DateFormat df= new SimpleDateFormat("dd MMM yyyy");
			
			return df.parse(date);
		}
		catch(ParseException pex){
			return null;
		}
		
	}
	
	public static String formatTimeTo24Hours(Date d)
			throws ParseException,Exception{
		
		if(d==null){
			throw new Exception("Date cannot be null");
		}
		
		DateFormat df= new SimpleDateFormat("HH:mm");
		
		return df.format(d);
		
	}
	
	public static String getDayOfWeek(Date date)
			throws Exception{
		
		if(date!=null){
			DateFormat df= new SimpleDateFormat("EEEE");
			
			return df.format(date);
		}
		
		throw new Exception("Date cannot be null");
	}
	
	public static boolean dateIsValid(String date){
		if(date==null || date.trim().isEmpty()) return false;
		String[] dateParts= date.split(" ");
		
		if(dateParts.length<3) return false;
		
		int yearPart=Integer.parseInt(dateParts[2]);
		
		return yearPart>2000 && yearPart <3000;
	}
	
	public static Date parseDateInDayShortMonthYear24HoursTime(String date){
		
		try{
			SimpleDateFormat dFormat= new SimpleDateFormat("dd MMM yyyy HH:mm");
			return dFormat.parse(date);
		}
		catch(Exception ex){
			Utility.logStackTrace(ex);
			return null;
		}
	}
	
	public static Date parseDateFromIsoString(String isoDate){
		SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm");
		
		try{
			return dateFormat.parse(isoDate);
		}
		catch(Exception ex){
			Utility.logStackTrace(ex);
			return null;
		}
	}
	
	public static Date parseDateInDayMonthYearTimeIn24Hours(String date){
		SimpleDateFormat dateFormat= new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		try{
			return dateFormat.parse(date);
		}
		catch(Exception ex){
			Utility.logStackTrace(ex);
			return null;
		}
	}
	
	public static String formatIsoDateWithSeparators(String nonFormattedIsoDate){
		if(nonFormattedIsoDate==null || nonFormattedIsoDate.trim().isEmpty())
			throw new IllegalArgumentException("nonfromatteddate cannot be null or empty");
		
		String year=nonFormattedIsoDate.substring(0, 4);
		String month=nonFormattedIsoDate.substring(4,6);
		String day=nonFormattedIsoDate.substring(6,8);
		
		return year+"-"+month+"-"+day;
	}
	
	public static String formatIsoDateWithoutSeparators(Date d){
		
		if(d==null)
			throw new IllegalArgumentException("Date cannot be null");
		
		try{
			SimpleDateFormat simpleDf= new SimpleDateFormat("yyyyMMdd");
			return simpleDf.format(d);
		}
		catch(Exception ex){
			Utility.logStackTrace(ex);
			return null;
		}
	}
}
