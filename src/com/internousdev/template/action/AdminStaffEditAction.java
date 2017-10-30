package com.internousdev.template.action;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.internousdev.template.dao.AdminStaffDAO;
import com.opensymphony.xwork2.ActionSupport;

public class AdminStaffEditAction extends ActionSupport implements ServletRequestAware{

	private int staffId;

	private String staffName;

	private String staffComment;

	private String editMsg;

	private File staffFile;

	private HttpServletRequest request;

	private String staffFileFileName;

	public String staffFileContentType;

	AdminStaffDAO dao = new AdminStaffDAO();

	public String execute() {
		if(staffFile == null || staffFile.length() == 0) {
			dao.editNoImgStaff(staffId, staffName, staffComment);
			editMsg ="編集が完了しました。";
			return SUCCESS;
		}else{

			try{
				//			String basePath = request.getServletContext().getRealPath("/");
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
		dao.editStaff(staffId, staffName, staffComment, staffFileFileName);
		editMsg = "編集が完了しました。";
		return SUCCESS;
	}

	public int getStaffId() {
		return staffId;
	}

	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public String getStaffComment() {
		return staffComment;
	}

	public void setStaffComment(String staffComment) {
		this.staffComment = staffComment;
	}

	public String getEditMsg() {
		return editMsg;
	}

	public void setEditMsg(String editMsg) {
		this.editMsg = editMsg;
	}

	public File getStaffFile() {
		return staffFile;
	}

	public void setStaffFile(File staffFile) {
		this.staffFile = staffFile;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;

	}

	public String getStaffFileFileName() {
		return staffFileFileName;
	}

	public void setStaffFileFileName(String staffFileFileName) {
		this.staffFileFileName = staffFileFileName;
	}

	public String getStaffFileContentType() {
		return staffFileContentType;
	}

	public void setStaffFileContentType(String staffFileContentType) {
		this.staffFileContentType = staffFileContentType;
	}

}
