<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/master.css">
<meta charset="UTF-8">
<title>style info</title>
</head>
<body>

		<div class="container">
		<!-- ヘッダー ------------------------------>
	<jsp:include page="header.jsp" />

		<s:iterator value="styleList">
			<div class="style">
				<div class="style-Img">
				<img src="<s:property value="styleImg"/>">
				</div>
				<div class="style-data">
					<table>
						<tr>
							<td><s:property value="styleName" /></td>
						</tr>
						<tr>
							<td><s:property value="styleComment" /></td>
						</tr>
					</table>
				</div>
			</div>
		</s:iterator>
		<!-- フッター -->
		<jsp:include page="footer.jsp" />
	</div>
</body>
</html>