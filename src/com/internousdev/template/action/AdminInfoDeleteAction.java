package com.internousdev.template.action;

import java.util.ArrayList;

import com.internousdev.template.dao.AdminInfoDAO;
import com.internousdev.template.dto.SalonDataDTO;
import com.opensymphony.xwork2.ActionSupport;
/**
 *管理者としてインフォメーションを削除するアクション
 * @author Kazuyuki Tasaki
 * @version 1.0
 *
 */
public class AdminInfoDeleteAction extends ActionSupport{

	/**
	 * インフォメーションvol
	 * @param infoVol
	 */
	private int infoVol;

	/**
	 * 動作後のメッセージ
	 * @param deleteMsg
	 */
	private String deleteMsg;

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
	 * インフォメーションを削除するメソッド
	 * @ return result 消去する情報のvolとDBのvolが合えばSUCCESS,合わないもしくは削除する内容がなければERROR
	 */
	public String execute() {
		String result = ERROR;
		//インフォメーション情報をDBから取得
		adminInfoList = dao.adminInfoSelect();
		//インフォメーションの内容があるか確認
		if(adminInfoList.size()==0) {
			deleteMsg = "※消去する内容がありません。";
			result = ERROR;
		}else if(adminInfoList.size()>0){
			for(int i = 0; i < adminInfoList.size(); i++) {
				//リストに該当するvolあれば削除メソッド実行、なければERROR
				if(adminInfoList.get(i).getInfoVol()!=infoVol) {
					deleteMsg = "※消去する内容が見つかりません。";
				}else if(adminInfoList.get(i).getInfoVol()==infoVol) {
					deleteMsg = "内容を消去しました。";
					dao.deleteInfo(infoVol);
					result = SUCCESS;
					break;
				}
			}
		}
		return result;
	}

	//以下setter getter
	/**
	 *
	 * @return infovol
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
	 * @return deleteMsg
	 */
	public String getDeleteMsg() {
		return deleteMsg;
	}

	/**
	 *
	 * @param deleteMsg
	 */
	public void setDeleteMsg(String deleteMsg) {
		this.deleteMsg = deleteMsg;
	}
}
