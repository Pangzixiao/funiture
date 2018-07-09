package controller;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import bean.User;
import dao.UserDAO;
import dao.UserDAOImp;
import dao.Utils;

public class UserAction extends ActionSupport {
	User user;
	int type;

	UserDAO userdao = new UserDAOImp();

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
    /**
     * 登录
     * @return
     * @throws Exception
     */
	public String login() throws Exception {
		boolean isTrue;
		if (type == 0) {
			isTrue = userdao.check_pass(user, "admin");
			if (isTrue == true) {
				Map session = ActionContext.getContext().getSession();
				session.put("shoper", user.getUid());
				return "suc_admin";
			}
		} else if (type == 1) {
			isTrue = userdao.check_pass(user, "shopUser");
			if (isTrue == true) {
				Map session = ActionContext.getContext().getSession();
				session.put("shoper", user.getUid());
				return "suc_shoper";
			}
		} else {
			isTrue = userdao.check_pass(user, "user");
			if (isTrue == true) {
				// 获取session
				Map session = ActionContext.getContext().getSession();
				// 将用户名存入session
				session.put("user", user.getUid());
				return "suc_user";
			}
		}
		return "fail";
	}

	
}
