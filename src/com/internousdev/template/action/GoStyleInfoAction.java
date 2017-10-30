package com.internousdev.template.action;

import java.util.ArrayList;

import com.internousdev.template.dao.GoStyleInfoDAO;
import com.internousdev.template.dto.StyleDTO;
import com.opensymphony.xwork2.ActionSupport;

public class GoStyleInfoAction extends ActionSupport {

	private int styleVol;


	GoStyleInfoDAO dao = new GoStyleInfoDAO();
	StyleDTO dto = new StyleDTO();
	ArrayList<StyleDTO> styleList = new  ArrayList<StyleDTO>();
	public String execute(){
		styleList = dao.styleSelect(styleVol);
		return  SUCCESS;
	}

	public ArrayList<StyleDTO> getStyleList(){
		return styleList;
	}

	public int getStyleVol(){
		return styleVol;
	}

	public void setStyleVol(int styleVol){
		this.styleVol = styleVol;
	}
}
