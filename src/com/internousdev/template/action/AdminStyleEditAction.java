package com.internousdev.template.action;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.internousdev.template.dao.AdminStyleDAO;
import com.internousdev.template.dto.StyleDTO;
import com.opensymphony.xwork2.ActionSupport;
/**
 * スタイル情報を編集するアクション
 * @author Kazuyuki Tasaki
 * @version 1.0
 */
public class AdminStyleEditAction extends ActionSupport implements ServletRequestAware{

	/**
	 * スタイルVol
	 * @param styleVol
	 */
	private int styleVol;

	/**
	 * スタイル名
	 * @param styleName
	 */
	private String styleName;

	/**
	 * スタイル紹介文
	 * @param styleComment
	 */
	private String styleComment;

	/**
	 * 担当スタッフID
	 * @param staffId
	 */
	private int staffId;

	/**
	 *実行後メッセージ
	 *@param editMsg
	 */
	private String editMsg;

	/**
	 * 画像ファイル
	 * @param styleFile
	 */
	private File styleFile;

	/**
	 * リクエスト
	 *@param request
	 */
	private HttpServletRequest request;

	/**
	 * ファイル名
	 * @param styleFileFileName
	 */
	private String styleFileFileName;

	/**
	 * 画像ファイル形式
	 *@param styleFileContentType
	 */
	public String styleFileContentType;

	//インスタンス化
	/**
	 * スタイル情報リスト
	 * @param styleList
	 */
	private ArrayList<StyleDTO> styleList = new ArrayList<StyleDTO>();

	/**
	 * スタイル情報を処理するDAO
	 * @param dao
	 */
	private AdminStyleDAO dao = new AdminStyleDAO();

	/**
	 * スタイルを編集するメソッド
	 * @return result 該当する情報があればSUCCESS なければERROR
	 */
	public String execute() {
		//画像の変更があるか確認
		if(styleFile == null || styleFile.length() == 0) {
			//DBからスタイル情報を取得
			styleList = dao.styleInsertSelect();
			//該当するスタイルがあるか確認
			for(int i = 0; i < styleList.size(); i++) {
				if(styleList.get(i).getStyleVol()!=styleVol) {
					editMsg = "該当するスタイルがありません。";
					return ERROR;
				}
			}
			dao.editNoImgStyle(styleVol, styleName, styleComment, staffId);
			editMsg ="編集が完了しました。";
			return SUCCESS;
		}else{
			try{
				//imgが重複するため下記パスに変更		String basePath = request.getServletContext().getRealPath("/");
				String basePath = "/Users/apple/git/template/WebContent/";
				File destFile = new File(basePath + "img", styleFileFileName);
				FileUtils.copyFile(styleFile, destFile);
				styleFileFileName = "img/" + styleFileFileName;
			} catch (IOException e1) {
				e1.printStackTrace();
			} catch (NullPointerException e2){
				e2.printStackTrace();
			}
		}
		//DBからスタイル情報を取得
		styleList = dao.styleInsertSelect();
		//該当するスタイルがあるか確認
		for(int i = 0; i < styleList.size(); i++) {
			if(styleList.get(i).getStyleVol()!=styleVol) {
				editMsg = "該当するスタイルがありません。";
				return ERROR;
			}
		}
		dao.editStyle(styleVol, styleName, styleComment, staffId,styleFileFileName);
		editMsg = "編集が完了しました。";
		return SUCCESS;
	}

	//以下、setter getter
	/**
	 *
	 * @return styleVol
	 */
	public int getStyleVol() {
		return styleVol;
	}

	/**
	 *
	 * @param styleVol
	 */
	public void setStyleVol(int styleVol) {
		this.styleVol = styleVol;
	}

	/**
	 *
	 * @return styleName
	 */
	public String getStyleName() {
		return styleName;
	}

	/**
	 *
	 * @param styleName
	 */
	public void setStyleName(String styleName) {
		this.styleName = styleName;
	}

	/**
	 *
	 * @return styleComment
	 */
	public String getStyleComment() {
		return styleComment;
	}

	/**
	 *
	 * @param styleComment
	 */
	public void setStyleComment(String styleComment) {
		this.styleComment = styleComment;
	}

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
	 * @return editMsg
	 */
	public String getEditMsg() {
		return editMsg;
	}

	/**
	 *
	 * @return styleFile
	 */
	public File getStyleFile() {
		return styleFile;
	}

	/**
	 *
	 * @param styleFile
	 */
	public void setStyleFile(File styleFile) {
		this.styleFile = styleFile;
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
	 * @return styleFileFileName
	 */
	public String getStyleFileFileName() {
		return styleFileFileName;
	}

	/**
	 *
	 * @param styleFileFileName
	 */
	public void setStyleFileFileName(String styleFileFileName) {
		this.styleFileFileName = styleFileFileName;
	}

	/**
	 *
	 * @return styleFileContentType
	 */
	public String getStyleFileContentType() {
		return styleFileContentType;
	}

	/**
	 *
	 * @param styleFileContentType
	 */
	public void setStyleFileContentType(String styleFileContentType) {
		this.styleFileContentType = styleFileContentType;
	}

	/**
	 * @param request
	 */
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
}
