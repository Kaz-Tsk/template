package com.internousdev.template.action;

import java.util.ArrayList;

import com.internousdev.template.dao.GoInformationDAO;
import com.internousdev.template.dto.SalonDataDTO;
import com.opensymphony.xwork2.ActionSupport;
/**
 *店舗情報へ遷移するためのアクション
 * @author Kazuyuki Tasaki
 * @version 1.0
 */
public class GoInformationAction extends ActionSupport {

	//インスタンス化
	private GoInformationDAO dao = new GoInformationDAO();
	private ArrayList<SalonDataDTO> salonDataList = new  ArrayList<SalonDataDTO>();
	/**
	 * 店舗情報を取得してページ遷移するメソッド
	 * @return SUCCESS
	 */
	public String execute(){
		salonDataList = dao.styleSelect();
		return  SUCCESS;
	}

	//getter
	/**
	 *
	 * @return salonDataList
	 */
	public ArrayList<SalonDataDTO> getSalonDataList(){
		return salonDataList;
	}

}
