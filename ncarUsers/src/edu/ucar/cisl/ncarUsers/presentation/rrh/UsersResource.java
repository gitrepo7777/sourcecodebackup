package edu.ucar.cisl.ncarUsers.presentation.rrh;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import edu.ucar.cisl.ncarUsers.bll.DivisionManager;
import edu.ucar.cisl.ncarUsers.bll.LabManager;
import edu.ucar.cisl.ncarUsers.bll.UserManager;
import edu.ucar.cisl.ncarUsers.domain.User;
import edu.ucar.cisl.ncarUsers.presentation.BeanFactory;

@Path("/users/")
public class UsersResource {

	protected @Context
	UriInfo uriInfo;
	protected UserManager userManager;
	protected DivisionManager divisionManager;
	protected LabManager labManager;

	public UsersResource() {
		userManager = (UserManager) BeanFactory.getInstance().getBean("userManager");
		divisionManager = (DivisionManager)BeanFactory.getInstance().getBean("divisionManager");
		labManager = (LabManager)BeanFactory.getInstance().getBean("labManager");
	}

	@Path("{userName}/")
	public UserResource getUser(@PathParam("userName")
	String userName) {
		return new UserResource(uriInfo, userManager, userName);
	}

	@GET
	@Produces("application/json")
	public JSONArray getUsersAsJsonArray() throws JSONException {
		ArrayList<User> users = this.userManager.getAllUsers();
		JSONArray usersArray = new JSONArray();
		for (User user : users) {
			JSONObject obj = new JSONObject();
			obj.put("USERNAME", user.getUserName());
			obj.put("PASSWORD", user.getPassword());
			obj.put("FIRST_NAME", user.getFirstName());
			obj.put("LAST_NAME", user.getLastName());
			obj.put("EMAIL", user.getEmail());
			String labName=labManager.getLabName(user.getLab());
			obj.put("LAB", labName);
			String divisionName=divisionManager.getDivisionName(user.getDivision());
			obj.put("DIVISION", divisionName);

			usersArray.put(obj);
		}
		return usersArray;
	}

	@PUT
	@Consumes("text/plain")
	public Response putUsers(String input) throws IOException {

		Reader reader=new StringReader(input);
		BufferedReader br=new BufferedReader(reader);
		while (true)
		{
			String line=br.readLine();
			if (line == null)
				break;
			processUser(line);
			
		}
		
		
		return Response.created(uriInfo.getAbsolutePath()).build();

	}
	
	/********************************
	 * If the user exists, update it. Otherwise, create a new one
	 * @param input
	 */
	protected void processUser(String input)
	{
		StringTokenizer token=new StringTokenizer(input, "|");
		String userName=token.nextToken();
		String password=token.nextToken();
		String firstName=token.nextToken();
		String lastName=token.nextToken();
		String email=token.nextToken();
		String labName=token.nextToken();
		String divisionName=token.nextToken();
		
		int lab=this.labManager.getLabID(labName);
		int division=this.divisionManager.getDivisionID(divisionName);
		User user=this.userManager.getUser(userName);
		if (user == null)
			user=new User();
		
		user.setUserName(userName);
		user.setPassword(password);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setEmail(email);
		user.setLab(lab);
		user.setDivision(division);
		
		this.userManager.addUser(user);
		
	}

}
