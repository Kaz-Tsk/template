<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<div class="index_img">
		<div class="img">
			<img src="img/main.jpg" height="90%" width="90%">
		</div>
		<div class="img">
			<img src="img/main1.jpg" height="90%" width="90%">
		</div>
		<div class="img">
			<img src="img/main2.png"height="90%" width="90%">
		</div>
	</div>

	<!-- カルーセルスライドのオプション ----->
	<script>
		$(function() {
			$('.index_img').slick({
				slidesToShow : 1,
				slidesToScroll : 1,
				autoplay : true,
				autoplaySpeed : 2000,
				arrows : true,
				dots : true,
			});
		});
	</script>

</body>
</html>