package com.internousdev.template.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.internousdev.template.util.DBConnector;

public class GoReserveDAO {

/**
 * menu取得のためのクラス
 *
 * @return menuList
 */
	public ArrayList<ResereveDAO> menuList = new ArrayList<ReserveDTO>();

	private DBConnector dbConnector = new DBConnector();

	private Connection connection =  dbConnector.getConnection();

	private ReserveDTO reserveDTO = new ReserveDTO();

	/**
	 * 背術メニューを取得するメソッド
	 *
	 * @return menuList
	 */
	public  ArrayList<reserveDTO> selectMenu(){
		String sql = "SELECT * FROM menu";

		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){

			}
		}catch
	}
}
