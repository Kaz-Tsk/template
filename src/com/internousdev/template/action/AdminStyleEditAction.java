package com.internousdev.template.action;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.internousdev.template.dao.AdminStyleDAO;
import com.opensymphony.xwork2.ActionSupport;


public class AdminStyleEditAction extends ActionSupport implements ServletRequestAware{

	private int styleVol;

	private String styleName;

	private String styleComment;

	private int staffId;

	private String editMsg;

	private File styleFile;

	private HttpServletRequest request;

	private String styleFileFileName;

	public String styleFileContentType;

	AdminStyleDAO dao = new AdminStyleDAO();
public String execute() {
	if(styleFile == null || styleFile.length() == 0) {
		dao.editNoImgStyle(styleVol, styleName, styleComment, staffId);
		editMsg ="編集が完了しました。";
		return SUCCESS;
	}else{

		try{
//			String basePath = request.getServletContext().getRealPath("/");
			String basePath = "/Users/apple/git/template/WebContent/";
			File destFile = new File(basePath + "img", styleFileFileName);
			FileUtils.copyFile(styleFile, destFile);
			styleFileFileName = "img/" + styleFileFileName;
//
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (NullPointerException e2){
			e2.printStackTrace();
		}
	}
	dao.editStyle(styleVol, styleName, styleComment, staffId,styleFileFileName);

	editMsg = "編集が完了しました。";
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


public String getEditMsg() {
	return editMsg;
}


public void setEditMsg(String editMsg) {
	this.editMsg = editMsg;
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


//public void setRequest(HttpServletRequest request) {
//	this.request = request;
//}


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



public void setServletRequest(HttpServletRequest request) {
	this.request = request;

}


}
