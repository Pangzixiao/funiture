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
    		//���û���¼��������û���Ϣ
    		isTrue = userdao.addUser(user, "user");
    		//Ϊ�û������ղؼ�(��utils�еķ������û��ղؼж�Ӧ��ϵ������Ӽ�¼�����ղؼ�id)
    		Utils utils = new Utils();
    		int favorite_id = utils.addFavoriteUser(user.getUid());
    		//Ϊ�û����ɹ��ﳵ(��utils�еķ������û����ﳵ��Ӧ��ϵ������Ӽ�¼���ع��ﳵid)
    		int car_id = utils.addCarUser(user.getUid());
    		
    	}
		return isTrue?"success":"fail";
	}
}
