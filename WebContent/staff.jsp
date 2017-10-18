<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>staff</title>
</head>
<body>
	<!-- ヘッダー ------------------------------>
	<jsp:include page="header.jsp" />

	<!-- staff -->
	<div class="container">
		<s:iterator value="staffList">
			<div class="staff">
				<div class="staff-Img">
				<img src="<s:property value="staffImg"/>">
				</div>
				<div class="staff-data">
					<table>
						<tr>
							<td><s:property value="staffName" /></td>
						</tr>
						<tr>
							<td><s:property value="staffComment" /></td>
						</tr>
					</table>
				</div>
			</div>
		</s:iterator>
	</div>
</body>
</html>