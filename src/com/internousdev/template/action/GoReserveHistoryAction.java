package com.internousdev.template.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template.dao.MyPageDAO;
import com.internousdev.template.dto.ReserveDTO;
import com.opensymphony.xwork2.ActionSupport;

public class GoReserveHistoryAction extends ActionSupport implements SessionAware{
	private String message;
	private Map<String, Object> session;
	private MyPageDAO dao =new MyPageDAO();
	private ArrayList<ReserveDTO> reserveHistoryList = new ArrayList<ReserveDTO>();

	public String execute() {
		String result = SUCCESS;
		if(session.get("Id")!=null) {
			reserveHistoryList = dao.reserveHistorySelect((int)session.get("Id"));
			if(reserveHistoryList.size()==0) {
				message = "予約履歴はありません。";
				return result;
			}
		}else {
			result = ERROR;
		}
		return result;
	}
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ArrayList<ReserveDTO> getReserveHistoryList() {
		return reserveHistoryList;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
