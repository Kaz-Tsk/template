package com.internousdev.template.util;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.internousdev.template.dao.LogOutDAO;
import com.internousdev.template.dao.ReserveComplateDAO;

/**
 * セッションを破棄した時にログアウト処理と仮予約状態の破棄を行うクラス
 * @author Kazuyuki Tasaki
 * @version 1.0
 */
public class TemplateHttpSessionListener implements HttpSessionListener{

		/**
		 * セッションの生成メソッド（セットで記入するため空欄）
		 */
		public void sessionCreated(HttpSessionEvent se){

		}

		/**
		 * セッションが破棄された時に実行するメソッド
		 */
		public void sessionDestroyed(HttpSessionEvent se){
			HttpSession session = se.getSession();
			LogOutDAO LogOutDao = new LogOutDAO();
			ReserveComplateDAO reserveComplateDao = new ReserveComplateDAO();
			LogOutDao.logOutFlg((int)session.getAttribute("Id"));
			reserveComplateDao.reserveReset((int)session.getAttribute("reserveId"));
		}
}
