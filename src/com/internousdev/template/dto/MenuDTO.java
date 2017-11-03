package com.internousdev.template.dto;
/**
 * メニュー関連情報のDTO
 * @author Kazuyuki Tasaki
 * @version 1.0
 */
public class MenuDTO {

	/**
	 * メニューID
	 * @param menuId
	 */
	private int menuId;

	/**
	 * メニュー名
	 * @param menuName
	 */
	private String menuName;

	/**
	 * 施術料金
	 * @param menuPrice
	 */
	private int menuPrice;

	/**
	 * 施術時間
	 * @param menuTime
	 */
	private int menuTime;

	/**
	 *予約ID
	 */
	private int reserveId;

	//以下、setter getter
	/**
	 *
	 * @return menuId
	 */
	public int getMenuId() {
		return menuId;
	}

	/**
	 *
	 * @param menuId
	 */
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	/**
	 *
	 * @return menuName
	 */
	public String getMenuName(){
		return menuName;
	}

	/**
	 *
	 * @param menuName
	 */
	public void setMenuName(String menuName){
		this.menuName = menuName;
	}

	/**
	 *
	 * @return menuPrice
	 */
	public int getMenuPrice(){
		return menuPrice;
	}

	/**
	 *
	 * @param menuPrice
	 */
	public void setMenuPrice(int menuPrice){
		this.menuPrice = menuPrice;
	}

	/**
	 *
	 * @return mwnuTime
	 */
	public int getMenuTime(){
		return menuTime;
	}

	/**
	 *
	 * @param menuTime
	 */
	public void setMenuTime(int menuTime){
		this.menuTime = menuTime;
	}

	/**
	 *
	 * @return reserveId
	 */
	public int getReserveId() {
		return reserveId;
	}

	/**
	 *
	 * @param reserveId
	 */
	public void setReserveId(int reserveId) {
		this.reserveId = reserveId;
	}
}