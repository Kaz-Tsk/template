package com.internousdev.template.action;

import java.util.ArrayList;

import com.internousdev.template.dao.GoStyleDAO;
import com.internousdev.template.dto.StyleDTO;
import com.opensymphony.xwork2.ActionSupport;



public class GoStyleAction extends ActionSupport {

	GoStyleDAO dao = new GoStyleDAO();
	StyleDTO dto = new StyleDTO();
	ArrayList<StyleDTO> styleList = new  ArrayList<StyleDTO>();

	public String execute(){
		styleList = dao.styleSelect();

		return  SUCCESS;
	}

	public ArrayList<StyleDTO> getStyleList(){
		return styleList;
	}


}
