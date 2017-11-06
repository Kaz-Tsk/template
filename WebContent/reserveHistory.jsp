<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- CSSの読み込み -->
<link rel="stylesheet" type="text/css" href="css/master.css">
<link rel="stylesheet" type="text/css" href="css/reserveHistory.css">

<title>reserveHistory</title>
</head>
<body>
	<div id="container">
		<!-- header -->
		<jsp:include page="header.jsp" />
		<div class="reserve-history">
		<s:property value="message" />
		<h2>Reserve History</h2>
		<table>
			<tr>
				<th>メニュー</th>
				<th>金額</th>
				<th>担当スタイリスト</th>
				<th>来店日</th>
			</tr>
			<s:iterator value="reserveHistoryList">
				<tr>
					<td><s:property value="reserveMenu" /></td>
					<td><fmt:formatNumber value="${reservePrice}" pattern="###,###,###" />円</td>
					<td><s:property value="reserveStaff" /></td>
					<td><s:property value="reserveStartDate" /></td>
				</tr>
			</s:iterator>
		</table>
		</div>
	</div>
</body>
</html>