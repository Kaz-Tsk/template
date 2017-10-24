package com.internousdev.template.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template.dao.GoStaffDAO;
import com.internousdev.template.dao.MenuDAO;
import com.internousdev.template.dto.MenuDTO;
import com.internousdev.template.dto.StaffDTO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 予約メニューを選ぶアクション
 *
 * @author Kazuyuki Tasaki
 *@return result
 */
public class GoReserveAction extends ActionSupport implements SessionAware{


	private Map<String,Object> session;

	private ArrayList<MenuDTO> menuList = new ArrayList<MenuDTO>();

	private ArrayList<StaffDTO> staffList = new ArrayList<StaffDTO>();

	MenuDTO menuDTO = new MenuDTO();

	MenuDAO menuDAO = new MenuDAO();

	GoStaffDAO staffDAO = new GoStaffDAO();

	StaffDTO staffDTO = new StaffDTO();

	public String execute(){
		String result = ERROR;
		if(session.containsKey("Id")){
			menuList = menuDAO.selectMenu();
			staffList = staffDAO.staffSelect();
			if(menuList.size()!=0 || staffList.size()!=0){
				result = SUCCESS;
			}
		}
		return result;
	}


	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;

	}

	public ArrayList<MenuDTO> getMenuList(){
		return menuList;
	}

	public ArrayList<StaffDTO> getStaffList(){
		return staffList;
	}
}
