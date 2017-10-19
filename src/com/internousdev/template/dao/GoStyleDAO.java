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

	private DBConnector dbConnector = new DBConnector();

	private Connection connection =  dbConnector.getConnection();

	public ArrayList<StyleDTO> styleSelect(){
		String sql = "SELECT  style_id,style_name,style_img FROM style_data order by style_id asc";

		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
					StyleDTO dto = new StyleDTO();
					dto.setStyleId(resultSet.getInt("style_id"));
					dto.setStyleName(resultSet.getString("style_name"));
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
