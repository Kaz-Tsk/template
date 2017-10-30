<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>adminStaff</title>
</head>
<body>
<div class="container">
	<div class="stafflist">
	<s:iterator value="staffList">
		<div class="staff">
		<img src="<s:property value="staffImg"/>">
		<s:property value="staffId"/>
		</div>
	</s:iterator>
	</div>

	<div class="staff-insert">
		<table>
		<s:form action="AdminStaffInsertAction" enctype="multipart/form-data">
			<tr>
				<td><input type="number" name="staffId"></td>
			</tr>
			<tr>
				<td><input type="text" name="staffName"></td>
			</tr>
			<tr>
				<td><textarea name="staffComment"></textarea></td>
			</tr>
			<tr>
				<td><input type="file" name="staffFile" accept="image/*"></td>
			</tr>
			<tr>
				<td><input type="submit" value="登録する"></td>
			</tr>
		</s:form>
		</table>
	</div>
	<div class="staff-edit">
		<table>
		<s:form action="GoAdminStaffEditAction">
			<tr>
				<td><input type="number" name="staffId"></td>
			</tr>
			<tr>
				<td><input type="submit" value="編集する"></td>
			</tr>
		</s:form>
		</table>
	</div>
	<div class="staff-delete">
	<s:property value="deleteMsg"/>
		<table>
		<s:form action="AdminStaffDeleteAction">
			<tr>
				<td><input type="number" name="staffId"></td>
			</tr>
			<tr>
				<td><input type="submit" value="削除する"></td>
			</tr>
		</s:form>
		</table>
	</div>
</div>
</body>
</html>