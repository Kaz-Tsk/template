<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>reserveConfirm</title>
</head>
<body>
<!-- ヘッダー ------------------------------>
	<jsp:include page="header.jsp" />
	<div class="container">
		<div class="reserve-confirm">
			<p>以下の内容で予約を確定してよろしいですか？</p>
			<table>

				<tr>
					<td>予約日時</td>
				</tr>
				<tr>
					<td><s:property value="reserveDate"/></td>
					<td><s:property value="reserveTime"/></td>
				</tr>
				<tr>
					<td>メニュー</td>
				</tr>
				<s:iterator value="reserveConfirmList">
				<tr>
					<td><s:property value="menuName"/></td>
				</tr>
				</s:iterator>
				<tr>
					<td>金額</td>
				</tr>
				<tr>
					<td><s:property value="subPrice"/></td>
				</tr>
				<tr>
					<td>スタイリスト指名</td>
				</tr>
				<tr>
					<td><s:property value="staffName"/></td>
				</tr>
				<tr>
					<td>支払い方法</td>
				</tr>
				<tr>
					<td><s:property value="pay"/></td>
				</tr>

				<input type="submit" value="">
			</table>
		</div>
	</div>
</body>
</html>