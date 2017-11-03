package com.internousdev.template.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template.dao.UserCreateDAO;
import com.opensymphony.xwork2.ActionSupport;
/**
 * ユーザー新規登録完了画面へ遷移するアクション
 * @author Kazuyuki Tasaki
 * @version 1.0
 */
public class UserCreateComplateAction extends ActionSupport implements SessionAware{

	/**
	 * セッション情報
	 * @param session
	 */
	private Map<String,Object> session;

	//インスタンス化
	/**
	 * ユーザー新規登録処理のDAO
	 * @param dao
	 */
	private UserCreateDAO dao = new UserCreateDAO();

	/**
	 * ユーザー新規登録実行メソッド
	 * @return result SUCCESS
	 */
	public String execute() throws SQLException {
		String result = SUCCESS;
		//新規登録
		dao.cerateUser((String)session.get("loginUserId"), (String)session.get("loginPassword"), (String)session.get("userName"),
				(String)session.get("telNumber"), (String)session.get("eMail"), (String)session.get("address"));
		//登録に使ったセッションを破棄
		session.clear();
		return result ;
	}
	//setter
	/**
	 *
	 * @param session
	 */
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;

	}
}
