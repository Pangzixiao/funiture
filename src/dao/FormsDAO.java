package dao;

import bean.Forms;

public interface FormsDAO {
	JdbcUtils jdbcUtils = new JdbcUtils();
	public boolean del(Forms forms)throws Exception;
	public boolean add(Forms forms)throws Exception;
}
