package dao;

import bean.Order;

public interface OrderDAO {
	JdbcUtils jdbcUtils = new JdbcUtils();
	//���
	public boolean add(Order order)throws Exception;
	
}
