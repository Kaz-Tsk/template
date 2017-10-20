package com.internousdev.template.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.template.util.DBConnector;

public class LogOutDAO {

	private DBConnector dbConnector = new DBConnector();

	private Connection connection = dbConnector.getConnection();

	public void logOutFlg(int Id){

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
