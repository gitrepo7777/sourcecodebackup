package edu.ucar.cisl.ncarUsers.dal;

import java.util.ArrayList;

import edu.ucar.cisl.ncarUsers.domain.User;

public interface UserDAO
{
    public User getUser(String s);    
    public void addUser(User user);
    public ArrayList<User> getAllUsers();
}
