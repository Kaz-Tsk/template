package com.internousdev.template.action;

import java.util.ArrayList;

import com.internousdev.template.dao.AdminMenuDAO;
import com.internousdev.template.dao.MenuDAO;
import com.internousdev.template.dto.MenuDTO;
import com.opensymphony.xwork2.ActionSupport;
/**
 * メニューを編集するアクション
 * @author Kazuyuki Tasaki
 *@version 1.0
 */
public class AdminMenuEditAction extends ActionSupport{

	/**
	 * メニューID
	 * @param menuId
	 */
	private int menuId;

	/**
	 * メニュー名
	 * @param menuName
	 */
	private String menuName;

	/**
	 * メニュー金額
	 * @param menuPrice
	 */
	private int menuPrice;

	/**
	 * 施術時間
	 * @param menuPrice
	 */
	private int menuTime;

	/**
	 * 実行後メッセージ
	 * @param editMsg
	 */
	private String editMsg;

	//インスタンス化
	/**
	 *メニュー情報取得のDAO
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
	 * メニューを編集するメソッド
	 * @return result 該当するメニューがあればSUCCESS なければERROR
	 */
	public String execute() {
		String result = ERROR;
		//DBにメニューがあるかチェック
		menuList = dao.selectMenu();
		if(menuList.size()==0) {
			editMsg = "該当するメニューがありません。";
			return ERROR;
		}else {
			//該当するメニューがあれば実行、なければエラー
			for(int i = 0; i < menuList.size(); i++) {
				if(menuList.get(i).getMenuId() == menuId) {
					menuDao.editMenu(menuName, menuPrice, menuTime, menuId);
					editMsg = "メニューを編集しました。";
					return SUCCESS;
				}
			}
		}
		editMsg = "該当するメニューがありません。";
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
	 * @return menuName
	 */
	public String getMenuName() {
		return menuName;
	}

	/**
	 *
	 * @param menuName
	 */
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	/**
	 *
	 * @return menuPrice
	 */
	public int getMenuPrice() {
		return menuPrice;
	}

	/**
	 *
	 * @param menuPrice
	 */
	public void setMenuPrice(int menuPrice) {
		this.menuPrice = menuPrice;
	}

	/**
	 *
	 * @return menuTime
	 */
	public int getMenuTime() {
		return menuTime;
	}

	/**
	 *
	 * @param menuTime
	 */
	public void setMenuTime(int menuTime) {
		this.menuTime = menuTime;
	}

	/**
	 *
	 * @return editMsg
	 */
	public String getEditMsg() {
		return editMsg;
	}
}
