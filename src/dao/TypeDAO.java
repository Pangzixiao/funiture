package dao;

import java.util.List;

import bean.Type;

public interface TypeDAO {
	JdbcUtils jdbcUtils = new JdbcUtils();
	//获得所有的分类
	public List<Type> getAllTypes()throws Exception;
	//更新内容
	public boolean update(Type type)throws Exception;
	//通过分类id不全分类信息
	public void findTypeById(Type type)throws Exception;
	//通过分类名称补全分类信息
	public void findTypeByName(Type type)throws Exception;
	//添加分类
	public boolean addType(String c_name)throws Exception;
	//查看分类名是否存在
	public boolean isTypeExit(String c_name)throws Exception;
	//删除分类
	public boolean delType(int c_id)throws Exception;
}
