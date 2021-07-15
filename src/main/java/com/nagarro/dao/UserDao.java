package com.nagarro.dao;

import com.nagarro.dto.User;

/**
 * @author jatinkumar02
 * 
 * This interface provide methods to interact with db for the user object.
 *
 */
public interface UserDao {

	/**
	 * This methods adds the new user into the db.
	 * @param user
	 */
	public void addUser(User user);
	
	/**
	 * 
	 * This method search the user with the given name in db and returns it.
	 * @param userName
	 * @return user
	 */
	public User getUser(String userName);
	
}
