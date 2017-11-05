
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/master.css">
<link rel="stylesheet" type="text/css" href="css/userCreateConfirm.css">
<script type="text/javascript">
	window.onunload = function() {
	};
	history.forward();
</script>
</head>
<body>
	<div id="container">
		<!-- ヘッダー ------------------------------>
		<jsp:include page="header.jsp" />
		<div class="confirm-box">
			<h3>登録する内容は以下でよろしいですか。</h3>
			<table>
				<s:form action="UserCreateComplateAction">
					<tr>
						<td><label>ログインID:</label></td>
						<td><s:property value="loginUserId" /></td>
					</tr>
					<tr>
						<td><label>ログインPASS:</label></td>
						<td><s:property value="loginPassword" /></td>
					</tr>
					<tr>
						<td><label>ユーザー名:</label></td>
						<td><s:property value="userName" /></td>
					</tr>
					<tr>
						<td><label>電話番号:</label></td>
						<td><s:property value="telNumber" /></td>
					</tr>
					<tr>
						<td><label>メールアドレス:</label></td>
						<td><s:property value="eMail" /></td>
					</tr>
					<tr>
						<td><label>住所:</label></td>
						<td><s:property value="address" /></td>
					</tr>
					<tr>
						<td><s:submit value="登録完了" /></td>
					</tr>
				</s:form>
			</table>
			<p><a href='<s:url action="GoUserCreateAction"/>'>修正</a></p>
		</div>
		<!-- フッター -->
		<jsp:include page="footer.jsp" />
	</div>
</body>
</html>