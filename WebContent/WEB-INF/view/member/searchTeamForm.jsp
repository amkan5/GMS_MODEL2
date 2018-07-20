<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
  <%
	String ctx = application.getContextPath();
%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>findbyteamForm</title>
</head>
<body>
	<h2 class="text-align">검색</h2>	S
		<form action="<%= ctx %>/member.do">
			TeamID 입력 <br>
			<input type="text" name="teamid"><br>
			<input type="hidden" name="action" value="search" />
			<input type="hidden" name="page" value="searchMemberByTeam" />
			<input type="submit" value="제출">
		</form>
</body>
</html>