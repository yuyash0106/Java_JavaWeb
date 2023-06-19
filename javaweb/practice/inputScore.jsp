<%--
JavaWeb Lesson Practice Src01

入力画面。

ファイル名=inputScore.jsp
ディレクトリ=/javaweb/practice
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String strName = (String) request.getAttribute("Name");
	String strMorning = (String) request.getAttribute("strMorning");
	String strAfternoon = (String) request.getAttribute("strAfternoon");
	Integer grade = (Integer) request.getAttribute("grade");

	String msg = (String) request.getAttribute("msg");

	if (strName == null) {
		strName = "";
	}
	if (strMorning == null) {
		strMorning = "";
	}
	if (strAfternoon == null) {
		strAfternoon = "";
	}
	if (grade == null) {
		grade = 1;
	}
%>
<%
	if (msg != null) {
%>
<p>
	<%=msg%>
</p>
<%
	}
%>


<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="author" content="Yuya OZAKI">
<title>国家試験判定：入力画面</title>
</head>
<body>
	国家試験判定
	<br>
	<br>
	<form action="/javaweb/practice/calcScore" method="post">

		お名前：<input type="text" name="name" value="<%=strName%>"><br>

		学年：<select name="grade">
			<%
				for (int i = 1; i <= 3; i++) {
					if (grade == i) {
			%>
			<option value="<%=i%>" selected><%=i%>年生
			</option>
			<%
				} else {
			%>
			<option value="<%=i%>"><%=i%>年生
			</option>
			<%
				}

				}
			%>

		</select><br> 午前試験：<input type="text" name="morning"
			value="<%=strMorning%>">点<br> 午後試験：<input type="text"
			name="afternoon" value="<%=strAfternoon%>">点<br> <input
			type="submit" name="submit" value="合否判定">
	</form>
</body>
</html>