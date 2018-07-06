package dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import bean.Forms;

public class FormsDAOImp implements FormsDAO {

	@Override
	public boolean del(Forms forms) throws Exception {
		String sql = "delete from forms where c_id = ? and form_name = ?";
		boolean istrue = false;
		jdbcUtils.getConnection();
    	List params = new ArrayList();
    	params.add(forms.getC_id());
    	params.add(forms.getForm_name());
    	istrue = jdbcUtils.updateByPreparedStatement(sql, params);
    	jdbcUtils.releaseConn();
		return istrue;
	}

	@Override
	public boolean add(Forms forms) throws Exception {
		String sql = "insert into forms(c_id,form_name) values(?,?)";
		boolean istrue = false;
		jdbcUtils.getConnection();
    	List params = new ArrayList();
    	params.add(forms.getC_id());
    	params.add(forms.getForm_name());
    	istrue = jdbcUtils.updateByPreparedStatement(sql, params);
    	jdbcUtils.releaseConn();
		return istrue;
	}

	@Override
	public List<String> getAllForms() throws Exception {
		jdbcUtils.getConnection();
		String sql = "select * from forms";
		List params = new ArrayList();
		Set<String> forms = new HashSet<String>();
		List<Map<String, Object>> maps = new ArrayList<Map<String, Object>>();
		maps = jdbcUtils.findMoreResult(sql, params);
		for (Map<String, Object> map : maps) {
			forms.add((String)map.get("form_name"));
		}
		jdbcUtils.releaseConn();
		List<String> list = new ArrayList<String>();
		for(String s:forms){
			list.add(s);
		}
		return list;
	}

	

}
