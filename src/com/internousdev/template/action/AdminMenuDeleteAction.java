package com.internousdev.template.action;

import java.util.ArrayList;

import com.internousdev.template.dao.AdminMenuDAO;
import com.internousdev.template.dao.MenuDAO;
import com.internousdev.template.dto.MenuDTO;
import com.opensymphony.xwork2.ActionSupport;
/**
 * メニュー情報を削除するアクション
 * @author Kazuyuki Tasaki
 *@version 1.0
 */
public class AdminMenuDeleteAction extends ActionSupport{

	/**
	 * メニューID
	 * @param menuId
	 */
	private int menuId;

	/**
	 * 実行後メッセージ
	 * @param msg
	 */
	private String msg;

	//インスタンス化
	/**
	 * メニュー情報取得のDAO
	 * @param dao
	 */
	private MenuDAO dao = new MenuDAO();

	/**
	 * メニュー処理のDAO
	 * @param menuDAO
	 */
	private AdminMenuDAO menuDao = new AdminMenuDAO();

	/**
	 * メニュー情報リスト
	 * @param menuList
	 */
	private ArrayList<MenuDTO> menuList = new ArrayList<MenuDTO>();

	/**
	 * メニューを削除するメソッド
	 * @return result 該当するメニューがあればSUCCESS なければERROR
	 */
	public String execute() {
		String result = ERROR;
		//DBからメニュー情報を取得
		menuList = dao.selectMenu();
		//該当するメニューIDがあるか確認
		if(menuList.size()==0) {
			msg ="該当するメニューがありません。";
			return ERROR;
		}else {
			for(int i = 0; i < menuList.size(); i++) {
				if(menuList.get(i).getMenuId() == menuId) {
					menuDao.deleteMenu(menuId);
					msg = "メニューを削除しました。";
					return SUCCESS;
				}
			}
		}
		msg = "該当するメニューがありません。";
		return result;
	}

	//以下、setter getter
	/**
	 *
	 * @return menuId
	 */
	public int getMenuId() {
		return menuId;
	}

	/**
	 *
	 * @param menuId
	 */
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	/**
	 *
	 * @return msg
	 */
	public String getMsg() {
		return msg;
	}
}
