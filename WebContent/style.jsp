<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>style</title>
</head>

<body>
<!-- ヘッダー ------------------------------>
	<jsp:include page="header.jsp" />

	<!-- staff -->
	<div class="container">
		<s:iterator value="styleList">
			<div class="style">
				<div class="style-Img">
				<a href="<s:url value="GoStyleInfoAction"><s:param name="styleId" value="%{styleId}"/></s:url>
				<img src="<s:property value="styleImg"/>">"><s:hidden value="styleId"/></a>
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
	</div>
</body>
</html>