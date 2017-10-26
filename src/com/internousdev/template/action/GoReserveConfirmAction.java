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


	private String[] menuId=null;

	private String reserveDate=null;

	private String rD;

	private String reserveTime;

	private int menuTime = 0;

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
		System.out.println(reserveTime);
		if(!(reserveDate.equals("")) && menuId!=null){
			//menuIdを配列で受け取る
			int[] menuId2 =  Stream.of(menuId).mapToInt(Integer::parseInt).toArray();
			//menu情報をDBから取得
			reserveConfirmList = dao.selectReserveConfirm(menuId2);
			//予約日と時間を文字列で連結
			rD = reserveDate.substring(0,10)+" "+reserveTime;
			//menuNameを連結して空白をはさんでひとつにまとめる
			for(int a = 0; a < reserveConfirmList.size(); a++){
				if( a != 0){
					reserveMenu += " ";
				}
				reserveMenu += reserveConfirmList.get(a).getMenuName();
			}
			//時間を計算してmenuTimeに代入
			for(int b=0; b < reserveConfirmList.size(); b++ ){
				menuTime += reserveConfirmList.get(b).getMenuTime();
			}

			//合計金額を計算してsubpriceに代入
			for(int i=0; i < reserveConfirmList.size(); i++ ){
				subPrice += reserveConfirmList.get(i).getMenuPrice();
			}
			////staffIdが０のとき、staffNameに指名なしと記載する。それ以外はスタイリスト名を入れる
			if(staffId==0){
				staffName = "指名なし";
			}else{
				sdto = dao.staffNameSelect(staffId);
				staffName = sdto.getStaffName();
			}
			//情報をインサート
			if(dao.reserveCheck(rD, menuTime)<=5){
				dao.reserveInsert(reserveMenu,subPrice,menuTime,staffName,pay,(int)session.get("Id"),reserveFlg,rD);
				dto = dao.reserveIdGet((int)session.get("Id"), rD);
				session.put("reserveId", dto.getReserveId());
				System.out.println(session.get("reserveId"));
				session.put("rD",rD);
				session.put("menuTime",menuTime);
				result = SUCCESS;
			}else{
				errorMsg="その予約時間帯は満席です。";
				result = ERROR;
			}
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

	public int getMenuTime() {
		return menuTime;
	}


	public void setMenuTime(int menuTime) {
		this.menuTime = menuTime;
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