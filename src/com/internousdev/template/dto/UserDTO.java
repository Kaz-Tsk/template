package com.internousdev.template.dto;

import java.util.Date;

public class UserDTO {

	private int id;

	private String loginId;

	private String loginPassword;

	private String userName;

	private String telNumber;

	private String eMail;

	private String address;

	private Date insertDate;

	private int loginFlg;

	private int userFlg;

	public int getId(){
		return id;
	}

	public void setId(int id){
		this.id = id;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
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

	public String getEMail() {
		return eMail;
	}

	public void setEMail(String eMail) {
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

	public int getLoginFlg() {
		return loginFlg;
	}

	public void setLoginFlg(int loginFlg) {
		this.loginFlg = loginFlg;
	}

	public int getUserFlg(){
		return userFlg;
	}

	public void setUserFlg(int userFlg){
		this.userFlg = userFlg;
	}
}
