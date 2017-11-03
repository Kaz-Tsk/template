package com.internousdev.template.dto;
/**
 * 店舗情報のDTO
 * @author kazuyuki Tasaki
 * @version 1.0
 */
public class SalonDataDTO {

	/**
	 * 店舗情報ID
	 * @param salonId
	 */
	private int salonId;

	/**
	 * 営業日
	 * @param salonWeek
	 */
	private String salonWeek;

	/**
	 * 営業時間
	 * @param salonHour
	 */
	private String salonHour;

	/**
	 * 店舗住所
	 * @param salonAddress
	 */
	private String salonAddress;

	/**
	 * 店舗電話番号
	 * @param salonTel
	 */
	private String salonTel;

	/**
	 * インフォメーションvol
	 * @infoVol
	 */
	private int infoVol;

	/**
	 * 公開日
	 * @param infoDay
	 */
	private String infoDay;

	/**
	 * インフォメーションテキスト
	 * @param infoText
	 */
	private String infoText;

	//以下、setter getter
	/**
	 *
	 * @return salonId
	 */
	public int getSalonId(){
		return salonId;
	}

	/**
	 *
	 * @param salonId
	 */
	public void setSalonId(int salonId){
		this.salonId = salonId;
	}

	/**
	 *
	 * @return salonWeek
	 */
	public String getSalonWeek(){
		return salonWeek;
	}

	/**
	 *
	 * @param salonWeek
	 */
	public void setSalonWeek(String salonWeek){
		this.salonWeek = salonWeek;
	}

	/**
	 *
	 * @return salonHour
	 */
	public String getSalonHour(){
		return salonHour;
	}

	/**
	 *
	 * @param salonHour
	 */
	public void setSalonHour(String salonHour){
		this.salonHour = salonHour;
	}

	/**
	 *
	 * @return salonAddress
	 */
	public String getSalonAddress(){
		return salonAddress;
	}

	/**
	 *
	 * @param salonAddress
	 */
	public void setSalonAddress(String salonAddress){
		this.salonAddress = salonAddress;
	}

	/**
	 *
	 * @return salonTel
	 */
	public String getSalonTel(){
		return salonTel;
	}

	/**
	 *
	 * @param salonTel
	 */
	public void setSalonTel(String salonTel){
		this.salonTel = salonTel;
	}

	/**
	 *
	 * @return infoVol
	 */
	public int getInfoVol() {
		return infoVol;
	}

	/**
	 *
	 * @param infoVol
	 */
	public void setInfoVol(int infoVol) {
		this.infoVol = infoVol;
	}

	/**
	 *
	 * @return infoDay
	 */
	public String getInfoDay() {
		return infoDay;
	}

	/**
	 *
	 * @param infoDay
	 */
	public void setInfoDay(String infoDay) {
		this.infoDay = infoDay;
	}

	/**
	 *
	 * @return infoText
	 */
	public String getInfoText() {
		return infoText;
	}

	/**
	 *
	 * @param infoText
	 */
	public void setInfoText(String infoText) {
		this.infoText = infoText;
	}
}
