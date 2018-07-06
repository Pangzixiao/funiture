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
	/**
	 * 通过类别获得所有商品
	 * @param type
	 * @return
	 * @throws Exception
	 */
	public List<Furniture> getAllFurnitureByType(String type)throws Exception;
	/**
	 * 通过细节id获得商品
	 * @param detail_id
	 * @return
	 * @throws Exception
	 */
	public Furniture getAllFurnitureByDetail(int detail_id)throws Exception;
	/**
	 * 
	 * 获得价格区间内的所有商品
	 * @param low
	 * @param up
	 * @return
	 * @throws Exception
	 */
	public List<Furniture> getAllFurnitureByPrice(double low,double up)throws Exception;
	
}
