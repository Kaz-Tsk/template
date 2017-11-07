package com.internousdev.template.action;

import java.util.ArrayList;

import com.internousdev.template.dao.AdminMenuDAO;
import com.internousdev.template.dao.MenuDAO;
import com.internousdev.template.dto.MenuDTO;
import com.opensymphony.xwork2.ActionSupport;
/**
 * メニューを新規登録するアクション
 * @author Kazuyuki Tasaki
 * @version 1.0
 */
public class AdminMenuInsertAction extends ActionSupport{

	/**
	 * メニューId
	 * @param menuid
	 */
	private int menuId;

	/**
	 * メニュー名
	 * @param menuName
	 */
	private String menuName;

	/**
	 * 施術料金
	 * @param menuPrice
	 */
	private int menuPrice;

	/**
	 * 施術時間
	 * @param menuTime
	 */
	private int menuTime;

	/**
	 *実行後メッセージ
	 *@param msg
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
	 * @menuList
	 */
	private ArrayList<MenuDTO> menuList = new ArrayList<MenuDTO>();

	/**
	 * メニューを新規登録するメソッド
	 * @return result メニューIDが重複していなければSUCCESS していたらERROR
	 */
	public String execute() {
		String result = ERROR;
		//DBからメニュー情報を取得
		menuList = dao.selectMenu();
		if(menuList.size()==0) {
			menuDao.InsertMenu(menuId, result, menuPrice, menuTime);
			msg = "メニューを登録しました。";
			return SUCCESS;
		}else if(menuList.size() > 0) {
			//メニューIDが重複していないかチェック
			for(int i = 0; i < menuList.size(); i++) {
				if(menuList.get(i).getMenuId()==menuId) {
					msg = "メニューIdが重複しています。";
					return ERROR;
				}
			}
			menuDao.InsertMenu(menuId, result, menuPrice, menuTime);
			msg = "メニューを登録しました。";
			result = SUCCESS;
		}
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
	 * @return insertMsg
	 */
	public String getMsg() {
		return msg;
	}
}
