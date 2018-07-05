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
}
