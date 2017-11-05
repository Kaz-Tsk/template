<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- CSS読み込み  -->
<link rel="stylesheet" type="text/css" href="css/master.css">
<link rel="stylesheet" type="text/css" href="css/reserve.css">
<!-- javascript読み込み  -->
<script type="text/javascript" src="js/reservedate.js"></script>
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
	<div id="container">

		<!-- header -->
		<jsp:include page="header.jsp" />
		<div class="reserve-container">
			<s:form action="GoReserveConfirmAction">
			<h3 style="margin-top:50px">Reserve</h3>
				<!-- 予約日時 -->
				<div class="menu-head">
				<h3 style="color: red;margin:0">
						<s:property value="errorMsg" />
					</h3>
					<p>予約日時</p>
					<input type="text" name="reserveDate" onchange="reservedate()"
						id="datepicker" readonly placeholder="予約日を選択してください"> <select
						name="reserveTime" id="reserveTime">
					</select>
					<table>
						<tr>
							<th>施術メニュー</th>
							<th>施術料金</th>
							<th style="padding-right:5px;">施術時間</th>
							<th></th>
						</tr>
					</table>
				</div>
				<div class="menu-box">
					<table>
						<s:iterator value="menuList">
							<tr>
								<td class="left" style="padding-left:10px;"><s:property value="menuName" /></td>
								<td class="right" style="padding-right:40px;"><fmt:formatNumber value="${menuPrice}"
										pattern="###,###,###" />円</td>
								<td class="right"><s:property value="menuTime" />分</td>
								<td style="padding-right:10px;"> <input type="checkbox" name="menuId"
									value="<s:property value="menuId"/>"></td>
							</tr>
						</s:iterator>
					</table>
				</div>
				<!-- stylist指名 -->
				<div class="under-box">
				<div class="stylist-box">
					<p>スタイリスト指名</p>
					<div class="staff-box">
						<table>
							<tr>
								<td>指名なし<input type="radio" name="staffId" value="0"
									checked="checked"></td>
							</tr>
							<s:iterator value="staffList">
								<tr>
									<td><s:property value="staffName" /><input type="radio"
										name="staffId" value="<s:property value="staffId"/>">
									</td>
								</tr>
							</s:iterator>
						</table>
					</div>
				</div>
				<!-- 支払い方法 -->
				<div class="pay-box">
					<p>支払い方法</p>
					<ul>
						<li>クレジット決済<input type="radio" name="pay" value="クレジット"
							checked="checked"></li>
						<li>現金<input type="radio" name="pay" value="現金"></li>
					</ul>

				</div>
				</div>
				<input type="submit" value="予約する">
			</s:form>
		</div>
		<!-- フッター -->
		<jsp:include page="footer.jsp" />
	</div>
</body>
</html>