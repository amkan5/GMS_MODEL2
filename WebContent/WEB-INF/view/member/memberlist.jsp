<%@page import="service.MemberServiceImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "java.util.*" %>
<%@ page import = "domain.*" %>
  <%
	String ctx = application.getContextPath();
%>
<!doctype html>
<html lang="en">
<head>
	<style> td{width:100px}
	</style>
	<meta charset="UTF-8" />
	<title>memberList</title>
</head>
<body>
<a href="<%= ctx %>/member.do?action=move&page=memberlist"> 목록보기 </a>
<table class = "tbl">
  <tr>
   <th>이름</th>
   <th>아이디</th>
   <th>팀아이디</th>
 <tr>
</table>
</body>
</html>

