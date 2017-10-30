package com.internousdev.template.action;

import java.util.ArrayList;

import com.internousdev.template.dao.AdminInfoDAO;
import com.internousdev.template.dto.SalonDataDTO;
import com.opensymphony.xwork2.ActionSupport;

public class AdminInfoEditAction extends ActionSupport{

	private int infoVol;

	private String infoDay;

	private String infoText;

	private String editMsg;

	ArrayList<SalonDataDTO> adminInfoList = new ArrayList<SalonDataDTO>();
	AdminInfoDAO dao = new AdminInfoDAO();
	public String execute() {
		String result = ERROR;
		adminInfoList = dao.adminInfoSelect();
		if(adminInfoList.size()==0) {
			editMsg = "※編集する内容がありません。";
			return ERROR;
		}else if (adminInfoList.size()>0) {
			for(int i = 0; i < adminInfoList.size(); i++) {
				if(adminInfoList.get(i).getInfoVol()!=infoVol) {
					editMsg = "※該当する内容がありません。";
				}else if (adminInfoList.get(i).getInfoVol()==infoVol) {
					editMsg = "編集が完了しました。";
					dao.editInfo(infoVol, infoDay, infoText);
					result = SUCCESS;
					break;
				}
			}
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
	public String getEditMsg() {
		return editMsg;
	}
	public void setEditMsg(String editMsg) {
		this.editMsg = editMsg;
	}

}
