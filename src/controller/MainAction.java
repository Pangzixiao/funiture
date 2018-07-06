package controller;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import bean.Brand;
import bean.Forms;
import bean.Furniture;
import bean.Type;
import dao.BrandDAO;
import dao.BrandDAOImp;
import dao.DetailDAO;
import dao.DetailDAOImp;
import dao.FormsDAO;
import dao.FormsDAOImp;
import dao.FurnitureDAO;
import dao.FurnitureDAOImp;
import dao.TypeDAO;
import dao.TypeDAOImp;
import dao.Utils;

public class MainAction extends ActionSupport {
	List<Type> types;
	TypeDAO typedao = new TypeDAOImp();
	List<String> forms;
	FormsDAO formsdao = new FormsDAOImp();
	List<String> brands;
	BrandDAO branddao = new BrandDAOImp();
	FurnitureDAO furnituredao = new FurnitureDAOImp();
	List<Forms> formlist;
	List<Brand> brandlist;
	Forms form;
	Type type;
	String form_string;
	List<Furniture> furnitures;
	DetailDAO detaildao = new DetailDAOImp();

	public String getForm_string() {
		return form_string;
	}

	public void setForm_string(String form_string) {
		this.form_string = form_string;
	}

	public Forms getForm() {
		return form;
	}

	public void setForm(Forms form) {
		this.form = form;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public List<Furniture> getFurnitures() {
		return furnitures;
	}

	public List<Type> getTypes() {
		return types;
	}

	public List<String> getForms() {
		return forms;
	}

	public List<String> getBrands() {
		return brands;
	}

	public List<Forms> getFormlist() {
		return formlist;
	}

	public List<Brand> getBrandlist() {
		return brandlist;
	}

	public String gettypes() throws Exception {
		types = typedao.getAllTypes();
		forms = formsdao.getAllForms();
		brands = branddao.getAllBrands();
		return SUCCESS;
	}

	public String selectByType() throws Exception {
		Utils utils = new Utils();
		formlist = utils.getAllForms(type.getC_id());
		brandlist = utils.getAllBrands(type.getC_id());
		furnitures = furnituredao.getAllFurnitureByType(type.getC_name());
		return SUCCESS;
	}

	public String selectByForm() throws Exception {
		types = typedao.getAllTypes();
		forms = formsdao.getAllForms();
		brands = branddao.getAllBrands();
		List<Integer> ids = detaildao.getAllDetailID(form_string);
		furnitures = new ArrayList<Furniture>();
		if (!ids.isEmpty()) {
			for (int detail_id : ids) {
				Furniture f = furnituredao.getAllFurnitureByDetail(detail_id);
				if (f != null){
					furnitures.add(f);
				}
			}
		}
		return SUCCESS;
	}
}
