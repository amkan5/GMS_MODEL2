<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
  <%
	String ctx = application.getContextPath();
%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>updateForm</title>
</head>
<body>
<h3>비밀번호 변경</h3>
<form action="<%= ctx %>/member.do">
	ID <br>
	<input type="text" name="userId"><br>
	Pass <br>
	<input type="text" name="oldPass"><br>
	NewPass <br>
	<input type="text" name="newPass"><br>
	<input type="hidden" name="action" value="memberUpdate" />
	<input type="submit" value="제출">
</form>
	<a herf="../../main.jsp">돌아가기</a>
</body>
</html>