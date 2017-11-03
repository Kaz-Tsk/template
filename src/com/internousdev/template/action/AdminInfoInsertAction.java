package com.internousdev.template.action;

import java.util.ArrayList;

import com.internousdev.template.dao.AdminInfoDAO;
import com.internousdev.template.dto.SalonDataDTO;
import com.opensymphony.xwork2.ActionSupport;
/**
 * インフォメーションの登録を行うアクション
 * @author Kazuyuki Tasaki
 *@version 1.0
 */
public class AdminInfoInsertAction extends ActionSupport{

	/**
	 * インフォメーションvol
	 * @param infoVol
	 */
	private int infoVol;

	/**
	 * 公開日
	 * @param infoDay
	 */
	private String infoDay;

	/**
	 * インフォメーションテキスト
	 * @param infoText
	 */
	private String infoText;

	/**
	 * 実行後メッセージ
	 * @param insertMsg
	 */
	private String insertMsg;

	//インスタンス化
	/**
	 * インフォメーション情報取得のDAO
	 * @param dao
	 */
	private AdminInfoDAO dao = new AdminInfoDAO();

	/**
	 * インフォメーション情報リスト
	 *@param adminInfoList
	 */
	private ArrayList<SalonDataDTO> adminInfoList = new ArrayList<SalonDataDTO>();

	/**
	 * インフォメーションの登録を行うメソッド
	 * @retern result DBに内容がない、もしくは該当するvolがなければSUCCESS あればERROR
	 */
	public String execute() {
		String result = ERROR;
		//DBからインフォメーション情報を取得
		adminInfoList = dao.adminInfoSelect();
		if (adminInfoList.size()==0) {
			dao.insertInfo(infoVol, infoDay, infoText);
			insertMsg ="登録が完了しました。";
			result = SUCCESS;
		}else if (adminInfoList.size()>0) {
			//リストのvolと照合して重複していないかチェック
			for (int i = 0; i < adminInfoList.size(); i++) {
				if (adminInfoList.get(i).getInfoVol()==infoVol) {
					insertMsg = "※volが重複しています。もう一度登録してください。";
					return result;
				}
			}
			dao.insertInfo(infoVol, infoDay, infoText);
			insertMsg = "登録が完了しました";
			result =SUCCESS;
		}
		return result;
	}

	//以下、setter getter
	/**
	 *
	 * @return infoVol
	 */
	public int getInfoVol() {
		return infoVol;
	}

	/**
	 *
	 * @param infoVol
	 */
	public void setInfoVol(int infoVol) {
		this.infoVol = infoVol;
	}

	/**
	 *
	 * @return infoDay
	 */
	public String getInfoDay() {
		return infoDay;
	}

	/**
	 *
	 * @param infoDay
	 */
	public void setInfoDay(String infoDay) {
		this.infoDay = infoDay;
	}

	/**
	 *
	 * @return infoText
	 */
	public String getInfoText() {
		return infoText;
	}

	/**
	 *
	 * @param infoText
	 */
	public void setInfoText(String infoText) {
		this.infoText = infoText;
	}

	/**
	 *
	 * @return insertMsg
	 */
	public String getInsertMsg() {
		return insertMsg;
	}
}
