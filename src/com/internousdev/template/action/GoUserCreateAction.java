package com.internousdev.template.action;

import com.opensymphony.xwork2.ActionSupport;
/**
 * 新規ユーザー登録画面へ遷移するアクション
 * @author Kazuyuki Tasaki
 * @version 1.0
 */
public class GoUserCreateAction extends ActionSupport {
	/**
	 * ユーザー登録画面へ遷移するメソッド
	 * @return SUCCESS
	 */
	public String execute() {
		return SUCCESS;
	}
}
