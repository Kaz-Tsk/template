package com.internousdev.template.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template.dao.MyPageDAO;
import com.internousdev.template.dto.ReserveDTO;
import com.opensymphony.xwork2.ActionSupport;
/**
 * 予約履歴画面へ遷移するアクション
 * @author Kazuyuki Tasaki
 * @version 1.0
 */
public class GoReserveHistoryAction extends ActionSupport implements SessionAware{

	/**
	 * 実行時のメッセージ
	 */
	private String message;

	/**
	 * セッション情報
	 * @param session
	 */
	private Map<String, Object> session;

	//インスタンス化
	/**
	 * 予約履歴情報を取得するためのDAO
	 * @param dao
	 */
	private MyPageDAO dao =new MyPageDAO();

	/**
	 * 予約履歴リスト
	 * @param reserveHistoryList
	 */
	private ArrayList<ReserveDTO> reserveHistoryList = new ArrayList<ReserveDTO>();

	/**
	 * 予約履歴を引き出して遷移するメソッド
	 * @result ユーザー確認ができていればSUCCESS できていなければERROR
	 */
	public String execute() {
		String result = SUCCESS;
		//ユーザーをチェック
		if(session.get("Id")!=null) {
			reserveHistoryList = dao.reserveHistorySelect((int)session.get("Id"));
			//予約履歴がない場合
			if(reserveHistoryList.size()==0) {
				message = "予約履歴はありません。";
				return result;
			}
		}else {
			result = ERROR;
		}
		return result;
	}

	//以下、setter getter
	/**
	 *
	 * @return message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 *
	 * @return reserveHistoryList
	 */
	public ArrayList<ReserveDTO> getReserveHistoryList() {
		return reserveHistoryList;
	}

	/**
	 *
	 * @param session
	 */
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
