package dao;

import java.util.ArrayList;
import java.util.List;

import bean.Order;

public class OrderDAOImp implements OrderDAO {

	@Override
	public boolean add(Order order) throws Exception {
		String sql = "insert into orderReport(order_id,username,shoper,furniture_id,cost,count,paydate) values(?,?,?,?,?,?,?)";
//		String sql = "insert into orderReport(order_id) values(?)";
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
    
}
