package com.internousdev.template.action;
import java.util.ArrayList;

import com.internousdev.template.dao.MenuDAO;
import com.internousdev.template.dto.MenuDTO;
import com.opensymphony.xwork2.ActionSupport;
/**
 * menu表に遷移するアクション
 * @author Kazuyuki Tasaki
 * @version 1.0
 */
public class GoMenuAction extends ActionSupport{

	//インスタンス化
	/**
	 * メニュー情報リスト
	 * @param menuList
	 */
	private ArrayList<MenuDTO> menuList = new ArrayList<MenuDTO>();

	/**
	 * メニュー情報を取得するDAO
	 * @param menuDAO
	 */
	private MenuDAO menuDAO = new MenuDAO();

	/**
	 * menu情報を取得してページ遷移するメソッド
	 *@return result SUCCESS
	 */
	public String execute(){
		String result = ERROR;
		menuList = menuDAO.selectMenu();
		if(menuList.size()!=0){
			result = SUCCESS;
		}
		return result;
	}

	//getter
	/**
	 *
	 * @return menuList
	 */
	public ArrayList<MenuDTO> getMenuList(){
		return menuList;
	}
}
