package com.internousdev.template.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.template.dto.StyleDTO;
import com.internousdev.template.util.DBConnector;

public class AdminStyleDAO {

	public ArrayList<StyleDTO> styleList () {
			DBConnector dbConnector = new DBConnector();
			Connection connection =  dbConnector.getConnection();
			ArrayList<StyleDTO> styleList = new ArrayList<StyleDTO>();
			String sql = "SELECT style_vol,style_name,style_sex,style_img FROM style_data order by style_vol asc";

			try{
				PreparedStatement preparedStatement = connection.prepareStatement(sql);

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

	public ArrayList<StyleDTO> styleInsertSelect(){

		DBConnector dbConnector = new DBConnector();

		Connection connection =  dbConnector.getConnection();
		ArrayList<StyleDTO> styleList = new ArrayList<StyleDTO>();
		String sql = "SELECT  style_vol FROM style_data order by style_vol asc";

		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
					StyleDTO dto = new StyleDTO();
					dto.setStyleVol(resultSet.getInt("style_vol"));
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


	public void InsertStyle(int styleVol,String styleName,String styleSex,String styleComment,int staffId,String styleFileFileName){

		DBConnector dbConnector = new DBConnector();
		Connection connection =  dbConnector.getConnection();

		String sql = "INSERT INTO style_data (style_vol,style_name,style_sex,style_comment,staff_id,style_img) VALUES(?, ?, ?, ?, ?, ?)";

		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setInt(1,styleVol);
			preparedStatement.setString(2,styleName);
			preparedStatement.setString(3,styleSex);
			preparedStatement.setString(4,styleComment);
			preparedStatement.setInt(5,staffId);
			preparedStatement.setString(6,styleFileFileName);
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


	public ArrayList<StyleDTO> styleEditSelect(int styleVol){

		DBConnector dbConnector = new DBConnector();
		Connection connection =  dbConnector.getConnection();
		ArrayList<StyleDTO> styleList = new ArrayList<StyleDTO>();
		String sql = "SELECT  style_vol,style_name,style_sex,style_comment,style_img,staff_name FROM style_data left join staff_data on style_data.staff_id = staff_data.staff_id where style_vol=?";

		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, styleVol);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
					StyleDTO dto = new StyleDTO();
					dto.setStyleVol(resultSet.getInt("style_vol"));
					dto.setStyleName(resultSet.getString("style_name"));
					dto.setStyleSex(resultSet.getString("style_sex"));
					dto.setStyleComment(resultSet.getString("style_comment"));
					dto.setStyleImg(resultSet.getString("style_img"));
					dto.setStaffName(resultSet.getString("staff_name"));
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

	public void editNoImgStyle(int styleVol,String styleName,String styleComment,int staffId){

		DBConnector dbConnector = new DBConnector();
		Connection connection =  dbConnector.getConnection();

		String sql = "UPDATE style_data SET style_name=?,style_comment=?,staff_id=? WHERE style_vol=?";

		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1,styleName);
			preparedStatement.setString(2,styleComment);
			preparedStatement.setInt(3,staffId);
			preparedStatement.setInt(4,styleVol);
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

	public void editStyle(int styleVol,String styleName,String styleComment,int staffId ,String styleFileFileName){

		DBConnector dbConnector = new DBConnector();
		Connection connection =  dbConnector.getConnection();

		String sql = "UPDATE style_data SET style_name=?,style_comment=?,staff_id=?,style_img=? WHERE style_vol=?";

		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1,styleName);
			preparedStatement.setString(2,styleComment);
			preparedStatement.setInt(3,staffId);
			preparedStatement.setString(4,styleFileFileName);
			preparedStatement.setInt(5,styleVol);
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


	public void deleteStyle(int styleVol) {
		DBConnector dbConnector = new DBConnector();
		Connection connection =  dbConnector.getConnection();
		String sql = "DELETE FROM style_data WHERE style_vol = ?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, styleVol);
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
