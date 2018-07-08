package dao;

import java.util.List;

import bean.Comment;

public interface CommentDAO {
	JdbcUtils jdbcUtils = new JdbcUtils();
	public boolean add(Comment comment)throws Exception;
	public boolean update(Comment comment)throws Exception;
	//ͨ���̼ң���Ʒ���鿴����
	public List<Comment> getComments(String shoper,int furniture_id)throws Exception;
	//�ж��Ƿ���ĳ�û���ĳ����Ʒ������
	public boolean isExite(String shoper,int furniture_id,String user) throws Exception;
}
