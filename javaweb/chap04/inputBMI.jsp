<%--
JavaWeb Lesson Chap04 Src01

バリデーション。
入力画面。

ファイル名=inputBMI.jsp
ディレクトリ=/javaweb/chap04
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String height = (String) request.getAttribute("height");
	String weight = (String) request.getAttribute("weight");
	String msg = (String) request.getAttribute("msg");

	if (height == null) {
		height = "";
	}
	if (weight == null) {
		weight = "";
	}
%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="author" content="Yuya OZAKI">
<title>入力チェック：入力画面</title>
<style type="text/css">
table {
	border-collapse: collapse;
}

table th, td {
	border: solid 1px black;
}

.submit {
	text-align: center;
}

#errorMsg {
	border: solid 1px orange;
	color: red;
	padding: 10px;
	mardin: 20px;
	width: 400px;
}
</style>
</head>
<body>
	<h1>入力チェック：入力画面</h1>
	<p>身長と体重を入力し、計算ボタンをクリックしてください。</p>
	<%
		if (msg != null) {
	%>
	<p id="errorMsg">
		<%=msg%>
	</p>
	<%
		}
	%>
	<form action="/javaweb/chap04/calcBMI" method="post">
		<div class="box">
			<table>
				<tr>
					<th><label for="height">身長</label></th>
					<td><input type="text" id="height" name="height"
						value="<%=height%>">cm</td>
				</tr>
				<tr>
					<th><label for="weight">体重</label></th>
					<td><input type="text" id="weight" name="weight"
						value="<%=weight%>">kg</td>
				</tr>
				<tr>
					<td class="submit" colspan="2">
						<button type="submit">計算</button>
					</td>
				</tr>
			</table>
		</div>
	</form>

</body>
</html>