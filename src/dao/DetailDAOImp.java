package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import bean.Detail;

public class DetailDAOImp implements DetailDAO {

	@Override
	public boolean add(Detail detail) throws Exception {
		String sql = "insert into detail(brand)values(?)";
		boolean istrue = false;
		jdbcUtils.getConnection();
    	List params = new ArrayList();
    	params.add(detail.getBrand());
    	istrue = jdbcUtils.updateByPreparedStatement(sql, params);
    	jdbcUtils.releaseConn();
		return istrue;
	}

	@Override
	public int getDetailId() throws Exception {
		String sql = "select detail_id from detail where brand = -1";
		jdbcUtils.getConnection();
    	List params = new ArrayList();
    	Map<String,Object> map = jdbcUtils.findSimpleResult(sql, params);
    	jdbcUtils.releaseConn();
    	return (int)map.get("detail_id"); 
	}

	@Override
	public boolean update(Detail detail) throws Exception {
		boolean isTrue = false;
		String sql = "update detail set introduce = ? , brand = ? ,form=? where detail_id = ?";
		jdbcUtils.getConnection();
    	List params = new ArrayList();
    	params.add(detail.getIntroduce());
    	params.add(detail.getBrand());
    	params.add(detail.getForm());
    	params.add(detail.getDetail_id());
    	isTrue = jdbcUtils.updateByPreparedStatement(sql, params);
    	jdbcUtils.releaseConn();
    	return isTrue;
	}

	
	
}
