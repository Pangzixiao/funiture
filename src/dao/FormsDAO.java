package dao;

import java.util.List;
import java.util.Set;

import bean.Forms;

public interface FormsDAO {
	JdbcUtils jdbcUtils = new JdbcUtils();
	//�����ݿ��в�������ĳ�����
	public boolean del(Forms forms)throws Exception;
	//�����ݿ���ɾ��ĳ�������ĳ�����
	public boolean add(Forms forms)throws Exception;
	//��ȡ���ļ���
	public List<String> getAllForms()throws Exception;
	
}
