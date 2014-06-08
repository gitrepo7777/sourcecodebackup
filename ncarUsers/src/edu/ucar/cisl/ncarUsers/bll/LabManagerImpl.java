package edu.ucar.cisl.ncarUsers.bll;

import java.util.ArrayList;

import edu.ucar.cisl.ncarUsers.dal.LabDAO;
import edu.ucar.cisl.ncarUsers.domain.Lab;
import edu.ucar.cisl.ncarUsers.domain.User;

public class LabManagerImpl implements LabManager 
{
	protected LabDAO labDao;
	protected ArrayList<Lab> labs=null;
	
	public ArrayList<Lab>  getLabs()
	{
		if (labs == null)
			labs = labDao.getAllLabs();
		
		return labs;
		
	}

	public LabDAO getLabDao() {
		return labDao;
	}

	public void setLabDao(LabDAO labDao) {
		this.labDao = labDao;
	}
	
	public String getLabName(int id)
	{
		ArrayList<Lab> ls=this.getLabs();
		for (Lab lab : ls) 
		{
			if (lab.getID() == id)
				return lab.getName();
		}
		return "";
		
	}
	
	public int getLabID(String name)
	{
		ArrayList<Lab> ls=this.getLabs();
		for (Lab lab : ls) 
		{
			if (lab.getName().equalsIgnoreCase(name))
				return lab.getID();
		}
		return -1;
		
	}
	
}
