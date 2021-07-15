package com.nagarro.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


/**
 * @author jatinkumar02
 *
 *This class controls the signing out process of the user.
 */

@Controller
public class SignOutController {
	
	/**
	 *  This controls the signing out process of the user
	 * @param request
	 * @param response
	 * @return modelAndView object
	 */
	@GetMapping("/SignOut")
	public ModelAndView signOut(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView();
		
		//setting the modelAndView object
		modelAndView.addObject("userName", null);
		modelAndView.setViewName("index");
		return modelAndView;
		
	}
}
