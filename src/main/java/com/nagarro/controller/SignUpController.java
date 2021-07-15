package com.nagarro.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.services.SignUpService;

/**
 * @author jatinkumar02
 *
 * This controller controls the sign up process of the new user.
 */
@Controller
public class SignUpController {

	@Autowired
	private SignUpService signUpService;

	@PostMapping("/SignUp")
	public ModelAndView signUp(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView();

		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirmPassword");

		// validating the credentials.
		boolean userExists = signUpService.userExists(userName);
		boolean passwordMatches = signUpService.passwordMatches(password,confirmPassword);
		boolean validPassword = signUpService.validPassword(password);
		boolean validUserName = signUpService.validUsername(userName);
		
		if(userExists) {
			
			//setting modelAndView object.
			modelAndView.addObject("signupmessage", "Username Already Exists!!");
			modelAndView.setViewName("SignUp");
			return modelAndView;
		}
		
		if(!passwordMatches) {
			
			//setting modelAndView object.
			modelAndView.addObject("signupmessage", "Password do not match. Try Again!!");
			modelAndView.setViewName("SignUp");
			return modelAndView;
		}
		
	
		if(!validPassword) {
			
			//setting modelAndView object.
			modelAndView.addObject("signupmessage", "Password length cannot be greater than 10.");
			modelAndView.setViewName("SignUp");
			return modelAndView;
		}
		
		if(!validUserName) {
			
			//setting modelAndView object.
			modelAndView.addObject("signupmessage", "Invalid userName.");
			modelAndView.setViewName("SignUp");
			return modelAndView;
		}
		
		//add new user into the db.
		signUpService.addNewUser(userName, confirmPassword);
		
		//setting modelAndView object.
		modelAndView.addObject("signupmessage", "Account created successfully. You can now Login!!");
		modelAndView.setViewName("index");
		return modelAndView;
		

	}


}
