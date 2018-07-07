package dao;

import java.util.ArrayList;
import java.util.List;

import bean.Comment;

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

}