<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>adminReserve</title>
</head>
<body>
<div class="container">
	<div class="reserve-list">
		<table>
		<tr>
				<td>予約Id</td>
				<td>メニュー</td>
				<td>施術料金</td>
				<td>施術時間></td>
				<td>担当スタイリスト</td>
				<td>支払い方法</td>
				<td>顧客指名</td>
				<td>予約時間</td>
				<td>退店時間</td>
				<td>予約決定日</td>
			</tr>
		<s:iterator 	value="reserveList">
			<tr>
				<td><s:property value="reserveId"/></td>
				<td><s:property value="reserveMenu"/></td>
				<td><s:property value="reservePrice"/></td>
				<td><s:property value="reserveTime"/></td>
				<td><s:property value="reserveStaff"/></td>
				<td><s:property value="reservePay"/></td>
				<td><s:property value="reserveUserName"/></td>
				<td><s:property value="reserveStartDate"/></td>
				<td><s:property value="reserveEndDate"/></td>
				<td><s:property value="reserveInsertDate"/></td>
			</tr>
		</s:iterator>
		</table>
	</div>
	<div class="reserve-delete">
	<s:property value="deleteMsg"/>
		<table>
		<s:form action="AdminReserveDeleteAction">
		<tr>
			<td><input type="number" name="reserveId"></td>
			<td><input type="submit" value="削除する"></td>
		</tr>
		</s:form>
		</table>
	</div>

</div>
</body>
</html>