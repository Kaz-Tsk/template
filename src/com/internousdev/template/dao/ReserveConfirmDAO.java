package com.internousdev.template.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.template.dto.MenuDTO;
import com.internousdev.template.dto.StaffDTO;
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
	public  ArrayList<MenuDTO> selectReserveConfirm(int[] menuId2){
		int menuId = menuId2.length;
		String sql = "SELECT * FROM menu where menu_Id  in ("+createInSQL(menuId)+")";

		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			for( int i=0; i < menuId; i++){
			preparedStatement.setInt(i+1,menuId2[i]);
			}
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

	private static String createInSQL(int menuId){
		StringBuilder builder = new StringBuilder();
		for(int i = 0; i < menuId;){
			builder.append("?");
			if(++i < menuId){
			builder.append(",");
			}
			}
		return builder.toString();
	}

	public StaffDTO staffNameSelect(int staffId){
		DBConnector dbConnector = new DBConnector();
		Connection connection =  dbConnector.getConnection();
		StaffDTO sdto = new StaffDTO();
		String sql = "SELECT staff_name FROM staff_data where staff_id=?";

		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);


			preparedStatement.setInt(1,staffId);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
					sdto.setStaffName(resultSet.getString("staff_name"));
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
		return sdto;
	}

	public void reserveInsert(String reserveMenu,int subPrice,String staffName,int userId,int reserveFlg,String rD){
		DBConnector dbConnector = new DBConnector();
		Connection connection =  dbConnector.getConnection();
		String sql = "insert into reserve_date(reserve_menu,reserve_price,reserve_staff,user_id,reserve_flg,reserve_date ,insert_date) values (?,?,?,?,?,?, now())";

		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1,reserveMenu);
			preparedStatement.setInt(2,subPrice);
			preparedStatement.setString(3,staffName);
			preparedStatement.setInt(4,userId);
			preparedStatement.setInt(5,reserveFlg);
			preparedStatement.setString(6,rD);
			preparedStatement.executeUpdate();

		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}


	}




}
