package com.internousdev.template.action;

import java.util.ArrayList;

import com.internousdev.template.dao.AdminStaffDAO;
import com.internousdev.template.dto.StaffDTO;
import com.opensymphony.xwork2.ActionSupport;

public class AdminStaffDeleteAction extends ActionSupport{

	private int staffId;
	private String deleteMsg;

	AdminStaffDAO dao = new AdminStaffDAO();
	ArrayList<StaffDTO> staffList = new ArrayList<StaffDTO>();
	public String execute() {
		String result = ERROR;
		staffList = dao.staffInsertSelect();
		if(staffList.size()==0) {
			deleteMsg = "削除するデータがありません。";
			return result;
		}else if(staffList.size()>0) {
			for(int i = 0; i < staffList.size(); i++) {
				if(staffList.get(i).getStaffId()==staffId) {
					dao.deleteStaff(staffId);
					deleteMsg = "スタッフを削除しました。";
					return SUCCESS;
				}
			}
			deleteMsg = "該当するスタッフがありません。";
		}
		return result;
	}
	public int getStaffId() {
		return staffId;
	}
	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}
	public String getDeleteMsg() {
		return deleteMsg;
	}
	public void setDeleteMsg(String deleteMsg) {
		this.deleteMsg = deleteMsg;
	}
}
