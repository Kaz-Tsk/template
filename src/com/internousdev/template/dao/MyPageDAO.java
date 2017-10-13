package com.internousdev.template.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.template.dto.MyPageDTO;
import com.internousdev.template.util.DBConnector;

public class MyPageDAO {
	private DBConnector dbConnector = new DBConnector();

	private Connection connection = dbConnector.getConnection();

	/**
	 * ユーザー情報獲得
	 *
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<MyPageDTO>userData(int id) throws SQLException {
		ArrayList<MyPageDTO> myPageDTO = new ArrayList<MyPageDTO>();

		String sql = "SELECT user_name,tel_number,e_mail,address FROM user_data WHERE id=?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1,id);
			ResultSet resultSet = preparedStatement.executeQuery();

			while(resultSet.next()) {
				MyPageDTO dto = new MyPageDTO();
				dto.setUserName(resultSet.getString("user_name"));
				dto.setTelNumber(resultSet.getString("tel_number"));
				dto.setEmail(resultSet.getString("e_mail"));
				dto.setAddress(resultSet.getString("address"));
				myPageDTO.add(dto);
			}

		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}

		return myPageDTO;
	}

}
