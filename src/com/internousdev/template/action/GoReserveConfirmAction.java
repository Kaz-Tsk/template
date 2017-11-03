package com.internousdev.template.action;

import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Stream;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template.dao.ReserveConfirmDAO;
import com.internousdev.template.dto.MenuDTO;
import com.internousdev.template.dto.StaffDTO;
import com.opensymphony.xwork2.ActionSupport;
/**
 * 予約確認画面へ遷移するアクション
 * @author Kazuyuki Tasaki
 * @version 1.0
 */
public class GoReserveConfirmAction extends ActionSupport implements SessionAware{
	/*
	 * メニューID
	 * @param menuId
	 */
	private String[] menuId=null;
	/**
	 * 予約日
	 * @param reserveDate
	 */
	private String reserveDate=null;
	/**
	 * 変換した予約日
	 * @param rD
	 */
	private String rD;
	/**
	 * 予約時間
	 * @param reserveTime
	 */
	private String reserveTime;
	/**
	 * 施術時間
	 * @param menuTime
	 */
	private int menuTime = 0;
	/**
	 * 担当スタイリストID
	 * @param staffId
	 */
	private int staffId;
	/**
	 * 支払い方法
	 * @param pay
	 */
	private String pay;
	/**
	 * 施術料金の合計金額
	 * @param subPrice
	 */
	private int subPrice = 0;
	/**
	 *スタッフ名
	 *@staffName
	 */
	private String staffName;
	/**
	 * 実行時のメッセージ
	 * @param errorMsg
	 */
	private String errorMsg;
	/**
	 * 予約フラグ
	 * @param reserveFlg
	 */
	private int reserveFlg=0;
	/**
	 * 予約メニュー
	 * @param reserveMenu
	 */
	private String reserveMenu = "";
	/**
	 * セッション情報
	 * @param session
	 */
	private Map<String,Object> session;
	//インスタンス化
	private ReserveConfirmDAO dao = new ReserveConfirmDAO();
	private StaffDTO sdto = new StaffDTO();
	private MenuDTO dto = new MenuDTO();
	private ArrayList<MenuDTO> reserveConfirmList = new ArrayList<MenuDTO>();
	/**
	 * 予約時間が空いてるかチェック、仮予約して遷移するメソッド
	 * @return result 予約可能であれば仮予約してSUCCESS 予約不可であればERROR
	 */
	public String execute(){
		String result = ERROR;
		//予約日とメニューが選択されているかチェック
		if(!(reserveDate.equals("")) && menuId!=null){
			//menuIdを配列で受け取る
			int[] menuId2 =  Stream.of(menuId).mapToInt(Integer::parseInt).toArray();
			//menu情報をDBから取得
			reserveConfirmList = dao.selectReserveConfirm(menuId2);
			//予約日と時間を文字列で連結
			rD = reserveDate.substring(0,10)+" "+reserveTime;
			//menuNameを連結して空白をはさんでひとつにまとめる
			for(int a = 0; a < reserveConfirmList.size(); a++){
				if( a != 0){
					reserveMenu += " ";
				}
				reserveMenu += reserveConfirmList.get(a).getMenuName();
			}
			//時間を計算してmenuTimeに代入
			for(int b=0; b < reserveConfirmList.size(); b++ ){
				menuTime += reserveConfirmList.get(b).getMenuTime();
			}
			//合計金額を計算してsubpriceに代入
			for(int i=0; i < reserveConfirmList.size(); i++ ){
				subPrice += reserveConfirmList.get(i).getMenuPrice();
			}
			////staffIdが０のとき、staffNameに指名なしと記載する。それ以外はスタイリスト名を入れる
			if(staffId==0){
				staffName = "指名なし";
			}else{
				sdto = dao.staffNameSelect(staffId);
				staffName = sdto.getStaffName();
			}
			//予約を仮予約
			if(dao.reserveCheck(rD, menuTime)<=5){
				dao.reserveInsert(reserveMenu,subPrice,menuTime,staffName,pay,(int)session.get("Id"),reserveFlg,rD);
				dto = dao.reserveIdGet((int)session.get("Id"), rD);
				//予約完了時に使用するsessionをセット
				session.put("reserveId", dto.getReserveId());
				session.put("rD",rD);
				session.put("menuTime",menuTime);
				result = SUCCESS;
			}else{
				errorMsg="その予約時間帯は満席です。";
				result = ERROR;
			}
		}else if(reserveDate.equals("")){
			errorMsg="※予約日が選択されてません。";
			return  ERROR;
		}else if(menuId==null){
			errorMsg="※メニューが選択されていません。";
			return ERROR;
		}else{
			errorMsg="※予約日とメニューが選択されていません。";
			result = ERROR;
		}
		return result;
	}
	//以下、setter getter
	/**
	 *
	 * @return menuId
	 */
	public String[] getMenuId() {
		return menuId;
	}
	/**
	 *
	 * @param menuId
	 */
	public void setMenuId(String menuId[]) {
		this.menuId = menuId;
	}
	/**
	 *
	 * @return reserveDate
	 */
	public String getReserveDate() {
		return reserveDate;
	}
	/**
	 *
	 * @param reserveDate
	 */
	public void setReserveDate(String reserveDate) {
		this. reserveDate =  reserveDate;
	}
	/**
	 *
	 * @return reserveTime
	 */
	public String getReserveTime() {
		return reserveTime;
	}
	/**
	 *
	 * @param reserveTime
	 */
	public void setReserveTime(String reserveTime) {
		this.reserveTime = reserveTime;
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
	 * @return menuTime
	 */
	public int getMenuTime() {
		return menuTime;
	}
	/**
	 *
	 * @param menuTime
	 */
	public void setMenuTime(int menuTime) {
		this.menuTime = menuTime;
	}
	/**
	 *
	 * @return pay
	 */
	public String getPay() {
		return pay;
	}
	/**
	 *
	 * @param pay
	 */
	public void setPay(String pay) {
		this.pay = pay;
	}
	/**
	 *
	 * @return subPrice
	 */
	public int getSubPrice() {
		return subPrice;
	}
	/**
	 *
	 * @param subPrice
	 */
	public void setSubPrice(int subPrice) {
		this.subPrice = subPrice;
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
	 * @return errorMsg
	 */
	public String getErrorMsg() {
		return errorMsg;
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