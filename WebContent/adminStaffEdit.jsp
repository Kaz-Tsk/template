<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/adminMaster.css">
<link rel="stylesheet" type="text/css" href="css/adminStaffEdit.css">
<meta charset="UTF-8">
<title>adminStaffEdit</title>
</head>
<body>
	<div class="container">
		<!-- header -->
		<jsp:include page="header.jsp" />
		<div class="staff">
			<img src="<s:property value="staffImg"/>">
		</div>
		<div class="staff-edit">
			<p>
				<s:property value="editMsg" />
			</p>
			<s:form action="AdminStaffEditAction" enctype="multipart/form-data">
				<table>
					<tr>
						<td>スタッフ名</td>
						<td><input type="text" name="staffName"
							value="<s:property value="staffName"/>"><input
							type="hidden" name="staffId"
							value="<s:property value="staffId"/>"></td>
					</tr>
					<tr>
						<td>紹介文</td>
						<td><textarea name="staffComment"><s:property
									value="staffComment" /></textarea></td>
					</tr>
					<tr>
						<td>スタッフ画像</td>
						<td><input type="file" name="staffFile"
							accept="image/*"></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="編集する"></td>
					</tr>
				</table>
			</s:form>
		</div>
		<div class="staff-delete">
			<s:property value="deleteMsg" />
			<s:form action="AdminStaffDeleteAction">
				<input type="submit" value="削除する">
				<input type="hidden" name="staffId"
					value="<s:property value="staffId"/>">
			</s:form>
		</div>
	</div>
</body>
</html>