package dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import bean.Brand;
import bean.Forms;

public class BrandDAOImp implements BrandDAO {

	@Override
	public boolean del(Brand brand) throws Exception {
		String sql = "delete from brand where c_id = ? and brand_name = ?";
		boolean istrue = false;
		jdbcUtils.getConnection();
    	List params = new ArrayList();
    	params.add(brand.getC_id());
    	params.add(brand.getBrand_name());
    	istrue = jdbcUtils.updateByPreparedStatement(sql, params);
    	jdbcUtils.releaseConn();
		return istrue;
	}

	@Override
	public boolean add(Brand brand) throws Exception {
		String sql = "insert into brand(c_id,brand_name) values(?,?)";
		boolean istrue = false;
		jdbcUtils.getConnection();
    	List params = new ArrayList();
    	params.add(brand.getC_id());
    	params.add(brand.getBrand_name());
    	istrue = jdbcUtils.updateByPreparedStatement(sql, params);
    	jdbcUtils.releaseConn();
		return istrue;
	}

	@Override
	public List<String> getAllBrands() throws Exception {
		jdbcUtils.getConnection();
		String sql = "select * from brand";
		List params = new ArrayList();
		Set<String> brands = new HashSet<String>();
		List<Map<String, Object>> maps = new ArrayList<Map<String, Object>>();
		maps = jdbcUtils.findMoreResult(sql, params);
		for (Map<String, Object> map : maps) {
			brands.add((String)map.get("brand_name"));
		}
		jdbcUtils.releaseConn();
		List<String> list = new ArrayList<String>();
		for(String s:brands){
			list.add(s);
		}
		return list;
	}

	@Override
	public boolean isExit(int c_id, String brand_name) throws Exception {
		jdbcUtils.getConnection();
		List<Forms> list = new ArrayList<Forms>();
		String sql = "select * from brand where c_id = ? and brand_name = ?";
		List params = new ArrayList();
		params.add(c_id);
		params.add(brand_name);
		List<Map<String,Object>> maps = jdbcUtils.findMoreResult(sql, params);
		jdbcUtils.releaseConn();
		return !maps.isEmpty();
	}

}
