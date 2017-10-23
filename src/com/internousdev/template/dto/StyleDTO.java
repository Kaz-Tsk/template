package com.internousdev.template.dto;

public class StyleDTO {

	private int styleId;

	private String styleName;

	private String styleSex;

	private String styleComment;

	private String styleImg;

	private String staffName;

	private String staffImg;

	public int getStyleId(){
		return styleId;
	}

	public void setStyleId(int styleId){
		this.styleId = styleId;
	}


	public String getStyleName(){
		return styleName;
	}


	public void setStyleName(String styleName){
		this.styleName = styleName;
	}

	public String getStyleSex() {
		return styleSex;
	}

	public void setStyleSex(String styleSex) {
		this.styleSex = styleSex;
	}

	public String getStyleComment(){
		return styleComment;
	}

	public void setStyleComment(String styleComment){
		this.styleComment = styleComment;
	}

	public String getStyleImg(){
		return styleImg;
	}

	public void setStyleImg(String styleImg){
		this.styleImg = styleImg;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public String getStaffImg() {
		return staffImg;
	}

	public void setStaffImg(String staffImg) {
		this.staffImg = staffImg;
	}
}

