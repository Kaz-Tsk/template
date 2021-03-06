package com.internousdev.template.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.template.dto.UserDTO;
import com.internousdev.template.util.DBConnector;
/**
 * ログイン認証を行うDAO
 * @author Kazuyuki Tasaki
 * @version 1.0
 */
public class LoginDAO {

	/**
	 * ログインユーザ情報取得メソッド
	 *
	 * @param loginUserId
	 * @param loginPassword
	 * @return LoginDTO
	 */
	public UserDTO getLoginUserInfo(String loginUserId, String loginPassword) {
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		UserDTO loginDTO = new UserDTO();
		String sql = "SELECT * FROM user_data WHERE login_id = ? AND login_pass = ?";

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
	 * ログインフラグを1にするメソッド
	 * @param Id
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
}
