package com.internousdev.template.action;
import java.util.ArrayList;

import com.internousdev.template.dao.MenuDAO;
import com.internousdev.template.dto.MenuDTO;
import com.opensymphony.xwork2.ActionSupport;
/**
 * menu表を表示するアクション
 *
 * @author Kazuyuki Tasaki
 *@return result
 */
public class GoMenuAction extends ActionSupport{



	/**
	 * 予約メニューを選ぶアクション
	 *
	 * @author Kazuyuki Tasaki
	 *@return result
	 */
	private ArrayList<MenuDTO> menuList = new ArrayList<MenuDTO>();

	MenuDTO menuDTO = new MenuDTO();

	MenuDAO menuDAO = new MenuDAO();


	public String execute(){
		String result = ERROR;
		menuList = menuDAO.selectMenu();
		if(menuList.size()!=0){
			result = SUCCESS;

		}
		return result;
	}


	public ArrayList<MenuDTO> getMenuList(){
		return menuList;
	}
}
