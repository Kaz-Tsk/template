package com.internousdev.template.action;



import com.internousdev.template.dao.GoStyleInfoDAO;
import com.internousdev.template.dto.StyleDTO;
import com.opensymphony.xwork2.ActionSupport;
/**
 * スタイル詳細ページへ遷移するアクション
 * @author Kazuyuki Tasaki
 * @version 1.0
 */
public class GoStyleInfoAction extends ActionSupport {

	/**
	 * スタイルvol
	 * @param styleVol
	 */
	private int styleVol;

	/**
	 *スタイル名
	 *@param staffName
	 */
	private String styleName;

	/**
	 * スタイル紹介文
	 * @param styleComment
	 */
	private String styleComment;

	/**
	 * 担当スタイリスト名
	 * @param staffName
	 */
	private String staffName;

	/**
	 * スタイル画像
	 * @param styleImg
	 */
	private String styleImg;

	//インスタンス化
	/**
	 * スタイル詳細情報を取得するDAO
	 * @param dao
	 */
	private GoStyleInfoDAO dao = new GoStyleInfoDAO();

	/**
	 * スタイル詳細dto
	 * @param dto
	 */
	private StyleDTO dto = new StyleDTO();

	/**
	 * スタイル詳細を取得して遷移するメソッド
	 * @return SUCCESS
	 */
	public String execute(){
		dto = dao.styleSelect(styleVol);
		styleName = dto.getStyleName();
		styleComment = dto.getStyleComment();
		staffName = dto.getStaffName();
		styleImg = dto.getStyleImg();
		return  SUCCESS;
	}


	//以下、setter getter

	/**
	 *
	 * @return styleVol
	 */
	public int getStyleVol(){
		return styleVol;
	}

	/**
	 *
	 * @param styleVol
	 */
	public void setStyleVol(int styleVol){
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
	 * @return styleImg
	 */
	public String getStyleImg() {
		return styleImg;
	}

	/**
	 *
	 * @param styleImg
	 */
	public void setStyleImg(String styleImg) {
		this.styleImg = styleImg;
	}
}
