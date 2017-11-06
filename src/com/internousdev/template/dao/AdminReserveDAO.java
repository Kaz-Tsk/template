package com.internousdev.template.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.template.dto.ReserveDTO;
import com.internousdev.template.util.DBConnector;
/**
 * 予約情報を管理するDAO
 * @author Kazuyuki Tasaki
 * @version 1.0
 */
public class AdminReserveDAO {

	/**
	 * 予約情報を取得するメソッド
	 * @return reserveList
	 */
	public ArrayList<ReserveDTO> reserveSelect (){
		DBConnector dbConnector = new DBConnector();
		Connection connection =  dbConnector.getConnection();
		ArrayList<ReserveDTO> reserveList = new ArrayList<ReserveDTO>();
		String sql = "SELECT reserve_menu, reserve_price, reserve_time, reserve_staff,reserve_pay,user_name,reserve_start_date, reserve_end_date, reserve_date.insert_date FROM reserve_date LEFT JOIN user_data ON reserve_date.user_id = user_data.id";

		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				ReserveDTO dto = new ReserveDTO();
				dto.setReserveMenu(resultSet.getString("reserve_menu"));
				dto.setReservePrice(resultSet.getInt("reserve_price"));
				dto.setReserveTime(resultSet.getInt("reserve_time"));
				dto.setReserveStaff(resultSet.getString("reserve_staff"));
				dto.setReservePay(resultSet.getString("reserve_pay"));
				dto.setReserveUserName(resultSet.getString("user_name"));
				dto.setReserveStartDate(resultSet.getString("reserve_start_date"));
				dto.setReserveEndDate(resultSet.getDate("reserve_end_date"));
				dto.setReserveInsertDate(resultSet.getDate("reserve_date.insert_date"));
				reserveList.add(dto);
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
		return reserveList;
	}


	/**
	 * 名前と来店日で予約情報を取得するメソッド
	 * @return reserveList
	 */
	public ArrayList<ReserveDTO> searchSelect (String searchName, String searchDate){
		DBConnector dbConnector = new DBConnector();
		Connection connection =  dbConnector.getConnection();
		ArrayList<ReserveDTO> reserveList = new ArrayList<ReserveDTO>();
		String sql = "SELECT reserve_menu, reserve_price, reserve_time, reserve_staff,reserve_pay,user_name,reserve_start_date, reserve_end_date, reserve_date.insert_date "
				+ "FROM reserve_date LEFT JOIN user_data ON reserve_date.user_id = user_data.id WHERE user_name LIKE ? AND reserve_start_date LIKE ? ";

		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, searchName);
			preparedStatement.setString(2, searchDate);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				ReserveDTO dto = new ReserveDTO();
				dto.setReserveMenu(resultSet.getString("reserve_menu"));
				dto.setReservePrice(resultSet.getInt("reserve_price"));
				dto.setReserveTime(resultSet.getInt("reserve_time"));
				dto.setReserveStaff(resultSet.getString("reserve_staff"));
				dto.setReservePay(resultSet.getString("reserve_pay"));
				dto.setReserveUserName(resultSet.getString("user_name"));
				dto.setReserveStartDate(resultSet.getString("reserve_start_date"));
				dto.setReserveEndDate(resultSet.getDate("reserve_end_date"));
				dto.setReserveInsertDate(resultSet.getDate("reserve_date.insert_date"));
				reserveList.add(dto);
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
		return reserveList;
	}

	/**
	 * 名前で予約情報を取得するメソッド
	 * @return reserveList
	 */
	public ArrayList<ReserveDTO> searchNameSelect (String searchName){
		DBConnector dbConnector = new DBConnector();
		Connection connection =  dbConnector.getConnection();
		ArrayList<ReserveDTO> reserveList = new ArrayList<ReserveDTO>();
		String sql = "SELECT reserve_menu, reserve_price, reserve_time, reserve_staff,reserve_pay,user_name,reserve_start_date, reserve_end_date, reserve_date.insert_date "
				+ "FROM reserve_date LEFT JOIN user_data ON reserve_date.user_id = user_data.id WHERE user_name LIKE ? ";

		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, searchName);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				ReserveDTO dto = new ReserveDTO();
				dto.setReserveMenu(resultSet.getString("reserve_menu"));
				dto.setReservePrice(resultSet.getInt("reserve_price"));
				dto.setReserveTime(resultSet.getInt("reserve_time"));
				dto.setReserveStaff(resultSet.getString("reserve_staff"));
				dto.setReservePay(resultSet.getString("reserve_pay"));
				dto.setReserveUserName(resultSet.getString("user_name"));
				dto.setReserveStartDate(resultSet.getString("reserve_start_date"));
				dto.setReserveEndDate(resultSet.getDate("reserve_end_date"));
				dto.setReserveInsertDate(resultSet.getDate("reserve_date.insert_date"));
				reserveList.add(dto);
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
		return reserveList;
	}

	/**
	 * 来店日で予約情報を取得するメソッド
	 * @return reserveList
	 */
	public ArrayList<ReserveDTO> searchDateSelect (String searchDate){
		DBConnector dbConnector = new DBConnector();
		Connection connection =  dbConnector.getConnection();
		ArrayList<ReserveDTO> reserveList = new ArrayList<ReserveDTO>();
		String sql = "SELECT reserve_menu, reserve_price, reserve_time, reserve_staff,reserve_pay,user_name,reserve_start_date, reserve_end_date, reserve_date.insert_date "
				+ "FROM reserve_date LEFT JOIN user_data ON reserve_date.user_id = user_data.id WHERE reserve_start_date LIKE ? ";

		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, searchDate);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				ReserveDTO dto = new ReserveDTO();
				dto.setReserveMenu(resultSet.getString("reserve_menu"));
				dto.setReservePrice(resultSet.getInt("reserve_price"));
				dto.setReserveTime(resultSet.getInt("reserve_time"));
				dto.setReserveStaff(resultSet.getString("reserve_staff"));
				dto.setReservePay(resultSet.getString("reserve_pay"));
				dto.setReserveUserName(resultSet.getString("user_name"));
				dto.setReserveStartDate(resultSet.getString("reserve_start_date"));
				dto.setReserveEndDate(resultSet.getDate("reserve_end_date"));
				dto.setReserveInsertDate(resultSet.getDate("reserve_date.insert_date"));
				reserveList.add(dto);
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
		return reserveList;
	}

	/**
	 * 予約情報を削除するメソッド
	 * @param reserveId
	 */
	public void deleteReserve(int reserveId) {
		DBConnector dbConnector = new DBConnector();
		Connection connection =  dbConnector.getConnection();
		String sql = "DELETE FROM reserve_date WHERE reserve_id = ?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, reserveId);
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
