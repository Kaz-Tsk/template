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
	 */
	private int styleVol;

	//インスタンス化
	/**
	 * スタイル情報リスト
	 * @param styleList
	 */
	private ArrayList<StyleDTO> styleList = new ArrayList<StyleDTO>();

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
		styleList = dao.styleEditSelect(styleVol);
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
	 * @return styleList
	 */
	public ArrayList<StyleDTO> getStyleList() {
		return styleList;
	}

	/**
	 *
	 * @return staffList
	 */
	public ArrayList<StaffDTO> getStaffList() {
		return staffList;
	}
}
