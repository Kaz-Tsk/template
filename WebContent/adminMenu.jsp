<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>adminMenu</title>
</head>
<body>
	<div class="container">
		<div class="menu-list">
			<table>
				<s:iterator value="menuList">
					<tr>
						<td><s:property value="menuId" /></td>
						<td><s:property value="menuName" /></td>
						<td><s:property value="menuPrice" /></td>
						<td><s:property value="menuTime" /></td>
					</tr>
				</s:iterator>
			</table>
		</div>
		<div class="menu-insert">
		<table>
				<s:form action="AdminMenuInsertAction">
					<tr>
						<td>menuId:<input type="number" name="menuId"></td>
						<td>menuName:<input type="text" name="menuName"></td>
						<td>menuPrice<input type="number" name="menuPrice">円</td>
						<td>menuTime(minute):<input type="number" name="menuTime">分</td>
						<td><input type="submit" value="menu登録"></td>
					</tr>
				</s:form>
			</table>
		</div>
		<div class="menu-edit">
		<table>
				<s:form action="AdminMenuEditAction">
					<tr>
						<td>menuId:<input type="number" name="menuId"></td>
						<td>menuName:<input type="text" name="menuName"></td>
						<td>menuPrice<input type="number" name="menuPrice">円</td>
						<td>menuTime(minute):<input type="number" name="menuTime">分</td>
						<td><input type="submit" value="menu編集"></td>
					</tr>
				</s:form>
			</table>
		</div>
		<div class="menu-delete">
		<table>
				<s:form action="AdminMenuDeleteAction">
					<tr>
						<td>menuId:<input type="number" name="menuId"></td>
						<td><input type="submit" value="menu削除"></td>
					</tr>
				</s:form>
			</table>
		</div>
	</div>
</body>
</html>