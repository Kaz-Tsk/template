package com.internousdev.template.dto;

public class SalonDataDTO {

	private int salonId;

	private String salonWeek;

	private String salonHour;

	private String salonAddress;

	private String salonTel;

	private int infoVol;

	private String infoDay;

	private String infoText;


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

	public int getInfoVol() {
		return infoVol;
	}

	public void setInfoVol(int infoVol) {
		this.infoVol = infoVol;
	}

	public String getInfoDay() {
		return infoDay;
	}

	public void setInfoDay(String infoDay) {
		this.infoDay = infoDay;
	}

	public String getInfoText() {
		return infoText;
	}

	public void setInfoText(String infoText) {
		this.infoText = infoText;
	}

}
