<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!doctype html>
<html lang="en">
	<jsp:include page="../common/head.jsp"/>
<body>
<%--  <jsp:include page = "../common/validationForm.jsp"/>
  --%>
	<div class="margin-200-auto text-align width-200 border">
	<h2 class="text-align">사용자 로그인</h2>	
		<form id="loginForm"> 
			ID <br>
			<input type="text" name="userid" value="ID입력"><br>
			Pass <br>
			<input type="text" name="password" ><br>
			<input type="hidden" name="action" value="login" />
			<input type ="hidden" name="page" value="my_page" />
			<input id="loginFormBtn" type="button">
		</form><br>
	</div>
	<script>
   	document.getElementById("loginFormBtn")
	.addEventListener('click',function (){
		var form = document.getElementById('loginForm');
		member.setMemid(form.userid.value);
	    member.setPassword(form.password.value);
	   	if(member.loginValidation()){
	   		form.action = "${ctx}/member.do";
			form.method = "post"; //form tag만 post방식이 있다. get은 보임. post는 안보임. 비번있음 post. get이 더 빠름
	   		form.submit(); 
	   	}
	});
   	
	</script>
</body>
</html>