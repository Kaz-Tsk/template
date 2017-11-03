package com.internousdev.template.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.template.dto.SalonDataDTO;
import com.internousdev.template.util.DBConnector;
/**
 * インフォメーション管理のDAO
 * @author Kazuyuki Tasaki
 *@version 1.0
 */
public class AdminInfoDAO {

	/**
	 *インフォメーション情報を取得するメソッド
	 * @return adminInfoList
	 */
	public ArrayList<SalonDataDTO> adminInfoSelect(){
		ArrayList<SalonDataDTO> adminInfoList = new ArrayList<SalonDataDTO>();
		DBConnector dbConnector = new DBConnector();
		Connection connection =  dbConnector.getConnection();
		String sql = "SELECT * FROM salon_info order by salon_vol" ;

		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				SalonDataDTO dto = new SalonDataDTO();
				dto.setInfoVol(resultSet.getInt("salon_vol"));
				dto.setInfoDay(resultSet.getString("salon_info_date"));
				dto.setInfoText(resultSet.getString("salon_info_text"));
				adminInfoList.add(dto);
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
		return adminInfoList;
	}

	/**
	 * インフォメーション情報を新規登録するメソッド
	 * @param infoVol
	 * @param infoDay
	 * @param infoText
	 */
	public void insertInfo(int infoVol,String infoDay, String infoText) {
		DBConnector dbConnector = new DBConnector();
		Connection connection =  dbConnector.getConnection();
		String sql ="INSERT INTO salon_info (salon_vol,salon_info_text,salon_info_date) VALUES (?,?,?)";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, infoVol);
			preparedStatement.setString(2, infoText);
			preparedStatement.setString(3, infoDay);
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
	 * インフォメーション情報を編集登録するメソッド
	 * @param infoVol
	 * @param infoDay
	 * @param infoText
	 */
	public void editInfo(int infoVol,String infoDay,String infoText) {
		DBConnector dbConnector = new DBConnector();
		Connection connection =  dbConnector.getConnection();
		String sql ="UPDATE salon_info SET salon_info_text=?,salon_info_date=? WHERE salon_vol=?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, infoText);
			preparedStatement.setString(2, infoDay);
			preparedStatement.setInt(3, infoVol);
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
	 * インフォメーション情報を削除するメソッド
	 * @param infoVol
	 */
	public void deleteInfo(int infoVol) {
		DBConnector dbConnector = new DBConnector();
		Connection connection =  dbConnector.getConnection();
		String sql = "DELETE FROM salon_info WHERE salon_vol = ?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, infoVol);
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
