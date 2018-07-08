package dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

import bean.Furniture;
import bean.Order;
import bean.OrderReport;

public class OrderDAOImp implements OrderDAO {

	@Override
	public boolean add(Order order) throws Exception {
		String sql = "insert into orderReport(order_id,username,shoper,furniture_id,cost,count,paydate) values(?,?,?,?,?,?,?)";
		boolean istrue = false;
		jdbcUtils.getConnection();
    	List params = new ArrayList();
    	params.add(order.getOrder_id());
    	params.add(order.getUsername());
    	params.add(order.getShoper());
    	params.add(order.getFurniture_id());
    	params.add(order.getCost());
    	params.add(order.getCount());
    	params.add(order.getPaydate());
    	istrue = jdbcUtils.updateByPreparedStatement(sql, params);
    	jdbcUtils.releaseConn();
		return istrue;
	}

	@Override
	public List<OrderReport> getReportForUser(String username) throws Exception {
		jdbcUtils.getConnection();
		String sql = "select order_id,furnitures.uid,furnitures.furniture_id,detail_id,furniture_name,count,price,cost,paydate from orderreport , furnitures where orderreport.furniture_id = furnitures.furniture_id and orderreport.username=?";
		List params = new ArrayList();
		params.add(username);
		List<OrderReport> list = new ArrayList<OrderReport>();
		List<Map<String, Object>> maps = new ArrayList<Map<String, Object>>();
		maps = jdbcUtils.findMoreResult(sql, params);
		for (Map<String, Object> map : maps) {
			OrderReport o = new OrderReport();
			o.setCost((double)map.get("cost"));
			o.setCount((int)map.get("count"));
			o.setDetail_id((int)map.get("detail_id"));
			o.setFurniture_id((int)map.get("furniture_id"));
			o.setFurniture_name((String)map.get("furniture_name"));
			o.setOrder_id((int)map.get("order_id"));
			o.setPaydate((Date)map.get("paydate"));
			o.setPrice((double)map.get("price"));
			o.setShoper((String)map.get("shoper"));
			o.setUid((String)map.get("uid"));
			list.add(o);
		}
		jdbcUtils.releaseConn();
		return list;
	}
    
	
}
