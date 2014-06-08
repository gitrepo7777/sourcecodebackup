package edu.ucar.cisl.ncarUsers.bll;

import java.util.ArrayList;

import edu.ucar.cisl.ncarUsers.domain.Lab;


public interface LabManager 
{
	public ArrayList<Lab> getLabs();
	public String getLabName(int id);
	public int getLabID(String name);
	

}
