package com.internousdev.template.action;

import java.util.ArrayList;

import com.internousdev.template.dao.GoStyleInfoDAO;
import com.internousdev.template.dto.StyleDTO;
import com.opensymphony.xwork2.ActionSupport;

public class GoStyleInfoAction extends ActionSupport {

	private int styleId;


	GoStyleInfoDAO dao = new GoStyleInfoDAO();
	StyleDTO dto = new StyleDTO();
	ArrayList<StyleDTO> styleList = new  ArrayList<StyleDTO>();

	public String execute(){
		styleList = dao.styleSelect(styleId);

		return  SUCCESS;
	}

	public ArrayList<StyleDTO> getStyleList(){
		return styleList;
	}


}
