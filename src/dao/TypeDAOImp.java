package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import bean.Type;

public class TypeDAOImp implements TypeDAO {

	@Override
	public List<Type> getAllTypes() throws Exception {
		jdbcUtils.getConnection();
		String sql = "select * from type";
		List params = new ArrayList();
		List <Type> list = new ArrayList<Type>();
		List<Map<String, Object>> types = new ArrayList<Map<String, Object>>();
		types = jdbcUtils.findMoreResult(sql, params);
		for (Map<String, Object> t : types) {
			Type type = new Type();
			type.setC_id((int)t.get("c_id"));
			type.setC_name((String)t.get("c_name"));
			list.add(type);
		}
		jdbcUtils.releaseConn();
		return list;
	}

	@Override
	public boolean update(Type type) throws Exception {
		boolean istrue = false;
		jdbcUtils.getConnection();
    	String sql = "update type set c_name = ? where c_id =?";
    	List params = new ArrayList();
    	params.add(type.getC_name());
    	params.add(type.getC_id());
    	
    	istrue = jdbcUtils.updateByPreparedStatement(sql, params);
    	jdbcUtils.releaseConn();
		return istrue;
	}

	@Override
	public void findTypeById(Type type) throws Exception {
    	jdbcUtils.getConnection();
    	String sql = "select * from type where c_id = ?";
    	List params = new ArrayList();
    	params.add(type.getC_id());
    	Map<String,Object> f = jdbcUtils.findSimpleResult(sql, params);
    	type.setC_name((String)f.get("c_name"));
    	jdbcUtils.releaseConn();
	}

	@Override
	public void findTypeByName(Type type) throws Exception {
		jdbcUtils.getConnection();
    	String sql = "select * from type where c_name = ?";
    	List params = new ArrayList();
    	params.add(type.getC_name());
    	Map<String,Object> f = jdbcUtils.findSimpleResult(sql, params);
    	type.setC_id((int)f.get("c_id"));
    	jdbcUtils.releaseConn();
		
	}
}
