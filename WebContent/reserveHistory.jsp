<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>reserveHistory</title>
</head>
<body>
	<div id="container">
		<s:property value="message" />
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
					<td><s:property value="reservePrice" /></td>
					<td><s:property value="reserveStaff" /></td>
					<td><s:property value="reserveStartDate" /></td>
				</tr>
			</s:iterator>
		</table>
	</div>
</body>
</html>