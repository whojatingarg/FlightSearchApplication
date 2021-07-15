package com.nagarro.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.dao.FlightDao;
import com.nagarro.dto.Flight;
import com.nagarro.utilities.DateParserUtil;

/**
 * @author jatinkumar02
 *  
 *  This class is used to search the flights based on the user input.
 */

@Service
public class FlightSearchService {

	@Autowired
	FlightDao flightDao;
	
	
	/**
	 *  This method takes in arguments from the controller method and passes it
	 * to the dao layer to get the list of available flights.
	 * 
	 * @param arrivalLocation
	 * @param depatureLocation
	 * @param flightDate
	 * @param flightClass
	 * @return List of available flights.
	 */
	public List<Flight> getAvailableFlights(String arrivalLocation, String depatureLocation, String date, String flightClass){
		
		List<Flight> availableFlights;
		
		Date flightDate = DateParserUtil.getDate(date);
		
		availableFlights = flightDao.getFlights(arrivalLocation, depatureLocation, flightDate, flightClass);
		
		return availableFlights;
	}
}
