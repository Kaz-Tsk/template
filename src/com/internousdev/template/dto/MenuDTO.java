package com.internousdev.template.dto;

import java.math.BigDecimal;

public class MenuDTO {

	private String menuName;

	private BigDecimal menuPrice;

	private int menuTime;

	public String getMenuName(){
		return menuName;
	}

	public void setMenuName(String menuName){
		this.menuName = menuName;
	}

	public BigDecimal getMenuPrice(){
		return menuPrice;
	}

	public void setMenuPrice(BigDecimal menuPrice){
		this.menuPrice = menuPrice;
	}

	public int getMenuTime(){
		return menuTime;
	}

	public void setMenuTime(int menuTime){
		this.menuTime = menuTime;
	}
}
