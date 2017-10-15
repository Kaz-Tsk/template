<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- jQueryUIの読み込み -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1/jquery-ui.min.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1/i18n/jquery.ui.datepicker-ja.min.js"></script>
<!-- jQueryのcss -->
<link rel="stylesheet" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1/themes/ui-lightness/jquery-ui.css" >
<!-- datepicker -->
<script>
  $(function() {
    $("#datepicker").datepicker();
    $("#datepicker").datepicker("option", "showOn", 'both');
    $("#datepicker").datepicker("option", "buttonImageOnly", true);
    $("#datepicker").datepicker("option", "buttonImage", 'ico_calendar.png');
  });
</script>
<title>reserve</title>
</head>
<body>
	<!-- ヘッダー ------------------------------>
		<jsp:include page="header.jsp" />

	<!--予約日時-->
	<input type="text" id="datepicker">
	<!--メニュー-->

	<!-- 支払い方法 -->
</body>
</html>