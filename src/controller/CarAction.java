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

	public List<Furniture> getList() {
		return list;
	}

	FurnitureDAO dao = new FurnitureDAOImp();
	
    //判断用户是否有购物车，没有新加入一个购物车
	private List<Car_Furniture> getCar(){
		Map session = ActionContext.getContext().getSession();
		List<Car_Furniture> cars = (List<Car_Furniture>)session.get("car");
		if(cars==null){
			System.out.println("用户没有购物车");
			cars = new ArrayList<Car_Furniture>();
			session.put("car", cars);
		}
		return cars;
	}
	
	public String execute()throws Exception{
		List<Car_Furniture> cars = getCar();
		if(cars.isEmpty()){
			System.out.println("购物车为空");
			return "empty";
		}else{
			for(Car_Furniture car : cars ){
				Furniture ftemp = dao.getFurniture(car.getShoper(), car.getF_id());
				System.out.println("当前家具id:"+ftemp.getFurniture_id());
				System.out.println("当前家具商家:"+ftemp.getUid());
				if(ftemp != null ){
					list.add(ftemp);
				}
			}
			if(list.isEmpty()){
				System.out.println("购物车为空");
				return "empty";
			}
			else
				return "success";
		}
	}
}
