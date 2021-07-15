package com.nagarro.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.nagarro.dao.Dao;
import com.nagarro.dao.FlightDao;
import com.nagarro.dao.FlightFileDao;
import com.nagarro.dao.UserDao;
import com.nagarro.daoimpl.DaoImpl;
import com.nagarro.daoimpl.FlightDaoImpl;
import com.nagarro.daoimpl.FlightFileDaoImpl;
import com.nagarro.daoimpl.UserDaoImpl;
import com.nagarro.services.AirportStateCodeLoaderService;
import com.nagarro.services.FlightLoaderService;
import com.nagarro.services.FlightSearchService;
import com.nagarro.services.FlightsComparatorService;
import com.nagarro.services.LoginService;
import com.nagarro.services.OutputPreferenceService;
import com.nagarro.services.SignUpService;

/**
 * @author jatinkumar02
 *
 *AppConfiguration File which contains all the configuration of
 *the Beans
 */

@Configuration
@EnableScheduling
public class AppConfig {

	@Bean
	public Dao getDao() {
		return new DaoImpl();
	}

	@Bean
	public UserDao getUserDao() {
		return new UserDaoImpl();
	}

	@Bean
	public FlightDao getFlightDao() {
		return new FlightDaoImpl();
	}
	
	@Bean
	public FlightFileDao getFlightFileDao() {
		return new FlightFileDaoImpl();
	}
	
	@Bean
	public LoginService getLoginService() {
		return new LoginService();
	}
	
	@Bean
	public SignUpService getSignUpService() {
		return new SignUpService();
	}
	
	@Bean
	public FlightLoaderService getFlightLoaderService() {
		return new FlightLoaderService();
	}
	
	@Bean
	public AirportStateCodeLoaderService getAirportStateCodeLoaderService() {
		return new AirportStateCodeLoaderService();
	}
	
	@Bean
	public FlightsComparatorService getFightComparatorService() {
		return new FlightsComparatorService();
	}
	
	@Bean
	public FlightSearchService getFlightSearchService() {
		return new FlightSearchService();
	}
	
	@Bean
	public OutputPreferenceService getOutputPreferenceService() {
		return new OutputPreferenceService();
	}
}
