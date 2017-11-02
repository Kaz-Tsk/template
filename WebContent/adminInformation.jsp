<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
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
		$(".datepicker").datepicker().holiday();
	});
</script>
<title>AdminInformation</title>
</head>
<body>
<div class="container">
		<div class="insert-display">
			<table>
				<tr>
					<td>vol</td>
						<td>公開日</td>
						<td>公開内容</td>
					</tr>
				<s:iterator value="adminInfoList">
					<tr>
						<td><s:property value="infoVol"/></td>
						<td><s:property value="infoDay"/></td>
						<td><s:property value="infoText"/></td>
					</tr>
				</s:iterator>
			</table>
		</div>
		<div class="info-insert">
		<s:property value="insertMsg"/>
		<table>
			<tr>
				<th>情報の登録</th>
			</tr>
			<s:form action="AdminInfoInsertAction">
			<tr>
				<td>vol:<input type="number" name="infoVol" required="required" placeholder="半角数字で記入"></td>
			</tr>
			<tr>
				<td>
					<input type="text" name="infoDay" class="datepicker" required="required" readonly placeholder="公開日を指定してください">
				</td>
			</tr>
			<tr>
				<td><textarea name="infoText" rows="4" cols="40" required="required" ></textarea></td>
			</tr>
			<tr>
				<td><input type="submit" value="登録する"></td>
			</tr>
			</s:form>
		</table>
	</div>
	<div class="info-edit">
	<s:property value="editMsg"/>
		<table>
			<tr>
				<th>情報の編集</th>
			</tr>
			<s:form action="AdminInfoEditAction">
			<tr>
				<td>vol:<input type="text" name="infoVol" required="required" placeholder="半角数字で記入"></td>
			</tr>
			<tr>
				<td>
					<input type="text" name="infoDay" class="datepicker" required="required" placeholder="公開日を指定してください">
				</td>
			</tr>
			<tr>
				<td><textarea name="infoText" rows="4" cols="40" required="required"></textarea></td>
			</tr>
			<tr>
				<td><input type="submit" value="編集する"></td>
			</tr>
			</s:form>
		</table>
	</div>
	<div class="info-delete">
		<s:property value="deleteMsg"/>
		<table>
			<tr>
				<th>情報の削除</th>
			</tr>
			<s:form action="AdminInfoDeleteAction">
			<tr>
				<td>vol:<input type="text" name="infoVol" required="required" placeholder="半角数字で記入"></td>
			</tr>
			<tr>
				<td><input type="submit" value="削除する"></td>
			</tr>
			</s:form>
		</table>
	</div>
</div>
</body>
</html>