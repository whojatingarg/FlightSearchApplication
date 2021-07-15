package com.nagarro.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.dao.UserDao;
import com.nagarro.dto.User;

/**
 * @author jatinkumar02
 *
 * This class provides the services for new user to sign up.
 */
@Service
public class SignUpService {

	
	@Autowired
	private UserDao userDao;
	
	/**
	 * This checks if user already present in the db or not
	 * @param userName
	 * @return true if user does not exists otherwise false.
	 */
	public boolean userExists(String userName) {
		
		User user = userDao.getUser(userName);
		
		if(user != null) {
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * This add the new user in to the db.
	 * @param userName
	 * @param password
	 */
	public void addNewUser(String userName, String password) {
		
		User user = new User();
		user.setUserName(userName);
		user.setPassword(password);
		userDao.addUser(user);
		
	}
	
	/**
	 * This checks if the entered password by the user is valid or not.
	 * @param password
	 * @return true if password is correct otherwise false.
	 */
	public boolean validPassword(String password) {
		
		if(password.length() >10) {
			return false;
		}else {
			return true;
		}
	}

	/**
	 * This confirms if both the passwords entered by the user in same or not.
	 * @param password
	 * @param confirmPassword
	 * @return true if same otherwise false.
	 */
	public boolean passwordMatches(String password, String confirmPassword) {
		// TODO Auto-generated method stub
		
		return password.equals(confirmPassword);
	}

	/**
	 * This validates the username for spaces
	 * @param userName
	 * @return true is not contais space otherwise false.
	 */
	public boolean validUsername(String userName) {
		// TODO Auto-generated method stub
		return !userName.contains(" ");
	}
	
}
