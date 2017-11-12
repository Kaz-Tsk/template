package com.internousdev.template.action;

import java.util.ArrayList;

import com.internousdev.template.dao.AdminStyleDAO;
import com.internousdev.template.dao.GoStaffDAO;
import com.internousdev.template.dto.StaffDTO;
import com.internousdev.template.dto.StyleDTO;
import com.opensymphony.xwork2.ActionSupport;
/**
 * スタイル情報を編集するページへ遷移するアクション
 * @author Kazuyuki Tasaki
 *
 */
public class GoAdminStyleEditAction extends ActionSupport {

	/**
	 * スタイルVol
	 * @param styleVol
	 */
	private int styleVol;

	/**
	 * スタイル名
	 * @param styleName
	 */
	private String styleName;

	/**
	 *スタイルの性別
	 *@param styleSex
	 */
	private String styleSex;

	/**
	 * スタイルのコメント
	 * @param styleComment
	 */
	private String styleComment;

	/**
	 * スタイル画像
	 * @param styleImg
	 */
	private String styleImg;

	//インスタンス化
	/**
	 * スタイル情報dto
	 * @param dto
	 */
	private StyleDTO dto = new StyleDTO();

	/**
	 *スタッフ情報リスト
	 *@param staffList
	 */
	private ArrayList<StaffDTO> staffList = new ArrayList<StaffDTO>();

	/**
	 * スタイル情報を取得するDAO
	 * @param dao
	 */
	private AdminStyleDAO dao =new AdminStyleDAO();

	/**
	 * スタッフ情報を取得するDAO
	 * @param staffDao
	 */
	private GoStaffDAO staffDao = new GoStaffDAO();

	/**
	 * スタイル情報を取得して編集ページへ遷移するメソッド
	 * @return SUCCESS
	 */
	public String execute() {
		dto = dao.styleEditSelect(styleVol);
		styleVol = dto.getStyleVol();
		styleName = dto.getStaffName();
		styleSex = dto.getStyleSex();
		styleComment = dto.getStyleComment();
		styleImg = dto.getStyleImg();
		staffList = staffDao.staffSelect();
		return SUCCESS;
	}

	//以下、getter setter
	/**
	 *
	 * @return styleVol
	 */
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
	public String getStyleName() {
		return styleName;
	}

	/**
	 *
	 * @param styleName
	 */
	public void setStyleName(String styleName) {
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
	public String getStyleComment() {
		return styleComment;
	}

	/**
	 *
	 * @param styleComment
	 */
	public void setStyleComment(String styleComment) {
		this.styleComment = styleComment;
	}

	/**
	 *
	 * @return styleImg
	 */
	public String getStyleImg() {
		return styleImg;
	}

	/**
	 *
	 * @param styleImg
	 */
	public void setStyleImg(String styleImg) {
		this.styleImg = styleImg;
	}

	/**
	 *
	 * @return staffList
	 */
	public ArrayList<StaffDTO> getStaffList() {
		return staffList;
	}


}
