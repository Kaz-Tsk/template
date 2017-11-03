package com.internousdev.template.action;
import com.opensymphony.xwork2.ActionSupport;
/**
 * 管理ページトップへ遷移するアクション
 * @author Kazuyuki Tasaki
 * @version 1.0
 */
public class GoAdminTopAction extends ActionSupport{

	/**
	 * 管理ページトップへ遷移するメソッド
	 * @return SUCCESS
	 */
	public String execute() {
		return SUCCESS;
	}
}
