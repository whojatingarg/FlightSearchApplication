package com.nagarro.services;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.dto.Flight;

/**
 * @author jatinkumar02
 *
 * OutputPreferance class sorts the search result according to the user's
 * preference.
 */
@Service
public class OutputPreferenceService {
	private final static Logger LOG = Logger.getLogger(OutputPreferenceService.class);

	@Autowired
	private FlightsComparatorService flightsComparatorService;

	/**
	 * Sorts flights collection by user's output preference after retrieving
	 * appropriate comparator from FlightComparator class.
	 * 
	 * @param searchResult List of Flights matching user's input.
	 * @param sortBy user's output preference.
	 */
	public void sortFlights(List<Flight> availableFlights, int sortBy) {
		LOG.info("Sorting search result according to output preference.");

		Comparator<Flight> comparator;

		if (sortBy == 1) {
			comparator = flightsComparatorService.getFlightComparatorbyFare();
			Collections.sort(availableFlights, comparator);
		} else {
			comparator = flightsComparatorService.getFlightComparatorbyDuration();
			Collections.sort(availableFlights, comparator);
		}

	}
}
