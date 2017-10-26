package com.internousdev.template.action;

import java.util.ArrayList;

import com.internousdev.template.dao.AdminInfoDAO;
import com.internousdev.template.dto.SalonDataDTO;
import com.opensymphony.xwork2.ActionSupport;

public class GoAdminInfoAction extends ActionSupport{

	ArrayList<SalonDataDTO> adminInfoList = new ArrayList<SalonDataDTO>();
	SalonDataDTO dto = new SalonDataDTO();
	AdminInfoDAO dao = new AdminInfoDAO();
	public String execute(){
		adminInfoList = dao.adminInfoSelect();
		return SUCCESS;
	}

	public ArrayList<SalonDataDTO> getAdminInfoList(){
		return adminInfoList;
	}
}
