<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- css読み込み -->
<link rel="stylesheet" type="text/css" href="css/master.css">

<title>Index</title>
</head>
<body>
	<div id="container">
		<!-- ヘッダー ------------------------------>
		<jsp:include page="header.jsp" />

		<!--informationテーブル-->
		<div class="information">
			<p>salon information</p>
			<table>
				<s:iterator value="salonInfoList">
					<tr>
						<td><s:property value="insertDate" /></td>
						<td><s:property value="salonInfo" /></td>
					</tr>
				</s:iterator>
			</table>
		</div>

		<!-- フッター -->
		<jsp:include page="footer.jsp" />
	</div>
</body>
</html>