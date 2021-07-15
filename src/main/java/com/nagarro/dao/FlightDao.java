package com.nagarro.dao;

import java.util.Date;
import java.util.List;

import com.nagarro.dto.Flight;

/**
 * @author jatinkumar02
 * 
 *  This interface provide methods to interact with db for the flight object.
 *
 */
public interface FlightDao {

	/**
	 * @param flight
	 * 
	 * This method adds a flight object to the Flight table in database.
	 *
	 */
	public void addFlight(Flight flight);
	
	/**
	 * @param arrivalLocation
	 * @param departLocation
	 * @param flightDate
	 * @param flightClass
	 * @return 
	 * 
	 * This method searches for flights that match the method parameters i.e. the
	 * user input. predicate is an array of all the restriction that are used to
	 * filter the flights according to user input.
	 */
	public List<Flight> getFlights(String arrivalLocation, String departLocation, Date flightDate, String flightClass);
	
	/**
	 * This method fetches distinct toAirportCodes i.e. Arrival Location.
	 * 
	 * @return List of distinct Arrival Locations
	 */
	public List<String> getArrivalLocations();
	
	/**
	 * This method fetches distinct fromAirportCodes i.e. Departure Location.
	 * 
	 * @return List of distinct Departure locations.
	 */
	public List<String> getDepartureLocations();

}
