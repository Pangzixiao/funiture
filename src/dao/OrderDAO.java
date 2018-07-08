package dao;

import java.util.List;

import bean.Order;
import bean.OrderReport;

public interface OrderDAO {
	JdbcUtils jdbcUtils = new JdbcUtils();
	//���
	public boolean add(Order order)throws Exception;
	//ͨ���û�����ѯ�����¼
	public List<OrderReport> getReportForUser(String username)throws Exception;
	
}
