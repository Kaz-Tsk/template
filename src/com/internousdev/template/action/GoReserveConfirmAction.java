package com.internousdev.template.action;

import java.util.ArrayList;
import java.util.stream.Stream;

import com.internousdev.template.dao.ReserveConfirmDAO;
import com.internousdev.template.dto.MenuDTO;
import com.opensymphony.xwork2.ActionSupport;

public class GoReserveConfirmAction extends ActionSupport {

	private String[] menuId ;

	int[] menuId2 =  Stream.of(menuId).mapToInt(Integer::parseInt).toArray();

	private String reserveDate;

	private String reserveTime;

	private int staffId;

	private String pay;
	@SuppressWarnings("unused")
	private int subPrice = 0;



	ReserveConfirmDAO dao = new ReserveConfirmDAO();
	MenuDTO dto = new MenuDTO();
	ArrayList<MenuDTO> reserveConfirmList = new ArrayList<MenuDTO>();
	public String execute(){
		System.out.println("test"+menuId2);
		String result = ERROR;
		reserveConfirmList = dao.selectReserveConfirm(menuId2);
		if(reserveConfirmList.size()>1){
			for(int i=0; i < reserveConfirmList.size(); i++ ){
				subPrice += reserveConfirmList.get(i).getMenuPrice();
				if(i<=reserveConfirmList.size()){
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



	public String[] getMenuId() {
		return menuId;
	}



	public void setMenuId(String menuId[]) {
		this.menuId = menuId;
	}



	public String getReserveDate() {
		return reserveDate;
	}
	public void setReserveDate(String reserveDate) {
		this.reserveDate = reserveDate;
	}
	public String getReserveTime() {
		return reserveTime;
	}
	public void setReserveTime(String reserveTime) {
		this.reserveTime = reserveTime;
	}
	public int getStaffId() {
		return staffId;
	}
	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}
	public String getPay() {
		return pay;
	}
	public void setPay(String pay) {
		this.pay = pay;
	}
	public int getSubPrice() {
		return subPrice;
	}
	public void setSubPrice(int subPrice) {
		this.subPrice = subPrice;
	}



}