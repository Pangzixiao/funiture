package controller;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import bean.User;
import dao.UserDAO;
import dao.UserDAOImp;

public class UserAction extends ActionSupport {
    User user;
    String type;
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
    
	
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String login()throws Exception{
		boolean isTrue;
    	UserDAO userdao = new UserDAOImp();
		isTrue = userdao.check_pass(user,"admin");
//		if(isTrue == true){
//			Map session = ActionContext.getContext().getSession();
//			session.put("user", user.getUid());
//		}
    	return isTrue? "success":"fair";
	}
}
