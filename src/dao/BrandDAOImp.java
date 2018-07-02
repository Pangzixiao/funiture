package dao;

import java.util.ArrayList;
import java.util.List;

import bean.Brand;

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

	

}
