<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>adminStyleEdit</title>
</head>
<body>
<div class="container">
	<p>編集中のスタイル</p>
	<s:iterator value="styleList">
	<img src="<s:property value="styleImg"/>">
	<p><s:property value="styleName"/></p>
	<p><s:property value="styleSex"/></p>
	<p><s:property value="styleComment"/></p>
	<p><s:property value="staffName"/></p>
	</s:iterator>
	<p><s:property value="editMsg"/></p>
	<s:form action="AdminStyleEditAction" enctype="multipart/form-data">
	<table>
	<s:iterator value="styleList">
	<tr>
		<td>スタイル名</td>
		<td><input type="text" name="styleName" value="<s:property value="styleName"/>"></td>
	</tr>
	<tr>
	<td>スタイルコメント</td>
	<td><textarea name="styleComment"><s:property value="styleComment"/></textarea></td>
	</tr>
	</s:iterator>
	<tr>
	<td>スタイル写真</td>
	<td><input type="file" name="StyleFile" accept="image/*"></td>
	</tr>
	<tr>
	<td>担当スタッフ</td>
	<s:iterator value="staffList">
	<td><input type="radio" name="staffId" value="<s:property value="staffId"/>"><s:property value="StaffName"/></td>
	</s:iterator>
	</tr>
	<tr>
	<td><input type="hidden" name="styleVol" value="<s:property value="styleVol"/>"><input type="submit" value="編集完了"></td>
	</tr>
	</table>
	</s:form>
</div>

</body>
</html>