<%--
JavaWeb Lesson Chap03 Src03

JSPの登場。

ファイル名=showBMI.jsp
ディレクトリ=/javaweb/chap03
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String bmiValue = (String) request.getAttribute("bmiValue");
%>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="author" content="Yuya OZAKI">
<title>JSPの登場:結果画面</title>
<style type="text/css">
.reader {
	color: red;
	font-size: 24pt;
}
</style>
</head>
<body>
	<h1>JSPの登場:結果画面</h1>
	<p>
		あなたのBMIは<span class "redChar"><%=bmiValue%></span>です。
</p>
	<p>
		<a href="/javaweb/chap03/inputHeightWeight.html">戻る</a>
</body>
</html>