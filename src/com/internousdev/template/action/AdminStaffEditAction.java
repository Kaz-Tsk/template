package com.internousdev.template.action;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.internousdev.template.dao.AdminStaffDAO;
import com.opensymphony.xwork2.ActionSupport;
/**
 * スタッフ情報を編集するアクション
 * @author Kazuyuki Tasaki
 * @version 1.0
 */
public class AdminStaffEditAction extends ActionSupport implements ServletRequestAware{

	/**
	 * スタッフID
	 * @param staffId
	 */
	private int staffId;

	/**
	 * スタッフ名
	 * @staffName
	 */
	private String staffName;

	/**
	 * スタッフ紹介文
	 * @param staffComment
	 */
	private String staffComment;

	/**
	 * 実行後メッセージ
	 */
	private String editMsg;

	/**
	 * スタッフの画像
	 *@param staffFile
	 */
	private File staffFile;

	/**
	 *リクエスト
	 *@param request
	 */
	private HttpServletRequest request;

	/**
	 * スタッフ画像名
	 *@param staffFileFileName
	 */
	private String staffFileFileName;

	/**
	 * ファイル形式
	 * @param staffFileContentType
	 */
	public String staffFileContentType;

	//インスタンス化
	/**
	 * スタッフ情報を処理するDAO
	 */
	private AdminStaffDAO dao = new AdminStaffDAO();

	/**
	 * スタッフの情報を編集するメソッド
	 * @return  該当す流スタッフがいればSUCCESS いなければERROR
	 */
	public String execute() {
		//画像の変更なしの場合
		if(staffFile == null || staffFile.length() == 0) {
			dao.editNoImgStaff(staffId, staffName, staffComment);
			editMsg ="編集が完了しました。";
			return SUCCESS;
		}else{
			//画像の変更も含む場合
			try{
				//	imgが重複するので下記のpassに変更		String basePath = request.getServletContext().getRealPath("/");
				String basePath = "/Users/apple/git/template/WebContent/";
				//画像の保管先を指定
				File destFile = new File(basePath + "img", staffFileFileName);
				//画像を保存
				FileUtils.copyFile(staffFile, destFile);
				//DBに送るパス
				staffFileFileName = "img/" + staffFileFileName;

			} catch (IOException e1) {
				e1.printStackTrace();
			} catch (NullPointerException e2){
				e2.printStackTrace();
			}
		}
		dao.editStaff(staffId, staffName, staffComment, staffFileFileName);
		editMsg = "編集が完了しました。";
		return SUCCESS;
	}

	//以下、setter getter
	/**
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
	 * @return editMsg
	 */
	public String getEditMsg() {
		return editMsg;
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
	 * @param request
	 */
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	/**
	 *
	 * @return staffFileFileName
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
