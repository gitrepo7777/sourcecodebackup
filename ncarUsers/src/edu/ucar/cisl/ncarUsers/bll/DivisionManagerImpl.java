package edu.ucar.cisl.ncarUsers.bll;

import java.util.ArrayList;

import edu.ucar.cisl.ncarUsers.dal.DivisionDAO;
import edu.ucar.cisl.ncarUsers.domain.Division;
import edu.ucar.cisl.ncarUsers.domain.Lab;

public class DivisionManagerImpl implements DivisionManager 
{
	protected DivisionDAO divisionDao;
	protected ArrayList<Division> divisions=null;
	
	public ArrayList<Division> getDivisions(int labID)
	{
		return divisionDao.getDivisions(labID);
	}
	
	public ArrayList<Division> getDivisions()
	{
		if (divisions == null)
			divisions=divisionDao.getAllDivisions();
		return divisions;
		
	}

	public DivisionDAO getDivisionDao() {
		return divisionDao;
	}

	public void setDivisionDao(DivisionDAO divisionDao) {
		this.divisionDao = divisionDao;
	}
	
	public String getDivisionName(int id)
	{
		ArrayList<Division> ds=this.getDivisions();
		for (Division d : ds) 
		{
			if (d.getID() == id)
				return d.getName();
		}
		return "";
	}
	
	public int getDivisionID(String name)
	{
		ArrayList<Division> ds=this.getDivisions();
		for (Division d : ds) 
		{
			if (d.getName().equalsIgnoreCase(name))
				return d.getID();
		}
		return -1;
	}
	
	

}
