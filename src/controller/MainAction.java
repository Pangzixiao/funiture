package controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import bean.Brand;
import bean.ComparatorByPrice;
import bean.ComparatorByPrice2;
import bean.ComparatorBySalevolume;
import bean.ComparatorBySalevolume2;
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
	// 可能是常用值
	Type type = new Type();
	double minprice, maxprice;
	String form_string, brand_string;
	int  sort_type ;
	List<Furniture> furnitures;
	Furniture furniture;
	DetailDAO detaildao = new DetailDAOImp();
	ComparatorByPrice comparatorByPrece = new ComparatorByPrice();
	ComparatorByPrice2 comparatorByPrece2 = new ComparatorByPrice2();
	ComparatorBySalevolume comparatorBySalevolume = new ComparatorBySalevolume();
	ComparatorBySalevolume2 comparatorBySalevolume2 = new ComparatorBySalevolume2();
	

	public void setSort_type(int sort_type) {
		this.sort_type = sort_type;
	}

	public Furniture getFurniture() {
		return furniture;
	}

	public void setFurniture(Furniture furniture) {
		this.furniture = furniture;
	}

	public void setMinprice(double minprice) {
		this.minprice = minprice;
	}

	public void setMaxprice(double maxprice) {
		this.maxprice = maxprice;
	}

	public String getForm_string() {
		return form_string;
	}

	public void setForm_string(String form_string) {
		this.form_string = form_string;
	}

	public String getBrand_string() {
		return brand_string;
	}

	public void setBrand_string(String brand_string) {
		this.brand_string = brand_string;
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
		types = typedao.getAllTypes();
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
		List<Integer> ids = detaildao.getAllDetailID("form", form_string);
		furnitures = new ArrayList<Furniture>();
		if (!ids.isEmpty()) {
			for (int detail_id : ids) {
				Furniture f = furnituredao.getAllFurnitureByDetail(detail_id);
				if (f != null) {
					furnitures.add(f);
				}
			}
		}
		return SUCCESS;
	}

	public String selectByBrand() throws Exception {
		types = typedao.getAllTypes();
		forms = formsdao.getAllForms();
		brands = branddao.getAllBrands();
		List<Integer> ids = detaildao.getAllDetailID("brand", brand_string);
		furnitures = new ArrayList<Furniture>();
		if (!ids.isEmpty()) {
			for (int detail_id : ids) {
				Furniture f = furnituredao.getAllFurnitureByDetail(detail_id);
				if (f != null) {
					furnitures.add(f);
				}
			}
		}
		return SUCCESS;
	}

	public String selectByPrice() throws Exception {
		types = typedao.getAllTypes();
		forms = formsdao.getAllForms();
		brands = branddao.getAllBrands();
		furnitures = furnituredao.getAllFurnitureByPrice(minprice, maxprice);
		return SUCCESS;
	}

	public String selectByFormType() throws Exception {
		types = typedao.getAllTypes();
		Utils utils = new Utils();
		formlist = utils.getAllForms(type.getC_id());
		brandlist = utils.getAllBrands(type.getC_id());
		List<Integer> ids = detaildao.getAllDetailID("form", form_string);
		furnitures = new ArrayList<Furniture>();
		if (!ids.isEmpty()) {
			for (int detail_id : ids) {
				Furniture f = furnituredao.getAllFurnitureByDetail(detail_id);
				if (f != null && f.getType().equals(type.getC_name())) {
					furnitures.add(f);
				}
			}
		}
		return SUCCESS;
	}

	public String selectByBrandType() throws Exception {
		types = typedao.getAllTypes();
		Utils utils = new Utils();
		formlist = utils.getAllForms(type.getC_id());
		brandlist = utils.getAllBrands(type.getC_id());
		List<Integer> ids = detaildao.getAllDetailID("brand", brand_string);
		furnitures = new ArrayList<Furniture>();
		if (!ids.isEmpty()) {
			for (int detail_id : ids) {
				Furniture f = furnituredao.getAllFurnitureByDetail(detail_id);
				if (f != null && f.getType().equals(type.getC_name())) {
					furnitures.add(f);
				}
			}
		}
		return SUCCESS;
	}

	public String selectByPriceType() throws Exception {
		types = typedao.getAllTypes();
		Utils utils = new Utils();
		formlist = utils.getAllForms(type.getC_id());
		brandlist = utils.getAllBrands(type.getC_id());
		List<Furniture> oldlist = furnituredao.getAllFurnitureByPrice(minprice, maxprice);
		furnitures = new ArrayList<Furniture>();
		for (Furniture f : oldlist) {
			if (f.getType().equals(type.getC_name())) {
				furnitures.add(f);
			}
		}
		return SUCCESS;
	}
	
	
	public String selectForOrder() throws Exception {
		types = typedao.getAllTypes();
		Utils utils = new Utils();
		formlist = utils.getAllForms(type.getC_id());
		brandlist = utils.getAllBrands(type.getC_id());
		furnitures = furnituredao.getAllFurnitureByType(type.getC_name());
		System.out.println("当前的选择是:"+sort_type);
		if(sort_type==0){
			Collections.sort(furnitures, comparatorByPrece);
			return "price1";
		}else if(sort_type==1){
			Collections.sort(furnitures, comparatorByPrece2);
			return "price2";
		}else if(sort_type==3){
			Collections.sort(furnitures, comparatorBySalevolume);
			return "salevolume1";
		}else if(sort_type==4){
			Collections.sort(furnitures, comparatorBySalevolume2);
			return "salevolume2";
		}
		return "price1";
		
	}
	
	
}
