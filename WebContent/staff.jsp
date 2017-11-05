<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/master.css">
<link rel="stylesheet" type="text/css" href="css/staff.css">
<title>staff</title>
</head>
<body>
	<!-- staff -->
	<div id="container">
		<!-- ヘッダー ------------------------------>
		<jsp:include page="header.jsp" />
		<h2 style="text-align:center">staff</h2>
		<div class="container-outer">
			<div class="staff-container">
				<s:iterator value="staffList">
					<div class="staff">
						<img src="<s:property value="staffImg"/>">
							<table>
								<tr>
									<td><s:property value="staffName" /></td>
								</tr>
								<tr>
									<td><s:property value="staffComment" /></td>
								</tr>
							</table>
						</div>
				</s:iterator>
			</div>
		</div>
		<!-- フッター -->
		<jsp:include page="footer.jsp" />
	</div>
</body>
</html>