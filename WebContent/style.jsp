<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/master.css">
<link rel="stylesheet" type="text/css" href="css/style.css">

<title>style</title>
</head>

<body>

	<!-- staff -->
	<div id="container">
		<!-- ヘッダー ------------------------------>
		<jsp:include page="header.jsp" />


			<div class="style">
			<s:iterator value="styleList">
				<div class="style-Img">
					<a
						href="<s:url action="GoStyleInfoAction"><s:param name="styleId" value="%{StyleId}"/></s:url>">
						<img src="<s:property value="StyleImg"/>">
					<s:hidden value="styleId" />
					</a>
					<div class="style-data">
					<table>
						<tr>
							<td><s:property value="styleName" /></td>
						</tr>
					</table>
				</div>
				</div>

				</s:iterator>
			</div>

		<!-- フッター -->
		<jsp:include page="footer.jsp" />
	</div>
</body>
</html>