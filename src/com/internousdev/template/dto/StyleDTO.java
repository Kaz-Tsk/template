package com.internousdev.template.dto;

public class StyleDTO {

	private int styleId;

	private String styleName;

	private String styleComment;

	private String styleImg;

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
}

