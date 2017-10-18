package com.internousdev.template.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.template.dto.StyleDTO;
import com.internousdev.template.util.DBConnector;

public class GoStyleInfoDAO {

	public ArrayList<StyleDTO> styleList = new ArrayList<StyleDTO>();

	private DBConnector dbConnector = new DBConnector();

	private Connection connection =  dbConnector.getConnection();

	public ArrayList<StyleDTO> styleSelect(int styleId){
		String sql = "SELECT  style_id,style_name,style_comment,style_img FROM style_data where=?";

		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			preparedStatement.setInt(1, styleId);

			while(resultSet.next()){
					StyleDTO dto = new StyleDTO();
					dto.setStyleId(resultSet.getInt("style_id"));
					dto.setStyleName(resultSet.getString("style_name"));
					dto.setStyleComment(resultSet.getString("style_comment"));
					dto.setStyleImg(resultSet.getString("style_img"));

					styleList.add(dto);

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
		return styleList;
	}

}
