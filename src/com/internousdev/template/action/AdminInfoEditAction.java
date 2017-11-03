package com.internousdev.template.action;

import java.util.ArrayList;

import com.internousdev.template.dao.AdminInfoDAO;
import com.internousdev.template.dto.SalonDataDTO;
import com.opensymphony.xwork2.ActionSupport;
/**
 * インフォメーション情報を編集するアクション
 * @author Kazuyuki Tasaki
 *@version 1.0
 */
public class AdminInfoEditAction extends ActionSupport{

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
	 * 編集後メッセージ
	 * @param editMsg
	 */
	private String editMsg;

	//インスタンス化
	/**
	 * インフォメーション情報リスト
	 * @param adminInfoList
	 */
	private ArrayList<SalonDataDTO> adminInfoList = new ArrayList<SalonDataDTO>();

	/**
	 * インフォメーション情報取得のDAO
	 * @param dao
	 */
	private AdminInfoDAO dao = new AdminInfoDAO();

	/**
	 *インフォメーションを編集するメソッド
	 *@return result 編集する内容があり、該当するものがあればSUCCESS 内容がない、もしくは該当しないとERROR
	 */
	public String execute() {
		String result = ERROR;
		//DBからインフォメーションの情報を取得
		adminInfoList = dao.adminInfoSelect();
		//内容があるか確認
		if(adminInfoList.size()==0) {
			editMsg = "※編集する内容がありません。";
			return ERROR;
		}else if (adminInfoList.size()>0) {
			//該当する内容があれば編集実行、なければERROR
			for(int i = 0; i < adminInfoList.size(); i++) {
				if(adminInfoList.get(i).getInfoVol()!=infoVol) {
					editMsg = "※該当する内容がありません。";
				}else if (adminInfoList.get(i).getInfoVol()==infoVol) {
					editMsg = "編集が完了しました。";
					dao.editInfo(infoVol, infoDay, infoText);
					result = SUCCESS;
					break;
				}
			}
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
	 * @return editMsg
	 */
	public String getEditMsg() {
		return editMsg;
	}

	/**
	 *
	 * @param editMsg
	 */
	public void setEditMsg(String editMsg) {
		this.editMsg = editMsg;
	}
}
