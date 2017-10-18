package com.internousdev.template.action;

import java.util.ArrayList;

import com.internousdev.template.dto.StyleDTO;
import com.opensymphony.xwork2.ActionSupport;

public class GoStyleInfoAction extends ActionSupport {


		GoStyleInfoDAO dao = new GoStyleInfoDAO();
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
