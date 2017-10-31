<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- css読み込み -->
<link rel="stylesheet" type="text/css" href="css/master.css">
<link rel="stylesheet" type="text/css" href="css/style.css">

<!-- jQuer読み込み -->
<script src="js/jquery-3.2.1.min.js"></script>
<!-- slick読み込み -->
<link rel="stylesheet" href="css/slick.css">
<link rel="stylesheet" type="text/css" href="css/slick-theme.css">
<script src="js/slick.min.js"></script>


<title>style</title>
</head>

<body>

	<!-- style-->
	<div id="container">
		<!-- ヘッダー ------------------------------>
		<jsp:include page="header.jsp" />
		<div class="head-space"></div>
		<div class="style">
			<h2>Ladies Style</h2>
			<div class="slider">
				<s:iterator value="ladiesStyleList">
					<div>
						<a
							href="<s:url action="GoStyleInfoAction"><s:param name="styleVol" value="%{StyleVol}"/></s:url>">
							<img class="img" src="<s:property value="StyleImg"/>"> <s:hidden
								value="styleVol" />
						</a>
					</div>
				</s:iterator>
			</div>

		</div>

		<div class="style-men">
			<div class="style">
				<h2>Mens Style</h2>
				<div class="slider">
					<s:iterator value="mensStyleList">
						<div>
							<a
								href="<s:url action="GoStyleInfoAction"><s:param name="styleVol" value="%{StyleVol}"/></s:url>">
								<img class="img" src="<s:property value="StyleImg"/>"> <s:hidden
									value="styleVol" />
							</a>
						</div>
					</s:iterator>
				</div>
			</div>
			<script>
			$('.slider').slick({
				  dots: false,
				  arrows:false,
				  pauseOnHover:true,
				  autoplay: true,
				  autoplaySpeed: 0,
				  cssEase:'linear',
				  infinite: true,
				  speed: 9000,
				  slidesToShow: 5,
				  slidesToScroll: 1,
				  responsive: [
				    {
				      breakpoint: 1024,
				      settings: {
				        slidesToShow: 4,
				        slidesToScroll: 1,
				        infinite: true,
				        dots: true
				      }
				    },
				    {
				      breakpoint: 600,
				      settings: {
				        slidesToShow: 3,
				        slidesToScroll: 1
				      }
				    },
				    {
				      breakpoint: 480,
				      settings: {
				        slidesToShow: 2,
				        slidesToScroll: 1
				      }
				    }
				  ]
				});
					</script>
		</div>

		<!-- フッター -->
		<jsp:include page="footer.jsp" />
	</div>
</body>
</html>