package com.internousdev.template.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.template.dto.StyleDTO;
import com.internousdev.template.util.DBConnector;
/**
 * スタイル情報を管理するDAO
 * @author Kazuyuki Tasaki
 * @version 1.0
 */
public class AdminStyleDAO {

	/**
	 * ヘアスタイル情報を取得するメソッド
	 * @return styleList
	 */
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

	/**
	 * 新規登録と既存情報の称号に使うスタイルvolを取得するメソッド
	 * @return styleList
	 */
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

	/**
	 * ヘアスタイルの新規登録を行うメソッド
	 * @param styleVol
	 * @param styleName
	 * @param styleSex
	 * @param styleComment
	 * @param staffId
	 * @param styleFileFileName
	 */
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

	/**
	 * 編集を行うヘアスタイルの情報を取得するメソッド
	 * @param styleVol
	 * @return dto
	 */
	public StyleDTO styleEditSelect(int styleVol){
		DBConnector dbConnector = new DBConnector();
		Connection connection =  dbConnector.getConnection();
		StyleDTO dto = new StyleDTO();
		String sql = "SELECT  style_vol,style_name,style_sex,style_comment,style_img,staff_name FROM style_data left join staff_data on style_data.staff_id = staff_data.staff_id where style_vol=?";

		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, styleVol);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				dto.setStyleVol(resultSet.getInt("style_vol"));
				dto.setStyleName(resultSet.getString("style_name"));
				dto.setStyleSex(resultSet.getString("style_sex"));
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

	/**
	 * 画像登録を伴わないヘアスタイル編集を登録するメソッド
	 * @param styleVol
	 * @param styleName
	 * @param styleComment
	 * @param staffId
	 */
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

	/**
	 * 画像を伴うスタイル編集登録を行うメソッド
	 * @param styleVol
	 * @param styleName
	 * @param styleComment
	 * @param staffId
	 * @param styleFileFileName
	 */
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

	/**
	 * スタイル情報を削除するメソッド
	 * @param styleVol
	 */
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
