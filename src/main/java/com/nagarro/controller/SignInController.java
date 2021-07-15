package com.nagarro.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.services.AirportStateCodeLoaderService;
import com.nagarro.services.LoginService;

/**
 * @author jatinkumar02
 *
 * This SignIn controller helps user in signing in into the application.
 */

@Controller
public class SignInController {
	
	@Autowired
	private LoginService loginService;
	
	@Autowired
	private AirportStateCodeLoaderService airportStateCodeLoaderService;

	/**
	 * This method takes user credentials verifies it and then let user
	 * sign in the user into the application.
	 * 
	 * @param request
	 * @param response
	 * @return modelAndView object with the user details and other necessary informations (like Airport codes). 
	 */
	@PostMapping("/SignIn")
	public ModelAndView signIn(HttpServletRequest request, HttpServletResponse response) {
		
		ModelAndView modelAndView = new ModelAndView();
		
		String userName = request.getParameter("userName").trim();
		String password = request.getParameter("password").trim();
		
		//verifying the credentials.
		boolean credentailsVerified = loginService.validateUser(userName, password);
		
		if(!credentailsVerified) {
			
			//setting the modelAndView object if credentials are wrong
			modelAndView.addObject("message", "Invalid Credentials.");
			modelAndView.setViewName("index");
			
			return modelAndView;
		}
		
		List<String> fromAirportStateCodes = airportStateCodeLoaderService.getFromAirportStateCodes();
		List<String> toAirportStateCodes = airportStateCodeLoaderService.getToAirportStateCodes();
		
		//setting the modelAndView object
		modelAndView.addObject("userName", userName);
		modelAndView.addObject("fromAirportStateCodes", fromAirportStateCodes);
		modelAndView.addObject("toAirportStateCodes", toAirportStateCodes);
		modelAndView.setViewName("home");
		
		return modelAndView;
		
	}
	
	/**
	 * Handles the get request from the user
	 * 
	 * @param request
	 * @param response
	 * @return object of modelAndView
	 */
	@GetMapping("/SignIn")
	public ModelAndView signInGet(HttpServletRequest request, HttpServletResponse response) {
		
		ModelAndView modelAndView = new ModelAndView();
	
		modelAndView.setViewName("home");
		return modelAndView;
	}

}
