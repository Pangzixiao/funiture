package bean;

import java.util.Date;

public class OrderReport {
	int order_id,furniture_id,count,detail_id;
    double cost,price;
    String shoper,uid,furniture_name;
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
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getShoper() {
		return shoper;
	}
	public void setShoper(String shoper) {
		this.shoper = shoper;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	
	public int getDetail_id() {
		return detail_id;
	}
	public void setDetail_id(int detail_id) {
		this.detail_id = detail_id;
	}
	public String getFurniture_name() {
		return furniture_name;
	}
	public void setFurniture_name(String furniture_name) {
		this.furniture_name = furniture_name;
	}
	public Date getPaydate() {
		return paydate;
	}
	public void setPaydate(Date paydate) {
		this.paydate = paydate;
	}
	@Override
	public String toString() {
		
		return "paydate:"+paydate+" furniture_name: "+furniture_name;
	}
    
    
}
