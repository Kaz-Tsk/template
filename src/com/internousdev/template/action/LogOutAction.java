package com.internousdev.template.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template.dao.LogOutDAO;
import com.opensymphony.xwork2.ActionSupport;
/**
 * ログアクト処理を行うアクション
 * @author Kazuyuki Tasaki
 * @version 1.0
 */
public class LogOutAction extends ActionSupport implements SessionAware {

	/**
	 * Session情報
	 * @param session
	 */
	private Map<String, Object> session;

	//インスタンス化
	/**
	 * ログアウト処理のDAO
	 * @param dao
	 */
	private LogOutDAO dao = new LogOutDAO();

	/**
	 * ログアウト実行メソッド
	 * @return SUCCESS
	 */
	public String execute() {
		//ログインフラグを0に戻す
		dao.logOutFlg((int)session.get("Id"));
		//セッションを破棄
		session.clear();
		return SUCCESS;
	}

	//setter
	/**
	 * @param session
	 */
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
