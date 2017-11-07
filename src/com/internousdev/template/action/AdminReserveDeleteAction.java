package com.internousdev.template.action;

import com.internousdev.template.dao.AdminReserveDAO;
import com.opensymphony.xwork2.ActionSupport;
/**
 * 管理側から予約を削除するアクション
 * @author Kazuyuki Tasaki
 * @version 1.0
 */
public class AdminReserveDeleteAction extends ActionSupport{

	/**
	 *予約ID
	 *@param reserveId
	 */
	private int reserveId;

	/**
	 * メッセージ
	 * @param msg
	 */
	private String msg;
	//インスタンス化
	/**
	 * 予約処理のDAO
	 * @param dao
	 */
	private AdminReserveDAO dao = new AdminReserveDAO();

	/**
	 * 予約情報を削除するメソッド
	 * @return SUCCESS
	 */
	public String execute() {
		dao.deleteReserve(reserveId);
		msg= "削除しました";
		return SUCCESS;

	}

	//以下setter getter
	/**
	 *
	 * @return reserveId
	 */
	public int getReserveId() {
		return reserveId;
	}

	/**
	 *
	 * @param reserveId
	 */
	public void setReserveId(int reserveId) {
		this.reserveId = reserveId;
	}

	/**
	 *
	 * @return msg
	 */
	public String getMsg() {
		return msg;
	}
}
