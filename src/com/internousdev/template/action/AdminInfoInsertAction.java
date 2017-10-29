package com.internousdev.template.action;

import java.util.ArrayList;

import com.internousdev.template.dao.AdminInfoDAO;
import com.internousdev.template.dto.SalonDataDTO;
import com.opensymphony.xwork2.ActionSupport;

public class AdminInfoInsertAction extends ActionSupport{

	private int vol;

	private String day;

	private String text;

	private String insertMsg;

	AdminInfoDAO dao = new AdminInfoDAO();
	ArrayList<SalonDataDTO> adminInfoList = new ArrayList<SalonDataDTO>();
	public String execute() {
		String result = ERROR;
		adminInfoList = dao.adminInfoSelect();
		System.out.println("test"+vol);
		if (adminInfoList.size()==0) {
			dao.insertInfo(vol, day, text);
			insertMsg ="登録が完了しました。";

			System.out.println("test2"+vol);

			result = SUCCESS;
		}else if (adminInfoList.size()>0) {
			for (int i = 0; i < adminInfoList.size(); i++) {
				if (adminInfoList.get(i).getVol()==vol) {
					System.out.println("test3"+vol);
					insertMsg = "volが重複しています。もう一度登録してください。";
					return result;
				}
			}
			System.out.println("test4"+vol);
			dao.insertInfo(vol, day, text);
			insertMsg = "登録が完了しました";
			result =SUCCESS;
		}
		return result;
	}

	public int getVol() {
		return vol;
	}

	public void setVol(int vol) {
		this.vol = vol;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getInsertMsg() {
		return insertMsg;
	}

}
