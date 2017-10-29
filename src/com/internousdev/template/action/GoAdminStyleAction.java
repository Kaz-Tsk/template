package com.internousdev.template.action;

import java.util.ArrayList;

import com.internousdev.template.dao.GoStaffDAO;
import com.internousdev.template.dto.StaffDTO;
import com.opensymphony.xwork2.ActionSupport;

public class GoAdminStyleAction extends ActionSupport{

	GoStaffDAO staffDao = new GoStaffDAO();
	ArrayList<StaffDTO> staffList = new ArrayList<StaffDTO>();
	public String execute() {
		staffList = staffDao.staffSelect();
		return SUCCESS;
	}


	public ArrayList<StaffDTO> getStaffList() {
		return staffList;
	}

}
