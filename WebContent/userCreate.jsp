<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/master.css">
<link rel="stylesheet" type="text/css" href="css/userCreate.css">
<meta charset="utf-8">
<script type="text/javascript">
	window.onunload = function() {};
	history.forward();
</script>
<title>UserCreate画面</title>

</head>
<body>
	<div id="container">
		<!-- ヘッダー ------------------------------>
		<jsp:include page="header.jsp" />
		<div class="create-box">
			<h2 style="text-align: center;">user create</h2>
			<p style="color: red;">
				<s:property value="errorMessage" />
			</p>
			<table>
				<s:form action="UserCreateConfirmAction">
					<tr>
						<td><label>ログインID:</label></td>
						<td><input type="text" name="loginUserId" required="required" />
						</td>
					</tr>
					<tr>
						<td><label>ログインPASS:</label></td>
						<td><input type="text" name="loginPassword"
							required="required" /></td>
					</tr>
					<tr>
						<td><label>ユーザー名:</label></td>
						<td><input type="text" name="userName" required="required" /></td>
					</tr>
					<tr>
						<td><label>電話番号:</label></td>
						<td><input type="number" name="telNumber" required="required" />
						</td>
					</tr>
					<tr>
						<td><label>メールアドレス:</label></td>
						<td><input type="text" name="eMail" required="required" /></td>
					</tr>
					<tr>
						<td><label>住所:</label></td>
						<td><input type="text" name="address" required="required" />
						</td>
					</tr>
					<s:submit value="登録" />
				</s:form>
			</table>
		</div>
		<!-- フッター -->
		<jsp:include page="footer.jsp" />
	</div>

</body>
</html>