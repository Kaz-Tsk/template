package com.internousdev.template.action;

import java.util.ArrayList;

import com.internousdev.template.dao.AdminStyleDAO;
import com.internousdev.template.dto.StyleDTO;
import com.opensymphony.xwork2.ActionSupport;
/**
 * ヘアスタイル情報を削除するアクション
 * @author Kazuyuki Tasaki
 * @version 1.0
 */
public class AdminStyleDeleteAction extends ActionSupport{
	/**
	 * スタイルVol
	 * @param styleVol
	 */
	private int styleVol;
	/**
	 * 実行後メッセージ
	 * @param deleteMsg
	 */
	private String deleteMsg;
	//インスタンス化
	private ArrayList<StyleDTO> styleList = new ArrayList<StyleDTO>();
	private AdminStyleDAO dao = new AdminStyleDAO();
	/**
	 * ヘアスタイル情報を削除するメソッド
	 * @return result 該当する情報があればSUCCESS なければERROR
	 */
	public String execute() {
		String result = ERROR;
		//DBからスタイル情報を取得
		styleList = dao.styleList();
		if(styleList.size()==0) {
			deleteMsg = "削除するデータがありません。";
			return ERROR;
		}else if(styleList.size()>0) {
			//リストに該当する情報があれば実行
			for(int i = 0; i < styleList.size(); i++) {
				if(styleList.get(i).getStyleVol()==styleVol) {
					dao.deleteStyle(styleVol);
					deleteMsg = "スタイルを削除しました。";
					return  SUCCESS;
				}
			}
			deleteMsg = "該当するスタイルがありません。";
		}
		return result;
	}
	//以下、setter getter
	/**
	 *
	 * @return styleVol
	 */
	public int getStyleVol() {
		return styleVol;
	}
	/**
	 *
	 * @param styleVol
	 */
	public void setStyleVol(int styleVol) {
		this.styleVol = styleVol;
	}
	/**
	 *
	 * @return deleteMsg
	 */
	public String getDeleteMsg() {
		return deleteMsg;
	}
}
