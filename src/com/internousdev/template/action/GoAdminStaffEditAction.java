package com.internousdev.template.action;

import java.util.ArrayList;

import com.internousdev.template.dao.AdminStaffDAO;
import com.internousdev.template.dto.StaffDTO;
import com.opensymphony.xwork2.ActionSupport;
/**
 * スタッフ情報の編集ぺーじへ遷移するアクション
 * @author Kazuyuki Tasaki
 * @version 1.0
 */
public class GoAdminStaffEditAction extends ActionSupport{
	/**
	 * スタッフId
	 * @param staffId
	 */
	private int staffId;
	//インスタンス化
	private AdminStaffDAO dao = new AdminStaffDAO();
	private ArrayList<StaffDTO> staffList = new ArrayList<StaffDTO>();
	/**
	 * スタッフ情報を取得してページ遷移するメソッド
	 * @return SUCCESS
	 */
	public String execute() {
		staffList = dao.staffEditSelect(staffId);
		return SUCCESS;
	}
	//以下、	setter getter
	/**
	 *
	 * @return staffId
	 */
	public int getStaffId() {
		return staffId;
	}
	/**
	 *
	 * @param staffId
	 */
	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}
	/**
	 *
	 * @return staffList
	 */
	public ArrayList<StaffDTO> getStaffList() {
		return staffList;
	}
}
