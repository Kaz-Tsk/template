<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- css読み込み -->
<link rel="stylesheet" type="text/css" href="css/adminMaster.css">
<link rel="stylesheet" type="text/css" href="css/adminStaff.css">
<!-- jQuery読み込み -->
<script src="js/jquery-3.2.1.min.js"></script>
<!-- slick読み込み -->
<link rel="stylesheet" href="css/slick.css">
<link rel="stylesheet" type="text/css" href="css/slick-theme.css">
<script src="js/slick.min.js"></script>
<title>adminStaff</title>
</head>
<body>
	<div class="container">
		<!-- header -->
		<jsp:include page="header.jsp" />
		<div class="staffList">
			<div class="slider">
				<s:iterator value="staffList">
					<div>
						<a
							href="<s:url action="GoAdminStaffEditAction"><s:param name="staffId" value="%{staffId}"/></s:url>">
							<img class="img" src="<s:property value="staffImg"/>"> <s:hidden
								value="staffId" />
						</a>
						<p>
							ID:
							<s:property value="staffId" />
						</p>
					</div>
				</s:iterator>
			</div>
		</div>
		<div class="staff-insert">
			<p>スタッフ新規登録</p>
			<p>
				<s:property value="insertMsg" />
			</p>
			<table>
				<s:form action="AdminStaffInsertAction"
					enctype="multipart/form-data">
					<tr>
						<td>スタッフID</td>
						<td><input type="text" name="staffId"></td>
					</tr>
					<tr>
						<td>スタッフ名</td>
						<td><input type="text" name="staffName"></td>
					</tr>
					<tr>
						<td>紹介文</td>
						<td><textarea name="staffComment"></textarea></td>
					</tr>
					<tr>
						<td>スタッフ画像</td>
						<td><input type="file" name="staffFile" accept="image/*"></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="登録する"></td>
					</tr>
				</s:form>
			</table>
		</div>
		<!-- sride -->
		<script>
			$('.slider').slick({
				dots : true,
				arrows : true,
				pauseOnHover : true,
				slidesToShow : 4,
				slidesToScroll : 1,
				responsive : [ {
					breakpoint : 1024,
					settings : {
						slidesToShow : 4,
						slidesToScroll : 1,
						infinite : true,
						dots : true
					}
				}, {
					breakpoint : 600,
					settings : {
						slidesToShow : 3,
						slidesToScroll : 1
					}
				}, {
					breakpoint : 480,
					settings : {
						slidesToShow : 2,
						slidesToScroll : 1
					}
				} ]
			});
		</script>
	</div>
</body>
</html>