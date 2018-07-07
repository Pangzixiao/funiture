package bean;

import java.util.Date;

public class Order {
    int order_id,furniture_id,count;
    double cost;
    String shoper,username;
    Date paydate;
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public int getFurniture_id() {
		return furniture_id;
	}
	public void setFurniture_id(int furniture_id) {
		this.furniture_id = furniture_id;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public String getShoper() {
		return shoper;
	}
	public void setShoper(String shoper) {
		this.shoper = shoper;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Date getPaydate() {
		return paydate;
	}
	public void setPaydate(Date paydate) {
		this.paydate = paydate;
	}
    
}
