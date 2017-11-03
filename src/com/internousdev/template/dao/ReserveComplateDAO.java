package com.internousdev.template.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.template.util.DBConnector;
/**
 * 予約完了の処理を行うDAO
 * @author Kazyuki Tasaki
 * @version 1.0
 */
public class ReserveComplateDAO {

	/**
	 * 予約状態を確認するreserveFlgを１にするメソッド
	 * @param reserveId
	 */
	public void reserveComp(int reserveId){
		DBConnector dbConnector = new DBConnector();
		Connection connection =  dbConnector.getConnection();
		String sql="UPDATE reserve_date SET reserve_flg = 1 WHERE reserve_id = ? ";

		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, reserveId);
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
	 * 仮予約を削除するメソッド
	 * @param reserveId
	 */
	public void reserveReset(int reserveId){
		DBConnector dbConnector = new DBConnector();
		Connection connection =  dbConnector.getConnection();
		String sql="DELETE FROM reserve_date WHERE reserve_id = ? and reserve_flg= 0 ";

		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, reserveId);
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
