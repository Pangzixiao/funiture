package dao;

import java.util.List;

import bean.Type;

public interface TypeDAO {
	JdbcUtils jdbcUtils = new JdbcUtils();
	public List<Type> getAllTypes()throws Exception;
	public boolean update(Type type)throws Exception;
	//ͨ������id��ȫ������Ϣ
	public void findTypeById(Type type)throws Exception;
	//ͨ���������Ʋ�ȫ������Ϣ
	public void findTypeByName(Type type)throws Exception;
}
