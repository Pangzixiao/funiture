package dao;

import java.util.List;

import bean.Furniture;

public interface FurnitureDAO {
	JdbcUtils jdbcUtils = new JdbcUtils();
	public boolean add(Furniture furniture)throws Exception;
	/**
	 * 
	 * ͨ���û������Ҹ��û��ϴ���������Ʒ
	 * @return
	 * @throws Exception
	 */
	public List<Furniture> getAllFurniture(String uid)throws Exception;
}
