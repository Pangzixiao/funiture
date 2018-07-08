package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import bean.Comment;
import bean.Favorite;

public class CommentDAOImp implements CommentDAO {

	@Override
	public boolean add(Comment comment) throws Exception {
		String sql = "insert into comment(shoper,furniture_id,user,comment) values(?,?,?,?)";
		boolean istrue = false;
		jdbcUtils.getConnection();
    	List params = new ArrayList();
    	params.add(comment.getShoper());
    	params.add(comment.getFurniture_id());
    	params.add(comment.getUser());
    	params.add(comment.getComment());
    	istrue = jdbcUtils.updateByPreparedStatement(sql, params);
    	jdbcUtils.releaseConn();
		return istrue;
	}

	
	@Override
	public boolean update(Comment comment) throws Exception {
		String sql = "update comment set comment = ? where user = ? and shoper = ? and furniture_id = ?";
		boolean istrue = false;
		jdbcUtils.getConnection();
    	List params = new ArrayList();
    	params.add(comment.getComment());
    	params.add(comment.getUser());
    	params.add(comment.getShoper());
    	params.add(comment.getFurniture_id());
    	istrue = jdbcUtils.updateByPreparedStatement(sql, params);
    	jdbcUtils.releaseConn();
		return istrue;
	}


	@Override
	public List<Comment> getComments(String shoper, int furniture_id) throws Exception {
		List<Comment> list = new ArrayList<Comment>();
		jdbcUtils.getConnection();
		String sql = "select * from comment where shoper = ? and furniture_id = ?";
		List params = new ArrayList();
		params.add(shoper);
		params.add(furniture_id);
		List<Map<String, Object>> maps = jdbcUtils.findMoreResult(sql, params);
		if(! maps.isEmpty()){
			for(Map<String,Object> map : maps){
				Comment f = new Comment();
				f.setShoper((String)shoper);
				f.setFurniture_id((int)map.get("furniture_id"));
				f.setComment((String)map.get("comment"));
				f.setUser((String)map.get("user"));
				list.add(f);
			}
		}
		
		jdbcUtils.releaseConn();
		return list;
	}

	@Override
	public boolean isExite(String shoper, int furniture_id, String user) throws Exception {
		boolean isTrue = false;
		List<Comment> list = new ArrayList<Comment>();
		jdbcUtils.getConnection();
		String sql = "select * from comment where shoper = ? and furniture_id = ? and user = ?";
		List params = new ArrayList();
		params.add(shoper);
		params.add(furniture_id);
		params.add(user);
		Map<String, Object> map = jdbcUtils.findSimpleResult(sql, params);
		isTrue = (!map.isEmpty());
		
		jdbcUtils.releaseConn();
		return isTrue;
	}

	
}