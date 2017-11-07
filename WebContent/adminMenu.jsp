<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- CSSの読み込み -->
<link rel="stylesheet" type="text/css" href="css/adminMaster.css">
<link rel="stylesheet" type="text/css" href="css/adminMenu.css">
<title>adminMenu</title>
</head>
<body>
	<div class="container">
		<!-- header -->
		<jsp:include page="header.jsp" />
		<div class="menu-list">
			<table>
				<thead>
					<tr>
						<th class="id">ID</th>
						<th class="name">メニュー名</th>
						<th class="price">施術料金</th>
						<th class="time">施術時間</th>
					</tr>
				</thead>
				<tbody>
					<s:iterator value="menuList">
						<tr>
							<td class="id"><s:property value="menuId" /></td>
							<td class="name"><s:property value="menuName" /></td>
							<td class="price"><s:property value="menuPrice" /></td>
							<td class="time"><s:property value="menuTime" /></td>
						</tr>
					</s:iterator>
				</tbody>
			</table>
		</div>
		<div class="menuEdit">
		<p style="margin:0; text-align:center;"><s:property value="msg"/></p>
			<div class="menu-insert">
				<s:form action="AdminMenuInsertAction">
					<ul>
						<li>新規登録</li>
						<li>menuId<input type="number" name="menuId"></li>
						<li>menuName<input type="text" name="menuName"></li>
						<li>menuPrice<input type="number" name="menuPrice">円</li>
						<li>menuTime(minute)<input type="number" name="menuTime">分</li>
						<li><input type="submit" value="menu登録"></li>
					</ul>
				</s:form>
			</div>
			<div class="menu-edit">
				<s:form action="AdminMenuEditAction">
					<ul>
						<li>編集</li>
						<li>menuId<input type="number" name="menuId"></li>
						<li>menuName<input type="text" name="menuName"></li>
						<li>menuPrice<input type="number" name="menuPrice">円</li>
						<li>menuTime(minute)<input type="number" name="menuTime">分</li>
						<li><input type="submit" value="menu登録"></li>
					</ul>
				</s:form>
			</div>
			<div class="menu-delete">
					<s:form action="AdminMenuDeleteAction">
						<ul>
							<li>削除</li>
							<li>menuId<input type="number" name="menuId"></li>
							<li><input type="submit" value="menu削除"></li>
						</ul>
					</s:form>
			</div>
		</div>
	</div>
</body>
</html>