package com.internousdev.template.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.template.dto.StyleDTO;
import com.internousdev.template.util.DBConnector;
/**
 * スタイル詳細情報を取得するDAO
 * @author Kazuyuki Tasaki
 * @version 1.0
 */
public class GoStyleInfoDAO {

	/**
	 * スタイル詳細情報を取得するメソッド
	 * @param styleVol
	 * @return dto
	 */
	public StyleDTO styleSelect(int styleVol){
		DBConnector dbConnector = new DBConnector();
		Connection connection =  dbConnector.getConnection();
		StyleDTO dto = new StyleDTO();
		String sql = "SELECT style_name,style_comment,style_img,staff_name FROM  style_data left join staff_data on style_data.staff_id = staff_data.staff_id WHERE style_vol=?";

		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, styleVol);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				dto.setStyleName(resultSet.getString("style_name"));
				dto.setStyleComment(resultSet.getString("style_comment"));
				dto.setStyleImg(resultSet.getString("style_img"));
				dto.setStaffName(resultSet.getString("staff_name"));
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
