package com.internousdev.template.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template.dao.UserCreateDAO;
import com.internousdev.template.dto.UserDTO;
import com.opensymphony.xwork2.ActionSupport;

/**
 *ユーザー新規登録の確認画面へ遷移するアクション
 * @author Kazuyuki Tasaki
 * @version 1.0
 */
public class UserCreateConfirmAction extends ActionSupport implements SessionAware{

	/**
	 * ログインユーザーID
	 * @param loginUserId
	 */
	private String loginUserId;

	/**
	 *ログインパスワード
	 *@param loginPassword
	 */
	private String loginPassword;

	/**
	 * ユーザー名
	 * @param userName
	 */
	private String userName;

	/**
	 * 電話番号
	 * @param telNumber
	 */
	private String telNumber;

	/**
	 * メールアドレス
	 * @param eMail
	 */
	private String eMail;

	/**
	 * 住所
	 * @param address
	 */
	private String address;

	/**
	 * 実行後メッセージ
	 * @param errorMessage
	 */
	private String errorMessage;

	/**
	 *セッション情報
	 *@param session
	 */
	private Map<String, Object> session;

	//インスタンス化
	/**
	 * 既存のユーザー情報リスト
	 * @param userCheckList
	 */
	private ArrayList<UserDTO> userCheckList = new ArrayList<UserDTO>();

	/**
	 * ユーザー新規登録のDAO
	 * @param dao
	 */
	private UserCreateDAO dao =  new UserCreateDAO();

	/**
	 * 新規登録情報を確認するメソッド
	 * @return result 既存の登録情報と重複していたらERROR していなければSUCCESS
	 */
	public String execute() {
		String result = ERROR;
		//既存のデータのメールアドレスと電話番号の重複がないかチェック
		userCheckList = dao.userCreateCheck();
		for(int i = 0; i < userCheckList.size(); i++) {
			if(userCheckList.get(i).getEMail().equals(eMail)||userCheckList.get(i).getTelNumber().equals(telNumber)) {
				errorMessage = "※すでに登録済みのユーザー情報が含まれています。";
				return result;
			}
		}
		//登録完了時に使うセッションをセット
		session.put("loginUserId", loginUserId);
		session.put("loginPassword", loginPassword);
		session.put("userName", userName);
		session.put("telNumber", telNumber);
		session.put("eMail", eMail);
		session.put("address", address);
		return SUCCESS;
	}

	//以下、setter  getter
	/**
	 *
	 * @return loginUserId
	 */
	public String getLoginUserId() {
		return loginUserId;
	}

	/**
	 *
	 * @param loginUserId
	 */
	public void setLoginUserId(String loginUserId) {
		this.loginUserId = loginUserId;
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
	public String geteMail() {
		return eMail;
	}

	/**
	 *
	 * @param eMail
	 */
	public void seteMail(String eMail) {
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
	 * @return errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 *
	 * @param session
	 */
	@Override
	public void setSession(Map<String,Object> session) {
		this.session = session;
	}
}
