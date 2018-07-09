package controller;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ExitAction extends ActionSupport {

	@Override
	public String execute() throws Exception {
		Map session = ActionContext.getContext().getSession();
		session.remove("user");
		return SUCCESS;
	}
	
	public String exitShoper() throws Exception {
		Map session = ActionContext.getContext().getSession();
		session.remove("shoper");
		return SUCCESS;
	}
}
