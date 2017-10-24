<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/master.css">
<script type="text/javascript" src="js/reservedate.js"></script>
<meta charset="UTF-8">
<!-- jquery datepicker読み込み -->
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.9.2.custom.min.js"></script>
<script type="text/javascript" src="js/jquery.ui.datepicker-ja.js"></script>
<script type="text/javascript" src="js/jquery.holiday.js"></script>
<link rel="stylesheet" type="text/css"
	href="css/jquery-ui-1.9.2.custom.css">

<!-- datepicker script -->
<script type="text/javascript" charset="utf-8">
	jQuery(function() {
		$("#datepicker").datepicker().holiday();
	});
</script>
<title>reserve</title>
</head>
<body>
	<div class="container">
		<!-- ヘッダー ------------------------------>
		<jsp:include page="header.jsp" />
		<s:form action="GoReserveConfirmAction">
			<!--予約日時-->

			<div class="reserve-date">
				<p>予約日時を選択してください</p>
				<input type="text" name="reserveDate" onchange="reservedate()"
					id="datepicker" placeholder="予約日を選択してください"> <select name="reserveTime"
					id="reserveTime">
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
							<td><s:property value="menuName" /></td>
							<td><fmt:formatNumber value="${menuPrice}"
									pattern="###,###,###" />円</td>
							<td><s:property value="menuTime" />分</td>
							<td><input type="checkbox" name="menuId"
								value="<s:property value="menuId"/>"></td>
						</tr>
					</s:iterator>
				</table>
			</div>
			<!-- stylist指名 -->
			<div class="stylist-choise">
				<p>スタイリスト指名</p>
				<table>
					<s:iterator value="staffList">
						<tr>
							<td><input type="radio" name="staffId"
								value="<s:property value="staffId"/>"> <s:property
									value="staffName" /></td>
						</tr>
					</s:iterator>
					<tr>
						<td><input type="radio" name="staffId" value= "1" >指名なし</td>
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
			<input type="submit" value="予約する">
		</s:form>
		<!-- フッター -->
		<jsp:include page="footer.jsp" />
	</div>
</body>
</html>