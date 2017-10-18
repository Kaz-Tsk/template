<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/master.css">
<!-- スライドのcss -------------------------------------------------->
<link rel="stylesheet" type="text/css" href="css/slick/slick-theme.css">
<link rel="stylesheet" type="text/css" href="css/slick/slick.css">

<link rel="shortcut icon" href="img/favicon.ico">

<!--jqueryとslick(スライド)のスクリプト  -------------------------------------------->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="js/slick.min.js"></script>
<title>Index</title>
</head>
<body>

	<!-- ヘッダー ------------------------------>
		<jsp:include page="header.jsp" />

 <!-- スライドしている画像 --------------------------------------------------------------------------->
	<div class="index_img" >
		<div class="img">
			<img src="img/main.jpg" height="100%" width="100%">
		</div>
		<div class="img">
			<img src="img/main1.jpg" height="100%" width="100%">
		</div>
		<div class="img">
			<img src="img/main2.png" height="100%" width="100%">
		</div>
	</div>

	<!-- カルーセルスライドのオプション ----->
	<script>
		$(function() {
			$('.index_img').slick({
				slidesToShow : 1,
				slidesToScroll : 1,
				autoplay : true,
				autoplaySpeed : 2200,
				arrows : false,
				dots : false,
			});
		});
	</script>

	<!--informationテーブル-->

	<div class="information">
		<p>salon information</p>
		<table>
			<s:iterator value="salonInfoList">
			<tr>
				<td><s:property value="insertDate"/></td>
				<td><s:property value="salonInfo"/></td>
			</tr>
			</s:iterator>
		</table>
	</div>

<!-- フッター -->
		<jsp:include page="footer.jsp" />

</body>
</html>