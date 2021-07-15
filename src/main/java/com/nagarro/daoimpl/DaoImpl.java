package com.nagarro.daoimpl;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nagarro.dao.Dao;

/**
 * @author jatinkumar02
 * 
 * This class implements all the methods specified in the Dao interface.
 *
 */
public class DaoImpl implements Dao{

	private final static Logger LOG = Logger.getLogger(DaoImpl.class);
	
	// establishing the connection to the db.
	private Configuration configuration = new Configuration().configure();
	private SessionFactory sessionFactory = configuration.buildSessionFactory();
	private Session session;
	
	
	/* (non-Javadoc)
	 * @see com.nagarro.dao.Dao#getSession()
	 */
	@Override
	public Session getSession() {
		// TODO Auto-generated method stub
		return session;
	}

	/* (non-Javadoc)
	 * @see com.nagarro.dao.Dao#begin()
	 */
	@Override
	public void begin() {
		// TODO Auto-generated method stub
		LOG.info("Starting new session.");
		session = sessionFactory.openSession();

		LOG.info("Starting new transaction.");
		session.beginTransaction();
	}

	/* (non-Javadoc)
	 * @see com.nagarro.dao.Dao#commit()
	 */
	@Override
	public void commit() {
		// TODO Auto-generated method stub
		LOG.info("Committing transaction.");
		session.getTransaction().commit();

	}

	/* (non-Javadoc)
	 * @see com.nagarro.dao.Dao#close()
	 */
	@Override
	public void close() {
		// TODO Auto-generated method stub
		LOG.info("Closing session.");
		session.close();

	}

	/* (non-Javadoc)
	 * @see com.nagarro.dao.Dao#rollback()
	 */
	@Override
	public void rollback() {
		// TODO Auto-generated method stub
		LOG.info("Rollback transaction.");
		session.getTransaction().rollback();
	}

	
}
