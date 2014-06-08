package edu.ucar.cisl.ncarUsers.bll;

import java.util.ArrayList;

import edu.ucar.cisl.ncarUsers.domain.Division;

public interface DivisionManager 
{
	public ArrayList<Division> getDivisions(int labID);
	public ArrayList<Division> getDivisions();
	public String getDivisionName(int id);
	public int getDivisionID(String name);

}
