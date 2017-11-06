package com.internousdev.template.action;

import com.opensymphony.xwork2.ActionSupport;
/**
 * 予約管理ページへ遷移するアクション
 * @author Kazuyuki Tasaki
 * @version 1.0
 *
 */
public class GoAdminReserveAction extends ActionSupport{


	/**
	 * 予約管理ページに遷移するメソッド
	 * @return SUCCESS
	 */
	public String execute() {
		return SUCCESS;
	}

}
