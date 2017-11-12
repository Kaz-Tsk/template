package com.internousdev.template.action;

import com.internousdev.template.dao.AdminStaffDAO;
import com.internousdev.template.dto.StaffDTO;
import com.opensymphony.xwork2.ActionSupport;
/**
 * スタッフ情報の編集ページへ遷移するアクション
 * @author Kazuyuki Tasaki
 * @version 1.0
 */
public class GoAdminStaffEditAction extends ActionSupport{

	/**
	 * スタッフId
	 * @param staffId
	 */
	private int staffId;

	/**
	 * スタッフ名
	 * @param staffName
	 */
	private String staffName;

	/**
	 * スタッフコメント
	 * @param staffComment
	 */
	private String staffComment;

	/**
	 * スタッフ画像
	 * @param staffImg
	 */
	private String staffImg;

	//インスタンス化
	/**
	 * スタッフ情報を取得するDAO
	 */
	private AdminStaffDAO dao = new AdminStaffDAO();

	/**
	 * スタッフ情報リスト
	 * @param staffList
	 */
	private StaffDTO dto = new StaffDTO();

	/**
	 * スタッフ情報を取得してページ遷移するメソッド
	 * @return SUCCESS
	 */
	public String execute() {
		dto = dao.staffEditSelect(staffId);
		staffId = dto.getStaffId();
		staffName = dto.getStaffName();
		staffComment = dto.getStaffComment();
		staffImg = dto.getStaffImg();
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
	 * @return staffName
	 */
	public String getStaffName() {
		return staffName;
	}

	/**
	 *
	 * @param staffName
	 */
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	/**
	 *
	 * @return staffComment
	 */
	public String getStaffComment() {
		return staffComment;
	}

	/**
	 *
	 * @param staffComment
	 */
	public void setStaffComment(String staffComment) {
		this.staffComment = staffComment;
	}

	/**
	 *
	 * @return staffImg
	 */
	public String getStaffImg() {
		return staffImg;
	}

	/**
	 *
	 * @param staffImg
	 */
	public void setStaffImg(String staffImg) {
		this.staffImg = staffImg;
	}
}
