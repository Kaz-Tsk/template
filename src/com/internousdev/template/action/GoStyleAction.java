package com.internousdev.template.action;

import java.util.ArrayList;

import com.internousdev.template.dao.GoStyleDAO;
import com.internousdev.template.dto.StyleDTO;
import com.opensymphony.xwork2.ActionSupport;



public class GoStyleAction extends ActionSupport {

	private String styleSex;

	GoStyleDAO dao = new GoStyleDAO();
	StyleDTO dto = new StyleDTO();
	ArrayList<StyleDTO> ladiesStyleList = new  ArrayList<StyleDTO>();

	ArrayList<StyleDTO> mensStyleList = new  ArrayList<StyleDTO>();


	public String execute(){
		styleSex = "ladies";
		ladiesStyleList = dao.styleSelect(styleSex);

		styleSex = "mens";
		mensStyleList = dao.styleSelect(styleSex);
		return  SUCCESS;
	}

	public ArrayList<StyleDTO> getLadiesStyleList(){
		return ladiesStyleList;
	}


	public ArrayList<StyleDTO> getMenStyleList(){
		return mensStyleList;
	}
}
