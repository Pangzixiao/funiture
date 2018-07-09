package controller;

import com.opensymphony.xwork2.ActionSupport;

import bean.User;
import dao.UserDAO;
import dao.UserDAOImp;

public class RegistAction extends ActionSupport {

	UserDAO userdao = new UserDAOImp();
	String repass,uid,pass,phone;
	int type;
	
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	
	public String getRepass() {
		return repass;
	}

	public void setRepass(String repass) {
		this.repass = repass;
	}
    
	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	
	@Override
	public void validate() {
		boolean isTrue = true;
		if (type == 0) {
			try {
				isTrue = userdao.isUidExit(uid, "shopUser");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			try {
				isTrue = userdao.isUidExit(uid, "user");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(isTrue == true){
			addActionError("用户已存在");
		}
		
	}

	/**
	 * 注册
	 * @return
	 * @throws Exception
	 */
	public String execute() throws Exception {
		boolean isTrue = false;
		User user = new User();
		user.setPass(pass);
		user.setPhone(phone);
		user.setUid(uid);
		if (type == 0) {
			isTrue = userdao.addUser(user, "shopUser");
		} else {
			isTrue = userdao.addUser(user, "user");
		}
		return isTrue ? "success" : "fail";
	}
}
