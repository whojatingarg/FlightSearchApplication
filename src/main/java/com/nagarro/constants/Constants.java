package com.nagarro.constants;

import java.text.SimpleDateFormat;

/**
 * @author jatinkumar02
 *
 *	This class contains all the constants used in the application
 */
public class Constants {
	
	public static final String FOLERPATH = "C:\\Users\\Jatinkumar02\\eclipse-workspace\\FlightSearchApplication\\src\\main\\resources";
	public static final String DATEFORMAT = "yyyy-mm-dd";
	
	//returns the converted date in the specified format.
	public static SimpleDateFormat getDateFormatter() {
		return new SimpleDateFormat(DATEFORMAT);
	}
}
