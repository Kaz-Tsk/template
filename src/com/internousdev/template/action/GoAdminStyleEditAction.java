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
	private ArrayList<StyleDTO> styleList = new ArrayList<StyleDTO>();
	private ArrayList<StaffDTO> staffList = new ArrayList<StaffDTO>();
	private AdminStyleDAO dao =new AdminStyleDAO();
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
