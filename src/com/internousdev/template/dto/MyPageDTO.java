package com.internousdev.template.dto;

public class MyPageDTO {

	private String userName;

	private String telNumber;

	private String eMail;

	private String address;


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

	public String getEmail(){
		return eMail;
	}

	public void setEmail(String eMail){
		this.eMail = eMail;
	}
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address= address;
	}



}
