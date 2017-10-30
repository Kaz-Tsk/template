package com.internousdev.template.action;



import java.util.ArrayList;

import com.internousdev.template.dao.GoStaffDAO;
import com.internousdev.template.dto.StaffDTO;
import com.opensymphony.xwork2.ActionSupport;

public class GoAdminStaffAction extends ActionSupport{
	GoStaffDAO dao = new GoStaffDAO();
	 ArrayList<StaffDTO> staffList = new ArrayList<StaffDTO>();

	public String execute() {
		staffList = dao.staffSelect();
		String result = SUCCESS;
		return result;
	}

	public ArrayList<StaffDTO> getStaffList() {
		return staffList;
	}
}
