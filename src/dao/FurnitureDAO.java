package dao;

import java.util.List;

import bean.Furniture;

public interface FurnitureDAO {
	JdbcUtils jdbcUtils = new JdbcUtils();
	/**
	 * 添加商品
	 * @param furniture
	 * @return
	 * @throws Exception
	 */
	public boolean add(Furniture furniture)throws Exception;
	/**
	 * 
	 * 通过用户名查找该用户上传的所有商品
	 * @return
	 * @throws Exception
	 */
	public List<Furniture> getAllFurniture(String uid)throws Exception;
	/**
	 * 通过商家名和商品名查找商品
	 * @param uid
	 * @param furniture_id
	 * @return
	 * @throws Exception
	 */
	public Furniture getFurniture(String uid,int furniture_id)throws Exception;
}
