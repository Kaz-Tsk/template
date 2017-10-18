package com.internousdev.template.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.template.util.DBConnector;

public class GoTopActionDAO {
/**
 * Indexの情報を引き出すメソッド
 */
	public ArrayList<SalonDataDTO> salonInfoList = new ArrayList<SalonDataDTO>();

	private DBConnector dbConnector = new DBConnector();

	private Connection connection =  dbConnector.getConnection();

	public ArrayList<SalonDataDTO> infoSelect(){
		String sql = "SELECT  salon_info,insert_date FROM salon_data";

		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
					SalonDataDTO dto = new SalonDataDTO();
					dto.setSalonInfo(resultSet.getString("salon_info"));
					dto.setInsertDate(resultSet.getDate("insert_date"));
					salonInfoList.add(dto);
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
		return salonInfoList;
	}
}