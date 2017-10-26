package com.internousdev.template.util;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.internousdev.template.dao.LogOutDAO;
import com.internousdev.template.dao.ReserveComplateDAO;


public class TemplateHttpSessionListener implements HttpSessionListener{
		public void sessionCreated(HttpSessionEvent se){

		}

		public void sessionDestroyed(HttpSessionEvent se){
			HttpSession session = se.getSession();
			LogOutDAO LogOutDao = new LogOutDAO();
			ReserveComplateDAO reserveComplateDao = new ReserveComplateDAO();
			LogOutDao.logOutFlg((int)session.getAttribute("Id"));
			reserveComplateDao.reserveReset((int)session.getAttribute("reserveId"));
		}
}
