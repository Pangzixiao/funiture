package dao;

import bean.Comment;

public interface CommentDAO {
	JdbcUtils jdbcUtils = new JdbcUtils();
	public boolean add(Comment comment)throws Exception;
}
