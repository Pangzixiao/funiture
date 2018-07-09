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

	@Override
	public boolean addUser(User user, String formname) throws Exception {
		boolean isTrue = false;
    	jdbcUtils.getConnection();
    	String sql = "insert into "+formname+" (uid,pass,phone)values(?,?,?)";
    	List params = new ArrayList();
    	params.add(user.getUid());
    	params.add(user.getPass());
    	params.add(user.getPhone());
    	isTrue = jdbcUtils.updateByPreparedStatement(sql, params);
    	jdbcUtils.releaseConn();
		return isTrue;
	}

	@Override
	public boolean isUidExit(String uid,String formname) throws Exception {
		boolean isTure = false;
    	jdbcUtils.getConnection();
    	String sql = "select * from "+formname+" where uid=?";
    	List params = new ArrayList();
    	params.add(uid);
    	Map<String,Object> admin = jdbcUtils.findSimpleResult(sql, params);
    	if(!admin.isEmpty())
    		isTure = true;
    	jdbcUtils.releaseConn();
    	return isTure;
	}
	
	
}
