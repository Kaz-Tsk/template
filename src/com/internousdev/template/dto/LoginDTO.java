package com.internousdev.template.dto;

public class LoginDTO {

	private int id;

	private String loginId;

	private String loginPassword;

	private String userName;

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
