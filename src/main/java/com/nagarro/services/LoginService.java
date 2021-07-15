package com.nagarro.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.dao.UserDao;
import com.nagarro.dto.User;

/**
 * @author jatinkumar02
 *
 *This class provides the login service to the user.
 */
@Service
public class LoginService {

	@Autowired
	private UserDao userDao;
	
	/**
	 * This validates the user that if user exists or not and 
	 * if the password entered by the user is correct or not.
	 * @param userName
	 * @param password
	 * @return true is user exists and password is correct otherwise false.
	 */
	public boolean validateUser(String userName, String password) {
		
		User user = userDao.getUser(userName);

		return user != null && user.getPassword().equals(password);
	}
	
}
