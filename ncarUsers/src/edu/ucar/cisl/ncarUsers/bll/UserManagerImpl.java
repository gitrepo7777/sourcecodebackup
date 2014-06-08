package edu.ucar.cisl.ncarUsers.bll;

import java.util.ArrayList;

import edu.ucar.cisl.ncarUsers.dal.UserDAO;
import edu.ucar.cisl.ncarUsers.domain.User;


public class UserManagerImpl implements UserManager
{
	protected UserDAO userDao;
	
	public User getUser(String userName)
	{
		return userDao.getUser(userName);
	}
	
	public void addUser(User user)
	{
		userDao.addUser(user);
	}

	public UserDAO getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}
	
	public ArrayList<User> getAllUsers()
	{
		return userDao.getAllUsers();
	}
	
}
