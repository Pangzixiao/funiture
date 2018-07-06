package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import bean.Brand;
import bean.Favorite;
import bean.Forms;

public class FavoriteDAOImp implements FavoriteDAO {

	@Override
	public boolean del(Favorite favorite) throws Exception {
		String sql = "delete from favorite where uid = ? and furniture_id = ? and shoper = ?";
		boolean istrue = false;
		jdbcUtils.getConnection();
    	List params = new ArrayList();
    	params.add(favorite.getUid());
    	params.add(favorite.getFurniture_id());
    	params.add(favorite.getShoper());
    	istrue = jdbcUtils.updateByPreparedStatement(sql, params);
    	jdbcUtils.releaseConn();
		return istrue;
	}

	@Override
	public boolean add(Favorite favorite) throws Exception {
		String sql = "insert into favorite(uid,furniture_id,shoper) values(?,?,?)";
		boolean istrue = false;
		jdbcUtils.getConnection();
    	List params = new ArrayList();
    	params.add(favorite.getUid());
    	params.add(favorite.getFurniture_id());
    	params.add(favorite.getShoper());
    	istrue = jdbcUtils.updateByPreparedStatement(sql, params);
    	jdbcUtils.releaseConn();
		return istrue;
	}

	@Override
	public boolean isExit(String uid) throws Exception {
		jdbcUtils.getConnection();
		List<Forms> list = new ArrayList<Forms>();
		String sql = "select * from favorite where uid = ?";
		List params = new ArrayList();
		params.add(uid);
		Map<String, Object> map = jdbcUtils.findSimpleResult(sql, params);
		jdbcUtils.releaseConn();
		return map.isEmpty();
	}

	@Override
	public List<Favorite> getAllFavorite(String uid) throws Exception {
		jdbcUtils.getConnection();
		List<Favorite> list = new ArrayList<Favorite>();
		String sql = "select * from favorite where uid = ?";
		List params = new ArrayList();
		params.add(uid);
		List<Map<String, Object>> maps = jdbcUtils.findMoreResult(sql, params);
		if(! maps.isEmpty()){
			for(Map<String,Object> map : maps){
				Favorite f = new Favorite();
				f.setFurniture_id((int)map.get("furniture_id"));
				f.setShoper((String)map.get("shoper"));
				f.setUid((String)map.get("uid"));
				list.add(f);
			}
		}
		
		jdbcUtils.releaseConn();
		return list;
		
	}

	

}
