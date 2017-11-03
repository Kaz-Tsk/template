package com.internousdev.template.dto;
/**
 * スタッフ情報のDTO
 * @author Kazuyuki Tasaki
 * @version 1.0
 */
public class StaffDTO {

	/**
	 * スタッフID
	 * @param staffId
	 */
	private int staffId;

	/**
	 * スタッフ名
	 *@param staffName
	 */
	private String staffName;
	/**
	 * スタッフ紹介文
	 * @param staffComment
	 */
	private String staffComment;

	/**
	 * スタッフ画像
	 * @param staffImg
	 */
	private String staffImg;

	//以下、setter getter
	/**
	 *
	 * @return staffId
	 */
	public int getStaffId(){
		return staffId;
	}

	/**
	 *
	 * @param staffId
	 */
	public void setStaffId(int staffId){
		this.staffId = staffId;
	}

	/**
	 *
	 * @return staffName
	 */
	public String getStaffName(){
		return staffName;
	}

	/**
	 *
	 * @param staffName
	 */
	public void setStaffName(String staffName){
		this.staffName = staffName;
	}

	/**
	 *
	 * @return staffComment
	 */
	public String getStaffComment(){
		return staffComment;
	}

	/**
	 *
	 * @param staffComment
	 */
	public void setStaffComment(String staffComment){
		this.staffComment = staffComment;
	}
	/**
	 *
	 * @return staffImg
	 */
	public String getStaffImg(){
		return staffImg;
	}

	/**
	 *
	 * @param staffImg
	 */
	public void setStaffImg(String staffImg){
		this.staffImg = staffImg;
	}
}
