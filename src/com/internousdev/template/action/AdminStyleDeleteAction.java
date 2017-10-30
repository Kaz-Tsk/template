package com.internousdev.template.action;

import java.util.ArrayList;

import com.internousdev.template.dao.AdminStyleDAO;
import com.internousdev.template.dto.StyleDTO;
import com.opensymphony.xwork2.ActionSupport;

public class AdminStyleDeleteAction extends ActionSupport{

	private int styleVol;

	private String deleteMsg;

	ArrayList<StyleDTO> styleList = new ArrayList<StyleDTO>();
	AdminStyleDAO dao = new AdminStyleDAO();
	public String execute() {
		String result = ERROR;
		styleList = dao.styleList();
		if(styleList.size()==0) {
			deleteMsg = "削除するデータがありません。";
			return ERROR;
		}else if(styleList.size()>0) {
			for(int i = 0; i < styleList.size(); i++) {
				if(styleList.get(i).getStyleVol()==styleVol) {
					dao.deleteStyle(styleVol);
					deleteMsg = "スタイルを削除しました。";
					return  SUCCESS;
				}
			}
		deleteMsg = "該当するスタイルがありません。";
		}
		return result;
	}
	public int getStyleVol() {
		return styleVol;
	}
	public void setStyleVol(int styleVol) {
		this.styleVol = styleVol;
	}
	public String getDeleteMsg() {
		return deleteMsg;
	}
	public void setDeleteMsg(String deleteMsg) {
		this.deleteMsg = deleteMsg;
	}
}
