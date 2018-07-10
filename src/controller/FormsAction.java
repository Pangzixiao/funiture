package controller;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import bean.Forms;
import bean.Type;
import dao.FormsDAO;
import dao.FormsDAOImp;
import dao.TypeDAO;
import dao.TypeDAOImp;
import dao.Utils;

public class FormsAction extends ActionSupport {
	Forms forms;
	List<Forms> list;
	List<Type> types;
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
	
	public List<Type> getTypes() {
		return types;
	}

	public String findForm() throws Exception {
	   System.out.println("form_id"+forms.getC_id());
       return SUCCESS;
	}
	
	
	public String delForm() throws Exception {
        boolean isTrue = false;
        isTrue = dao.del(forms);
		return isTrue? "success":"fault";
	}

	public String addForm() throws Exception {
		boolean isTrue = false;
		if(!dao.isExit(forms.getC_id(),forms.getForm_name())){
			isTrue = dao.add(forms);
		}
		return isTrue? "success":"fault";
	}
	
	public String gettypes() throws Exception{
		TypeDAO typedao = new TypeDAOImp();
		types = typedao.getAllTypes();
		return SUCCESS;
	}
}
