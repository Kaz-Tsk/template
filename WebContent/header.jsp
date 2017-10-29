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
		<s:if test="#session.userFlg==2">
			<div class="navi">
				<div class="navi-box"><a href="LogOutAction">ログアウト</a></div>
				<div class="navi-box"><a href="GoAdiminReserveAction">予約管理</a></div>
				<div class="navi-box"><a href="GoAdminMenuAction"></a>メニュー管理</div>
				<div class="navi-box"><a href="GoAdiminStaffAction"></a>スタッフ管理</div>
				<div class="navi-box"><a href="GoAdminStyleAction">スタイル管理</a></div>
				<div class="navi-box"><a href="GoAdiminInfoAction">お知らせ管理</a></div>
				<div class="navi-box"><a class="logo" href="GoAdminTopAction"><img src="img/logo.png"></a></div>
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
		<s:else>
			<div class="navi">
				<div class="navi-box"><a href="login.jsp">login</a></div>
				<div class="navi-box"><a href="GoInformationAction">information</a></div>
				<div class="navi-box"><a href="GoMenuAction">menu</a></div>
				<div class="navi-box"><a href="GoStaffAction">staff</a></div>
				<div class="navi-box"><a href="GoStyleAction">style</a></div>
				<div class="navi-box"><a class="logo" href="GoTopAction"><img src="img/logo.png"></a></div>
			</div>
		</s:else>
</header>
</body>
</html>