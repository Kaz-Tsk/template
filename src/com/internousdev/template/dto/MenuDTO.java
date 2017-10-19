package com.internousdev.template.dto;

public class MenuDTO {

	private int menuId;

	private String menuName;

	private int menuPrice;

	private int menuTime;

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public String getMenuName(){
		return menuName;
	}

	public void setMenuName(String menuName){
		this.menuName = menuName;
	}

	public int getMenuPrice(){
		return menuPrice;
	}

	public void setMenuPrice(int menuPrice){
		this.menuPrice = menuPrice;
	}

	public int getMenuTime(){
		return menuTime;
	}

	public void setMenuTime(int menuTime){
		this.menuTime = menuTime;
	}
}