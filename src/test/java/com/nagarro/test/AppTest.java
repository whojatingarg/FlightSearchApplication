package com.nagarro.test;

import com.nagarro.services.AdditionService;

import junit.framework.*;

public class AppTest extends TestCase {

	LoginService loginService = new LoginService();

	public AppTest(String name) {
		super(name);
	}

	public void testSum() {
		assertEquals(true, loginService.validateUser("jatin", "pass"));
	}
	
	public void testNegativeSum() {
		assertEquals(false, additionService.addNumbers("yash", "none"));
	}
}