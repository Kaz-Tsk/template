package com.internousdev.template.dto;

import java.util.Date;
/**
 * 予約情報のDTO
 * @author Kazuyuki Tasaki
 * @version 1.0
 */
public class ReserveDTO {

	/**
	 *予約ID
	 *@param reserveId
	 */
	private int reserveId;

	/**
	 * 予約メニュー
	 * @param reserveMenu
	 */
	private String reserveMenu;

	/**
	 * 施術料金
	 * @param reservePrice
	 */
	private int reservePrice;

	/**
	 * 施術時間
	 * @param reserveTime
	 */
	private int reserveTime;

	/**
	 * 担当スタイリスト
	 * @param reserveStaff
	 */
	private String reserveStaff;

	/**
	 * 支払い方法
	 * @param pay
	 */
	private String reservePay;

	/**
	 * 顧客名
	 * @param reserveUserName
	 */
	private String reserveUserName;

	/**
	 * 来店日時
	 * @param reserveStartDate
	 */
	private String  reserveStartDate;

	/**
	 * 退店日時
	 * @param reserveEndDate
	 */
	private Date reserveEndDate;

	/**
	 * 予約受付日
	 */
	private Date reserveInsertDate;

	//以下、setter getter
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

	/**
	 *
	 * @return reserveMenu
	 */
	public String getReserveMenu() {
		return reserveMenu;
	}

	/**
	 *
	 * @param reserveMenu
	 */
	public void setReserveMenu(String reserveMenu) {
		this.reserveMenu = reserveMenu;
	}

	/**
	 *
	 * @return reservePrice
	 */
	public int getReservePrice() {
		return reservePrice;
	}

	/**
	 *
	 * @param reservePrice
	 */
	public void setReservePrice(int reservePrice) {
		this.reservePrice = reservePrice;
	}

	/**
	 *
	 * @return reserveTime
	 */
	public int getReserveTime() {
		return reserveTime;
	}

	/**
	 *
	 * @param reserveTime
	 */
	public void setReserveTime(int reserveTime) {
		this.reserveTime = reserveTime;
	}

	/**
	 *
	 * @return reserveStaff
	 */
	public String getReserveStaff() {
		return reserveStaff;
	}

	/**
	 *
	 * @param reserveStaff
	 */
	public void setReserveStaff(String reserveStaff) {
		this.reserveStaff = reserveStaff;
	}

	/**
	 *
	 * @return reservePay
	 */
	public String getReservePay() {
		return reservePay;
	}

	/**
	 *
	 * @param reservePay
	 */
	public void setReservePay(String reservePay) {
		this.reservePay = reservePay;
	}

	/**
	 *
	 * @return reserveUserName
	 */
	public String getReserveUserName() {
		return reserveUserName;
	}

	/**
	 *
	 * @param reserveUserName
	 */
	public void setReserveUserName(String reserveUserName) {
		this.reserveUserName = reserveUserName;
	}

	/**
	 *
	 * @return reserveStartDate
	 */
	public String getReserveStartDate() {
		return reserveStartDate;
	}

	/**
	 *
	 * @param reserveStartDate
	 */
	public void setReserveStartDate(String  reserveStartDate) {
		this.reserveStartDate = reserveStartDate;
	}

	/**
	 *
	 * @return reserveEndDate
	 */
	public Date getReserveEndDate() {
		return reserveEndDate;
	}

	/**
	 *
	 * @param reserveEndDate
	 */
	public void setReserveEndDate(Date reserveEndDate) {
		this.reserveEndDate = reserveEndDate;
	}

	/**
	 *
	 * @return reserveInsertDate
	 */
	public Date getReserveInsertDate() {
		return reserveInsertDate;
	}

	/**
	 *
	 * @param reserveInsertDate
	 */
	public void setReserveInsertDate(Date reserveInsertDate) {
		this.reserveInsertDate = reserveInsertDate;
	}
}
