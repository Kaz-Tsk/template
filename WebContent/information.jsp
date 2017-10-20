<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/master.css">
<meta charset="UTF-8">
<title>information</title>
</head>
<body>
	<div id="container">
		<!-- ヘッダー ------------------------------>
		<jsp:include page="header.jsp" />
		<div class="salon-date">
			<p>営業日・時間</p>
			<s:iterator value="salonDataList">
				<table>
					<tr>
						<td><s:property value="salonWeek" /></td>
						<td><s:property value="salonHour" /></td>
					</tr>
				</table>
			</s:iterator>
		</div>

		<div class="salon-addtel">
			<table>
				<tr>
					<th>住所</th>
					<th>電話番号</th>
				</tr>
				<s:iterator value="salonDataList">
					<tr>
						<td><s:property value="salonAddress" /></td>
						<td><s:property value="salonTel" /></td>
					</tr>
				</s:iterator>
			</table>
		</div>
		<!-- フッター -->
		<jsp:include page="footer.jsp" />
	</div>
</body>
</html>