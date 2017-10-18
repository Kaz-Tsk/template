package com.internousdev.template.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.template.dto.SalonDataDTO;
import com.internousdev.template.util.DBConnector;

public class GoInformationDAO {

	public ArrayList<SalonDataDTO> salonDataList = new ArrayList<SalonDataDTO>();

	private DBConnector dbConnector = new DBConnector();

	private Connection connection =  dbConnector.getConnection();

	public ArrayList<SalonDataDTO> styleSelect(){
		String sql = "SELECT  salon_id,salon_week, salon_hour, salon_address, salon_tel FROM salon_data order by salon_id asc";

		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
					SalonDataDTO dto = new SalonDataDTO();
					dto.setSalonId(resultSet.getInt("salon_id"));
					dto.setSalonWeek(resultSet.getString("salon_week"));
					dto.setSalonHour(resultSet.getString("salon_hour"));
					dto.setSalonAddress(resultSet.getString("salon_address"));
					dto.setSalonTel(resultSet.getString("salon_tel"));

					salonDataList.add(dto);

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
		return salonDataList;
	}
}
