package com.internousdev.template.action;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.internousdev.template.dao.AdminStaffDAO;
import com.internousdev.template.dto.StaffDTO;
import com.opensymphony.xwork2.ActionSupport;
/**
 * スタッフ情報を新規登録するアクション
 * @author Kazuyuki Tasaki
 * @version 1.0
 */
public class AdminStaffInsertAction extends ActionSupport implements ServletRequestAware{

	/**
	 *スタッフID
	 *@param staffId
	 */
	private int staffId;
	/**
	 * スタッフ名
	 * @param staffName
	 */
	private String staffName;

	/**
	 * スタッフ紹介文
	 * @param staffComment
	 */
	private String staffComment;

	/**
	 * 実行後メッセージ
	 * @param insertMsg
	 */
	private String insertMsg;

	/**
	 * スタッフ画像
	 * @param staffFile
	 */
	private File staffFile;

	/**
	 * リクエスト
	 * @param request
	 */
	private HttpServletRequest request;

	/**
	 * 画像ファイル名
	 * @param staffFileFileName
	 */
	private String staffFileFileName;

	/**
	 * 画像ファイル形式
	 * @param staffFileContentType
	 */
	private String staffFileContentType;

	//インスタンス化
	/**
	 * スタッフ情報を処理するDAO
	 * @param dao
	 */
	private AdminStaffDAO dao = new AdminStaffDAO();

	/**
	 * スタッフ情報リスト
	 * @param staffList
	 */
	private ArrayList<StaffDTO> staffList = new ArrayList<StaffDTO>();

	/**
	 *スタッフ情報を新規登録するメソッド
	 *@return result  画像がなければnoImgに差し替えてSUCCESS, IDが重複していたらERROR;
	 */
	public String execute() {
		staffList = dao.staffInsertSelect();
		if(staffList.size()==0) {
			if(staffFile == null || staffFile.length() == 0){
				staffFileFileName = "img/noimg.png";
			}else{
				try{
					//	imgが重複するため下記パスに変更	String basePath = request.getServletContext().getRealPath("/");
					String basePath = "/Users/apple/git/template/WebContent/";
					File destFile = new File(basePath + "img", staffFileFileName);
					FileUtils.copyFile(staffFile, destFile);
					staffFileFileName = "img/" + staffFileFileName;
					//画像名上書確認用
					//for(int i = 0; staffList.size(); i++) {
					//	if(staffList.get(i).getStaffImg().equals(staffFileFileName)) {
					//		insertMsg= "画像名が重複しています。";
					//		return ERROR;
					//		}
					//	}
				} catch (IOException e1) {
					e1.printStackTrace();
				} catch (NullPointerException e2){
					e2.printStackTrace();
				}
			}
			dao.InsertStaff(staffId,staffName, staffComment, staffFileFileName);
			insertMsg = "登録が完了しました。";
			return SUCCESS;
		}else {
			for(int i = 0; i < staffList.size(); i++) {
				if(staffList.get(i).getStaffId() == staffId) {
					insertMsg = "staffIdが重複しています。";
					return ERROR;
				}
			}
			if(staffFile == null || staffFile.length() == 0){
				staffFileFileName = "img/noimg.png";
			}else{
				try{
					//imgが重複するため下記パスに変更		String basePath = request.getServletContext().getRealPath("/");
					String basePath = "/Users/apple/git/template/WebContent/";
					File destFile = new File(basePath + "img", staffFileFileName);
					FileUtils.copyFile(staffFile, destFile);
					staffFileFileName = "img/" + staffFileFileName;
				} catch (IOException e1) {
					e1.printStackTrace();
				} catch (NullPointerException e2){
					e2.printStackTrace();
				}
			}
			dao.InsertStaff(staffId,staffName, staffComment, staffFileFileName);
			insertMsg = "登録が完了しました。";
			return SUCCESS;
		}
	}

	//以下、setter getter

	/*
	 *
	 * @return staffId
	 */
	public int getStaffId() {
		return staffId;
	}

	/**
	 *
	 * @param staffId
	 */
	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}

	/**
	 *
	 * @return staffName
	 */
	public String getStaffName() {
		return staffName;
	}

	/**
	 *
	 * @param staffName
	 */
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	/**
	 *
	 * @return staffComment
	 */
	public String getStaffComment() {
		return staffComment;
	}

	/**
	 *
	 * @param staffComment
	 */
	public void setStaffComment(String staffComment) {
		this.staffComment = staffComment;
	}

	/**
	 *
	 * @return insertMsg
	 */
	public String getInsertMsg() {
		return insertMsg;
	}

	/**
	 *
	 * @return staffFile
	 */
	public File getStaffFile() {
		return staffFile;
	}

	/**
	 *
	 * @param staffFile
	 */
	public void setStaffFile(File staffFile) {
		this.staffFile = staffFile;
	}

	/**
	 *
	 * @return request
	 */
	public HttpServletRequest getRequest() {
		return request;
	}

	/**
	 *
	 * @param request
	 */
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	/**
	 *
	 * @return stafFileFileName
	 */
	public String getStaffFileFileName() {
		return staffFileFileName;
	}

	/**
	 *
	 * @param staffFileFileName
	 */
	public void setStaffFileFileName(String staffFileFileName) {
		this.staffFileFileName = staffFileFileName;
	}

	/**
	 *
	 * @return staffFileContentType
	 */
	public String getStaffFileContentType() {
		return staffFileContentType;
	}

	/**
	 *
	 * @param staffFileContentType
	 */
	public void setStaffFileContentType(String staffFileContentType) {
		this.staffFileContentType = staffFileContentType;
	}
}
