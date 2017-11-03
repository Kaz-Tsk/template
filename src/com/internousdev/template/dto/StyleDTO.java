package com.internousdev.template.dto;
/**
 * ヘアスタイル情報のDTO
 * @author Kazuyuki Tasaki
 * @version 1.0
 */
public class StyleDTO {

	/**
	 * スタイルvol
	 * @param styleVol
	 */
	private int styleVol;

	/**
	 * スタイル名
	 * @param styleName
	 */
	private String styleName;

	/**
	 * スタイルの性別
	 * @param styleSex
	 */
	private String styleSex;

	/**
	 * スタイル紹介文
	 * @param styleComment
	 */
	private String styleComment;

	/**
	 * スタイル画像
	 * @param styleImg
	 */
	private String styleImg;

	/**
	 * 担当スタッフ名
	 * @param staffName
	 */
	private String staffName;

	/**
	 * 担当スタッフ画像
	 */
	private String staffImg;

	//以下、setter getter
	public int getStyleVol() {
		return styleVol;
	}

	/**
	 *
	 * @param styleVol
	 */
	public void setStyleVol(int styleVol) {
		this.styleVol = styleVol;
	}

	/**
	 *
	 * @return styleName
	 */
	public String getStyleName(){
		return styleName;
	}

	/**
	 *
	 * @param styleName
	 */
	public void setStyleName(String styleName){
		this.styleName = styleName;
	}

	/**
	 *
	 * @return styleSex
	 */
	public String getStyleSex() {
		return styleSex;
	}

	/**
	 *
	 * @param styleSex
	 */
	public void setStyleSex(String styleSex) {
		this.styleSex = styleSex;
	}

	/**
	 *
	 * @return styleComment
	 */
	public String getStyleComment(){
		return styleComment;
	}
	/**
	 *
	 * @param styleComment
	 */
	public void setStyleComment(String styleComment){
		this.styleComment = styleComment;
	}
	/**
	 *
	 * @return styleImg
	 */
	public String getStyleImg(){
		return styleImg;
	}

	/**
	 *
	 * @param styleImg
	 */
	public void setStyleImg(String styleImg){
		this.styleImg = styleImg;
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

