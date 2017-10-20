package com.internousdev.template.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template.dao.LogOutDAO;
import com.opensymphony.xwork2.ActionSupport;

public class LogOutAction extends ActionSupport implements SessionAware {

	/**
	 * Session情報
	 */
	private Map<String, Object> session;

	LogOutDAO dao = new LogOutDAO();

	public String execute() {
		dao.logOutFlg((int)session.get("Id"));
		session.clear();
		return SUCCESS;
	}


	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
