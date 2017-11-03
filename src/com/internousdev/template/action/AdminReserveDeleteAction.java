package com.internousdev.template.action;

import java.util.ArrayList;

import com.internousdev.template.dao.AdminReserveDAO;
import com.internousdev.template.dto.ReserveDTO;
import com.opensymphony.xwork2.ActionSupport;
/**
 * 管理側から予約を削除するアクション
 * @author Kazuyuki Tasaki
 * @version 1.0
 */
public class AdminReserveDeleteAction extends ActionSupport{

	/**
	 *予約ID
	 *@param reserveId
	 */
	private int reserveId;

	/**
	 *実行後メッセージ
	 *@param deleteMsg
	 */
	private String deleteMsg;

	//インスタンス化
	/**
	 * 予約処理のDAO
	 * @param dao
	 */
	private AdminReserveDAO dao = new AdminReserveDAO();

	/**
	 * 予約情報リスト
	 * @param reserveList
	 */
	private ArrayList<ReserveDTO> reserveList = new ArrayList<ReserveDTO>();

	/**
	 * 予約情報を削除するメソッド
	 * @return result 該当する予約があればSUCCESS なければERROR
	 */
	public String execute() {
		String result = ERROR;
		//DBから予約情報を取得
		reserveList = dao.reserveSelect();
		if(reserveList.size()==0) {
			deleteMsg = "削除する予約がありません。";
			return ERROR;
		}else {
			//該当する予約があるかをチェック
			for(int i = 0; i < reserveList.size(); i++) {
				if(reserveList.get(i).getReserveId()==reserveId) {
					dao.deleteReserve(reserveId);
					deleteMsg = "削除しました。";
					return SUCCESS;
				}
			}
		}
		deleteMsg = "削除する予約がありません";
		return result;
	}

	//以下setter getter
	/**
	 *
	 * @return reserveId
	 */
	public int getReserveId() {
		return reserveId;
	}

	/**
	 *
	 * @param reserveId
	 */
	public void setReserveId(int reserveId) {
		this.reserveId = reserveId;
	}

	/**
	 *
	 * @return deleteMsg
	 */
	public String getDeleteMsg() {
		return deleteMsg;
	}
}
