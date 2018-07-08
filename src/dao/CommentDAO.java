package dao;

import java.util.List;

import bean.Comment;

public interface CommentDAO {
	JdbcUtils jdbcUtils = new JdbcUtils();
	public boolean add(Comment comment)throws Exception;
	public boolean update(Comment comment)throws Exception;
	//通过商家，商品名查看评论
	public List<Comment> getComments(String shoper,int furniture_id)throws Exception;
	//判断是否有某用户对某件商品的评论
	public boolean isExite(String shoper,int furniture_id,String user) throws Exception;
}
