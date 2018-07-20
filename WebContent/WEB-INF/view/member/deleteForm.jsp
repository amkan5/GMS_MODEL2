<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
  <%
	String ctx = application.getContextPath();
%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>delete</title>
</head>
<body>
<h3>회원탈퇴</h3>
<form action="<%= ctx %>/member.do">
	ID <br>
	<input type="text" name="userId"><br>
	Pass <br>
	<input type="text" name="Pass"><br>
	<input type="hidden" name="action" value="delete" />
	<input type="submit" value="제출">
</form>
</body>
</html>