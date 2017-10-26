package com.internousdev.template.dto;

public class SalonDataDTO {

	private int salonId;

	private String salonWeek;

	private String salonHour;

	private String salonAddress;

	private String salonTel;

	private int vol;

	private String day;

	private String text;


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

	public int getVol() {
		return vol;
	}

	public void setVol(int vol) {
		this.vol = vol;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
