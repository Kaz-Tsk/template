package com.internousdev.template.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.template.dto.StyleDTO;
import com.internousdev.template.util.DBConnector;

public class GoStyleDAO {

	public ArrayList<StyleDTO> styleList = new ArrayList<StyleDTO>();



	public ArrayList<StyleDTO> styleSelect(String styleSex){

		DBConnector dbConnector = new DBConnector();

		Connection connection =  dbConnector.getConnection();

		String sql = "SELECT  style_id,style_name,style_sex,style_img FROM style_data where style_sex=? order by style_id asc";

		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1,styleSex);

			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
					StyleDTO dto = new StyleDTO();
					dto.setStyleId(resultSet.getInt("style_id"));
					dto.setStyleName(resultSet.getString("style_name"));
					dto.setStyleSex(resultSet.getString("style_sex"));
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
