<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- CSSの読み込み -->
<link rel="stylesheet" type="text/css" href="css/adminMaster.css">
<link rel="stylesheet" type="text/css" href="css/adminReserve.css">
<title>adminReserve</title>
</head>
<body>
	<div id="container">
		<!-- header -->
		<jsp:include page="header.jsp" />
		<div class="reserve-list">
			<div class="reserve-search">
				<p style="margin: 0; font-size:15px;">検索</p>
				<s:property value="msg" />
				<s:form action="AdminReserveSearchAction">
					<input type="text" name="searchName" placeholder="ユーザー名">
					<input type="month" name="searchDate">
					<input type="submit" value="検索する">
				</s:form>
			</div>
			<table>
				<thead>
					<tr>
						<th class="menu">メニュー</th>
						<th class="price">施術料金</th>
						<th class="time">施術時間</th>
						<th class="staff">担当</th>
						<th class="pay">支払方法</th>
						<th class="user">顧客指名</th>
						<th class="reserve-in">予約時間</th>
						<th class="reserve-out">退店時間</th>
						<th class="reserve-day">予約決定日</th>
					</tr>
				</thead>

				<tbody>
					<s:iterator value="reserveList">
						<tr>
							<td class="menu"><s:property value="reserveMenu" /></td>
							<td class="price"><s:property value="reservePrice" /></td>
							<td class="time"><s:property value="reserveTime" /></td>
							<td class="staff"><s:property value="reserveStaff" /></td>
							<td class="pay"><s:property value="reservePay" /></td>
							<td class="user"><s:property value="reserveUserName" /></td>
							<td class="reserve-in"><s:property value="reserveStartDate" /></td>
							<td class="reserve-out"><s:property value="reserveEndDate" /></td>
							<td class="reserve-day"><s:property value="reserveInsertDate" /></td>
							<td class="reserve-delete">
								<s:form action="AdminReserveDeleteAction">
									<button name="reserveId" value="<s:property value="reserveId"/>">削除</button>
								</s:form>
							</td>
						</tr>
					</s:iterator>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>