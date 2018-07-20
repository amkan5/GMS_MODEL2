<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="domain.*" %>
<%
	MemberBean user = (MemberBean)request.getAttribute("user");
%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>my_page</title>
</head>
<body>
	<h1><%= user.getMemId() %> 님 어서오세요</h1>
</body>
</html>

