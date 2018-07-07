package controller;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import bean.Furniture;
import bean.Order;
import dao.FurnitureDAO;
import dao.FurnitureDAOImp;
import dao.OrderDAO;
import dao.OrderDAOImp;

public class OrderAction extends ActionSupport {
    Order order;
    String name;
    OrderDAO orderdao = new OrderDAOImp();
    FurnitureDAO furnituredao = new FurnitureDAOImp();
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
    
	public String pay() throws Exception{
		boolean istrue = false;
		Map session = ActionContext.getContext().getSession();
		String username = (String)session.get("user");
		if(username!=null){
			order.setUsername(username);
			istrue = true;
		}
		System.out.println("username:"+order.getUsername());
		System.out.println("furniture_id:"+order.getFurniture_id());
		System.out.println("shop:"+order.getShoper());
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
		istrue = orderdao.add(order);
		Furniture f = furnituredao.getFurniture(order.getShoper(), order.getFurniture_id());
		f.setSalevolume(f.getSalevolume()+order.getCount());
		furnituredao.updateSaleVolumeById(f.getSalevolume(), f.getFurniture_id(), f.getUid());
	    return istrue?"success":"fail";
	}
	
}
