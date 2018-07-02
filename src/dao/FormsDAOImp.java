package dao;

import java.util.ArrayList;
import java.util.List;

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

	

}
