package com.internousdev.template.action;

import java.util.ArrayList;

import com.internousdev.template.dao.GoStaffDAO;
import com.internousdev.template.dao.GoStyleDAO;
import com.internousdev.template.dto.StaffDTO;
import com.internousdev.template.dto.StyleDTO;
import com.opensymphony.xwork2.ActionSupport;
/**
 * ヘアスタイル管理ページへ遷移するアクション
 * @author Kazuyuki Tasaki
 * @version 1.0
 */
public class GoAdminStyleAction extends ActionSupport{
	/**
	 * スタイルの性別
	 * @param styleSex
	 */
	private String styleSex;
	//インスタンス化
	private GoStaffDAO staffDao = new GoStaffDAO();
	private GoStyleDAO styleDAO = new GoStyleDAO();
	private ArrayList<StyleDTO> ladiesStyleList = new  ArrayList<StyleDTO>();
	private ArrayList<StyleDTO> mensStyleList = new  ArrayList<StyleDTO>();
	private ArrayList<StaffDTO> staffList = new ArrayList<StaffDTO>();
	/**
	 * ヘアスタイル情報とスタッフ情報を取得してページ遷移をするメソッド
	 * @return SUCCESS
	 */
	public String execute() {
		//DBから女性のヘアスタイルを取得
		styleSex = "ladies";
		ladiesStyleList = styleDAO.styleSelect(styleSex);
		//DBから男性のヘアスタイルを取得
		styleSex = "mens";
		mensStyleList = styleDAO.styleSelect(styleSex);
		//スタッフ情報を取得
		staffList = staffDao.staffSelect();
		return SUCCESS;
	}
	//以下getter
	/**
	 *
	 * @return ladiesStyleList
	 */
	public ArrayList<StyleDTO> getLadiesStyleList() {
		return ladiesStyleList;
	}
	/**
	 *
	 * @return mensStyleList
	 */
	public ArrayList<StyleDTO> getMensStyleList() {
		return mensStyleList;
	}
	/**
	 *
	 * @return staffList
	 */
	public ArrayList<StaffDTO> getStaffList() {
		return staffList;
	}
}
