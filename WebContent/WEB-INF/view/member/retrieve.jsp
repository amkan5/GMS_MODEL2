<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="domain.*" %>
	<div id="content" style="width:100% height:300px">
<%-- 	 <link rel="stylesheet" href="${ctx}/resources/css/style.css" /> --%>
	 	<%-- <jsp:include page="../common/head.jsp"/> --%>
	<table id="table">
		<tr>
			<td id=mypageImg" rowspan="3" colspan="2">
			<img src="${img}/${profile}" width="200" height="300"/>
			</td>
			<td><h2>ID</h2></td>
			<td><h2>${user.memId}</h2></td>
		</tr>
		<tr>
			<td><h2>이름</h2></td>
			<td><h2>${user.name}</h2></td>
	
		</tr>
		<tr>
			<td><h2>비번</h2></td>
			<td><h2>비밀번호 : ******</h2></td>
		</tr>
		<tr>
			<td><h2>나이</h2></td>
			<td><h2>${user.age}</h2></td>
			<td><h2>팀</h2></td>
			<td><h2>${user.teamId}</h2></td>
		</tr>
		<tr>
			<td><h2>성별</h2></td>
			<td><h2>${user.gender}</h2></td>
			<td><h2>역할</h2></td>
			<td><h2>${user.roll}</h2></td>
		</tr>
	</table>
<h3><a id="myPageMoveToUpdate">UPDATE FORM</a></h3>
<h3><a id="myPageMoveToDelete">DELETE FORM</a></h3>
</div>
<script>
  document.getElementById('myPageMoveToUpdate')
.addEventListener('click',function(){
alert('넘어간다요');
router.move({context:'${ctx}',
			domain : 'member',
			action: 'move',
			page: 'modify'})
			});
			
document.getElementById('myPageMoveToDelete')
.addEventListener('click',function(){
alert('넘어간다요');
router.move({context:'${ctx}',
			domain : 'member',
			action: 'move',
			page: 'remove'})
			});
</script>	
</body>

</html>

