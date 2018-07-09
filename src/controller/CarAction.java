package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import bean.Car_Furniture;
import bean.Furniture;
import dao.FurnitureDAO;
import dao.FurnitureDAOImp;

public class CarAction extends ActionSupport {
	List<Furniture> list = new ArrayList<Furniture>();
	int id;

	public List<Furniture> getList() {
		return list;
	}

	Car_Furniture car_furniture;
	FurnitureDAO dao = new FurnitureDAOImp();

	public void setCar_furniture(Car_Furniture car_furniture) {
		this.car_furniture = car_furniture;
	}

	
	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	// �ж��û��Ƿ��й��ﳵ��û���¼���һ�����ﳵ
	private List<Car_Furniture> getCar() {
		Map session = ActionContext.getContext().getSession();
		List<Car_Furniture> cars = (List<Car_Furniture>) session.get("car");
		if (cars == null) {
			System.out.println("�û�û�й��ﳵ");
			cars = new ArrayList<Car_Furniture>();
			session.put("car", cars);
		}
		return cars;
	}

	public String execute() throws Exception {
		List<Car_Furniture> cars = getCar();
		if (cars.isEmpty()) {
			System.out.println("���ﳵΪ��");
			return "empty";
		} else {
			for (Car_Furniture car : cars) {
				Furniture ftemp = dao.getFurniture(car.getShoper(), car.getF_id());
				if (ftemp != null) {
					list.add(ftemp);
				}
			}
			if (list.isEmpty()) {
				System.out.println("���ﳵΪ��");
				return "empty";
			} else
				return "success";
		}
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
			car_furniture.setF_id(id);
			session = ActionContext.getContext().getSession();
			List<Car_Furniture> cars = (List<Car_Furniture>) session.get("car");
			if (cars==null) {
				cars = new ArrayList<Car_Furniture>();
			}
			cars.add(car_furniture);
			session.put("car", cars);
			System.out.println("��ӵ��ɹ����ﳵ");
			
			isTrue = true;
		}
		return isTrue ? "success" : "fail";
	}
	
	public String removeFromCar() throws Exception {
		boolean isTrue = false;

		Map session = ActionContext.getContext().getSession();
		List<Car_Furniture> cars = (List<Car_Furniture>) session.get("car");
		car_furniture.setF_id(id);
		List<Car_Furniture> newcars= new ArrayList<Car_Furniture>();
		if (cars != null) {
			for (Car_Furniture car : cars) {
				System.out.println("caruid:"+car.getShoper()+"  carf_id:"+car.getF_id());
				
				if (!car.equals(car_furniture)) {
					newcars.add(car);
				}
			}
			session.put("car", newcars);
			isTrue = true;
		}else{
			cars = new ArrayList<Car_Furniture>();
			session.put("car", cars);
		}

		return isTrue ? "success" : "fail";
	}
}
