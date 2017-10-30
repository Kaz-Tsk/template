package com.internousdev.template.action;

import java.util.ArrayList;

import com.internousdev.template.dao.AdminInfoDAO;
import com.internousdev.template.dto.SalonDataDTO;
import com.opensymphony.xwork2.ActionSupport;

public class GoAdminInfoAction extends ActionSupport{

	private int infoVol;

	private String infoDay;

	private String infoText;

	private String insertMsg;

	ArrayList<SalonDataDTO> adminInfoList = new ArrayList<SalonDataDTO>();
	SalonDataDTO dto = new SalonDataDTO();
	AdminInfoDAO dao = new AdminInfoDAO();
	public String execute(){
		adminInfoList = dao.adminInfoSelect();
		for(int i=0; i < adminInfoList.size() ;i++) {
			System.out.println("volの値"+i+":"+adminInfoList.get(i).getInfoVol());
		}
		return SUCCESS;
	}

	public int getInfoVol() {
		return infoVol;
	}

	public void setInfoVol(int infoVol) {
		this.infoVol = infoVol;
	}

	public String getInfoDay() {
		return infoDay;
	}

	public void setInfoDay(String infoDay) {
		this.infoDay = infoDay;
	}

	public String getInfoText() {
		return infoText;
	}

	public void setText(String infoText) {
		this.infoText = infoText;
	}

	public String getInsertMsg() {
		return insertMsg;
	}

	public void setInsertMsg(String insertMsg) {
		this.insertMsg = insertMsg;
	}

	public ArrayList<SalonDataDTO> getAdminInfoList(){
		return adminInfoList;
	}
}
