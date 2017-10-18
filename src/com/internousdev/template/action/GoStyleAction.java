package com.internousdev.template.action;

import java.util.ArrayList;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template.dao.GoStyleDAO;
import com.internousdev.template.dto.StyleDTO;
import com.opensymphony.xwork2.ActionSupport;



public class GoStyleAction extends ActionSupport implements SessionAware {

	GoStyleDAO dao = new GoStyleDAO();
	StyleDTO dto = new StyleDTO();
	ArrayList<StyleDTO> styleList = new  ArrayList<StyleDTO>();
	session Map<String,Object> session = new session Map<String,Object>();
	public String execute(){
		styleList = dao.styleSelect();
		sess

		return  SUCCESS;
	}

	public ArrayList<StyleDTO> getStyleList(){
		return styleList;
	}


}
