package com.internousdev.template.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.template.dto.UserDTO;
import com.internousdev.template.util.DBConnector;
/**
 * ユーザーの新規登録を行うDAO
 * @author Kazuyuki Tasaki
 * @version 1.0
 */
public class UserCreateDAO {

	/**
	 * ユーザーを新規登録するメソッド
	 * @param loginUserId
	 * @param loginPassword
	 * @param userName
	 * @param telNumber
	 * @param eMail
	 * @param address
	 * @throws SQLException
	 */
	public void cerateUser(String loginUserId, String loginPassword, String userName,String telNumber,String eMail,String address) throws SQLException {
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		String sql = "INSERT INTO user_data (login_id, login_pass, user_name, tel_number, e_mail, address, insert_date) VALUES(?, ? ,?, ?, ?, ?,NOW())";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, loginUserId);
			preparedStatement.setString(2, loginPassword);
			preparedStatement.setString(3, userName);
			preparedStatement.setString(4, telNumber);
			preparedStatement.setString(5, eMail);
			preparedStatement.setString(6, address);
			preparedStatement.execute();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
	}

	/**
	 * ユーザーが重複していないか確認するための情報を取得するメソッド
	 * @return userCheckeList
	 */
	public ArrayList<UserDTO> userCreateCheck(){
		ArrayList<UserDTO> userCheckList = new ArrayList<UserDTO>();
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		String sql = "SELECT tel_number, e_mail FROM user_data";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.executeQuery();
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				UserDTO dto = new UserDTO();
				dto.setTelNumber(resultSet.getString("tel_number"));
				dto.setEMail(resultSet.getString("e_mail"));
				userCheckList.add(dto);
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
		return userCheckList;
	}
}
