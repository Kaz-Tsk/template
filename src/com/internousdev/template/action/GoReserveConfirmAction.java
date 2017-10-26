package com.internousdev.template.action;

import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Stream;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template.dao.ReserveConfirmDAO;
import com.internousdev.template.dto.MenuDTO;
import com.internousdev.template.dto.StaffDTO;
import com.opensymphony.xwork2.ActionSupport;

public class GoReserveConfirmAction extends ActionSupport implements SessionAware{



	private String reserveDate=null;

	private String rD;

	private String reserveTime;

	private int staffId;

	private String pay;

	private int subPrice = 0;

	private String staffName;

	private String errorMsg;

	private int reserveFlg=0;

	private String reserveMenu = "";

	private Map<String,Object> session;

	ReserveConfirmDAO dao = new ReserveConfirmDAO();
	StaffDTO sdto = new StaffDTO();
	MenuDTO dto = new MenuDTO();
	ArrayList<MenuDTO> reserveConfirmList = new ArrayList<MenuDTO>();
	public String execute(){
		String result = ERROR;

		if(reserveDate!=null && menuId!=null){
			int[] menuId2 =  Stream.of(menuId).mapToInt(Integer::parseInt).toArray();
			reserveConfirmList = dao.selectReserveConfirm(menuId2);
			rD = reserveDate.substring(0,10)+" "+reserveTime;

			for(int a = 0; a < reserveConfirmList.size(); a++){
				if( a != 0){
					reserveMenu += " ";


				}
				reserveMenu += reserveConfirmList.get(a).getMenuName();




																																		/*try {

																																		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm");
																																		Date drDate = sdFormat.parse(rD);
																																		System.out.println("Date型 = " + drDate);


																																	} catch (ParseException e) {
																																		e.printStackTrace();
																																	}*/
			}
			if(staffId==0){
				staffName = "指名なし";
			}else{
				sdto = dao.staffNameSelect(staffId);
				staffName = sdto.getStaffName();
			}
			for(int i=0; i < reserveConfirmList.size(); i++ ){
				subPrice += reserveConfirmList.get(i).getMenuPrice();
			}


			dao.reserveInsert(reserveMenu,subPrice,staffName,(int)session.get("Id"),reserveFlg,rD);
			result = SUCCESS;
		}else if(reserveDate.equals("")){
			errorMsg="※予約日が選択されてません。";
			return  ERROR;
		}else if(menuId==null){
			errorMsg="※メニューが選択されていません。";
			return ERROR;
		}else{
			errorMsg="※予約日とメニューが選択されていません。";
			result = ERROR;
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
		this. reserveDate =  reserveDate;
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

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}


	public String getErrorMsg() {
		return errorMsg;
	}


	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}


	public Map<String, Object> getSession() {
		return session;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}



}