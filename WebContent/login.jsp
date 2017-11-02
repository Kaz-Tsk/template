<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/login.css">
<link rel="stylesheet" type="text/css" href="css/master.css">
<title>Login画面</title>

</head>
<body>
	<div id="container">
		<!-- header -->
		<jsp:include page="header.jsp" />

		<h3>LOGIN</h3>
		<s:form action="LoginAction">
			<s:textfield name="loginUserId" />
			<s:password name="loginPassword" />
			<s:submit value="ログイン" />
		</s:form>
		<br />
		<p>新規登録は<a href="userCreate.jsp">こちら</a>から</p>

		<!-- footer -->
		<jsp:include page="footer.jsp" />
	</div>
</body>
</html>