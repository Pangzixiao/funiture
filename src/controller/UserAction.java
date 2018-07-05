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

	public String login() throws Exception {
		boolean isTrue;
		if (type == 0) {
			isTrue = userdao.check_pass(user, "admin");
			if (isTrue == true) {
				return "suc_admin";
			}
		} else if (type == 1) {
			isTrue = userdao.check_pass(user, "shopUser");
			if (isTrue == true) {
				Map session = ActionContext.getContext().getSession();
				session.put("shoper",user.getUid());
				return "suc_shoper";
			}
		} else {
			isTrue = userdao.check_pass(user, "user");
			if (isTrue == true) {
				return "suc_user";
			}
		}
		// if(isTrue == true){
		// Map session = ActionContext.getContext().getSession();
		// session.put("user", user.getUid());
		// }
		return "fail";
	}

	public String addUser() throws Exception {
		boolean isTrue = false;
    	if(type==0){
    		isTrue = userdao.addUser(user, "shopUser");
    	}else{
    		//在用户登录表中添加用户信息
    		isTrue = userdao.addUser(user, "user");
    		//为用户生成收藏夹(用utils中的方法向用户收藏夹对应关系表中添加记录返回收藏夹id)
    		Utils utils = new Utils();
    		int favorite_id = utils.addFavoriteUser(user.getUid());
    		//为用户生成购物车(用utils中的方法向用户购物车对应关系表中添加记录返回购物车id)
    		int car_id = utils.addCarUser(user.getUid());
    		
    	}
		return isTrue?"success":"fail";
	}
}
