<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>adminStyle</title>
</head>
<body>
	<div class="container">
		<div class="style-isnert">
			<table>
				<tr>
					<td>スタイルの追加</td>
				</tr>
				<tr>
					<td>スタイルNo</td>
					<td><input type="text" name="stylelVol"></td>
				</tr>
				<tr>
					<td>スタイル名</td>
					<td><input type="text" name="styleName"></td>
				</tr>
				<tr>
					<td>スタイルの性別</td>
					<td><input type="radio" name="styleSex" value="ladies">女性</td>
					<td><input type="radio" name="styleSex" value="mens">男性</td>
				</tr>
				<tr>
					<td>担当スタイリスト</td>
					<td><select name="staffId">
							<s:iterator value="staffList">
								<option value="<s:property value="staffId"/>"><s:property
										value="staffName" /></option>
							</s:iterator>
					</select></td>
				</tr>
				<tr>
					<td>スタイル詳細</td>
					<td><textarea name="styleComment"></textarea></td>
				</tr>
				<tr>
					<td>スタイル写真</td>
					<td>insert</td>
				</tr>
			</table>
		</div>
		<div class="style-edit">
			<table>
				<tr>
					<td>スタイルの編集</td>
				</tr>
				<s:form action="GoAdminStyleEditAction">
				<tr>
					<td>スタイルvol</td>
					<td><input type="text" name="stylelVol"></td>
				</tr>
				<tr>
					<td><input type="submit" value="編集する">
				</tr>
				</s:form>
			</table>
		</div>
		<div class="style-delete">
		<s:form>
		<input type="text" name="styleVol">
		<input type="submit" value="削除">
		</s:form>
		</div>
	</div>
</body>
</html>