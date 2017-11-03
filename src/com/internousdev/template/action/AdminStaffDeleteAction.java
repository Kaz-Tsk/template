package com.internousdev.template.action;

import java.util.ArrayList;

import com.internousdev.template.dao.AdminStaffDAO;
import com.internousdev.template.dto.StaffDTO;
import com.opensymphony.xwork2.ActionSupport;
/**
 * スタッフ情報を削除するアクション
 * @author Kazuyuki Tasaki
 * @version 1.0
 */
public class AdminStaffDeleteAction extends ActionSupport{

	/**
	 * スタッフID
	 * @param staffId
	 */
	private int staffId;

	/**
	 * 実行後メッセージ
	 * @param deleteMsg
	 */
	private String deleteMsg;

	//インスタンス化
	/**
	 * スタッフ情報処理のDAO
	 * @param dao
	 */
	private AdminStaffDAO dao = new AdminStaffDAO();

	/**
	 * スタッフ情報リスト
	 * @param staffList
	 */
	private ArrayList<StaffDTO> staffList = new ArrayList<StaffDTO>();

	/**
	 * スタッフ情報を削除するメソッド
	 * @return result 該当す報があればSUCCESS なければERROR
	 */
	public String execute() {
		String result = ERROR;
		//DBからスタッフ情報を取得
		staffList = dao.staffInsertSelect();
		if(staffList.size()==0) {
			deleteMsg = "削除するデータがありません。";
			return result;
		}else if(staffList.size()>0) {
			//該当する情報があれば実行
			for(int i = 0; i < staffList.size(); i++) {
				if(staffList.get(i).getStaffId()==staffId) {
					dao.deleteStaff(staffId);
					deleteMsg = "スタッフを削除しました。";
					return SUCCESS;
				}
			}
			deleteMsg = "該当するスタッフがありません。";
		}
		return result;
	}

	//以下、setter getter
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
	 * @return deleteMsg
	 */
	public String getDeleteMsg() {
		return deleteMsg;
	}
}
