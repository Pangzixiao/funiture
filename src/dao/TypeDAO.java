package dao;

import java.util.List;

import bean.Type;

public interface TypeDAO {
	JdbcUtils jdbcUtils = new JdbcUtils();
	public List<Type> getAllTypes()throws Exception;
	public boolean update(Type type)throws Exception;
	public void findTypeById(Type type)throws Exception;
}
