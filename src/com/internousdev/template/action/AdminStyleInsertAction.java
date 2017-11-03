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
 * ヘアスタイルを新規登録するアクション
 * @author Kazuyuki Tasaki
 * @version 1.0
 */
public class AdminStyleInsertAction extends ActionSupport implements ServletRequestAware{

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
	 * スタイルの性別
	 * @param styleSex
	 */
	private String styleSex;

	/**
	 * スタイルの紹介文
	 * @param styleComment
	 */
	private String styleComment;

	/**
	 * 担当スタッフID
	 * @param staffId
	 */
	private int staffId;

	/**
	 * 実行後メッセージ
	 * @param insertMsg
	 */
	private String insertMsg;

	/**
	 * 画像ファイル
	 * @param styleFile
	 */
	private File styleFile;

	/**
	 * リクエスト
	 * @param request
	 */
	private HttpServletRequest request;

	/**
	 * 画像ファイル名
	 * @param styleFileFileName
	 */
	private String styleFileFileName;

	/**
	 * 画像ファイル名
	 *@param styleFileContetType
	 */
	public String styleFileContentType;

	//インスタンス化
	/**
	 * スタイル情報を処理するDAO
	 */
	private AdminStyleDAO dao = new AdminStyleDAO();

	/**
	 * スタイル情報リスト
	 * @param styleList
	 */
	private ArrayList<StyleDTO> styleList = new ArrayList<StyleDTO>();

	/**
	 * ヘアスタイルを陰気登録するメソッド
	 * @return result スタイルVolが重複していなければSUCCESS していればERROR
	 */
	public String execute() {
		//DBからヘアスタイル情報を取得
		styleList = dao.styleInsertSelect();
		if(styleList.size()==0) {
			//画像がなければnoimgを差し込む
			if(styleFile == null || styleFile.length() == 0){
				styleFileFileName = "img/noimg.png";
			}else{
				try{
					//imgが重複するため下記パスに変更 String basePath = request.getServletContext().getRealPath("/");
					String basePath = "/Users/apple/git/template/WebContent/";
					File destFile = new File(basePath + "img", styleFileFileName);
					FileUtils.copyFile(styleFile, destFile);
					styleFileFileName = "img/" + styleFileFileName;
					//画像名が重複していないか確認（仮）
					//	for(int i = 0; styleList.size(); i++) {
					//		if(styleList.get(i).getStyleImg().equals(styleFileFileName)) {
					//			insertMsg= "画像名が重複しています。";
					//			return ERROR;
					//	}
					//}
				} catch (IOException e1) {
					e1.printStackTrace();
				} catch (NullPointerException e2){
					e2.printStackTrace();
				}
			}
			dao.InsertStyle(styleVol, styleName, styleSex, styleComment, staffId, styleFileFileName);
			insertMsg = "登録が完了しました。";
			return SUCCESS;
		}else if(styleList.size()!=0) {
			//volが重複していないかチェック
			for(int i = 0; i < styleList.size(); i++) {
				if(styleList.get(i).getStyleVol()==styleVol) {
					insertMsg = "volが重複しています。";
					return ERROR;
				}
			}
		}
		if(styleFile == null || styleFile.length() == 0){
			styleFileFileName = "img/noimage.png";
		}else{
			try{
				//imgが重複するため下記パスに変更 String basePath = request.getServletContext().getRealPath("/");
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
		dao.InsertStyle(styleVol, styleName, styleSex, styleComment, staffId, styleFileFileName);
		insertMsg = "登録が完了しました。";
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
	 * @return styleSex
	 */
	public String getStyleSex() {
		return styleSex;
	}

	/**
	 *
	 * @param styleSex
	 */
	public void setStyleSex(String styleSex) {
		this.styleSex = styleSex;
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
	 * @return insertMsg
	 */
	public String getInsertMsg() {
		return insertMsg;
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
	 * @return styleContentType
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
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
}

