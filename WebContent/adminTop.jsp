<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- CSSの読み込み -->
<link rel="stylesheet" type="text/css" href="css/adminMaster.css">
<link rel="stylesheet" type="text/css" href="css/adminTop.css">
<title>adiminTop</title>
</head>
<body>
	<div id="container">
		<!-- header -->
		<jsp:include page="header.jsp" />
		<div class="admin-navi">
			<ul>
				<li><a href="<s:url action='GoAdminInfoAction'/>">SalonInfo管理</a></li>
				<li><a href="<s:url action='GoAdminStyleAction'/>">Style管理</a></li>
				<li><a href="<s:url action='GoAdminStaffAction'/>">Staff管理</a></li>
				<li><a href="<s:url action='GoAdminMenuAction'/>">Menu管理</a></li>
				<li><a href="<s:url action='GoAdminReserveAction'/>">Reserve管理</a></li>
			</ul>
		</div>
	</div>

</body>
</html>