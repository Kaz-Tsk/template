<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- CSSの読み込み -->
<link rel="stylesheet" type="text/css" href="css/master.css">
<link rel="stylesheet" type="text/css" href="css/reserveComplate.css">
<!-- javascriptの読み込み -->
<script type="text/javascript">
	window.onunload = function() {
	};
	//FireFox
	history.forward();
</script>
<title>reserveComplate</title>
</head>
<body>
	<div id="container">
		<!-- ヘッダー -->
		<jsp:include page="header.jsp" />
		<div class="message-box">
		<h2>Reserve Complate</h2>
			<h3>予約が確定しました。</h3>
			<h4>スタッフ一同ご来店心よりお待ちしております。</h4>
			<input type="button" onClick="location.href='<s:url action="GoTopAction"/>'" value="TOPへ">
		</div>
		<!-- フッター -->
		<jsp:include page="footer.jsp" />
	</div>
</body>
</html>