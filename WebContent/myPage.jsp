<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>mypage</title>
</head>
<body>
	<!-- ヘッダー ------------------------------>
	<jsp:include page="header.jsp" />

	<!-- ユーザー情報 -->
	<div class="container">
		<h2>ユーザー情報</h2>
		<table>
			<tr>
				<td>名前</td>
				<td><s:property value="userName" /></td>
			</tr>
			<tr>
				<td>電話番号</td>
				<td><s:property value="telNumber" /></td>
			</tr>
			<tr>
				<td>メールアドレス</td>
				<td><s:property value="eMail" /></td>
			</tr>
			<tr>
				<td>住所</td>
				<td><s:property value="address" /></td>
			</tr>
			<tr>
				<td>登録日</td>
				<td><s:property value="insertDate" /></td>
			</tr>
		</table>
		<br>
		<s:form action="GoReserveHistoryAction">
			<button type="submit">予約履歴</button>
		</s:form>
	</div>
</body>
</html>