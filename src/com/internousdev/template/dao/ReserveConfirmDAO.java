package com.internousdev.template.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.template.dto.MenuDTO;
import com.internousdev.template.util.DBConnector;

public class ReserveConfirmDAO {

	public ArrayList<MenuDTO> reserveConfirmList = new ArrayList<MenuDTO>();

	private DBConnector dbConnector = new DBConnector();

	private Connection connection =  dbConnector.getConnection();


	/**
	 * メニューを取得するメソッド
	 *
	 * @return menuList
	 */
	public  ArrayList<MenuDTO> selectReserveConfirm(int menuIdList){
		String sql = "SELECT * FROM menu where=?";

		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, menuId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
					MenuDTO menuDTO = new MenuDTO();
					menuDTO.setMenuName(resultSet.getString("menu_name"));
					menuDTO.setMenuPrice(resultSet.getInt("menu_price"));
					menuDTO.setMenuTime(resultSet.getInt("menu_time"));
					reserveConfirmList.add(menuDTO);
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
		return reserveConfirmList;
	}
}
