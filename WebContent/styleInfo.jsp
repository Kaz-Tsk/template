<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/master.css">
<link rel="stylesheet" type="text/css" href="css/styleInfo.css">
<meta charset="UTF-8">
<title>style info</title>
</head>
<body>

	<div id="container">
		<!-- ヘッダー ------------------------------>
		<jsp:include page="header.jsp" />
		<div class="head-space"></div>
			<div class="style">
				<div class="style-Img">
					<img src="<s:property value="styleImg"/>">
				</div>
				<div class="style-data">

					<table>
						<tr>
							<td class="tag">Stylist:</td>
							<td><s:property value="staffName" /></td>
						</tr>
						<tr>
							<td class="tag">Style Name:</td>
							<td><s:property value="styleName" /></td>
						</tr>
						<tr>
							<td class="tag">Comment:</td>
							<td><s:property value="styleComment" /></td>
						</tr>
					</table>
				</div>
			</div>
		<!-- フッター -->
		<jsp:include page="footer.jsp" />
	</div>
</body>
</html>