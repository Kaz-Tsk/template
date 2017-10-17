package com.internousdev.template.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template.dao.MenuDAO;
import com.internousdev.template.dto.MenuDTO;
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

	MenuDTO menuDTO = new MenuDTO();

	MenuDAO menuDAO = new MenuDAO();


	public String execute(){
		String result = ERROR;
		if(session.containsKey("Id")){
			menuList = menuDAO.selectMenu();
			if(menuList.size()!=0){
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
}
