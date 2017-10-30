package com.internousdev.template.action;

import java.util.ArrayList;

import com.internousdev.template.dao.MenuDAO;
import com.internousdev.template.dto.MenuDTO;
import com.opensymphony.xwork2.ActionSupport;

public class GoAdminMenuAction extends ActionSupport{


	private ArrayList<MenuDTO> menuList = new ArrayList<MenuDTO>();


	MenuDAO dao = new MenuDAO();
	public String execute() {
		menuList = dao.selectMenu();
		return SUCCESS;
	}


	public ArrayList<MenuDTO> getMenuList() {
		return menuList;
	}
}
