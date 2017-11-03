package com.internousdev.template.action;

import java.util.ArrayList;

import com.internousdev.template.dao.AdminReserveDAO;
import com.internousdev.template.dto.ReserveDTO;
import com.opensymphony.xwork2.ActionSupport;
/**
 * 予約管理ページへ遷移するアクション
 * @author Kazuyuki Tasaki
 * @version 1.0
 *
 */
public class GoAdminReserveAction extends ActionSupport{
	//インスタンス化
	private AdminReserveDAO dao = new AdminReserveDAO();
	private ArrayList<ReserveDTO> reserveList = new ArrayList<ReserveDTO>();
	/**
	 * 予約情報を取得してページ遷移するメソッド
	 * @return SUCCESS
	 */
	public String execute() {
		reserveList = dao.reserveSelect();
		return SUCCESS;
	}
	//getter
	/**
	 *
	 * @return reserveList
	 */
	public ArrayList<ReserveDTO> getReserveList() {
		return reserveList;
	}
}
