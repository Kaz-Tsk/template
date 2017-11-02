package com.internousdev.template.action;

import java.util.Date;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template.dao.MyPageDAO;
import com.internousdev.template.dto.UserDTO;
import com.opensymphony.xwork2.ActionSupport;

public class GoMyPageAction  extends ActionSupport implements SessionAware{

	private String userName;
	private String telNumber;
	private String eMail;
	private String address;
	private Date insertDate;
	private Map<String,Object> session;
	private UserDTO dto = new UserDTO();
	private MyPageDAO dao = new MyPageDAO();
	public String execute() {
		String result = ERROR;
		dto = dao.myPageSelect((int)session.get("Id"));
		if(session.get("Id")!=null) {
			userName = dto.getUserName();
			telNumber = dto.getTelNumber();
			eMail = dto.getEMail();
			address = dto.getAddress();
			insertDate = dto.getInsertDate();
			return SUCCESS;
		}
		return result;
	}


	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getTelNumber() {
		return telNumber;
	}
	public void setTelNumber(String telNumber) {
		this.telNumber = telNumber;
	}
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getInsertDate() {
		return insertDate;
	}
	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
