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
	<s:form action="AdiminEditAction">
	<table>
	<s:iterator >
	<tr>
		<td>スタイル名</td>
		<td><input type="text" name="styleName"></td>
	</tr>
	<tr>
		<td>性別</td>
		<td>
		<ul>
		<li><input type="radio" name="StyleSex" value="ladies" checked="checked">女性</li>
		<li><input type="radio" name="StyleSex" value="mens">男性</li>
		</ul>
		</td>
	</tr>
	<tr>
	<td>スタイルコメント</td>
	<td><textarea name="styleComment"></textarea></td>
	</tr>
	</s:iterator>
	<tr>
	<td>スタイル写真</td>
	<td></td>
	</tr>
	<tr>
	<td>担当スタッフ</td>
	<s:iterator value="staffList">
	<td><input type="radio" name="staffId" value="<s:property value="staffId"/>"><s:property value="StaffName"/></td>
	</s:iterator>
	</tr>
	<s:hidden name="styleVol" value=""/>
	<tr>
	<td><input type="submit" value="編集完了"></td>
	</tr>
	</table>
	</s:form>
</div>

</body>
</html>