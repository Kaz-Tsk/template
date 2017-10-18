<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Menu</title>
</head>
<body>
	<!-- ヘッダー ------------------------------>
	<jsp:include page="header.jsp" />

	<!-- メニューリスト -->
	<div class="container">
		<div class="menuList">
		<p>menu</p>
			<table>
				<s:iterator value="menuList">
				<tr>
					<td><s:property value="menuName"/></td>
					<td><s:property value="menuPrice"/>円</td>
					<td><s:property value="menuTime"/>分</td>
				</tr>
				</s:iterator>
			</table>
		</div>
	</div>
</body>
</html>