package com.internousdev.template.action;

import java.util.Date;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template.dao.MyPageDAO;
import com.internousdev.template.dto.UserDTO;
import com.opensymphony.xwork2.ActionSupport;
/**
 * マイページへ遷移するアクション
 * @author Kazuyuki Tasaki
 * @version 1.0
 */
public class GoMyPageAction  extends ActionSupport implements SessionAware{
	/**
	 *ユーザー名
	 *@param userName
	 */
	private String userName;
	/**
	 * 電話番号
	 * @param telNumber
	 */
	private String telNumber;
	/**
	 * メールアドレス
	 * @param eMail
	 */
	private String eMail;
	/**
	 * 住所
	 * @param address
	 */
	private String address;
	/**
	 * 登録日
	 * @insertDate
	 */
	private Date insertDate;
	/**
	 *セッション
	 *@param session
	 */
	private Map<String,Object> session;
	//インスタンス化
	private UserDTO dto = new UserDTO();
	private MyPageDAO dao = new MyPageDAO();
	/**
	 * ユーザー情報を取得してページ遷移をするメソッド
	 * @return result ID情報が取得できていればSUCCESS できなければERROR
	 */
	public String execute() {
		String result = ERROR;
		//セッション情報からユーザー情報を取得
		dto = dao.myPageSelect((int)session.get("Id"));
		if(session.get("Id")!=null) {
			userName = dto.getUserName();
			telNumber = dto.getTelNumber();
			eMail = dto.getEMail();
			address = dto.getAddress();
			insertDate = dto.getInsertDate();
			return SUCCESS;
		}
		return result;
	}
	//以下、setter getter
	/**
	 *
	 * @return userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 *
	 * @param userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 *
	 * @return telNumber
	 */
	public String getTelNumber() {
		return telNumber;
	}
	/**
	 *
	 * @param telNumber
	 */
	public void setTelNumber(String telNumber) {
		this.telNumber = telNumber;
	}
	/**
	 *
	 * @return eMail
	 */
	public String geteMail() {
		return eMail;
	}
	/**
	 *
	 * @param eMail
	 */
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	/**
	 *
	 * @return address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 *
	 * @param address
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 *
	 * @return insertDate
	 */
	public Date getInsertDate() {
		return insertDate;
	}
	/**
	 *
	 * @param insertDate
	 */
	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}
	/**
	 *
	 * @param session
	 */
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
