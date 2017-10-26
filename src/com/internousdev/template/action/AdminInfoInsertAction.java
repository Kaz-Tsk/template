package com.internousdev.template.action;

import java.util.ArrayList;

import com.internousdev.template.dao.AdminInfoDAO;
import com.internousdev.template.dto.SalonDataDTO;
import com.opensymphony.xwork2.ActionSupport;

public class AdminInfoInsertAction extends ActionSupport{

	private int vol;

	private String day;

	private String text;

	private String insertErrorMsg;

	private String insertSuccessMsg;

	AdminInfoDAO dao = new AdminInfoDAO();
	ArrayList<SalonDataDTO> adminInfoList = new ArrayList<SalonDataDTO>();
	public String execute() {
		String result = ERROR;
		adminInfoList = dao.adminInfoSelect();
		for(int i = 0; i < adminInfoList.size(); i++) {
			if(adminInfoList.get(i).getVol() == vol) {
				insertErrorMsg = "volが重複しています。";
				return result;
			}else {
				dao.insertInfo(vol, day, text);
				insertSuccessMsg = "登録完了しました。";
				result = SUCCESS;
			}
		}
		return result;
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

	public String getInsertErrorMsg() {
		return insertErrorMsg;
	}

	public String getInsertSuccessMsg() {
		return insertSuccessMsg;
	}
}
