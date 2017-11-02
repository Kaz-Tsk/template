package com.internousdev.template.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template.dao.UserCreateDAO;
import com.internousdev.template.dto.UserDTO;
import com.opensymphony.xwork2.ActionSupport;

/**
 *
 * @author
 *
 */
public class UserCreateConfirmAction extends ActionSupport implements SessionAware{

	private String loginUserId;

	private String loginPassword;

	private String userName;

	private String telNumber;

	private String eMail;

	private String address;

	private String errorMassage;

	private Map<String, Object> session;

	private ArrayList<UserDTO> userCheckList = new ArrayList<UserDTO>();
	private UserCreateDAO dao =  new UserCreateDAO();
	public String execute() {
		String result = ERROR;
		userCheckList = dao.userCreateCheck();
		for(int i = 0; i < userCheckList.size(); i++) {
			if(userCheckList.get(i).getEMail().equals(eMail)||userCheckList.get(i).getTelNumber().equals(telNumber)) {
				errorMassage = "すでに登録済みのユーザー情報が含まれています。";
				return result;
			}
		}
		session.put("loginUserId", loginUserId);
		session.put("loginPassword", loginPassword);
		session.put("userName", userName);
		session.put("telNumber", telNumber);
		session.put("eMail", eMail);
		session.put("address", address);
		return SUCCESS;
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
	public String getErrorMassage() {
		return errorMassage;
	}
	public void setErrorMassage(String errorMassage) {
		this.errorMassage = errorMassage;
	}
	@Override
	public void setSession(Map<String,Object> session) {
		this.session = session;
	}
}
