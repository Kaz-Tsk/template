package com.internousdev.template.action;

import java.util.ArrayList;

import com.internousdev.template.dao.AdminReserveDAO;
import com.internousdev.template.dto.ReserveDTO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 予約情報を検索するアクション
 * @author Kazuyuki Tasaki
 * @version 1.0
 */
public class AdminReserveSearchAction extends ActionSupport{

	/**
	 * ユーザー名
	 * @param searchName
	 */

	private String searchName = "";

	/**
	 * 照会年日
	 * @param searchDate
	 */
	private String searchDate ="";

	/**
	 * エラーメッセージ
	 * @param msg
	 */
	private String msg;

	//インスタンス化
	/**
	 * 予約情報を検索するDAO
	 * @param dao
	 */
	private AdminReserveDAO dao =new AdminReserveDAO();

	/**
	 * 検索情報リスト
	 * @param searchList
	 */
	private ArrayList<ReserveDTO> reserveList = new ArrayList<ReserveDTO>();

	/**
	 * 予約情報を検索する実行メソッド
	 * @return result 検索結果があればSUCCESS それ以外はERROR
	 */
	public String execute() {
		String result = ERROR;
		//検索に名前と照会年月がある場合
		if(!(searchName.equals("")) && !(searchDate.equals(""))) {
			//MySqlのlike演算子対策
			searchName = "%" + searchName + "%";
			searchDate =searchDate + "%";
			reserveList = dao.searchSelect(searchName, searchDate);
			if(reserveList.size()!=0) {
				result = SUCCESS;
			}else {
				msg = "検索結果がありません";
			}
			//検索に名前だけの場合
		}else if(!(searchName.equals("")) && searchDate.equals("")) {
			//MySqlのlike演算子対策
			searchName = "%"+ searchName+"%";
			reserveList = dao.searchNameSelect(searchName);
			if(reserveList.size()!=0) {
				result = SUCCESS;
			}else {
				msg = "検索結果がありません";
			}
			//検索に照会年月だけの場合
		}else if (searchName.equals("") && !(searchDate.equals(""))) {
			//MySqlのlike演算子対策
			searchDate = searchDate + "%";
			reserveList = dao.searchDateSelect(searchDate);
			if(reserveList.size()!=0) {
				result = SUCCESS;
			}else {
				msg = "検索結果がありません";
			}
			//検索条件がない場合：全検索
		} else {
			reserveList = dao.reserveSelect();
			return result;
		}
		return result;
	}

	//getter
	/**
	 * @return reserveList
	 */
	public ArrayList<ReserveDTO> getReserveList() {
		return reserveList;
	}

	/**
	 * @return msg
	 */
	public String getMsg() {
		return msg;
	}

	public String getSearchName() {
		return searchName;
	}

	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}

	public String getSearchDate() {
		return searchDate;
	}

	public void setSearchDate(String searchDate) {
		this.searchDate = searchDate;
	}

}
