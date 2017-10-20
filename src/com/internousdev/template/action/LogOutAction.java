package com.internousdev.template.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class LogOutAction extends ActionSupport implements SessionAware {

	/**
	 * Session情報
	 */
	public Map<String, Object> session;

	LogOutDAO dao = new LogOutDAO();

	public String execute() {
		System.out.println("test"+(int)session.get("Id"));
		dao.logOutFlg((int)session.get("Id"));
		session.clear();
		return SUCCESS;
	}


	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
