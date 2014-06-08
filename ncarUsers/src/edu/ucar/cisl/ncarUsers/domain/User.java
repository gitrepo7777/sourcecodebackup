package edu.ucar.cisl.ncarUsers.domain;

import java.io.Serializable;

public class User
    implements Serializable
{
	protected int ID;
    protected String userName;
    protected String password;
    protected String firstName;
    protected String lastName;
    protected String email;
    protected int lab;
    protected int division;
    
	public int getID() {
		return ID;
	}
	public void setID(int id) {
		ID = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getLab() {
		return lab;
	}
	public void setLab(int lab) {
		this.lab = lab;
	}
	public int getDivision() {
		return division;
	}
	public void setDivision(int division) {
		this.division = division;
	}
    
    
    
}
