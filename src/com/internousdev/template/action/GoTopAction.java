package com.internousdev.template.action;

import java.util.ArrayList;

import com.internousdev.template.dao.GoTopActionDAO;
import com.internousdev.template.dto.SalonDataDTO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * index.jspに遷移するアクション
 * @author Kazuyuki Tasaki
 * @version 1.0
 */
public class GoTopAction extends ActionSupport {

	//インスタンス化
	private GoTopActionDAO dao = new GoTopActionDAO();
	private ArrayList<SalonDataDTO> salonInfoList = new  ArrayList<SalonDataDTO>();
	/**
	 * インフォメーション情報を取得して遷移するメソッド
	 * @return SUCCESS
	 */
	public String execute(){
		salonInfoList = dao.infoSelect();
		return  SUCCESS;
	}
	// getter
	/**
	 *
	 * @return salonInfoList
	 */
	public ArrayList<SalonDataDTO> getSalonInfoList(){
		return salonInfoList;
	}
}
