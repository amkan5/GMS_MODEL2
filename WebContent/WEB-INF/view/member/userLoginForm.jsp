<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%
	String ctx = application.getContextPath();
%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>user-login</title>
</head>
<body>
	<div class="margin-200-auto text-align width-200 border">
	<h2 class="text-align">사용자 로그인</h2>	
		<form action="<%= ctx %>/member.do">
			ID <br>
			<input type="text" name="userid" value="ID입력"><br>
			Pass <br>
			<input type="text" name="password" value="비번입력" ><br>
			<input type="hidden" name="action" value="move" />
			<input type ="hidden" name="page" value="userLoginResult" />
			<input type="submit" value="제출">
		</form><br>
		<a href="<%= ctx %>../../index.do">돌아가기</a>
	</div>
</body>
</html>