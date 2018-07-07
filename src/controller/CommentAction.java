package controller;

import com.opensymphony.xwork2.ActionSupport;

import bean.Comment;
import dao.CommentDAO;
import dao.CommentDAOImp;

public class CommentAction extends ActionSupport {
    Comment comment;
    CommentDAO commentdao = new CommentDAOImp();
	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}
	
	public String findcomment()throws Exception{
		
		return SUCCESS;
	}
	
public String addComment()throws Exception{
		boolean istrue = false;
		istrue = commentdao.add(comment);
		return istrue?"success":"fail";
	}
}
