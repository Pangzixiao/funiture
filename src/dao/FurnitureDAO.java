package dao;

import java.util.List;

import bean.Furniture;

public interface FurnitureDAO {
	JdbcUtils jdbcUtils = new JdbcUtils();
	public boolean add(Furniture furniture)throws Exception;
	/**
	 * 
	 * 通过用户名查找该用户上传的所有商品
	 * @return
	 * @throws Exception
	 */
	public List<Furniture> getAllFurniture(String uid)throws Exception;
}
