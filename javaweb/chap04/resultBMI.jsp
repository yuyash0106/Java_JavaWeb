<%--
JavaWeb Lesson Chap04 Src03

バリデーション。
結果画面。

ファイル名=resultBMI.jsp
ディレクトリ=/javaweb/chap04
 --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="author" content="Yuya OZAKI">
<title>入力チェック：結果画面</title>
<style type="text/css">
.redChar {
	color: red;
	font-size: 24pt;
}
</style>
</head>
<body>
	<h1>入力チェック：結果画面</h1>
	<p>
		あなたのBMIは<span class="redChar"><%=request.getAttribute("bmi")%></span>です。
	</p>
	<p>
		<%=request.getAttribute("advice")%>
	</p>
	<p>
		<a href="/javaweb/chap04/inputBMI.jsp">戻る</a>
	</p>
</body>
</html>