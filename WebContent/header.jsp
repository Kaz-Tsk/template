<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/header.css">
<link rel="stylesheet" type="text/css" href="css/master.css">
<title>header</title>

<style type="text/css">
<!--
a:link { color:#fff; text-decoration:none }
a:visited { color:#fff; text-decoration:none }
a:hover { color:#fff; text-decoration:none }
a:active { color:#fff; text-decoration:none }
-->
</style>
</head>
<body>
<!-- ログイン前ヘッダー -->
	<div class="header">
	<s:if test="#session.userFlg==null">
		<div class="logo"><a href="GoTopAction">template</a></div>
		<div class="navi">
			<div class="navi-box"><a href="LoginAction">login</a></div>
			<div class="navi-box"><a href="GoInformationAction">information</a></div>
			<div class="navi-box"><a href="GoMenuAction">menu</a></div>
			<div class="navi-box"><a href="GoStaffAction">staff</a></div>
			<div class="navi-box"><a href="GoStyleAction">style</a></div>
		</div>
	</s:if>

	<s:elseif test="#session.userFlg==1">
		<div class="logo"><a href="GoTopAction">template</a></div>
		<div class="navi">
			<div class="navi-box"><a href="GoReserveAction">reserve</a></div>
			<div class="navi-box"><a href="GoInformationAction">information</a></div>
			<div class="navi-box"><a href="GoMenuAction">menu</a></div>
			<div class="navi-box"><a href="GoStaffAction">staff</a></div>
			<div class="navi-box"><a href="GoStyleAction">style</a></div>
		</div>
	</s:elseif>
	</div>
</body>
</html>