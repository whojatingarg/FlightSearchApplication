package com.nagarro.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.dao.FlightDao;

/**
 * @author jatinkumar02
 *
 * This class is used to fetch distinct arrival and departure locations using
 * FlightDao that will be populated in the drop down in the search screen.
 * 
 */
@Service
public class AirportStateCodeLoaderService {

	@Autowired
	private FlightDao flightDao;
	
	/**
	 * This method fetches distinct fromAirportStateCodes i.e. Departure Location.
	 * 
	 * @return List of distinct Departure locations.
	 */
	public List<String> getFromAirportStateCodes(){
		
		List<String> fromAirportStateCodes;
		
		fromAirportStateCodes = flightDao.getDepartureLocations();
		
		return fromAirportStateCodes;
	}
	
	/**
	 * This method fetches distinct toAirportStateCodes i.e. Arrival Location.
	 * 
	 * @return List of distinct Arrival Locations
	 */
	public List<String> getToAirportStateCodes(){
		List<String> toAirportStateCodes;
		
		toAirportStateCodes = flightDao.getArrivalLocations();
		
		return toAirportStateCodes;
	}
	
}
