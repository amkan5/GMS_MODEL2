<%
	String ctx = application.getContextPath();
%>
<%@page import="service.MemberServiceImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import= "java.text.SimpleDateFormat" %>
<%@page import= "java.util.Date" %>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>main</title>
	<link rel="stylesheet" href="resoures/css/style.css" />
</head>
<body>
<h3> 현재회원수 :  <makr> resoures </makr> </h3>
	<table class="margin-auto">
		<tr class="height-150">
			<th colspan="2">
			<font size="20em">
			GMS
			</font>
			</th>		
		</tr>
		<tr class="height-400">
			<td>
			<img src="home/test.jpg" alt=""
			class="image-size"/>
			</td>
			<td>
			<ul>
				<li><a href="<%= ctx %>/member.do?action=move&page=userLoginForm">사용자로그인</a></li>
				<li><a href="<%= ctx %>/member/admin_login.do">관리자로그인</a></li>
				<li><a href="<%= ctx %>/member.do?action=move&page=joinForm">회원가입</a> </li>
				<li><a href="<%= ctx %>/member/updateForm.do">비밀번호바꾸기</a></li>
				<li><a href="<%= ctx %>/member/deleteForm.do">회원탈퇴</a></li>
				<li><a href="<%= ctx %>/member/memberlist.do">회원목록</a></li>
				<li><a href="<%= ctx %>/member/searchTeamForm.do"> 팀이름검색 </a></li>
					
			</ul>			
			</td>
		</tr>
		<tr class="height-150">
			<td colspan="2">
			<font size="10em">주소</font>			
			</td>			
		</tr>
	</table>


</body>
</html>