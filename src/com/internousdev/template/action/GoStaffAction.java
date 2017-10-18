package com.internousdev.template.action;

import java.util.ArrayList;

import com.internousdev.template.dao.SalonDataDTO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * スタッフページの情報を取得する
 * @author Kazuyuki Tasaki
 *
 */
public class GoStaffAction extends ActionSupport{

	GoStaffDAO dao = new GoStaffDAO();
	StaffDTO dto = new StaffDTO();
	ArrayList<SaffDTO> staffList = new  ArrayList<StaffDTO>();
	public String execute(){
		staffList = dao.staffSelect();

		return  SUCCESS;
	}

	public ArrayList<SalonDataDTO> getSalonInfoList(){
		return staffList;
	}

}
