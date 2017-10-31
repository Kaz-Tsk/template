package com.internousdev.template.action;

import java.util.ArrayList;

import com.internousdev.template.dao.AdminReserveDAO;
import com.internousdev.template.dto.ReserveDTO;
import com.opensymphony.xwork2.ActionSupport;

public class GoAdminReserveAction extends ActionSupport{

	AdminReserveDAO dao = new AdminReserveDAO();
	ArrayList<ReserveDTO> reserveList = new ArrayList<ReserveDTO>();
	public String execute() {
		reserveList = dao.reserveSelect();
		return SUCCESS;
	}


	public ArrayList<ReserveDTO> getReserveList() {
		return reserveList;
	}
}
