package com.internousdev.template.action;

import java.util.ArrayList;

import com.internousdev.template.dao.AdminMenuDAO;
import com.internousdev.template.dao.MenuDAO;
import com.internousdev.template.dto.MenuDTO;
import com.opensymphony.xwork2.ActionSupport;

public class AdminMenuInsertAction extends ActionSupport{


	private int menuId;

	private String menuName;

	private int menuPrice;

	private int menuTime;

	private String insertMsg;

	MenuDAO dao = new MenuDAO();
	AdminMenuDAO menuDao = new AdminMenuDAO();
	ArrayList<MenuDTO> menuList = new ArrayList<MenuDTO>();
	public String execute() {
		String result = ERROR;
		menuList = dao.selectMenu();
		if(menuList.size()==0) {
			menuDao.InsertMenu(menuId, result, menuPrice, menuTime);
			insertMsg = "メニューを登録しました。";
			return SUCCESS;
		}else if(menuList.size() > 0) {
			for(int i = 0; i < menuList.size(); i++) {
				if(menuList.get(i).getMenuId()==menuId) {
					insertMsg = "メニューIdが重複しています。";
					return ERROR;
				}
			}
			menuDao.InsertMenu(menuId, result, menuPrice, menuTime);
			insertMsg = "メニューを登録しました。";
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
	public String getInsertMsg() {
		return insertMsg;
	}
	public void setInsertMsg(String insertMsg) {
		this.insertMsg = insertMsg;
	}
}
