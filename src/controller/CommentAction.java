package controller;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import bean.Comment;
import dao.CommentDAO;
import dao.CommentDAOImp;

public class CommentAction extends ActionSupport {
	Comment comment;
	List<Comment> comments;
	CommentDAO commentdao = new CommentDAOImp();

	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}

	
	public List<Comment> getComments() {
		return comments;
	}

	public String findcomment() throws Exception {

		return SUCCESS;
	}
    //添加评论
	public String addComment() throws Exception {
		boolean istrue = false;
		//判断评论是否存在
		if(commentdao.isExite(comment.getShoper(), comment.getFurniture_id(), comment.getUser())){
			//更新评论
			istrue = commentdao.update(comment);
		}else{
			//添加评论
			istrue = commentdao.add(comment);
		}
		return istrue ? "success" : "fail";
	}
	
	public String showComment() throws Exception {
		boolean istrue = false;
		comments = commentdao.getComments(comment.getShoper(), comment.getFurniture_id());
		if(!comments.isEmpty()){
			istrue = true;
		}
		return istrue ? "success" : "fail";
	}
}
