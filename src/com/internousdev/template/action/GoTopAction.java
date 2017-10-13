package com.internousdev.template.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * index.jspに遷移するアクション
 * @author Kazuyuki Tasaki
 *@return result
 */
public class GoTopAction extends ActionSupport {

	public String execute(){
		return  SUCCESS;
	}
}
