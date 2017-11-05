package com.internousdev.template.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template.dao.GoStaffDAO;
import com.internousdev.template.dao.MenuDAO;
import com.internousdev.template.dao.ReserveComplateDAO;
import com.internousdev.template.dto.MenuDTO;
import com.internousdev.template.dto.StaffDTO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 予約画面へ遷移するアクション
 *
 * @author Kazuyuki Tasaki
 * @version 1.0
 */
public class GoReserveAction extends ActionSupport implements SessionAware{

	/**
	 * セッション情報
	 * @param session
	 */
	private Map<String,Object> session;

	//インスタンス化
	/**
	 * メニュー情報リスト
	 * @param menuList
	 */
	private ArrayList<MenuDTO> menuList = new ArrayList<MenuDTO>();

	/**
	 * スタッフ情報リスト
	 * @param staffList
	 */
	private ArrayList<StaffDTO> staffList = new ArrayList<StaffDTO>();

	/**
	 * メニュー情報を取得するDAO
	 * @param menuDAO
	 */
	private MenuDAO menuDAO = new MenuDAO();

	/**
	 * スタッフ情報を取得するDAO
	 * @param staffDAO
	 */
	private GoStaffDAO staffDAO = new GoStaffDAO();

	/**
	 * 予約処理に関するDAO
	 * @param ReserveComplateDAO
	 */
	private ReserveComplateDAO reserveComplateDAO = new ReserveComplateDAO();

	/**
	 * 予約時に使うメニューやスタッフの情報を取得して遷移するメソッド
	 * @return result SUCCESS
	 */
	public String execute(){
		String result = ERROR;
		//もし仮予約の情報があれば削除する
		if(session.get("reserveId") != null) {
			reserveComplateDAO.reserveReset((int)session.get("reserveId"));
		}
		//セッションを保った状態であれば予約に必要な情報を取得したのち予約画面に遷移
		if(session.containsKey("Id")){
			menuList = menuDAO.selectMenu();
			staffList = staffDAO.staffSelect();
			if(menuList.size()!=0 || staffList.size()!=0){
				result = SUCCESS;
			}
		}
		return result;
	}

	//以下、setter getter
	/**
	 *
	 * @param session
	 */
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	/**
	 *
	 * @return menuList
	 */
	public ArrayList<MenuDTO> getMenuList(){
		return menuList;
	}

	/**
	 *
	 * @return staffList
	 */
	public ArrayList<StaffDTO> getStaffList(){
		return staffList;
	}
}
