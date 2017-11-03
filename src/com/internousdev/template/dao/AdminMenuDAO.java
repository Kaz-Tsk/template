package com.internousdev.template.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.template.util.DBConnector;
/**
 * メニュー情報を管理するDAO
 * @author Kazuyuki Tasaki
 *@version 1.0
 */
public class AdminMenuDAO {

	/**
	 * メニュー情報を新規登録するメソッド
	 * @param menuId
	 * @param menuName
	 * @param menuPrice
	 * @param menuTime
	 */
	public void InsertMenu(int menuId,String menuName,int menuPrice,int menuTime){
		DBConnector dbConnector = new DBConnector();
		Connection connection =  dbConnector.getConnection();
		String sql = "INSERT INTO menu (menu_id,menu_name,menu_price,menu_time) VALUES(?, ?, ?, ?, ?)";

		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1,menuId);
			preparedStatement.setString(2,menuName);
			preparedStatement.setInt(3,menuPrice);
			preparedStatement.setInt(4,menuTime);
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
	 * メニュー情報を編集登録するメソッド
	 * @param menuName
	 * @param menuPrice
	 * @param menuTime
	 * @param menuId
	 */
	public void editMenu(String menuName,int menuPrice,int menuTime,int menuId){

		DBConnector dbConnector = new DBConnector();
		Connection connection =  dbConnector.getConnection();
		String sql = "UPDATE menu SET menu_name=?,menu_price=?,menu_time=? WHERE menu_id=?";

		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1,menuName);
			preparedStatement.setInt(2,menuPrice);
			preparedStatement.setInt(3,menuTime);
			preparedStatement.setInt(4,menuId);
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
	 * メニュー情報を削除するメソッド
	 * @param menuId
	 */
	public void deleteMenu(int menuId) {
		DBConnector dbConnector = new DBConnector();
		Connection connection =  dbConnector.getConnection();
		String sql = "DELETE FROM menu WHERE menu_id = ?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, menuId);
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
