package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import bean.Brand;
import bean.Car_Furniture;
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
	String form_string, brand_string, sort_type = new String("1");
	List<Furniture> furnitures;
	Furniture furniture;
	DetailDAO detaildao = new DetailDAOImp();

	public void setSort_type(String sort_type) {
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
		type.setC_id(type.getC_id());
		type.setC_name(type.getC_name());
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
		furnitures = furnituredao.getAllFurnitureByPrice(minprice, maxprice);
		for (Furniture f : furnitures) {
			if (!f.getType().equals(type.getC_name())) {
				furnitures.remove(f);
			}
		}
		return SUCCESS;
	}

	private String getUid() {
		Map session = ActionContext.getContext().getSession();
		Object o = session.get("user");
		if (o == null) {
			return null;
		} else {
			return (String) o;
		}
	}

	public String addInCar() throws Exception {
		boolean isTrue = false;
		Map session = ActionContext.getContext().getSession();
		Object o = session.get("user");
		if (o != null ) {
			String uid = (String)o;
			Car_Furniture car = new Car_Furniture();
			car.setF_id(furniture.getFurniture_id());
			car.setShoper(furniture.getUid());
			session = ActionContext.getContext().getSession();
			List<Car_Furniture> cars = (List<Car_Furniture>) session.get("car");
			if (cars==null) {
				cars = new ArrayList<Car_Furniture>();
			}
			cars.add(car);
			session.put("car", cars);
			System.out.println("添加到成功购物车");
			
			isTrue = true;
		}
		return isTrue ? "success" : "fail";
	}
}
