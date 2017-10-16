package com.internousdev.template.action;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template.dto.ReserveDTO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 予約メニューを選ぶアクション
 *
 * @author Kazuyuki Tasaki
 *@return result
 */
public class GoReserveAction extends ActionSupport implements SessionAware{

	private String menu;

	private BigDecimal price;

	private int treatmentTime;

	private Map<String,Object> session = new HashMap<>();

	private ArrayList<reserveDTO> menuList = new ArrayList<ReserveDTO>();

	ReserveDTO reserveDTO = new ReserveDTO();

	ReseveMenuDAO reseaveMenuDAO = ReserveMenuDAO();


	public String execute(){
		String result = ERROR;
		if(session.containsKey("Id")){
			menuList = reserveDAO.selectMenu();
			if(menuList.size()!=0){
				result = SUCCESS;
			}
		}
		return result;
	}

}
