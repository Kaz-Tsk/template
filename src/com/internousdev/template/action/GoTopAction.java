package com.internousdev.template.action;

import java.util.ArrayList;

import com.internousdev.template.dao.GoTopActionDAO;
import com.internousdev.template.dto.SalonDataDTO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * index.jspに遷移するアクション
 * @author Kazuyuki Tasaki
 *@return result
 */
public class GoTopAction extends ActionSupport {

	GoTopActionDAO dao = new GoTopActionDAO();
	SalonDataDTO dto = new SalonDataDTO();
	ArrayList<SalonDataDTO> salonInfoList = new  ArrayList<SalonDataDTO>();
	public String execute(){
		salonInfoList = dao.infoSelect();
		System.out.println(salonInfoList.size());
		return  SUCCESS;

	}

	public ArrayList<SalonDataDTO> getSalonInfoList(){
		return salonInfoList;
	}
}
