package dao;

import java.util.ArrayList;
import java.util.List;

import bean.Shoppingcar;

public class ShoppingcarDAOImp implements ShoppingcarDAO {

	@Override
	public boolean del(Shoppingcar shoppingcar) throws Exception {
		String sql = "delete from shoppingcar where car_id = ? and furniture_id = ?";
		boolean istrue = false;
		jdbcUtils.getConnection();
    	List params = new ArrayList();
    	params.add(shoppingcar.getCar_id());
    	params.add(shoppingcar.getFurniture_id());
    	istrue = jdbcUtils.updateByPreparedStatement(sql, params);
    	jdbcUtils.releaseConn();
		return istrue;
	}

	@Override
	public boolean add(Shoppingcar shoppingcar) throws Exception {
		String sql = "insert into shoppingcar(car_id,furniture_id,uid) values(?,?,?)";
		boolean istrue = false;
		jdbcUtils.getConnection();
    	List params = new ArrayList();
    	params.add(shoppingcar.getCar_id());
    	params.add(shoppingcar.getFurniture_id());
    	params.add(shoppingcar.getUid());
    	istrue = jdbcUtils.updateByPreparedStatement(sql, params);
    	jdbcUtils.releaseConn();
		return istrue;
	}

	

}
