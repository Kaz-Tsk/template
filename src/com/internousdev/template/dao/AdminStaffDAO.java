package com.internousdev.template.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.template.dto.StaffDTO;
import com.internousdev.template.util.DBConnector;
/**
 * スタッフ情報を管理するDAO
 * @author Kazuyuki Tasaki
 * @version 1.0
 */
public class AdminStaffDAO {

	/**
	 * スタッフ情報を取得するメソッド
	 * @return staffList
	 */
	public ArrayList<StaffDTO> staffInsertSelect(){
		DBConnector dbConnector = new DBConnector();
		Connection connection =  dbConnector.getConnection();
		ArrayList<StaffDTO> staffList = new ArrayList<StaffDTO>();
		String sql = "SELECT  staff_id FROM staff_data order by staff_id asc";

		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				StaffDTO dto = new StaffDTO();
				dto.setStaffId(resultSet.getInt("staff_id"));
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

	/**
	 * スタッフ情報を新規登録するメソッド
	 * @param staffId
	 * @param staffName
	 * @param staffComment
	 * @param staffFileFileName
	 */
	public void InsertStaff(int staffId,String staffName,String staffComment,String staffFileFileName){
		DBConnector dbConnector = new DBConnector();
		Connection connection =  dbConnector.getConnection();
		String sql = "INSERT INTO staff_data (staff_id,staff_name,staff_comment,staff_img) VALUES(?, ?, ?, ?)";

		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1,staffId);
			preparedStatement.setString(2,staffName);
			preparedStatement.setString(3,staffComment);
			preparedStatement.setString(4,staffFileFileName);
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
	 * 編集するスタッフの情報を取得するメソッド
	 * @param staffId
	 * @return staffList
	 */
	public ArrayList<StaffDTO> staffEditSelect(int staffId){
		DBConnector dbConnector = new DBConnector();
		Connection connection =  dbConnector.getConnection();
		ArrayList<StaffDTO> staffList = new ArrayList<StaffDTO>();
		String sql = "SELECT  staff_id, staff_name, staff_comment, staff_img FROM staff_data WHERE staff_id=?";

		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, staffId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				StaffDTO dto = new StaffDTO();
				dto.setStaffId(resultSet.getInt("staff_id"));
				dto.setStaffName(resultSet.getString("staff_Name"));
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

	/**
	 * 画像を編集登録しないスタッフ編集登録を行うメソッド
	 * @param staffId
	 * @param staffName
	 * @param staffComment
	 */
	public void editNoImgStaff(int staffId,String staffName,String staffComment){
		DBConnector dbConnector = new DBConnector();
		Connection connection =  dbConnector.getConnection();
		String sql = "UPDATE staff_data SET staff_name=?,staff_comment=? WHERE staff_id=?";

		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1,staffName);
			preparedStatement.setString(2,staffComment);
			preparedStatement.setInt(3,staffId);
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
	 * 画像の編集登録を伴うスタッフ編集登録を行うメソッド
	 * @param staffId
	 * @param staffName
	 * @param staffComment
	 * @param staffFileFileName
	 */
	public void editStaff(int staffId,String staffName,String staffComment,String staffFileFileName){
		DBConnector dbConnector = new DBConnector();
		Connection connection =  dbConnector.getConnection();
		String sql = "UPDATE staff_data SET staff_name=?,staff_comment=?,staff_img=? WHERE staff_id=?";

		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1,staffName);
			preparedStatement.setString(2,staffComment);
			preparedStatement.setString(3,staffFileFileName);
			preparedStatement.setInt(4,staffId);
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
	 * スタッフ情報を削除するメソッド
	 * @param staffId
	 */
	public void deleteStaff(int staffId) {
		DBConnector dbConnector = new DBConnector();
		Connection connection =  dbConnector.getConnection();
		String sql = "DELETE FROM staff_data WHERE staff_id = ?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, staffId);
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
