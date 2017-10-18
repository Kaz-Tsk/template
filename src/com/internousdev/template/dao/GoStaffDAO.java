package com.internousdev.template.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.template.util.DBConnector;

public class GoStaffDAO {

	public ArrayList<StaffDTO> staffList = new ArrayList<StaffDTO>();

	private DBConnector dbConnector = new DBConnector();

	private Connection connection =  dbConnector.getConnection();

	public ArrayList<SalonDataDTO> infoSelect(){
		String sql = "SELECT  staf_name,staff_comment FROM staff_data";

		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
					StaffDTO dto = new StaffDTO();
					dto.setStaffName(resultSet.getString("staff_name"));
					dto.setStaffComment(resultSet.getString("staff_comment"));
					staffList.add(dto);
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
		return staffList;
	}

}
