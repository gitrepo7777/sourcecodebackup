package edu.ucar.cisl.ncarUsers.dal;

import java.util.ArrayList;

import edu.ucar.cisl.ncarUsers.domain.Division;

public interface DivisionDAO
{
	public ArrayList<Division> getAllDivisions();
	public ArrayList<Division> getDivisions(int labID);
}
