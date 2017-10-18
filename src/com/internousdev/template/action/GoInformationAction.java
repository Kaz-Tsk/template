package com.internousdev.template.action;

import java.util.ArrayList;

import com.internousdev.template.dao.GoInformationDAO;
import com.internousdev.template.dto.SalonDataDTO;
import com.opensymphony.xwork2.ActionSupport;

public class GoInformationAction extends ActionSupport {

	GoInformationDAO dao = new GoInformationDAO();
	SalonDataDTO dto = new SalonDataDTO();
	ArrayList<SalonDataDTO> salonDataList = new  ArrayList<SalonDataDTO>();

	public String execute(){
		salonDataList = dao.styleSelect();

		return  SUCCESS;
	}

	public ArrayList<SalonDataDTO> getSalonDataList(){
		return salonDataList;
	}

}
