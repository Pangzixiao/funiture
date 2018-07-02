package controller;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import bean.Brand;
import dao.BrandDAO;
import dao.BrandDAOImp;
import dao.Utils;

public class BrandAction extends ActionSupport {
	Brand brand;
	List<Brand> list = new ArrayList<Brand>();
	BrandDAO dao = new BrandDAOImp();
	
	public Brand getBrand() {
		return brand;
	}


	public void setBrand(Brand brand) {
		this.brand = brand;
	}


	public List<Brand> getList() {
		return list;
	}


	public void setList(List<Brand> list) {
		this.list = list;
	}


	public String execute() throws Exception {
		list = Utils.getAllBrands(brand.getC_id());
		return SUCCESS;
	}

	
	public String findBrand() throws Exception {
       return SUCCESS;
	}
	
	
	public String delBrand() throws Exception {
        boolean isTrue = false;
        isTrue = dao.del(brand);
		return isTrue? "success":"fault";
	}

	public String addBrand() throws Exception {
		boolean isTrue = false;
        isTrue = dao.add(brand);
		return isTrue? "success":"fault";
	}
}
