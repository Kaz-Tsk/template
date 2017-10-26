package com.internousdev.template.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template.dao.ReserveComplateDAO;
import com.internousdev.template.dao.ReserveConfirmDAO;
import com.opensymphony.xwork2.ActionSupport;

public class GoReserveComplateAction extends ActionSupport implements SessionAware{


	private String errorMsg;
	private Map<String,Object> session;

	ReserveConfirmDAO checkDao = new ReserveConfirmDAO();
	ReserveComplateDAO compDao = new ReserveComplateDAO();
	public String execute (){
		String result = ERROR;
		if(checkDao.reserveCheck((String)session.get("rD"), (int)session.get("menuTime"))<=5){
			compDao.reserveComp((int)session.get("reserveId"));
			result = SUCCESS;
		}else{
			errorMsg = "その時間帯の予約は満席になりました。";
			compDao.reserveReset((int)session.get("reserveId"));
			return  ERROR;
		}
		return result;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
