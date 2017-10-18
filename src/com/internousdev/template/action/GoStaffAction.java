package com.internousdev.template.action;

import java.util.ArrayList;

import com.internousdev.template.dao.GoStaffDAO;
import com.internousdev.template.dto.StaffDTO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * スタッフページの情報を取得する
 * @author Kazuyuki Tasaki
 *
 */
public class GoStaffAction extends ActionSupport{

	GoStaffDAO dao = new GoStaffDAO();
	StaffDTO dto = new StaffDTO();
	ArrayList<StaffDTO> staffList = new  ArrayList<StaffDTO>();

	public String execute(){
		staffList = dao.staffSelect();

		return  SUCCESS;
	}

	public ArrayList<StaffDTO> getStaffList(){
		return staffList;
	}

}
