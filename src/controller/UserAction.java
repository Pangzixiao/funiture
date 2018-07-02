package controller;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import bean.User;
import dao.UserDAO;
import dao.UserDAOImp;

public class UserAction extends ActionSupport {
    User user;
    int type;
    
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String login()throws Exception{
		boolean isTrue;
    	UserDAO userdao = new UserDAOImp();
		if(type == 0){
			isTrue = userdao.check_pass(user,"admin");
		}else if(type == 1){
			isTrue = userdao.check_pass(user,"shopUser");
		}else{
			isTrue = userdao.check_pass(user,"user");
		}
//		if(isTrue == true){
//			Map session = ActionContext.getContext().getSession();
//			session.put("user", user.getUid());
//		}
    	return isTrue? "success":"fair";
	}
}
