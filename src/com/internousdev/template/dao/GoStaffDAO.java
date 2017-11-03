package com.internousdev.template.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.template.dto.StaffDTO;
import com.internousdev.template.util.DBConnector;
/**
 * スタッフ情報取得するDAO
 * @author Kazuyuki Tasaki
 * @version 1.0
 */
public class GoStaffDAO {

	/**
	 * スタッフ情報を取得するメソッド
	 * @return staffList
	 */
	public ArrayList<StaffDTO> staffSelect(){
		ArrayList<StaffDTO> staffList = new ArrayList<StaffDTO>();
		DBConnector dbConnector = new DBConnector();
		Connection connection =  dbConnector.getConnection();
		String sql = "SELECT  staff_id,staff_name,staff_comment,staff_img FROM staff_data order by staff_id asc";

		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				StaffDTO dto = new StaffDTO();
				dto.setStaffId(resultSet.getInt("staff_id"));
				dto.setStaffName(resultSet.getString("staff_name"));
				dto.setStaffComment(resultSet.getString("staff_comment"));
				dto.setStaffImg(resultSet.getString("staff_img"));
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
