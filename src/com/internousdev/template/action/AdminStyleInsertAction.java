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

public class AdminStyleInsertAction extends ActionSupport implements ServletRequestAware{

	private int styleVol;

	private String styleName;

	private String styleSex;

	private String styleComment;

	private int staffId;

	private String insertMsg;

	private File styleFile;

	private HttpServletRequest request;

	private String styleFileFileName;

	public String styleFileContentType;

	AdminStyleDAO dao = new AdminStyleDAO();
	ArrayList<StyleDTO> styleList = new ArrayList<StyleDTO>();
	public String execute() {
		styleList = dao.styleInsertSelect();
		if(styleList.size()==0) {
			if(styleFile == null || styleFile.length() == 0){
				styleFileFileName = "img/noimg.png";
			}else{

				try{
//					String basePath = request.getServletContext().getRealPath("/");
					String basePath = "/Users/apple/git/template/WebContent/";
					File destFile = new File(basePath + "img", styleFileFileName);
					FileUtils.copyFile(styleFile, destFile);
					styleFileFileName = "img/" + styleFileFileName;
//					for(int i = 0; styleList.size(); i++) {
//						if(styleList.get(i).getStyleImg().equals(styleFileFileName)) {
//							insertMsg= "画像名が重複しています。";
//							return ERROR;
//						}
//					}
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
//				String basePath = request.getServletContext().getRealPath("/");
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
	public int getStyleVol() {
		return styleVol;
	}
	public void setStyleVol(int styleVol) {
		this.styleVol = styleVol;
	}
	public String getStyleName() {
		return styleName;
	}
	public void setStyleName(String styleName) {
		this.styleName = styleName;
	}
	public String getStyleSex() {
		return styleSex;
	}
	public void setStyleSex(String styleSex) {
		this.styleSex = styleSex;
	}
	public String getStyleComment() {
		return styleComment;
	}
	public void setStyleComment(String styleComment) {
		this.styleComment = styleComment;
	}
	public int getStaffId() {
		return staffId;
	}
	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}
	public String getInsertMsg() {
		return insertMsg;
	}
	public void setInsertMsg(String insertMsg) {
		this.insertMsg = insertMsg;
	}
	public File getStyleFile() {
		return styleFile;
	}
	public void setStyleFile(File styleFile) {
		this.styleFile = styleFile;
	}
	public HttpServletRequest getRequest() {
		return request;
	}
//	public void setRequest(HttpServletRequest request) {
//		this.request = request;
//	}
	public String getStyleFileFileName() {
		return styleFileFileName;
	}
	public void setStyleFileFileName(String styleFileFileName) {
		this.styleFileFileName = styleFileFileName;
	}
	public String getStyleFileContentType() {
		return styleFileContentType;
	}
	public void setStyleFileContentType(String styleFileContentType) {
		this.styleFileContentType = styleFileContentType;
	}
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;

	}
}

