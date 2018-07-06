package dao;

import java.util.List;
import java.util.Set;

import bean.Forms;

public interface FormsDAO {
	JdbcUtils jdbcUtils = new JdbcUtils();
	//向数据库中插入分类的某个风格
	public boolean del(Forms forms)throws Exception;
	//从数据库中删除某个分类的某个风格
	public boolean add(Forms forms)throws Exception;
	//获取风格的集合
	public List<String> getAllForms()throws Exception;
	
}
