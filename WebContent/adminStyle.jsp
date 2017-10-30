<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- css読み込み -->
<link rel="stylesheet" type="text/css" href="css/style.css">

<!-- jQuery読み込み -->
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
							href="<s:url action="GoAdminStyleEditAction"><s:param name="styleVol" value="%{StyleVol}"/></s:url>">
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
								href="<s:url action="AdminStyleEditAction"><s:param name="styleVol" value="%{StyleVol}"/></s:url>">
								<img class="img" src="<s:property value="StyleImg"/>"> <s:hidden
									value="styleVol" />
							</a>
						</div>
					</s:iterator>
				</div>
			</div>
			<div class="style-insert">
			<s:property value="insertMsg"/>
			<table>
			<s:form action="AdminStyleInsertAction" enctype="multipart/form-data">
				<tr>
					<td>vol:<input type="number" name="styleVol" ></td>
				</tr>
				<tr>
					<td>スタイル名:<input type="text" name="styleName"></td>
				</tr>
				<tr>
					<td>性別:女性<input type="radio" name="styleSex" value="ladies" checked="checked">男性<input type="radio" name="styleSex" value="mens"></td>
				</tr>
				<tr>
					<td>スタイルコメント:<textarea name="styleComment" placeholder="スタイルの詳細を記入"></textarea></td>
				</tr>
					<tr>
						<td>担当スタイリスト: <select name="staffId">
								<s:iterator value="staffList">
									<option value="<s:property value="staffId"/>"><s:property
											value="staffName" /></option>
								</s:iterator>
						</select>
					</tr>
					<tr>
						<td><input type="file" name="StyleFile" accept="image/*"></td>
					</tr>
					<tr>
						<td><input type="submit" value="スタイルを追加"></td>
					</tr>
					</s:form>
				</table>
			</div>
			<div class="style-delete">
			<p>スタイルを削除する</p>
			<s:property value="deleteMsg"/>
				<table>
				<s:form action="AdminStyleDeleteAction">
				<tr>
					<td><input type="number" name="styleVol"></td>
				</tr>
				<tr>
					<td><input type="submit" value="削除する"></td>
				</tr>
				</s:form>
				</table>
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
