package edu.ucar.cisl.ncarUsers.dal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;

import edu.ucar.cisl.ncarUsers.domain.Division;
import edu.ucar.cisl.ncarUsers.domain.Lab;

public class LabDAOJDBCImpl extends SimpleJdbcDaoSupport implements LabDAO
{
	public ArrayList<Lab> getAllLabs()
	{
		Collection labs = this.getJdbcTemplate().query(
				"select ID, SHORT_NAME, NAME, DESCRIPTION from LAB",
				new RowMapper() {
					public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
						Lab lab = new Lab();
						lab.setID(rs.getInt("ID"));
						lab.setShortName(rs.getString("SHORT_NAME"));
						lab.setName(rs.getString("NAME"));
						lab.setDescription(rs.getString("DESCRIPTION"));						
						return lab;
					}
				});
		ArrayList<Lab> labs2= new ArrayList <Lab>();
		Iterator it=labs.iterator();
		while (it.hasNext())
		{
			labs2.add((Lab)it.next());
		}
		
		return labs2;		
	}

}
