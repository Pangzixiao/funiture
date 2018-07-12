package dao;

import java.util.List;

import bean.Type;

public interface TypeDAO {
	JdbcUtils jdbcUtils = new JdbcUtils();
	//������еķ���
	public List<Type> getAllTypes()throws Exception;
	//��������
	public boolean update(Type type)throws Exception;
	//ͨ������id��ȫ������Ϣ
	public void findTypeById(Type type)throws Exception;
	//ͨ���������Ʋ�ȫ������Ϣ
	public void findTypeByName(Type type)throws Exception;
	//��ӷ���
	public boolean addType(String c_name)throws Exception;
	//�鿴�������Ƿ����
	public boolean isTypeExit(String c_name)throws Exception;
	//ɾ������
	public boolean delType(int c_id)throws Exception;
}
