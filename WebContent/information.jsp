<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/master.css">
<link rel="stylesheet" type="text/css" href="css/information.css">
<meta charset="UTF-8">
<title>information</title>
</head>
<body>
	<div id="container">
		<!-- ヘッダー ------------------------------>
		<jsp:include page="header.jsp" />
		<div class="salon-date">
		<div class="head-space"></div>
			<table>
				<tr>
					<td colspan="2">営業日・時間</td>
				</tr>
				<s:iterator value="salonDataList">
				<tr>
					<td><s:property value="salonWeek" /></td>
					<td><s:property value="salonHour" /></td>
				</tr>
				</s:iterator>
			</table>

		</div>

		<div class="salon-addtel">
			<p>Salon Tel</p>
			<s:iterator value="salonDataList">
				<p>
					<s:property value="salonTel" />
				</p>
			</s:iterator>
			<p>Salon Add</p>
			<s:iterator value="salonDataList">
				<p>
					<s:property value="salonAddress" />
				</p>
			</s:iterator>
		</div>
		<!-- フッター -->
		<jsp:include page="footer.jsp" />
	</div>
</body>
</html>