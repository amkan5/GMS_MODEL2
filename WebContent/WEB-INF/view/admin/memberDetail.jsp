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
	<link rel="stylesheet" href="${ctx}/resources/css/style.css" />
	<jsp:include page="../common/head.jsp"/>
</head>

<body>
	<table id="table">
		<tr>
			<td rowspan="3" colspan="2">프로필사진</td>
			<td><h2>ID</h2></td>
			<td><h2>${member.memId}</h2></td>
		</tr>
		<tr>
			<td><h2>이름</h2></td>
			<td><h2>${member.name}</h2></td>
	
		</tr>
		<tr>
			<td><h2>비번</h2></td>
			<td><h2>비밀번호 : ******</h2></td>
		</tr>
		<tr>
			<td><h2>나이</h2></td>
			<td><h2>${member.age}</h2></td>
			<td><h2>팀</h2></td>
			<td><h2>${member.teamId}</h2></td>
		</tr>
		<tr>
			<td><h2>성별</h2></td>
			<td><h2>${member.gender}</h2></td>
			<td><h2>역할</h2></td>
			<td><h2>${member.roll}</h2></td>
		</tr>
	</table>
<h3><a id="myPageMoveToUpdate">UPDATE FORM</a></h3>
<h3><a id="myPageMoveToDelete">DELETE FORM</a></h3>

<script>
document.getElementById('myPageMoveToUpdate')
.addEventListener('click',function(){
alert('넘어간다요');
router.move({context:'${ctx}',
			domain : 'member',
			action: 'move',
			page: 'updateForm'})
			});
			
document.getElementById('myPageMoveToDelete')
.addEventListener('click',function(){
alert('넘어간다요');
router.move({context:'${ctx}',
			domain : 'member',
			action: 'move',
			page: 'deleteForm'})
			});
</script>	
</body>

</html>

