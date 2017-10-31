package com.internousdev.template.action;

import java.util.ArrayList;

import com.internousdev.template.dao.AdminReserveDAO;
import com.internousdev.template.dto.ReserveDTO;
import com.opensymphony.xwork2.ActionSupport;

public class AdminReserveDeleteAction extends ActionSupport{


	private int reserveId;

	private String deleteMsg;

	AdminReserveDAO dao = new AdminReserveDAO();
	ArrayList<ReserveDTO> reserveList = new ArrayList<ReserveDTO>();

	public String execute() {
		String result = ERROR;
		reserveList = dao.reserveSelect();
		if(reserveList.size()==0) {
			deleteMsg = "削除する予約がありません。";
			return ERROR;
		}else {
			for(int i = 0; i < reserveList.size(); i++) {
				if(reserveList.get(i).getReserveId()==reserveId) {
					dao.deleteReserve(reserveId);
					deleteMsg = "削除しました。";
					return SUCCESS;
				}
			}
		}
		deleteMsg = "削除する予約がありません";
		return result;
	}

	public int getReserveId() {
		return reserveId;
	}

	public void setReserveId(int reserveId) {
		this.reserveId = reserveId;
	}

	public String getDeleteMsg() {
		return deleteMsg;
	}

	public void setDeleteMsg(String deleteMsg) {
		this.deleteMsg = deleteMsg;
	}
}
