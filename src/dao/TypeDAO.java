package dao;

import java.util.List;

import bean.Type;

public interface TypeDAO {
	JdbcUtils jdbcUtils = new JdbcUtils();
	public List<Type> getAllTypes()throws Exception;
	public boolean update(Type type)throws Exception;
	//通过分类id不全分类信息
	public void findTypeById(Type type)throws Exception;
	//通过分类名称补全分类信息
	public void findTypeByName(Type type)throws Exception;
}
