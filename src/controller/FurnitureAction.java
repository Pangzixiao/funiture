package controller;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import bean.Brand;
import bean.Detail;
import bean.Forms;
import bean.Furniture;
import bean.Type;
import dao.FurnitureDAO;
import dao.FurnitureDAOImp;
import dao.TypeDAO;
import dao.TypeDAOImp;
import dao.Utils;

public class FurnitureAction extends ActionSupport {
	List<Forms> forms;
	List<Brand> brands;
	Furniture furniture;
	List<Furniture> list;
	Detail detail = new Detail();
	String form;
	FurnitureDAO furnituredao = new FurnitureDAOImp();

	
	public String getForm() {
		return form;
	}

	public void setForm(String form) {
		this.form = form;
	}

	public List<Forms> getForms() {
		return forms;
	}

	public List<Brand> getBrands() {
		return brands;
	}

	public Furniture getFurniture() {
		return furniture;
	}

	public void setFurniture(Furniture furniture) {
		this.furniture = furniture;
	}

	public Detail getDetail() {
		return detail;
	}

	public List<Furniture> getList() {
		return list;
	}

	public String addFurniture() throws Exception {
		boolean isTrue = false;
		furniture.setSalevolume(0);
		// furniture.setPic_src(path);
		// 将信息存入数据库
		detail.setDetail_id(furniture.getDetail_id());
		System.out.println("furniture_id = " + furniture.getFurniture_id());
		isTrue = furnituredao.add(furniture);
		// 得到该分类的分类号
		TypeDAO typedao = new TypeDAOImp();
		Type type = new Type();
		type.setC_name(furniture.getType());
		typedao.findTypeByName(type);
		// 得到该分类下所有的风格
		Utils utils = new Utils();
		forms = utils.getAllForms(type.getC_id());

		// 得到该分类下所有的品牌
		brands = utils.getAllBrands(type.getC_id());
		return isTrue ? "suc" : "fail";
	}

	public String getAllFunitureByshoper() throws Exception {
		boolean isTrue = false;
		Map session = ActionContext.getContext().getSession();
		String uid = (String)session.get("shoper");
		if(uid != null){
			list = furnituredao.getAllFurniture(uid);
			if(!list.isEmpty()){
				isTrue = true;
			}
		}
		return isTrue?"success":"fail";
	}

	
	public String showTotalInfoForShoper() throws Exception {
		boolean isTrue = false;
		Map session = ActionContext.getContext().getSession();
		String uid = (String)session.get("shoper");
		if(uid!=null){
			list = furnituredao.getAllFurniture(uid);
			if(!list.isEmpty()){
				isTrue = true;
			}
		}
		return isTrue?"success":"fail";
	}
}
