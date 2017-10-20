<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/master.css">
<meta charset="UTF-8">
<!-- jQueryUIの読み込み -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script
	src="http://ajax.googleapis.com/ajax/libs/jqueryui/1/jquery-ui.min.js"></script>
<script
	src="http://ajax.googleapis.com/ajax/libs/jqueryui/1/i18n/jquery.ui.datepicker-ja.min.js"></script>
<!-- jQueryのcssの読み込み-->
<link rel="stylesheet"
	href="http://ajax.googleapis.com/ajax/libs/jqueryui/1/themes/ui-lightness/jquery-ui.css">

<!-- datepicker -->
<script>
  $(function() {
    $("#datepicker").datepicker();
    $("#datepicker").datepicker("option", "showOn", 'both');
    $("#datepicker").datepicker("option", "buttonImageOnly", true);
    $("#datepicker").datepicker("option", "buttonImage", 'img/cal_icon.png');
  });
</script>
<title>reserve</title>
</head>
<body>


	<div class="container">
	<!-- ヘッダー ------------------------------>
	<jsp:include page="header.jsp" />
		<!--予約日時-->
		<s:form action="GoReserveConfirmAction">
			<div class="reserve-date">
				<p>予約日時を選択してください</p>
				<input type="text" name="reserveDate" id="datepicker">
				<select name="reseveHour">
					<option value="">
				</select>

			</div>
			<!--メニュー-->
			<div class="reserve-menu">
				<p>施術メニューを選択してください</p>
				<table>
					<tr>
						<th>施術メニュー</th>
						<th>施術料金</th>
						<th>施術時間</th>
						<th></th>
					</tr>

					<s:iterator value="menuList">
					<tr>
						<td><s:property value="menuName"/></td>
						<td><fmt:formatNumber value="${menuPrice}" pattern="###,###,###"/>円</td>
						<td><s:property value="menuTime"/>分</td>
						<td><input type="checkbox" name="menuId[]" value="<s:property value="menuId"/>"></td>
					</tr>
					</s:iterator>
				</table>
			</div>
			<!-- stylist指名 -->
			<div class="stylist-choise">
				<p>スタイリスト指名</p>
				<table>
					<tr>
						<td>stlist</td>
						<td><input type="radio" name="staff" value="<s:property value="staffName"/>"></td>
					</tr>
					<tr>
						<td>指名なし</td>
						<td><input type="radio" name="staff" value="指名なし"></td>
					</tr>
				</table>
			</div>
			<!-- 支払い方法 -->
			<div class="pay-select">
				<p>支払い方法</p>
				<ul>
					<li><input type="radio" name="pay" value="credit">クレジット決済</li>
					<li><input type="radio" name="pay" value="cash">現金</li>
				</ul>
			</div>
			<input type="submit" value="予約決定">
		</s:form>
		<!-- フッター -->
		<jsp:include page="footer.jsp" />
	</div>
</body>
</html>