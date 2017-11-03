package com.internousdev.template.action;

import java.util.ArrayList;

import com.internousdev.template.dao.MenuDAO;
import com.internousdev.template.dto.MenuDTO;
import com.opensymphony.xwork2.ActionSupport;
/**
 * メニュー管理ページへ遷移するアクション
 * @author Kazuyuki Tasaki
 * @version 1.0
 */
public class GoAdminMenuAction extends ActionSupport{

	//インスタンス化
	/**
	 * メニュー情報リスト
	 * @param menuList
	 */
	private ArrayList<MenuDTO> menuList = new ArrayList<MenuDTO>();

	/**
	 * メニュー情報取得のDAO
	 * @param dao
	 */
	private MenuDAO dao = new MenuDAO();

	/**
	 * メニュー情報を取得してページ遷移するメソッド
	 * @return result SUCCESS
	 */
	public String execute() {
		menuList = dao.selectMenu();
		return SUCCESS;
	}

	//getter
	/**
	 *
	 * @return menuList
	 */
	public ArrayList<MenuDTO> getMenuList() {
		return menuList;
	}
}
