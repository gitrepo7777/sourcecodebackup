package edu.ucar.cisl.ncarUsers.presentation.rrh;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import edu.ucar.cisl.ncarUsers.bll.DivisionManager;
import edu.ucar.cisl.ncarUsers.domain.Division;
import edu.ucar.cisl.ncarUsers.presentation.BeanFactory;

@Path("/divisions/")
public class DivisionsResource {

	protected @Context
	UriInfo uriInfo;
	protected DivisionManager divisionManager;

	public DivisionsResource() {
		divisionManager = (DivisionManager) BeanFactory.getInstance().getBean("divisionManager");
	}

	@GET
	@Produces("application/json")
	public JSONArray getDivisions(@QueryParam("labID")
	String labID) throws JSONException {
		int id = Integer.parseInt(labID);
		ArrayList<Division> divisions = this.divisionManager.getDivisions(id);
		JSONArray divisionsArray = new JSONArray();
		for (Division division : divisions) {
			JSONObject obj = new JSONObject();
			obj.put("ID", division.getID()).put("name", division.getName());

			divisionsArray.put(obj);
		}
		return divisionsArray;
	}
}
