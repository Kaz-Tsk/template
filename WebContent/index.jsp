<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- css読み込み -->
<link rel="stylesheet" type="text/css" href="css/master.css">
<link rel="stylesheet" type="text/css" href="css/index.css">
<!-- jQuery読み込み -->
<script src="js/jquery-3.2.1.min.js"></script>
<script src="js/fadein.js"></script>
<title>Index</title>
</head>
<body>
	<div id="container">
		<!-- ヘッダー ------------------------------>
		<jsp:include page="header.jsp" />
		<div class="head-space"></div>

		<div class="salon-name">
			<h1 class="salon-template">template</h1>
			<h3 class="salon-concept">The special quality skills...for all
				of beauty.</h3>
		</div>

		<!--informationテーブル-->
		<div class="information">
			<p>salon information</p>
			<div class="info-table">
				<table>
					<s:iterator value="salonInfoList">
						<tr>
							<td><s:property value="day" /></td>
							<td><s:property value="text" /></td>
						</tr>
					</s:iterator>
				</table>
			</div>
		</div>
		<!-- フッター -->
		<jsp:include page="footer.jsp" />
	</div>
</body>
</html>