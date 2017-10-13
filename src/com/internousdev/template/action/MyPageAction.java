package com.internousdev.template.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template.dao.MyPageDAO;
import com.internousdev.template.dto.MyPageDTO;
import com.opensymphony.xwork2.ActionSupport;

public class MyPageAction extends ActionSupport implements SessionAware{

	/**
	 * ログイン情報を格納
	 */
	public Map<String, Object> loginInfoMap = new HashMap<>();


	/**
	 * マイページ情報取得DAO
	 */
	public MyPageDAO myPageDAO = new MyPageDAO();

	/**
	 * マイページ情報格納DTO
	 */
	public ArrayList<MyPageDTO> myPageList = new ArrayList<MyPageDTO>();


	/**
	 * 商品履歴取得メソッド
	 *
	 * @author internous
	 */
	public String execute() throws SQLException {

		if (loginInfoMap.get("id")!=null) {
			myPageList = myPageDAO.userData((int)loginInfoMap.get("id"));
			return SUCCESS;
		}
		return ERROR;
	}

	@Override
	public void setSession(Map<String, Object> loginSessionMap) {
		this.loginInfoMap = loginSessionMap;
	}
}
