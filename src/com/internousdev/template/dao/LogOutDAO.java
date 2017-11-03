package com.internousdev.template.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.template.util.DBConnector;
/**
 * ログアウト処理を行うDAO
 * @author Kazuyuki Tasaki
 * @version 1.0
 */
public class LogOutDAO {

	/**
	 * ログアウト処理を行うメソッド
	 * @param Id
	 */
	public void logOutFlg(int Id){
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		String sql = "update  user_data set login_flg=0 where id=?";

		try{
			PreparedStatement preparedStatement  = connection.prepareStatement(sql);
			preparedStatement.setInt(1, Id);
			preparedStatement.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}try{
			connection.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
}
