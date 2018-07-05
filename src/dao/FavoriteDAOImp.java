package dao;

import java.util.ArrayList;
import java.util.List;

import bean.Brand;
import bean.Favorite;

public class FavoriteDAOImp implements FavoriteDAO {

	@Override
	public boolean del(Favorite favorite) throws Exception {
		String sql = "delete from favorite where id = ? and furniture_id = ?";
		boolean istrue = false;
		jdbcUtils.getConnection();
    	List params = new ArrayList();
    	params.add(favorite.getId());
    	params.add(favorite.getFurniture_id());
    	istrue = jdbcUtils.updateByPreparedStatement(sql, params);
    	jdbcUtils.releaseConn();
		return istrue;
	}

	@Override
	public boolean add(Favorite favorite) throws Exception {
		String sql = "insert into favorite(id,furniture_id,uid) values(?,?,?)";
		boolean istrue = false;
		jdbcUtils.getConnection();
    	List params = new ArrayList();
    	params.add(favorite.getId());
    	params.add(favorite.getFurniture_id());
    	params.add(favorite.getUid());
    	istrue = jdbcUtils.updateByPreparedStatement(sql, params);
    	jdbcUtils.releaseConn();
		return istrue;
	}

	

}
