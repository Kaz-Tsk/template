package com.internousdev.template.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

/**
 *
 * @author
 *
 */
public class UserCreateConfirmAction extends ActionSupport implements SessionAware {

	public String loginUserId;

	public String loginPassword;

	public String userName;

	public String telNumber;

	public String eMail;

	public String address;

	public Map<String,Object> createUserSession;

	public String result;

	public String errorMassage;

	public String execute() {

		result = SUCCESS;

		if(!(loginUserId.equals("")) && !(loginPassword.equals("")) && !(userName.equals(""))) {
			createUserSession.put("loginUserId", loginUserId);
			createUserSession.put("loginPassword", loginPassword);
			createUserSession.put("userName", userName);
			createUserSession.put("telNumber", telNumber);
			createUserSession.put("eMail", eMail);
			createUserSession.put("address", address);


		} else {

			errorMassage = "未入力の項目があります。";
			result = ERROR;
		}

		return result;
	}

	public String getLoginUserId() {
		return loginUserId;
	}

	public void setLoginUserId(String loginUserId) {
		this.loginUserId = loginUserId;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public void setSession(Map<String, Object> createUserSession) {
		this.createUserSession = createUserSession;
	}
}
