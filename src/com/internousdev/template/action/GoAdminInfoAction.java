package com.internousdev.template.action;

import java.util.ArrayList;

import com.internousdev.template.dao.AdminInfoDAO;
import com.internousdev.template.dto.SalonDataDTO;
import com.opensymphony.xwork2.ActionSupport;

public class GoAdminInfoAction extends ActionSupport{

	private int vol;

	private String day;

	private String text;

	private String insertMsg;

	ArrayList<SalonDataDTO> adminInfoList = new ArrayList<SalonDataDTO>();
	SalonDataDTO dto = new SalonDataDTO();
	AdminInfoDAO dao = new AdminInfoDAO();
	public String execute(){
		adminInfoList = dao.adminInfoSelect();
		for(int i=0; i < adminInfoList.size() ;i++) {
			System.out.println("volの値"+i+":"+adminInfoList.get(i).getVol());
		}
		return SUCCESS;
	}

	public int getVol() {
		return vol;
	}

	public void setVol(int vol) {
		this.vol = vol;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
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
