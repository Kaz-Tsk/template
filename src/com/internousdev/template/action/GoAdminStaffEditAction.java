package com.internousdev.template.action;

import java.util.ArrayList;

import com.internousdev.template.dao.AdminStaffDAO;
import com.internousdev.template.dto.StaffDTO;
import com.opensymphony.xwork2.ActionSupport;

public class GoAdminStaffEditAction extends ActionSupport{

	private int staffId;



	AdminStaffDAO dao = new AdminStaffDAO();
	ArrayList<StaffDTO> staffList = new ArrayList<StaffDTO>();
	public String execute() {
		staffList = dao.staffEditSelect(staffId);
		return SUCCESS;
	}

	public int getStaffId() {
		return staffId;
	}
	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}
	public ArrayList<StaffDTO> getStaffList() {
		return staffList;
	}
}
