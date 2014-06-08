package edu.ucar.cisl.ncarUsers.dal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;

import edu.ucar.cisl.ncarUsers.domain.Division;

public class DivisionDAOJDBCImpl extends SimpleJdbcDaoSupport implements DivisionDAO 
{
	public ArrayList<Division> getAllDivisions()
	{
		Collection divisions = this.getJdbcTemplate().query(
				"select ID, SHORT_NAME, NAME, DESCRIPTION, LAB_ID  from DIVISION",
				new RowMapper() {
					public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
						Division division = new Division();
						division.setID(rs.getInt("ID"));
						division.setShortName(rs.getString("SHORT_NAME"));
						division.setName(rs.getString("NAME"));
						division.setDescription(rs.getString("DESCRIPTION"));
						division.setLabID(rs.getInt("LAB_ID"));
						
						return division;
					}
				});
		ArrayList<Division> divs= new ArrayList <Division>();
		Iterator it=divisions.iterator();
		while (it.hasNext())
		{
			divs.add((Division)it.next());
		}
		
		return divs;		
	}
	
	public ArrayList<Division> getDivisions(int labID)
	{
		ArrayList<Division> divisions=this.getAllDivisions();
		Iterator <Division> it=divisions.iterator();
		ArrayList<Division> divs= new ArrayList <Division>();
		
		while (it.hasNext())
		{
			Division div=it.next();
			if (div.getLabID() == labID)
				divs.add(div);
		}
		
		return divs;
		
	}

}
