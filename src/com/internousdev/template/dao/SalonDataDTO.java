package com.internousdev.template.dao;

import java.sql.Date;

public class SalonDataDTO {

	private String salonInfo;

	private Date insertDate;

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
