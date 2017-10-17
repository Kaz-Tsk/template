package com.internousdev.template.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.template.dto.MenuDTO;
import com.internousdev.template.util.DBConnector;

public class MenuDAO {

/**
 * menu取得のためのクラス
 *
 * @return menuList
 */
	public ArrayList<MenuDTO> menuList = new ArrayList<MenuDTO>();

	private DBConnector dbConnector = new DBConnector();

	private Connection connection =  dbConnector.getConnection();


	/**
	 * 背術メニューを取得するメソッド
	 *
	 * @return menuList
	 */
	public  ArrayList<MenuDTO> selectMenu(){
		String sql = "SELECT * FROM menu";

		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
					MenuDTO menuDTO = new MenuDTO();
					menuDTO.setMenuName(resultSet.getString("menu_name"));
					menuDTO.setMenuPrice(resultSet.getBigDecimal("menu_price"));
					menuDTO.setMenuTime(resultSet.getInt("menu_time"));
					System.out.println(menuList);
					menuList.add(menuDTO);
					System.out.println(menuList.size());
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
