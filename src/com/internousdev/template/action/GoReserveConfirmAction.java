package com.internousdev.template.action;

import java.util.ArrayList;

import com.internousdev.template.dao.ReserveConfirmDAO;
import com.internousdev.template.dto.MenuDTO;
import com.opensymphony.xwork2.ActionSupport;

public class GoReserveConfirmAction extends ActionSupport {

	private int menuId;
	
	private String reserveDate;
	
	private String reserveHour;
	
	private String staffName;
	
	private String pay;
	
	private int subPrice = 0;

	ReserveConfirmDAO dao = new ReserveConfirmDAO();
	MenuDTO dto = new MenuDTO();
	ArrayList<MenuDTO> reserveConfirmList = new ArrayList<MenuDTO>();
	public String execute(){
		String result = ERROR;
		reserveConfirmList = dao.selectReserveConfirm(menuId);
		if(reserveConfirmList.size()>1){
			for(int i=0; i <= reserveConfirmList.size()-1; i++ ){
				subPrice += reserveConfirmList.get(i).getMenuPrice();
				if(i<=reserveConfirmList.size()-1){
					result =  SUCCESS;
				}
			}
		}else if(reserveConfirmList.size()==1){
			subPrice += reserveConfirmList.get(0).getMenuPrice();
			result = SUCCESS;
		}else{
			result = SUCCESS;
		}
		return result;
	}
	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}
	public String getReserveDate() {
		return reserveDate;
	}
	public void setReserveDate(String reserveDate) {
		this.reserveDate = reserveDate;
	}
	public String getReserveHour() {
		return reserveHour;
	}
	public void setReserveHour(String reserveHour) {
		this.reserveHour = reserveHour;
	}
	public String getStaffName() {
		return staffName;
	}
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	public String getPay() {
		return pay;
	}
	public void setPay(String pay) {
		this.pay = pay;
	}

}
