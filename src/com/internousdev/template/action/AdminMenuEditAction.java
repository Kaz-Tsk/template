package com.internousdev.template.action;

import java.util.ArrayList;

import com.internousdev.template.dao.AdminMenuDAO;
import com.internousdev.template.dao.MenuDAO;
import com.internousdev.template.dto.MenuDTO;
import com.opensymphony.xwork2.ActionSupport;

public class AdminMenuEditAction extends ActionSupport{

	private int menuId;

	private String menuName;

	private int menuPrice;

	private int menuTime;

	private String editMsg;

	MenuDAO dao = new MenuDAO();
	AdminMenuDAO menuDao = new AdminMenuDAO();
	ArrayList<MenuDTO> menuList = new ArrayList<MenuDTO>();
	public String execute() {
		String result = ERROR;
		menuList = dao.selectMenu();
		if(menuList.size()==0) {
			editMsg = "該当するメニューがありません。";
			return ERROR;
		}else {
			for(int i = 0; i < menuList.size(); i++) {
				if(menuList.get(i).getMenuId() == menuId) {
					menuDao.editMenu(menuName, menuPrice, menuTime, menuId);
					editMsg = "メニューを編集しました。";
					return SUCCESS;
				}
			}
		}
		editMsg = "該当するメニューがありません。";
		return result;
	}
	public int getMenuId() {
		return menuId;
	}
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public int getMenuPrice() {
		return menuPrice;
	}
	public void setMenuPrice(int menuPrice) {
		this.menuPrice = menuPrice;
	}
	public int getMenuTime() {
		return menuTime;
	}
	public void setMenuTime(int menuTime) {
		this.menuTime = menuTime;
	}
	public String getEditMsg() {
		return editMsg;
	}
	public void setEditMsg(String editMsg) {
		this.editMsg = editMsg;
	}
}
