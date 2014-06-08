package edu.ucar.cisl.ncarUsers.presentation.brh;

import org.springframework.webflow.action.FormAction;
import org.springframework.webflow.execution.Event;
import org.springframework.webflow.execution.RequestContext;

import edu.ucar.cisl.ncarUsers.bll.LabManager;
import edu.ucar.cisl.ncarUsers.bll.UserManager;
import edu.ucar.cisl.ncarUsers.domain.User;

public class AddUserFormAction extends FormAction {
	protected UserManager userManager;
	protected LabManager labManager;

	public AddUserFormAction() {
		userManager = null;
	}

	public Event initForm(RequestContext context) throws Exception {
		AddUserForm form = (AddUserForm) getFormObject(context);
		form.setLabs(this.labManager.getLabs());
		form.setUser(new User());
		return success();
	}

	public Event submit(RequestContext context) throws Exception {
		AddUserForm form = (AddUserForm) getFormObject(context);
		User user = form.getUser();
		userManager.addUser(user);
		return success();
	}

	public Event addNewUser(RequestContext context) throws Exception {
		initForm(context);
		return success();
	}

	public UserManager getUserManager() {
		return userManager;
	}

	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}

	public LabManager getLabManager() {
		return labManager;
	}

	public void setLabManager(LabManager labManager) {
		this.labManager = labManager;
	}

}
