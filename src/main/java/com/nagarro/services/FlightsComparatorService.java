package com.nagarro.services;

import java.util.Comparator;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.nagarro.dto.Flight;

/**
 * @author jatinkumar02
 *
 * FlightsComparator class generates Comparator according to user's output
 * preference.
 */

@Service
public class FlightsComparatorService {

	private final static Logger LOG = Logger.getLogger(FlightsComparatorService.class);
	
	/**
	 * Used to sort the flights by Fare
	 */
	public Comparator<Flight> getFlightComparatorbyFare() {
		LOG.info("Creating Comparator by sort by Fare.");
		
		return new Comparator<Flight>() {
			public int compare(Flight flight1, Flight flight2) {
				return Double.compare(flight1.getFare(), flight2.getFare());
			}
		};

	}
	
	/**
	 * Used to sort the flights by Duration.
	 */
	public Comparator<Flight> getFlightComparatorbyDuration() {
		LOG.info("Creating Comparator to sort by Fare & Flight Duration.");

		return new Comparator<Flight>() {
			public int compare(Flight flight1, Flight flight2) {
				
					return Double.compare(flight1.getFlightDuration(), flight2.getFlightDuration());
					
			}
		};
		
	}
	
}
