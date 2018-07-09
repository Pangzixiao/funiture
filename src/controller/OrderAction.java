package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import bean.Car_Furniture;
import bean.Furniture;
import bean.Order;
import bean.OrderReport;
import dao.FurnitureDAO;
import dao.FurnitureDAOImp;
import dao.OrderDAO;
import dao.OrderDAOImp;

public class OrderAction extends ActionSupport {
    Order order;
    String name;
    OrderDAO orderdao = new OrderDAOImp();
    FurnitureDAO furnituredao = new FurnitureDAOImp();
    List<OrderReport> reports;
	public Order getOrder() {
		return order;
	}

	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void setOrder(Order order) {
		this.order = order;
	}
    
	public List<OrderReport> getReports() {
		return reports;
	}


	public String pay() throws Exception{
		boolean istrue = false;
		Map session = ActionContext.getContext().getSession();
		String username = (String)session.get("user");
		if(username!=null){
			order.setUsername(username);
			istrue = true;
		}
		return istrue?"success":"fail";
	}
	
	public String count_fee() throws Exception{
		boolean istrue = false;
		Furniture f = furnituredao.getFurniture(order.getShoper(), order.getFurniture_id());
		if(f!=null){
			order.setCost(order.getCount()*f.getPrice());
			istrue = true;
		}
	    return istrue?"success":"fail";
	}
	
	public String addOrder() throws Exception{
		boolean istrue = false;
		//添加订单记录
		istrue = orderdao.add(order);
		//获取家具通过订单的商家和家具id
		Furniture f = furnituredao.getFurniture(order.getShoper(), order.getFurniture_id());
		//更新家具的销售量
		f.setSalevolume(f.getSalevolume()+order.getCount());
		furnituredao.updateSaleVolumeById(f.getSalevolume(), f.getFurniture_id(), f.getUid());
		//将支付完成的商品从购物车中移除
		Map session = ActionContext.getContext().getSession();
		List<Car_Furniture> cars = (List<Car_Furniture>) session.get("car");
		Car_Furniture car_furniture = new Car_Furniture();
		car_furniture.setF_id(order.getFurniture_id());
		car_furniture.setShoper(order.getShoper());
		List<Car_Furniture> newcars= new ArrayList<Car_Furniture>();
		if (cars != null) {
			for (Car_Furniture car : cars) {
				
				if (!car.equals(car_furniture)) {
					newcars.add(car);
				}
			}
			session.put("car", newcars);
		}
	    return istrue?"success":"fail";
	}
	public String showsPayRecordForUser() throws Exception{
		boolean istrue = false;
		Map session = ActionContext.getContext().getSession();
		String username = (String)session.get("user");
		if(!username.isEmpty()){
			reports = orderdao.getReportForUser(username);
			if(!reports.isEmpty()){
				istrue = true;
			}
		}
	    return istrue?"success":"fail";
	}
}
