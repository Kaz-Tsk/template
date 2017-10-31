package com.internousdev.template.dto;

import java.util.Date;

public class ReserveDTO {

	private int reserveId;

	private String reserveMenu;

	private int reservePrice;

	private int reserveTime;

	private String reserveStaff;

	private String reservePay;

	private String reserveUserName;

	private String  reserveStartDate;

	private Date reserveEndDate;

	private Date reserveInsertDate;

	public int getReserveId() {
		return reserveId;
	}

	public void setReserveId(int reserveId) {
		this.reserveId = reserveId;
	}

	public String getReserveMenu() {
		return reserveMenu;
	}

	public void setReserveMenu(String reserveMenu) {
		this.reserveMenu = reserveMenu;
	}

	public int getReservePrice() {
		return reservePrice;
	}

	public void setReservePrice(int reservePrice) {
		this.reservePrice = reservePrice;
	}

	public int getReserveTime() {
		return reserveTime;
	}

	public void setReserveTime(int reserveTime) {
		this.reserveTime = reserveTime;
	}

	public String getReserveStaff() {
		return reserveStaff;
	}

	public void setReserveStaff(String reserveStaff) {
		this.reserveStaff = reserveStaff;
	}

	public String getReservePay() {
		return reservePay;
	}

	public void setReservePay(String reservePay) {
		this.reservePay = reservePay;
	}

	public String getReserveUserName() {
		return reserveUserName;
	}

	public void setReserveUserName(String reserveUserName) {
		this.reserveUserName = reserveUserName;
	}

	public String getReserveStartDate() {
		return reserveStartDate;
	}

	public void setReserveStartDate(String  reserveStartDate) {
		this.reserveStartDate = reserveStartDate;
	}

	public Date getReserveEndDate() {
		return reserveEndDate;
	}

	public void setReserveEndDate(Date reserveEndDate) {
		this.reserveEndDate = reserveEndDate;
	}

	public Date getReserveInsertDate() {
		return reserveInsertDate;
	}

	public void setReserveInsertDate(Date reserveInsertDate) {
		this.reserveInsertDate = reserveInsertDate;
	}
}
