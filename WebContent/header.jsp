<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/header.css">
<meta charset="UTF-8">
<title>header</title>
</head>
<body>
<!-- ヘッダー -->
	<header>
		<s:if test="#session.userFlg==2">
		<ul id="navi">
			<li class="admin logo"><a href="<s:url action="GoAdminTopAction"/>"><img src="img/logo.png"></a></li>
			<li class="admin"><a href="<s:url action="GoAdminInfoAction"/>">SalonInfo管理</a></li>
			<li class="admin"><a href="<s:url action="GoAdminStyleAction"/>">HairStyle管理</a></li>
			<li class="admin"><a href="<s:url action="GoAdminStaffAction"/>">Staff管理</a></li>
			<li class="admin"><a href="<s:url action="GoAdminMenuAction"/>">Menu管理</a></li>
			<li class="admin"><a href="<s:url action="GoAdminReserveAction"/>">Reserve管理</a></li>
			<li class="admin"><a href="<s:url action="LogOutAction"/>">Logout</a></li>
		</ul>
		</s:if>

		<s:elseif test="#session.userFlg==1">
		<ul id="navi">
			<li class="login logo"><a href="<s:url action="GoTopAction"/>"><img src="img/logo.png"></a></li>
			<li class="login"><a href="<s:url action="GoStyleAction"/>">Style</a></li>
			<li class="login"><a href="<s:url action="GoStaffAction"/>">Staff</a></li>
			<li class="login"><a href="<s:url action="GoMenuAction"/>">Menu</a></li>
			<li class="login"><a href="<s:url action="GoInformationAction"/>">Information</a></li>
			<li class="login"><a href="<s:url action="GoMyPageAction"/>">Mypage</a></li>
			<li class="login"><a href="<s:url action="GoReserveAction"/>">Reserve</a></li>
			<li class="login"><a href="<s:url action="LogOutAction"/>">Logout</a></li>
		</ul>
		</s:elseif>
		<s:else>
		<ul id="navi">
			<li class="default logo"><a href="<s:url action="GoTopAction"/>"><img src="img/logo.png"></a></li>
			<li class="default"><a href="<s:url action="GoStyleAction"/>">Style</a></li>
			<li class="default"><a href="<s:url action="GoStaffAction"/>">Staff</a></li>
			<li class="default"><a href="<s:url action="GoMenuAction"/>">Menu</a></li>
			<li class="default"><a href="<s:url action="GoInformationAction"/>">Information</a></li>
			<li class="default"><a href="login.jsp">Login</a></li>
		</ul>
		</s:else>
</header>
</body>
</html>