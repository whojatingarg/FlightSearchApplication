package com.nagarro.dao;

import java.util.List;

import com.nagarro.dto.FlightFile;

/**
 * @author jatinkumar02
 *
 *This interface provide methods to interact with db for the flightfile object. 
 */
public interface FlightFileDao {

	/**
	 * @return the list of files saved in db.
	 */
	public List<FlightFile> getAllFlightFiles();
	
	/**
	 * @param fileName
	 * @return the flight object from the db.
	 */
	public FlightFile getFlightFile(String fileName);
	
	/**
	 * This method updates the flight file in the db.
	 * @param flightFile
	 */
	public void updateFlightFile(FlightFile flightFile);
	
	/**
	 * This method add the new flight file into the db.
	 * @param newFlightFile
	 */
	public void addFlightFile(FlightFile newFlightFile);
	
}
