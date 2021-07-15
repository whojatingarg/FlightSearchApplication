package com.nagarro.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * @author jatinkumar02
 *
 *Flight class is an user entity that is stored in database.
 * 
 */


@Entity
@Table(name = "Flights")
public class Flight {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int flightId;
	private String flightNumber;
	private String departLocation;
	private String arrivalLocation;
	
	@Temporal(TemporalType.DATE)
	private Date flightDate;
	private String flightTime;
	private double flightDuration;
	private double fare;
	private char seatAvailablility;
	private String flightClass;
	
	
	
	/**
	 * @return the flightId
	 */
	public int getFlightId() {
		return flightId;
	}



	/**
	 * @param flightId the flightId to set
	 */
	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}



	/**
	 * @return the flightNumber
	 */
	public String getFlightNumber() {
		return flightNumber;
	}



	/**
	 * @param flightNumber the flightNumber to set
	 */
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}



	/**
	 * @return the departLocation
	 */
	public String getDepartLocation() {
		return departLocation;
	}



	/**
	 * @param departLocation the departLocation to set
	 */
	public void setDepartLocation(String departLocation) {
		this.departLocation = departLocation;
	}



	/**
	 * @return the arrivalLocation
	 */
	public String getArrivalLocation() {
		return arrivalLocation;
	}



	/**
	 * @param arrivalLocation the arrivalLocation to set
	 */
	public void setArrivalLocation(String arrivalLocation) {
		this.arrivalLocation = arrivalLocation;
	}



	/**
	 * @return the flightDate
	 */
	public Date getFlightDate() {
		return flightDate;
	}



	/**
	 * @param flightDate2 the flightDate to set
	 */
	public void setFlightDate(Date flightDate) {
		this.flightDate = flightDate;
	}



	/**
	 * @return the flightTime
	 */
	public String getFlightTime() {
		return flightTime;
	}



	/**
	 * @param flightTime the flightTime to set
	 */
	public void setFlightTime(String flightTime) {
		this.flightTime = flightTime;
	}



	/**
	 * @return the flightDuration
	 */
	public double getFlightDuration() {
		return flightDuration;
	}



	/**
	 * @param flightDuration the flightDuration to set
	 */
	public void setFlightDuration(double flightDuration) {
		this.flightDuration = flightDuration;
	}



	/**
	 * @return the fare
	 */
	public double getFare() {
		return fare;
	}



	/**
	 * @param fare the fare to set
	 */
	public void setFare(double fare) {
		this.fare = fare;
	}



	/**
	 * @return the seatAvailablility
	 */
	public char getSeatAvailablility() {
		return seatAvailablility;
	}



	/**
	 * @param seatAvailablility the seatAvailablility to set
	 */
	public void setSeatAvailablility(char seatAvailablility) {
		this.seatAvailablility = seatAvailablility;
	}



	/**
	 * @return the flightClass
	 */
	public String getFlightClass() {
		return flightClass;
	}



	/**
	 * @param flightClass the flightClass to set
	 */
	public void setFlightClass(String flightClass) {
		this.flightClass = flightClass;
	}



//	public String toString() {
//
//		String flightDetails = "";
//
//		flightDetails = "[ " + this.getFlightNumber() + " | " + this.getDepartLocation() + " | "
//				+ this.getArrivalLocation() + " | " + this.getFlightDate() + " | " + this.getFlightTime() + " | "
//				+ this.getFlightDuration() + " | " + this.getFare() + " | " + this.getSeatAvailablility() + " | "
//				+ this.getFlightClass() + " ]";
//
//		return flightDetails;
//	}
//	
	
}
