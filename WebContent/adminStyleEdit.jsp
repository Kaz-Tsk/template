<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<!-- CSSの読み込み  -->
<link rel="stylesheet" type="text/css" href="css/adminMaster.css">
<link rel="stylesheet" type="text/css" href="css/adminStyleEdit.css">
<meta charset="UTF-8">
<title>adminStyleEdit</title>
</head>
<body>
	<div class="container">
		<!-- header -->
		<jsp:include page="header.jsp" />
		<div class="style-img">
			<img src="<s:property value="styleImg"/>">
		</div>
		<div class="style-edit">
			<s:form action="AdminStyleEditAction" enctype="multipart/form-data">
				<table>
					<tr>
						<td>スタイル名</td>
						<td><input type="text" name="styleName"
							value="<s:property value="styleName"/>"></td>
					</tr>
					<tr>
						<td>スタイルコメント</td>
						<td><textarea name="styleComment"><s:property
									value="styleComment" /></textarea></td>
					</tr>
					<tr>
						<td>スタイル写真</td>
						<td><input type="file" name="StyleFile" accept="image/*"></td>
					</tr>
					<tr>
						<td>担当スタッフ</td>
						<s:iterator value="staffList">
							<td><input type="radio" name="staffId"
								value="<s:property value="staffId"/>"> <s:property
									value="StaffName" /></td>
						</s:iterator>
					</tr>
					<tr>
						<td colspan="2"><input type="hidden" name="styleVol"
							value="<s:property value="styleVol"/>"><input
							type="submit" value="編集完了"></td>
					</tr>
				</table>
			</s:form>
			<div class="style-delete">
				<s:property value="deleteMsg" />
				<s:form action="AdminStyleDeleteAction">
					<input type="hidden" name="styleVol"
						value="<s:property value="styleVol"/>">
					<input type="submit" value="削除する">
				</s:form>
			</div>
		</div>
	</div>
</body>
</html>