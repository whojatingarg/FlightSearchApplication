package com.nagarro.daoimpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.springframework.beans.factory.annotation.Autowired;

import com.nagarro.dao.Dao;
import com.nagarro.dao.FlightFileDao;
import com.nagarro.dto.FlightFile;

/**
 * @author jatinkumar02
 * 
 * This class implements all the methods defined in FLightFileDao interface
 */
public class FlightFileDaoImpl implements FlightFileDao{

	private final static Logger LOG = Logger.getLogger(FlightFileDaoImpl.class);

	@Autowired
	private Dao dao;

	/* (non-Javadoc)
	 * @see com.nagarro.dao.FlightFileDao#getAllFlightFiles()
	 */
	@Override
	public List<FlightFile> getAllFlightFiles() {
		// TODO Auto-generated method stub
		LOG.info("Retrieving all FlightFile object of read files.");

		dao.begin();

		@SuppressWarnings("deprecation")
		Criteria criteria = dao.getSession().createCriteria(FlightFile.class);
		@SuppressWarnings("unchecked")
		List<FlightFile> flightFiles = (List<FlightFile>) criteria.list();

		dao.commit();
		dao.close();

		LOG.info("Retrieved all FlightFile objects of read files successfully.");
		return flightFiles;
	}

	/* (non-Javadoc)
	 * @see com.nagarro.dao.FlightFileDao#getFlightFile(java.lang.String)
	 */
	@Override
	public FlightFile getFlightFile(String fileName) {
		// TODO Auto-generated method stub
		LOG.info("Retrieving FlightFile object of : " + fileName);

		dao.begin();

		FlightFile flightFile = (FlightFile) dao.getSession().get(FlightFile.class, fileName);

		dao.commit();
		dao.close();

		LOG.info("Retrieved FlightFile object of " + fileName + " successfully.");
		return flightFile;
	}

	/* (non-Javadoc)
	 * @see com.nagarro.dao.FlightFileDao#updateFlightFile(com.nagarro.dto.FlightFile)
	 */
	@Override
	public void updateFlightFile(FlightFile flightFile) {
		// TODO Auto-generated method stub
		LOG.info("Updating FlightFile object of " + flightFile.getFileName());

		dao.begin();

		dao.getSession().update(flightFile);

		dao.commit();
		dao.close();

		LOG.info("Updated FlightFile object of " + flightFile.getFileName() + " successfully.");
	}

	/* (non-Javadoc)
	 * @see com.nagarro.dao.FlightFileDao#addFlightFile(com.nagarro.dto.FlightFile)
	 */
	@Override
	public void addFlightFile(FlightFile newFlightFile) {
		// TODO Auto-generated method stub
		LOG.info("Adding FlightFile object of " + newFlightFile.getFileName());

		dao.begin();

		dao.getSession().save(newFlightFile);

		dao.commit();
		dao.close();

		LOG.info("Added FlightFile object of " + newFlightFile.getFileName() + " successfully.");
	}



}
