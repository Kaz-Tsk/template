package com.internousdev.template.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.template.dto.ReserveDTO;
import com.internousdev.template.dto.UserDTO;
import com.internousdev.template.util.DBConnector;
/**
 * マイページに必要な情報を取得するDAO
 * @author Kazuyuki Tasaki
 * @version 1.0
 */
public class MyPageDAO {
	/**
	 * ユーザー情報を取得するメソッド
	 * @param id
	 * @return dto
	 */
	public UserDTO myPageSelect(int id) {
		UserDTO dto = new UserDTO();
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		String sql = "SELECT * FROM user_data WHERE id = ?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.executeQuery();
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				dto.setUserName(resultSet.getString("user_name"));
				dto.setTelNumber(resultSet.getString("tel_number"));
				dto.setEMail(resultSet.getString("e_mail"));
				dto.setAddress(resultSet.getString("address"));
				dto.setInsertDate(resultSet.getDate("insert_date"));
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

	/**
	 * 予約履歴を取得するメソッド
	 * @param Id
	 * @return reserveHistoryList
	 */
	public ArrayList<ReserveDTO> reserveHistorySelect(int Id) {
		ArrayList<ReserveDTO> reserveHistoryList = new ArrayList<ReserveDTO>();
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		String sql = "SELECT reserve_menu, reserve_price, reserve_staff,reserve_start_date FROM reserve_date WHERE user_id = ? AND reserve_flg = 1";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, Id);
			preparedStatement.executeQuery();
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				ReserveDTO dto = new ReserveDTO();
				dto.setReserveMenu(resultSet.getString("reserve_menu"));
				dto.setReservePrice(resultSet.getInt("reserve_price"));
				dto.setReserveStaff(resultSet.getString("reserve_staff"));
				dto.setReserveStartDate(resultSet.getString("reserve_start_date"));
				reserveHistoryList.add(dto);
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
		return reserveHistoryList;
	}
}
