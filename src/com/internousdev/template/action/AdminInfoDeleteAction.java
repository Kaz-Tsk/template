package com.internousdev.template.action;

import java.util.ArrayList;

import com.internousdev.template.dao.AdminInfoDAO;
import com.internousdev.template.dto.SalonDataDTO;
import com.opensymphony.xwork2.ActionSupport;

public class AdminInfoDeleteAction extends ActionSupport{

	private int infoVol;

	private String deleteMsg;

	ArrayList<SalonDataDTO> adminInfoList = new ArrayList<SalonDataDTO>();
	AdminInfoDAO dao = new AdminInfoDAO();
	public String execute() {
		String result = ERROR;
		adminInfoList = dao.adminInfoSelect();
		if(adminInfoList.size()==0) {
			deleteMsg = "※消去する内容がありません。";
			result = ERROR;
		}else if(adminInfoList.size()>0){
			for(int i = 0; i < adminInfoList.size(); i++) {
				if(adminInfoList.get(i).getInfoVol()!=infoVol) {
					deleteMsg = "※消去する内容が見つかりません。";
				}else if(adminInfoList.get(i).getInfoVol()==infoVol) {
					deleteMsg = "内容を消去しました。";
					dao.deleteInfo(infoVol);
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
	public String getDeleteMsg() {
		return deleteMsg;
	}
	public void setDeleteMsg(String deleteMsg) {
		this.deleteMsg = deleteMsg;
	}
}
