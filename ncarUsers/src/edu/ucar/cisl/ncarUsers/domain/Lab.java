package edu.ucar.cisl.ncarUsers.domain;

import java.io.Serializable;

public class Lab implements Serializable
{
    protected int ID;
    protected String shortName;
    protected String name;
    protected String description;
    
	public int getID() {
		return ID;
	}
	public void setID(int id) {
		ID = id;
	}
	public String getShortName() {
		return shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
    
    
}
