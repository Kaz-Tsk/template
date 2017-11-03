package com.internousdev.template.action;

import java.util.ArrayList;

import com.internousdev.template.dao.GoStaffDAO;
import com.internousdev.template.dto.StaffDTO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * スタッフ紹介ページへ遷移するアクション
 * @author Kazuyuki Tasaki
 * @version 1.0
 */
public class GoStaffAction extends ActionSupport{

	//インスタンス化
	private GoStaffDAO dao = new GoStaffDAO();
	private ArrayList<StaffDTO> staffList = new  ArrayList<StaffDTO>();
	/**
	 * スタッフ情報を取得して遷移するメソッド
	 * @return result SUCCESS
	 */
	public String execute(){
		staffList = dao.staffSelect();
		return  SUCCESS;
	}

	/**
	 * getter
	 * @return staffList
	 */
	public ArrayList<StaffDTO> getStaffList(){
		return staffList;
	}
}
