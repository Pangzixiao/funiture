package dao;

import bean.Shoppingcar;

public interface ShoppingcarDAO {
	JdbcUtils jdbcUtils = new JdbcUtils();
	public boolean del(Shoppingcar shoppingcar)throws Exception;
	public boolean add(Shoppingcar shoppingcar)throws Exception;
}
