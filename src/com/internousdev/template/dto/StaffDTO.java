package com.internousdev.template.dto;

public class StaffDTO {

	private int staffId;

	private String staffName;

	private String staffComment;

	private String staffImg;

	public int getStaffId(){
		return staffId;
	}

	public void setStaffId(int staffId){
		this.staffId = staffId;
	}


	public String getStaffName(){
		return staffName;
	}


	public void setStaffName(String staffName){
		this.staffName = staffName;
	}

	public String getStaffComment(){
		return staffComment;
	}

	public void setStaffComment(String staffComment){
		this.staffComment = staffComment;
	}

	public String getStaffImg(){
		return staffImg;
	}

	public void setStaffImg(String staffImg){
		this.staffImg = staffImg;
	}
}
