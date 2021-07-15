package com.nagarro.daoimpl;

import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.log4j.Logger;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import com.nagarro.dao.Dao;
import com.nagarro.dao.FlightDao;
import com.nagarro.dto.Flight;

/**
 * @author jatinkumar02
 * 
 * This class implements all the method defined in FlightDao interface.
 *
 */
public class FlightDaoImpl implements FlightDao{

	private final static Logger LOG = Logger.getLogger(FlightDaoImpl.class);
	
	@Autowired
	private Dao dao;

	/* (non-Javadoc)
	 * @see com.nagarro.dao.FlightDao#addFlight(com.nagarro.dto.Flight)
	 */
	@Override
	public void addFlight(Flight flight) {
		// TODO Auto-generated method stub
		LOG.info("Adding new flight : " + flight.getFlightId());

		dao.begin();

		dao.getSession().save(flight);

		dao.commit();
		dao.close();

		LOG.info(flight.getFlightId() + " flight added successfully.");
	}

	/* (non-Javadoc)
	 * @see com.nagarro.dao.FlightDao#getFlights(java.lang.String, java.lang.String, java.util.Date, java.lang.String)
	 */
	@Override
	public List<Flight> getFlights(String arrivalLocation, String depatureLocation, Date flightDate, String flightClass) {
		// TODO Auto-generated method stub
		LOG.info("Searching for flights according to user's input.");

		dao.begin();
		
		// query for getting the flights from the db based on serch preference.
		CriteriaBuilder criteriaBuilder = dao.getSession().getCriteriaBuilder();
		CriteriaQuery<Flight> criteriaQuery = criteriaBuilder.createQuery(Flight.class);
		Root<Flight> root = criteriaQuery.from(Flight.class);

		Predicate[] predicates = new Predicate[4];

		predicates[2] = criteriaBuilder.equal(root.get("departLocation"), depatureLocation);
		predicates[0] = criteriaBuilder.equal(root.get("arrivalLocation"), arrivalLocation);

		predicates[3] = criteriaBuilder.greaterThanOrEqualTo(root.get("flightDate"), flightDate);
		
		predicates[1] = criteriaBuilder.like(root.get("flightClass"), "%" + flightClass + "%");

		criteriaQuery.select(root).where(predicates);
		
		Query<Flight> query = dao.getSession().createQuery(criteriaQuery);
		
		List<Flight> searchResult = query.getResultList();

		dao.commit();
		dao.close();

		return searchResult;
	}

	/* (non-Javadoc)
	 * @see com.nagarro.dao.FlightDao#getArrivalLocations()
	 */
	@Override
	public List<String> getArrivalLocations() {
		// TODO Auto-generated method stub
		LOG.info("Retrieving distinct arrival locations.");

		List<String> arrivalLocations;

		dao.begin();
		
		//query for getting the list of arrival location from the db.
		CriteriaBuilder criteriaBuilder = dao.getSession().getCriteriaBuilder();
		CriteriaQuery<String> criteriaQuery = criteriaBuilder.createQuery(String.class);
		Root<Flight> root = criteriaQuery.from(Flight.class);
		criteriaQuery.multiselect(root.get("arrivalLocation")).distinct(true);

		arrivalLocations = dao.getSession().createQuery(criteriaQuery).getResultList();

		return arrivalLocations;
	}

	/* (non-Javadoc)
	 * @see com.nagarro.dao.FlightDao#getDepartureLocations()
	 */
	@Override
	public List<String> getDepartureLocations() {
		// TODO Auto-generated method stub
		LOG.info("Retrieving distinct departure locations.");

		List<String> departLocations;

		dao.begin();
		
		//query for getting the depature locations from the db.
		CriteriaBuilder criteriaBuilder = dao.getSession().getCriteriaBuilder();
		CriteriaQuery<String> criteriaQuery = criteriaBuilder.createQuery(String.class);
		Root<Flight> root = criteriaQuery.from(Flight.class);
		criteriaQuery.multiselect(root.get("departLocation")).distinct(true);

		departLocations = dao.getSession().createQuery(criteriaQuery).getResultList();

		return departLocations;
	}
	
	
}
