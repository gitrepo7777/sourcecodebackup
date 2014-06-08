package edu.ucar.cisl.ncarUsers.presentation.brh;

import edu.ucar.cisl.ncarUsers.domain.Division;
import edu.ucar.cisl.ncarUsers.domain.Lab;
import edu.ucar.cisl.ncarUsers.domain.User;

import java.io.Serializable;
import java.util.ArrayList;

public class AddUserForm implements Serializable {
	protected ArrayList<Lab> labs;
	protected User user;

	public AddUserForm() {
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public ArrayList<Lab> getLabs() {
		return labs;
	}

	public void setLabs(ArrayList<Lab> labs) {
		this.labs = labs;
	}
}
