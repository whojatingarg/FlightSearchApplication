package com.nagarro.daoimpl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.nagarro.dao.Dao;
import com.nagarro.dao.UserDao;
import com.nagarro.dto.User;

/**
 * @author jatinkumar02
 *
 *This class implements the methods defined in UserDao interface.
 */
public class UserDaoImpl implements UserDao {

	private final static Logger LOG = Logger.getLogger(FlightFileDaoImpl.class);

	@Autowired
	private Dao dao;
	
	/* (non-Javadoc)
	 * @see com.nagarro.dao.UserDao#addUser(com.nagarro.dto.User)
	 */
	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		LOG.info("Saving new user : " + user.getUserName());
		
		dao.begin();
		dao.getSession().save(user);
		dao.commit();
		dao.close();

		LOG.info("Saved new user : " + user.getUserName() + "successfully.");
		
	}

	/* (non-Javadoc)
	 * @see com.nagarro.dao.UserDao#getUser(java.lang.String)
	 */
	@Override
	public User getUser(String userName) {
		// TODO Auto-generated method stub
		LOG.info("Retriving User : " + userName);
		
		dao.begin();
		User user = (User) dao.getSession().get(User.class, userName);
		dao.commit();
		dao.close();

		LOG.info("Retrived User : " + userName + " successfully.");
		
		return user;
	}

}
