package com.internousdev.template.action;

import java.util.ArrayList;

import com.internousdev.template.dao.GoStaffDAO;
import com.internousdev.template.dao.GoStyleDAO;
import com.internousdev.template.dto.StaffDTO;
import com.internousdev.template.dto.StyleDTO;
import com.opensymphony.xwork2.ActionSupport;

public class GoAdminStyleAction extends ActionSupport{

	private String styleSex;

	GoStaffDAO staffDao = new GoStaffDAO();
	GoStyleDAO styleDAO = new GoStyleDAO();
	ArrayList<StyleDTO> ladiesStyleList = new  ArrayList<StyleDTO>();
	ArrayList<StyleDTO> mensStyleList = new  ArrayList<StyleDTO>();
	ArrayList<StaffDTO> staffList = new ArrayList<StaffDTO>();
	public String execute() {
		styleSex = "ladies";
		ladiesStyleList = styleDAO.styleSelect(styleSex);

		styleSex = "mens";
		mensStyleList = styleDAO.styleSelect(styleSex);
		staffList = staffDao.staffSelect();
		return SUCCESS;
	}


	public ArrayList<StyleDTO> getLadiesStyleList() {
		return ladiesStyleList;
	}


	public ArrayList<StyleDTO> getMensStyleList() {
		return mensStyleList;
	}


	public ArrayList<StaffDTO> getStaffList() {
		return staffList;
	}

}
