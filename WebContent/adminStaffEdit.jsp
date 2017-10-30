<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>adminStaffEdit</title>
</head>
<body>
<div class="container">
	<s:iterator>
	<div class="staff">
	<img src="<s:property value="staffImg"/>">
	<s:property value="staffName"/>
	<s:property value="staffComment"/>
	</div>
	</s:iterator>
	<s:property value="editMsg"/>
	<div class="staff-edit">
	<s:form action="AdminStaffEditAction" enctype="multipart/form-data">
	<table>
	<s:iterator value="staffList">
	<tr>
		<td><input type="text" name="staffName" value="<s:property value="staffName"/>"><input type="hidden" name="staffId" value="<s:property value="staffId"/>"></td>
	</tr>
	<tr>
		<td><textarea name="staffComment"><s:property value="staffComment"/></textarea></td>
	</tr>
	</s:iterator>
	<tr>
		<td><input type="file" name="staffFile" accept="image/*"></td>
	</tr>
	<tr>
		<td><input type="submit" value="編集する"></td>
	</tr>
	</table>
	</s:form>
	</div>
</div>
</body>
</html>