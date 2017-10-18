package com.internousdev.template.dto;

import java.sql.Date;

public class SalonDataDTO {

	private int salonId;

	private String salonWeek;

	private String salonHour;

	private String salonAddress;

	private String salonTel;

	private String salonInfo;

	private Date insertDate;


	public int getSalonId(){
		return salonId;
	}

	public void setSalonId(int salonId){
		this.salonId = salonId;
	}

	public String getSalonWeek(){
		return salonWeek;
	}

	public void setSalonWeek(String salonWeek){
		this.salonWeek = salonWeek;
	}

	public String getSalonHour(){
		return salonHour;
	}

	public void setSalonHour(String salonHour){
		this.salonHour = salonHour;
	}

	public String getSalonAddress(){
		return salonAddress;
	}

	public void setSalonAddress(String salonAddress){
		this.salonAddress = salonAddress;
	}

	public String getSalonTel(){
		return salonTel;
	}

	public void setSalonTel(String salonTel){
		this.salonTel = salonTel;
	}

	public String getSalonInfo(){
		return salonInfo;
	}

	public void setSalonInfo(String salonInfo){
		this.salonInfo = salonInfo;
	}

	public Date getInsertDate(){
		return insertDate;
	}

	public void setInsertDate(Date insertDate){
		this.insertDate = insertDate;
	}
}
