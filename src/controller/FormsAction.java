package controller;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import bean.Forms;
import dao.FormsDAO;
import dao.FormsDAOImp;
import dao.Utils;

public class FormsAction extends ActionSupport {
	Forms forms;
	List<Forms> list;
	FormsDAO dao = new FormsDAOImp();

	public Forms getForms() {
		return forms;
	}

	public void setForms(Forms forms) {
		this.forms = forms;
	}

	public List<Forms> getList() {
		return list;
	}

	public void setList(List<Forms> list) {
		this.list = list;
	}

	public String execute() throws Exception {
		list = Utils.getAllForms(forms.getC_id());
		return SUCCESS;
	}

	
	public String findForm() throws Exception {
       return SUCCESS;
	}
	
	
	public String delForm() throws Exception {
        boolean isTrue = false;
        isTrue = dao.del(forms);
		return isTrue? "success":"fault";
	}

	public String addForm() throws Exception {
		boolean isTrue = false;
        isTrue = dao.add(forms);
		return isTrue? "success":"fault";
	}
}
