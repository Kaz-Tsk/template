package com.internousdev.template.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template.dao.LoginDAO;
import com.internousdev.template.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * ログイン認証処理
 * Login.jspからログインID、ログインパスワードを受け取り
 * DBへ問い合わせを行います。
 *
 * @author Kazuyuki Tasaki
 * @param loginUserId
 * @param loginPassword
 *
 * @return result
 */
public class LoginAction extends ActionSupport implements SessionAware{

	/**
	 * ログインID
	 */
	public String loginUserId;

	/**
	 * ログインパスワード
	 */
	public String loginPassword;

	/**
	 * 処理結果を格納
	 */
	public String result;

	/**
	 * ログイン情報を格納
	 */
	public Map<String, Object> session;

	/**
	 * ログイン情報取得DAO
	 */
	public LoginDAO loginDAO = new LoginDAO();

	/**
	 * ログイン情報格納DTO
	 */
	private LoginDTO loginDTO = new LoginDTO();

	/**
	 *
	 * 実行メソッド
	 */
	public String execute() {

		result = ERROR;

		// ログイン実行
		loginDTO = loginDAO.getLoginUserInfo(loginUserId, loginPassword);
		if(loginDTO.getLoginFlg()==1){
			result= ERROR;
		}else if(loginDTO.getUserFlg()==1){
			session.put("Id", loginDTO.getId());
			session.put("userFlg", loginDTO.getUserFlg());
			System.out.println(loginDTO.getId());
			loginDAO.updateFlg(loginDTO.getId());
			result= SUCCESS;
		}else{
			session.put("userFlg",loginDTO.getUserFlg());
			result = "admin";
		}
		return result;
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

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
