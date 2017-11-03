package com.internousdev.template.action;

import java.util.ArrayList;

import com.internousdev.template.dao.GoStyleInfoDAO;
import com.internousdev.template.dto.StyleDTO;
import com.opensymphony.xwork2.ActionSupport;
/**
 * スタイル詳細ページへ遷移するアクション
 * @author Kazuyuki Tasaki
 * @version 1.0
 */
public class GoStyleInfoAction extends ActionSupport {
	/**
	 * スタイルvol
	 * @param styleVol
	 */
	private int styleVol;
	//インスタンス化
	private GoStyleInfoDAO dao = new GoStyleInfoDAO();
	private ArrayList<StyleDTO> styleList = new  ArrayList<StyleDTO>();
	/**
	 * スタイル詳細を取得して遷移するメソッド
	 * @return SUCCESS
	 */
	public String execute(){
		styleList = dao.styleSelect(styleVol);
		return  SUCCESS;
	}
	//以下、setter getter
	/**
	 *
	 * @return styleList
	 */
	public ArrayList<StyleDTO> getStyleList(){
		return styleList;
	}
	/**
	 *
	 * @return styleVol
	 */
	public int getStyleVol(){
		return styleVol;
	}
	/**
	 *
	 * @param styleVol
	 */
	public void setStyleVol(int styleVol){
		this.styleVol = styleVol;
	}
}
