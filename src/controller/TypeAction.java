package controller;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import bean.Type;
import dao.BrandDAO;
import dao.BrandDAOImp;
import dao.FormsDAO;
import dao.FormsDAOImp;
import dao.TypeDAO;
import dao.TypeDAOImp;

public class TypeAction extends ActionSupport {
	List<Type> list;
	TypeDAO dao = new TypeDAOImp();
	Type type;

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public List<Type> getList() {
		return list;
	}

	public void setList(List<Type> list) {
		this.list = list;
	}

	public String execute() throws Exception {
		list = dao.getAllTypes();
		return SUCCESS;
	}

	public String findType() throws Exception {
		dao.findTypeById(type);
		return SUCCESS;
	}

	public String update() throws Exception {
		boolean istrue = false;
		istrue = dao.update(type);
		return istrue ? "success" : "fault";
	}
	
	public String addType() throws Exception {
		boolean istrue = false;
		if(!dao.isTypeExit(type.getC_name())){
			istrue = dao.addType(type.getC_name());
		}
		return istrue ? "success" : "fail";
	}
	
	public String delType() throws Exception {
		boolean istrue = false;
		FormsDAO formdao = new FormsDAOImp();
		BrandDAO branddao = new BrandDAOImp();
		istrue = dao.delType(type.getC_id());
		formdao.delByType(type.getC_id());
		branddao.delByType(type.getC_id());
		return istrue ? "success" : "fail";
	}
}
