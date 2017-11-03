package com.internousdev.template.action;

import java.util.ArrayList;

import com.internousdev.template.dao.GoStaffDAO;
import com.internousdev.template.dto.StaffDTO;
import com.opensymphony.xwork2.ActionSupport;
/**
 * スタッフ管理ページへ遷移するアクション
 * @author Kazuyuki Tasaki
 * @version 1.0
 */
public class GoAdminStaffAction extends ActionSupport{

	//インスタンス化
	/**
	 * スタッフ情報取得のDAO
	 * @param dao
	 */
	private GoStaffDAO dao = new GoStaffDAO();

	/**
	 * スタッフ情報リスト
	 * @param staffList
	 */
	private ArrayList<StaffDTO> staffList = new ArrayList<StaffDTO>();

	/**
	 * スタッフ情報を取得してページ遷移するメソッド
	 * @return result SUCCESS
	 */
	public String execute() {
		staffList = dao.staffSelect();
		String result = SUCCESS;
		return result;
	}

	//getter
	/**
	 *
	 * @return staffList
	 */
	public ArrayList<StaffDTO> getStaffList() {
		return staffList;
	}
}
