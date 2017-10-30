package com.internousdev.template.action;

import java.util.ArrayList;

import com.internousdev.template.dao.AdminInfoDAO;
import com.internousdev.template.dto.SalonDataDTO;
import com.opensymphony.xwork2.ActionSupport;

public class AdminInfoInsertAction extends ActionSupport{

	private int infoVol;

	private String infoDay;

	private String infoText;

	private String insertMsg;

	AdminInfoDAO dao = new AdminInfoDAO();
	ArrayList<SalonDataDTO> adminInfoList = new ArrayList<SalonDataDTO>();
	public String execute() {
		String result = ERROR;
		adminInfoList = dao.adminInfoSelect();
		if (adminInfoList.size()==0) {
			dao.insertInfo(infoVol, infoDay, infoText);
			insertMsg ="登録が完了しました。";
			result = SUCCESS;
		}else if (adminInfoList.size()>0) {
			for (int i = 0; i < adminInfoList.size(); i++) {
				if (adminInfoList.get(i).getInfoVol()==infoVol) {
					insertMsg = "※volが重複しています。もう一度登録してください。";
					return result;
				}
			}
			dao.insertInfo(infoVol, infoDay, infoText);
			insertMsg = "登録が完了しました";
			result =SUCCESS;
		}
		return result;
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

	public void setInfoText(String infoText) {
		this.infoText = infoText;
	}

	public String getInsertMsg() {
		return insertMsg;
	}

}
