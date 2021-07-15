package com.nagarro.utilities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

import com.nagarro.constants.Constants;


/**
 * @author jatinkumar02
 * 
 * This class is use to parse the string object into the date object.
 *
 */
public class DateParserUtil {

	final static Logger LOG = Logger.getLogger(DateParserUtil.class);
	
	private static SimpleDateFormat formatter;

	/**
	 * This method take date in string format and converts it into Date format.
	 * @param stringDate
	 * @return Date
	 */
	public static Date getDate(String stringDate) {
		
		LOG.info("Parsing String date " + stringDate +" to Date Object.");
		
		Date date = null;

		try {
			formatter = Constants.getDateFormatter();
			date = formatter.parse(stringDate);			
			
		} catch (ParseException parseException) {
			LOG.error("Exception occured while parsing String date " + stringDate +" to Date Object.");
		}

		LOG.info("Parsed String date " + stringDate +" to Date Object successfully.");
		return date;
	}
}
