package com.internousdev.template.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.template.dto.MenuDTO;
import com.internousdev.template.util.DBConnector;
/**
 * メニュー情報を取得するDAO
 * @author Kazuyuki Tasaki
 *
 */
public class MenuDAO {

	/**
	 * メニューを取得するメソッド
	 * @return menuList
	 */
	public  ArrayList<MenuDTO> selectMenu(){
		ArrayList<MenuDTO> menuList = new ArrayList<MenuDTO>();
		DBConnector dbConnector = new DBConnector();
		Connection connection =  dbConnector.getConnection();
		String sql = "SELECT * FROM menu";

		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				MenuDTO menuDTO = new MenuDTO();
				menuDTO.setMenuId(resultSet.getInt("menu_id"));
				menuDTO.setMenuName(resultSet.getString("menu_name"));
				menuDTO.setMenuPrice(resultSet.getInt("menu_price"));
				menuDTO.setMenuTime(resultSet.getInt("menu_time"));
				menuList.add(menuDTO);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return menuList;
	}
}
