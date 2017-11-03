<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/master.css">
<link rel="stylesheet" type="text/css" href="css/menu.css">
<title>Menu</title>
</head>
<body>


	<!-- メニューリスト -->
	<div id="container">
		<!-- ヘッダー ------------------------------>
		<jsp:include page="header.jsp" />
		<div class="menuList">
			<div class="head-space"></div>
			<h2>menu</h2>
			<div class="menu-table">
				<table>
					<tr>
						<td colspan="3" style="text-align: center;">All in Tax</td>
					</tr>
					<s:iterator value="menuList">
						<tr>
							<td><s:property value="menuName" /></td>
							<td><s:property value="menuPrice" />円</td>
							<td><s:property value="menuTime" />分</td>
						</tr>
					</s:iterator>
				</table>
			</div>
		</div>
		<!-- フッター -->
		<jsp:include page="footer.jsp" />
	</div>
</body>
</html>