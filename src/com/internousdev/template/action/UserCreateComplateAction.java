package com.internousdev.template.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template.dao.UserCreateDAO;
import com.opensymphony.xwork2.ActionSupport;

public class UserCreateComplateAction extends ActionSupport implements SessionAware{

	private Map<String,Object> session;
	private UserCreateDAO dao = new UserCreateDAO();

	public String execute() throws SQLException {
		String result = SUCCESS;
		dao.cerateUser((String)session.get("loginUserId"), (String)session.get("loginPassword"), (String)session.get("userName"),
					  (String)session.get("telNumber"), (String)session.get("eMail"), (String)session.get("address"));
		session.clear();
		return result ;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;

	}


}
