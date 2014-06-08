package edu.ucar.cisl.ncarUsers.bll;

import java.util.ArrayList;

import edu.ucar.cisl.ncarUsers.domain.User;

public interface UserManager
{
	public User getUser(String userName);
	
	public void addUser(User user);
	
	public ArrayList<User> getAllUsers();
}
