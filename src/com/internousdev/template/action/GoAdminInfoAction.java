package com.internousdev.template.action;

import java.util.ArrayList;

import com.internousdev.template.dao.AdminInfoDAO;
import com.internousdev.template.dto.SalonDataDTO;
import com.opensymphony.xwork2.ActionSupport;
/**
 * インフォメーション管理ページへ遷移するアクション
 * @author Kazuyuki Tasaki
 * @version 1.0
 */
public class GoAdminInfoAction extends ActionSupport{
	/**
	 * インフォメーションVol
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
	 *@param infoText
	 */
	private String infoText;
	//インスタンス化
	private ArrayList<SalonDataDTO> adminInfoList = new ArrayList<SalonDataDTO>();
	private AdminInfoDAO dao = new AdminInfoDAO();
	/**
	 * インフォメーション情報を取得して遷移するメソッド
	 * @return result SUCCESS
	 */
	public String execute(){
		//DBからインフォメーション情報を取得
		adminInfoList = dao.adminInfoSelect();
		return SUCCESS;
	}
	//以下、getter setter
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
	public void setText(String infoText) {
		this.infoText = infoText;
	}
	/**
	 *
	 * @return adminInfoList
	 */
	public ArrayList<SalonDataDTO> getAdminInfoList(){
		return adminInfoList;
	}
}
