package com.internousdev.template.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.template.dto.LoginDTO;
import com.internousdev.template.util.DBConnector;

public class LoginDAO {

	private DBConnector dbConnector = new DBConnector();

	private Connection connection = dbConnector.getConnection();

	private LoginDTO loginDTO = new LoginDTO();

	/**
	 * ログインユーザ情報取得メソッド
	 *
	 * @param loginUserId
	 * @param loginPassword
	 * @return LoginDTO
	 */
	public LoginDTO getLoginUserInfo(String loginUserId, String loginPassword) {

		String sql = "SELECT * FROM user_data where login_id = ? AND login_pass = ?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, loginUserId);
			preparedStatement.setString(2, loginPassword);

			ResultSet resultSet = preparedStatement.executeQuery();

			if(resultSet.next()) {
				loginDTO.setId(resultSet.getInt("id"));
				loginDTO.setLoginId(resultSet.getString("login_id"));
				loginDTO.setLoginPassword(resultSet.getString("login_pass"));
				loginDTO.setUserName(resultSet.getString("user_name"));
				loginDTO.setLoginFlg(resultSet.getInt("login_flg"));
				loginDTO.setLoginFlg(resultSet.getInt("login_flg"));
				loginDTO.setUserFlg(resultSet.getInt("user_flg"));

			}

		} catch(Exception e) {
			e.printStackTrace();
		}try{
			connection.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return loginDTO;
	}

/**
 * loginFlg=1にするメソッド
 */
	public void updateFlg(int Id){
		 DBConnector dbConnector = new DBConnector();
		 Connection connection = dbConnector.getConnection();
		String sql = "update  user_data set login_flg=1 where id=?";
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

	public LoginDTO getLoginDTO() {
		return loginDTO;
	}
}
