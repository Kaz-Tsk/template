<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/master.css">
<link rel="stylesheet" type="text/css" href="css/reserveConfirm.css">
<title>reserveConfirm</title>
</head>
<body>

	<div id="container">
	<!-- ヘッダー -->
	<jsp:include page="header.jsp" />
		<div class="reserve-confirm">
			<h3>以下の内容で予約を確定してよろしいですか？</h3>
			<table>
				<tr>
					<td class="field">予約日時</td>
				</tr>
				<tr>
					<td><s:property value="reserveDate"/><s:property value="reserveTime"/></td>
				</tr>
				<tr>
					<td class="field">メニュー</td>
				</tr>
				<tr>
					<td><s:property value="reserveMenu"/></td>
				</tr>
				<tr>
					<td class="field">施術時間</td>
				</tr>
				<tr>
					<td><s:property value="menuTime"/>分</td>
				</tr>
				<tr>
					<td class="field">金額</td>
				</tr>
				<tr>
					<td><fmt:formatNumber value="${subPrice}" pattern="###,###,###" />円</td>
				</tr>
				<tr>
					<td class="field">スタイリスト指名</td>
				</tr>
				<tr>
					<td><s:property value="staffName"/></td>
				</tr>
				<tr>
					<td class="field">支払い方法</td>
				</tr>
				<tr>
					<td><s:property value="pay"/></td>
				</tr>
			</table>
			<s:form action="GoReserveComplateAction">
				<input type="submit" value="予約完了">
			</s:form>
			<input type="button" onClick="location.href='<s:url action="GoReserveAction"/>'" value="変更する">
		</div>
		<!-- フッター -->
		<jsp:include page="footer.jsp" />
	</div>
</body>
</html>