package edu.ucar.cisl.ncarUsers.dal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;

import edu.ucar.cisl.ncarUsers.domain.User;

public class UserDAOJDBCImpl extends SimpleJdbcDaoSupport implements UserDAO {
	public User getUser(String s) {
		String criteria="USERNAME = '" + s + "'";
		ArrayList<User> users=getUsers(criteria);
		if (users.size() > 0)
			return users.get(0);
		else
			return null;
	}

	public void addUser(User user) {

		Object objs[] = new Object[7];
		objs[0] = user.getUserName();
		objs[1] = user.getPassword();
		objs[2] = user.getEmail();
		objs[3] = user.getFirstName();
		objs[4] = user.getLastName();
		objs[5] = user.getLab();
		objs[6] = user.getDivision();

		this.getJdbcTemplate().update("insert into USER (USERNAME, PASSWORD, EMAIL, FIRST_NAME, LAST_NAME, LAB, DIVISION ) values (?, ?, ?, ?, ?, ?, ?)", objs);
	}
	
	public ArrayList<User> getAllUsers()
	{
		return getUsers(null);
	}
	
	protected ArrayList<User> getUsers(String criteria)
	{
		String query="select ID, USERNAME, PASSWORD, EMAIL, FIRST_NAME, LAST_NAME, LAB, DIVISION  from USER";
		if (criteria != null && criteria.trim().length() > 0)
			query= query + " Where " + criteria;
		Collection users = this.getJdbcTemplate().query(query,
				new RowMapper() {
					public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
						User user = new User();
						user.setID(rs.getInt("ID"));
						user.setUserName(rs.getString("USERNAME"));
						user.setPassword(rs.getString("PASSWORD"));
						user.setEmail(rs.getString("EMAIL"));
						user.setFirstName(rs.getString("FIRST_NAME"));
						user.setLastName(rs.getString("LAST_NAME"));
						user.setLab(rs.getInt("LAB"));
						user.setDivision(rs.getInt("DIVISION"));
						return user;
					}
				});
		ArrayList<User> results= new ArrayList <User>();
		Iterator it=users.iterator();
		while (it.hasNext())
		{
			results.add((User)it.next());
		}
		
		return results;		
	}

}
