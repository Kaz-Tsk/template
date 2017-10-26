package com.internousdev.template.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.template.dto.SalonDataDTO;
import com.internousdev.template.util.DBConnector;

public class AdminInfoDAO {


	public ArrayList<SalonDataDTO> adminInfoSelect(){
		ArrayList<SalonDataDTO> adminInfoList = new ArrayList<SalonDataDTO>();
		DBConnector dbConnector = new DBConnector();
		Connection connection =  dbConnector.getConnection();
		String sql = "SELECT * FROM salon_info order by salon_vol" ;

		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				SalonDataDTO dto = new SalonDataDTO();
				dto.setDay(resultSet.getString("salon_vol"));
				dto.setDay(resultSet.getString("salon_info_date"));
				dto.setText(resultSet.getString("salon_info_text"));
				adminInfoList.add(dto);
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
		return adminInfoList;
	}






	public void insertInfo(int vol,String day, String text) {
		DBConnector dbConnector = new DBConnector();
		Connection connection =  dbConnector.getConnection();
		String sql ="INSERT INTO salon_info (salon_vol,salon_info_text,salon_info_date) VALUES (?,?,?)";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, vol);
			preparedStatement.setString(2, day);
			preparedStatement.setString(3, text);
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

	public void editInfo(int vol,String day,String text) {
		DBConnector dbConnector = new DBConnector();
		Connection connection =  dbConnector.getConnection();
		String sql ="UPDATE salon_info SET salon_info_text=?,salon_info_date=? WHERE salon_vol=?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, text);
			preparedStatement.setString(2, day);
			preparedStatement.setInt(3, vol);
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

	public void deleteInfo(int vol) {
		DBConnector dbConnector = new DBConnector();
		Connection connection =  dbConnector.getConnection();
		String sql = "DELETE FROM salon_info WHERE salon_vol = ?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, vol);
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
