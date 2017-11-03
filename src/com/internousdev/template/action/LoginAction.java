package com.internousdev.template.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template.dao.LoginDAO;
import com.internousdev.template.dto.UserDTO;
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
	 * @param loginUserId
	 */
	public String loginUserId;

	/**
	 * ログインパスワード
	 * @param loginPassword
	 */

	public String loginPassword;

	/**
	 * 処理結果を格納
	 * @param result
	 */

	public String result;

	/**
	 * ログイン情報
	 * @param session
	 */

	public Map<String, Object> session;

	//インスタンス化
	/**
	 * ログイン情報取得DAO
	 * @param loginDAO
	 */

	public LoginDAO loginDAO = new LoginDAO();

	/**
	 * ログイン情報格納DTO
	 * @param loginDTO
	 */
	private UserDTO loginDTO = new UserDTO();

	/**
	 *
	 * ログイン実行メソッド
	 * @return result ログイン成功でSUCCESS 失敗でERROR
	 */
	public String execute() {
		result = ERROR;
		// ログイン実行
		loginDTO = loginDAO.getLoginUserInfo(loginUserId, loginPassword);
		//ログインフラグが立っていたらERROR
		if(loginDTO.getLoginFlg()==1){
			result= ERROR;
			//ユーザーの判別
		}else if(loginDTO.getUserFlg()==1){
			session.put("Id", loginDTO.getId());
			session.put("userFlg", loginDTO.getUserFlg());
			loginDAO.updateFlg(loginDTO.getId());
			result= SUCCESS;
		}else if(loginDTO.getUserFlg()==2){
			session.put("userFlg",loginDTO.getUserFlg());
			session.put("Id",loginDTO.getId());
			result = "admin";
		}
		return result;
	}

	//以下、setter getter
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
	 * @param session
	 */
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
