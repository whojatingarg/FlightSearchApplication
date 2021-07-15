package com.nagarro.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.dto.Flight;
import com.nagarro.services.FlightSearchService;
import com.nagarro.services.OutputPreferenceService;

/**
 * @author jatinkumar02
 * 
 * This controller takes the user input and display the
 * available flights according to the user preference.
 *
 */
@Controller
public class SearchFlightController {

	@Autowired
	private FlightSearchService flightSearchService;

	@Autowired
	private OutputPreferenceService outputPreferenceService;

	/**
	 * 
	 * This method takes the user input and set the modelAndView object according
	 * to the results.
	 * 
	 * @param request
	 * @param response
	 * @return modelAndView with the search results.
	 */
	@GetMapping("/Search")
	public ModelAndView searchFligts(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView();

		String depatureLocation = request.getParameter("from").toString();
		String arrivalLocation = request.getParameter("to").toString();
		String date = request.getParameter("date").toString();
		String flightClass = request.getParameter("class").toString();
		int sortBy = Integer.parseInt(request.getParameter("sortBy").toString());

		//getting the available flights
		List<Flight> availableFlights = flightSearchService.getAvailableFlights(arrivalLocation, depatureLocation, date, flightClass);

		//sorting the flights according to the user choice.
		outputPreferenceService.sortFlights(availableFlights, sortBy);

		//setting the modelAndView object.
		modelAndView.addObject("availableFlights", availableFlights);

		modelAndView.setViewName("result");

		return modelAndView;
	}

}
