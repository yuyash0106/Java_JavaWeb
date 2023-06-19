<%--
JavaWeb Lesson Practice Src03

結果画面
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>結果画面</title>
</head>
<body>
	<p>国家試験判定</p>
	<br>
	<br>
	<p>
		<%=request.getAttribute("grade")%>年生の<%=request.getAttribute("Name")%>さん
	</p>
	<p>あなたの得点は</p>
		午前<%=request.getAttribute("strMorning")%>点 午後<%=request.getAttribute("strAfternoon")%>点<br>
		合計<%=request.getAttribute("total")%>点
	<p>
		判定結果は<%=request.getAttribute("judge")%>です
	</p>
	<p>
		<a href="/javaweb/practice/inputScore.jsp">戻る</a>
	</p>
</body>
</html>