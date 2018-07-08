package dao;

import java.util.List;

import bean.Order;
import bean.OrderReport;

public interface OrderDAO {
	JdbcUtils jdbcUtils = new JdbcUtils();
	//添加
	public boolean add(Order order)throws Exception;
	//通过用户名查询购买记录
	public List<OrderReport> getReportForUser(String username)throws Exception;
	
}
