package dao;

import java.util.List;

import bean.Furniture;

public interface FurnitureDAO {
	JdbcUtils jdbcUtils = new JdbcUtils();
	/**
	 * �����Ʒ
	 * @param furniture
	 * @return
	 * @throws Exception
	 */
	public boolean add(Furniture furniture)throws Exception;
	/**
	 * 
	 * ͨ���û������Ҹ��û��ϴ���������Ʒ
	 * @return
	 * @throws Exception
	 */
	public List<Furniture> getAllFurniture(String uid)throws Exception;
	/**
	 * ͨ���̼�������Ʒ��������Ʒ
	 * @param uid
	 * @param furniture_id
	 * @return
	 * @throws Exception
	 */
	public Furniture getFurniture(String uid,int furniture_id)throws Exception;
	/**
	 * ͨ�������������Ʒ
	 * @param type
	 * @return
	 * @throws Exception
	 */
	public List<Furniture> getAllFurnitureByType(String type)throws Exception;
	/**
	 * ͨ��ϸ��id�����Ʒ
	 * @param detail_id
	 * @return
	 * @throws Exception
	 */
	public Furniture getAllFurnitureByDetail(int detail_id)throws Exception;
	/**
	 * 
	 * ��ü۸������ڵ�������Ʒ
	 * @param low
	 * @param up
	 * @return
	 * @throws Exception
	 */
	public List<Furniture> getAllFurnitureByPrice(double low,double up)throws Exception;
	
}
