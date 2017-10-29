package com.internousdev.template.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.template.dto.StyleDTO;
import com.internousdev.template.util.DBConnector;

public class AdminStyleEditDAO {


	public ArrayList<StyleDTO> styleSelect(int styleVol){

		DBConnector dbConnector = new DBConnector();
		Connection connection =  dbConnector.getConnection();
		ArrayList<StyleDTO> styleList = new ArrayList<StyleDTO>();
		String sql = "SELECT  style_vol,style_name,style_sex,style_img FROM style_data order where style_vol=?";

		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, styleVol);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
					StyleDTO dto = new StyleDTO();
					dto.setStyleVol(resultSet.getInt("style_vol"));
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
