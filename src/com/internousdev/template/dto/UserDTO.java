package com.internousdev.template.dto;

import java.util.Date;

/**
 * ユーザー情報のDTO
 * @author Kazuyuki Tasaki
 * @version 1.0
 */
public class UserDTO {
	/**
	 * ユーザーID
	 *@param id
	 */
	private int id;

	/**
	 * ログインID
	 * @param loginId
	 */
	private String loginId;

	/**
	 * ログインパスワード
	 * @param loginPassword
	 */
	private String loginPassword;

	/**
	 * ユーザー名
	 * @param userName
	 */
	private String userName;

	/**
	 *電話番号
	 *@param telNumber
	 */
	private String telNumber;

	/**
	 * メールアドレス
	 * @param eMail
	 */
	private String eMail;

	/**
	 * 住所
	 *@param address
	 */
	private String address;

	/**
	 * 登録日
	 * @param insertDate
	 */
	private Date insertDate;

	/**
	 * ログインフラグ
	 * @param loginFlg
	 */
	private int loginFlg;

	/**
	 * ユーザーフラグ
	 * @param userFlg
	 */
	private int userFlg;

	//以下、setter getter
	/**
	 *
	 * @return id
	 */
	public int getId(){
		return id;
	}

	/**
	 *
	 * @param id
	 */
	public void setId(int id){
		this.id = id;
	}
	/**
	 *@return loginId
	 */
	public String getLoginId() {
		return loginId;
	}

	/**
	 *@param loginId
	 */
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	/**
	 *
	 * @return loginPassword
	 */
	public String getLoginPassword() {
		return loginPassword;
	}

	/**
	 *
	 * @param loginPassword
	 */
	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	/**
	 *
	 * @return userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 *
	 * @param userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 *
	 * @return telNumber
	 */
	public String getTelNumber() {
		return telNumber;
	}

	/**
	 *
	 * @param telNumber
	 */
	public void setTelNumber(String telNumber) {
		this.telNumber = telNumber;
	}

	/**
	 *
	 * @return eMail
	 */
	public String getEMail() {
		return eMail;
	}

	/**
	 *
	 * @param eMail
	 */
	public void setEMail(String eMail) {
		this.eMail = eMail;
	}

	/**
	 *
	 * @return address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 *
	 * @param address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 *
	 * @return isnertDate
	 */
	public Date getInsertDate() {
		return insertDate;
	}

	/**
	 *
	 * @param insertDate
	 */
	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}

	/**
	 *
	 * @return loginFlg
	 */
	public int getLoginFlg() {
		return loginFlg;
	}

	/**
	 *
	 * @param loginFlg
	 */
	public void setLoginFlg(int loginFlg) {
		this.loginFlg = loginFlg;
	}

	/**
	 *
	 * @return userFlg
	 */
	public int getUserFlg(){
		return userFlg;
	}

	/**
	 *
	 * @param userFlg
	 */
	public void setUserFlg(int userFlg){
		this.userFlg = userFlg;
	}
}
