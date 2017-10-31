package com.internousdev.template.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.template.dto.ReserveDTO;
import com.internousdev.template.util.DBConnector;

public class AdminReserveDAO {


	public ArrayList<ReserveDTO> reserveSelect (){
		DBConnector dbConnector = new DBConnector();
		Connection connection =  dbConnector.getConnection();
		ArrayList<ReserveDTO> reserveList = new ArrayList<ReserveDTO>();
		String sql = "SELECT reserve_id, reserve_menu, reserve_price, reserve_time, reserve_staff,reserve_pay,user_name,reserve_start_date, reserve_end_date, reserve_date.insert_date FROM reserve_date LEFT JOIN user_data ON reserve_date.user_id = user_data.id";

		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
					ReserveDTO dto = new ReserveDTO();
					dto.setReserveId(resultSet.getInt("reserve_id"));
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
