package com.internousdev.template.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template.dao.ReserveComplateDAO;
import com.internousdev.template.dao.ReserveConfirmDAO;
import com.opensymphony.xwork2.ActionSupport;
/**
 * 予約完了画面へ遷移するアクション
 * @author Kazuyuki Tasaki
 * @version 1.0
 */
public class GoReserveComplateAction extends ActionSupport implements SessionAware{
	/**
	 * 実行時のメッセージ
	 * @param errorMsg
	 */
	private String errorMsg;
	/**
	 * セッション情報
	 * @param session
	 */
	private Map<String,Object> session;
	//インスタンス化
	private ReserveConfirmDAO checkDao = new ReserveConfirmDAO();
	private ReserveComplateDAO compDao = new ReserveComplateDAO();
	/**
	 * 予約状況をチェックして大丈夫であれば予約完了にするメソッド
	 * @return result 予約状況をチェックして空きがあればSUCCESS なければERROR
	 */
	public String execute (){
		String result = ERROR;
		//予約状況をチェック
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
	//以下、setter getter
	/**
	 *
	 * @return errorMsg
	 */
	public String getErrorMsg() {
		return errorMsg;
	}
	/**
	 * @param session
	 */
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
