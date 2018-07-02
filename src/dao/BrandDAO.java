package dao;

import bean.Brand;

public interface BrandDAO {
	JdbcUtils jdbcUtils = new JdbcUtils();
	public boolean del(Brand brand)throws Exception;
	public boolean add(Brand brand)throws Exception;
}
