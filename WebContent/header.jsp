<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/header.css">
<link rel="stylesheet" type="text/css" href="css/master.css">
<title>header</title>
</head>
<body>
<!-- ログイン前ヘッダー -->
	<div class="header">
	<s:if test="#session.userFlg==null">
		<div class="logo">template</div>
		<div class="navi">
			<div class="navi-box"><a href="LoginAction">login</a></div>
			<div class="navi-box">infomation</div>
			<div class="navi-box"><a href="GoMenuAction">menu</a></div>
			<div class="navi-box">staff</div>
			<div class="navi-box">style</div>
		</div>
	</s:if>

	<s:elseif test="#session.userFlg==1">
		<div class="logo">template</div>
		<div class="navi">
			<div class="navi-box"><a href="GoReserveAction">reserve</a></div>
			<div class="navi-box">infomation</div>
			<div class="navi-box"><a href="GoMenuAction">menu</a></div>
			<div class="navi-box">staff</div>
			<div class="navi-box">style</div>
		</div>
	</s:elseif>
	</div>
</body>
</html>