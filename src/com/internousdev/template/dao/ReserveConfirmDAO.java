package com.internousdev.template.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.template.dto.MenuDTO;
import com.internousdev.template.dto.StaffDTO;
import com.internousdev.template.util.DBConnector;
/**
 * 予約確認処理をするDAO
 * @author Kazuyuki Tasaki
 * @version 1.0
 */
public class ReserveConfirmDAO {

	/**
	 * 仮予約のメニュー情報を取得するメソッド
	 * @return reserveConfirmList
	 */
	public  ArrayList<MenuDTO> selectReserveConfirm(int[] menuId2){
		ArrayList<MenuDTO> reserveConfirmList = new ArrayList<MenuDTO>();
		DBConnector dbConnector = new DBConnector();
		Connection connection =  dbConnector.getConnection();
		int menuId = menuId2.length;
		String sql = "SELECT * FROM menu where menu_Id  in ("+createInSQL(menuId)+")";

		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			//配列で取得したmenuIdをセットする
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

	/**
	 * 可変するmenuIdの情報に合わせて?を連動させるメソッド
	 * @param menuId
	 * @return builder
	 */
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

	public void reserveInsert(String reserveMenu,int subPrice,int menuTime,String staffName,String pay,int userId,int reserveFlg,String rD){
		DBConnector dbConnector = new DBConnector();
		Connection connection =  dbConnector.getConnection();
		String sql = "insert into reserve_date(reserve_menu,reserve_price,reserve_time,reserve_pay,reserve_staff,user_id,reserve_flg,reserve_start_date ,reserve_end_date,insert_date) values (?, ?, ?, ?, ?, ?, ?, ?, ? + interval ? minute , now())";

		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1,reserveMenu);
			preparedStatement.setInt(2,subPrice);
			preparedStatement.setInt(3,menuTime);
			preparedStatement.setString(4,pay);
			preparedStatement.setString(5,staffName);
			preparedStatement.setInt(6,userId);
			preparedStatement.setInt(7,reserveFlg);
			preparedStatement.setString(8,rD);
			preparedStatement.setString(9,rD);
			preparedStatement.setInt(10,menuTime);
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

	public int reserveCheck (String rD,int menuTime){
		int count=0;
		DBConnector dbConnector = new DBConnector();
		Connection connection =  dbConnector.getConnection();

		String sql = "SELECT COUNT(reserve_flg) as count FROM reserve_date WHERE (reserve_start_date BETWEEN ? AND ? + interval ? minute) AND (reserve_flg = 1)";

		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1,rD);
			preparedStatement.setString(2,rD);
			preparedStatement.setInt(3,menuTime);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				count =(resultSet.getInt("count"));
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
		return count;
	}

	public MenuDTO reserveIdGet(int Id,String rD){
		DBConnector dbConnector = new DBConnector();
		Connection connection =  dbConnector.getConnection();
		MenuDTO dto = new MenuDTO();
		String sql = "SELECT reserve_id FROM reserve_date WHERE user_Id=? AND reserve_start_date=? ";
		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1,Id);
			preparedStatement.setString(2, rD);
			ResultSet resultSet = preparedStatement.executeQuery();

			if(resultSet.next()){
				dto.setReserveId(resultSet.getInt("reserve_id"));
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
		return dto;
	}
}
