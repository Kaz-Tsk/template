package com.internousdev.template.action;

import java.util.ArrayList;

import com.internousdev.template.dao.AdminStyleDAO;
import com.internousdev.template.dao.GoStaffDAO;
import com.internousdev.template.dto.StaffDTO;
import com.internousdev.template.dto.StyleDTO;
import com.opensymphony.xwork2.ActionSupport;

public class GoAdminStyleEditAction extends ActionSupport {

	private int styleVol;

	ArrayList<StyleDTO> styleList = new ArrayList<StyleDTO>();
	ArrayList<StaffDTO> staffList = new ArrayList<StaffDTO>();
	AdminStyleDAO dao =new AdminStyleDAO();
	GoStaffDAO staffDao = new GoStaffDAO();

	public String execute() {

		styleList = dao.styleEditSelect(styleVol);
		staffList = staffDao.staffSelect();
		return SUCCESS;
	}
	public int getStyleVol() {
		return styleVol;
	}
	public void setStyleVol(int styleVol) {
		this.styleVol = styleVol;
	}

	public ArrayList<StyleDTO> getStyleList() {
		return styleList;
	}
	public ArrayList<StaffDTO> getStaffList() {
		return staffList;
	}
}
