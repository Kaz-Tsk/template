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

public class AdminStaffInsertAction extends ActionSupport implements ServletRequestAware{

	private int staffId;

	private String staffName;

	private String staffComment;

	private String insertMsg;

	private File staffFile;

	private HttpServletRequest request;

	private String staffFileFileName;

	private String staffFileContentType;

	AdminStaffDAO dao = new AdminStaffDAO();
	ArrayList<StaffDTO> staffList = new ArrayList<StaffDTO>();

	public String execute() {
		staffList = dao.staffInsertSelect();
		if(staffList.size()==0) {
			if(staffFile == null || staffFile.length() == 0){
				staffFileFileName = "img/noimg.png";
			}else{

				try{
//					String basePath = request.getServletContext().getRealPath("/");
					String basePath = "/Users/apple/git/template/WebContent/";
					File destFile = new File(basePath + "img", staffFileFileName);
					FileUtils.copyFile(staffFile, destFile);
					staffFileFileName = "img/" + staffFileFileName;
//					for(int i = 0; staffList.size(); i++) {
//						if(staffList.get(i).getStaffImg().equals(staffFileFileName)) {
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
			dao.InsertStaff(staffId, staffName, staffComment, staffFileFileName);

			insertMsg = "登録が完了しました。";
			return SUCCESS;
		}else if(staffList.size()!=0) {
			for(int i = 0; i < staffList.size(); i++) {
				if(staffList.get(i).getStaffId()==staffId) {
					insertMsg = "staffIdが重複しています。";
					return ERROR;
				}
			}
		}
		if(staffFile == null || staffFile.length() == 0){
			staffFileFileName = "img/noimage.png";
		}else{
			try{
//				String basePath = request.getServletContext().getRealPath("/");
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
		dao.InsertStaff(staffId, staffName, staffComment, staffFileFileName);
		insertMsg = "登録が完了しました。";
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

	public String getInsertMsg() {
		return insertMsg;
	}

	public void setInsertMsg(String insertMsg) {
		this.insertMsg = insertMsg;
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
