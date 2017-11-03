package com.internousdev.template.action;

import java.util.ArrayList;

import com.internousdev.template.dao.GoStyleDAO;
import com.internousdev.template.dto.StyleDTO;
import com.opensymphony.xwork2.ActionSupport;
/**
 * ヘアスタイルページへ遷移するアクション
 * @author Kazuyuki Tasaki
 * @version 1.0
 */
public class GoStyleAction extends ActionSupport {

	/**
	 * スタイルの性別
	 * @param styleSex
	 */
	private String styleSex;

	//インスタンス化
	/**
	 * スタイル情報を取得するDAO
	 * @param dao
	 */
	private GoStyleDAO dao = new GoStyleDAO();

	/**
	 * 女性のスタイル情報リスト
	 * @param ladiesStyleList
	 */
	private ArrayList<StyleDTO> ladiesStyleList = new  ArrayList<StyleDTO>();

	/**
	 * 男性のスタイル情報リスト
	 * @param mensStyleList
	 */
	private ArrayList<StyleDTO> mensStyleList = new  ArrayList<StyleDTO>();

	/**
	 * 性別ごとのスタイル情報を取得して遷移するメソッド
	 * @return SUCCESS
	 */
	public String execute(){
		styleSex = "ladies";
		ladiesStyleList = dao.styleSelect(styleSex);
		styleSex = "mens";
		mensStyleList = dao.styleSelect(styleSex);
		return  SUCCESS;
	}

	//以下、getter
	/**
	 *
	 * @return ladiesStyleList
	 */
	public ArrayList<StyleDTO> getLadiesStyleList(){
		return ladiesStyleList;
	}

	/**
	 *
	 * @return mensStyleList
	 */
	public ArrayList<StyleDTO> getMensStyleList(){
		return mensStyleList;
	}
}
