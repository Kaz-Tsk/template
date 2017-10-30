package com.internousdev.template.action;

import java.util.ArrayList;

import com.internousdev.template.dao.AdminMenuDAO;
import com.internousdev.template.dao.MenuDAO;
import com.internousdev.template.dto.MenuDTO;
import com.opensymphony.xwork2.ActionSupport;

public class AdminMenuDeleteAction extends ActionSupport{


	private int menuId;

	private String deleteMsg;

	MenuDAO dao = new MenuDAO();
	AdminMenuDAO menuDao = new AdminMenuDAO();
	ArrayList<MenuDTO> menuList = new ArrayList<MenuDTO>();

	public String execute() {
		String result = ERROR;
		menuList = dao.selectMenu();
		if(menuList.size()==0) {
			deleteMsg ="該当するメニューがありません。";
			return ERROR;
		}else {
			for(int i = 0; i < menuList.size(); i++) {
				if(menuList.get(i).getMenuId() == menuId) {
					menuDao.deleteMenu(menuId);
					deleteMsg = "メニューを削除しました。";
					return SUCCESS;
				}
			}
		}
		deleteMsg = "該当するメニューがありません。";
		return result;
	}

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public String getDeleteMsg() {
		return deleteMsg;
	}

	public void setDeleteMsg(String deleteMsg) {
		this.deleteMsg = deleteMsg;
	}

}
