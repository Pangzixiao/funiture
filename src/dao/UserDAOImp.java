package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import bean.User;

public class UserDAOImp implements UserDAO {
	public boolean check_pass(User user,String formname) throws SQLException{
    	boolean isTure = false;
    	jdbcUtils.getConnection();
    	String sql = "select * from "+formname+" where uid=?";
    	List params = new ArrayList();
    	params.add(user.getUid());
    	Map<String,Object> admin = jdbcUtils.findSimpleResult(sql, params);
    	if(!admin.isEmpty()&&admin.get("pass").equals(user.getPass()))
    		isTure = true;
    	jdbcUtils.releaseConn();
    	return isTure;
    }

}
