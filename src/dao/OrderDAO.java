package dao;

import bean.Order;

public interface OrderDAO {
	JdbcUtils jdbcUtils = new JdbcUtils();
	//Ìí¼Ó
	public boolean add(Order order)throws Exception;
	
}
