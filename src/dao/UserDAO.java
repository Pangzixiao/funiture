package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import bean.User;



public interface UserDAO {
	JdbcUtils jdbcUtils = new JdbcUtils();
	public boolean check_pass(User user,String formname) throws Exception;
	public boolean addUser(User user,String formname) throws Exception;
}
