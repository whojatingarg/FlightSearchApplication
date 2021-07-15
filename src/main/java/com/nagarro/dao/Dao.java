package com.nagarro.dao;

import org.hibernate.Session;

/**
 * @author jatinkumar02
 * 
 * This interface specifies all the methods used to interact with the database.
 *
 */
public interface Dao {

	/**
	 * This method get the session object to work upon the db.
	 */
	public Session getSession();
	
	
	/**
	 * This method begin the transaction
	 */
	public void begin();
	
	/**
	 * This method commit the transaction
	 */
	public void commit();
	
	/**
	 * This method close the connection from the db.
	 */
	public void close();
	
	/**
	 * This method rollback the transaction
	 */
	public void rollback();
	
}
