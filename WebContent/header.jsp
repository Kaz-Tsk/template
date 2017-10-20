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
<!-- ログイン前ヘッダー -->
	<header>
		<s:if test="#session.userFlg==null || #session.userFlg==0">
			<div class="navi">
				<div class="navi-box before"><a href="login.jsp">login</a></div>
				<div class="navi-box before"><a href="GoInformationAction">information</a></div>
				<div class="navi-box before"><a href="GoMenuAction">menu</a></div>
				<div class="navi-box before" ><a href="GoStaffAction">staff</a></div>
				<div class="navi-box before"><a href="GoStyleAction">style</a></div>
				<div class="navi-box before"><a class="logo" href="GoTopAction"><img src="img/logo.png"></a></div>
			</div>
		</s:if>

		<s:elseif test="#session.userFlg==1">
			<div class="navi">
				<div class="navi-box"><a href="LogOutAction">logout</a></div>
				<div class="navi-box"><a href="GoReserveAction">reserve</a></div>
				<div class="navi-box"><a href="GoInformationAction">information</a></div>
				<div class="navi-box"><a href="GoMenuAction">menu</a></div>
				<div class="navi-box"><a href="GoStaffAction">staff</a></div>
				<div class="navi-box"><a href="GoStyleAction">style</a></div>
				<div class="navi-box"><a class="logo" href="GoTopAction"><img src="img/logo.png"></a></div>
			</div>
		</s:elseif>
</header>
</body>
</html>