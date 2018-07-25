<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!doctype html>
<html lang="en">
<head>
	<jsp:include page="../common/head.jsp"/>
	<meta charset="UTF-8" />
	<title>회원가입</title>
</head>
<body>
	<div class="margin-200-auto text-align width-200 border">
	<h2 class="text-align">회원가입</h2>	
		<form name="joinForm" action="${ctx}/member.do"
		onsubmit="return validationForm()" method="get">
			ID <br>
			<input type="text" name="userid" value="ID입력"><br>
			Pass <br>
			<input type="text" name="password" value="비번입력" ><br>
			이름 <br>
			<input type="text" name="name" value="" ><br>
			주민번호<br>
			<input type="text" name="ssn" value="" ><br>
			<input type="hidden" name="action" value="join" />
			<input type ="hidden" name="page" value="joinResult" />
			<input type="submit" value="제출">
		</form><br>
	</div>
	<script>
   	document.getElementById("loginFormBtn")
	.addEventListener('click',function (){
		var form = document.getElementById('loginForm');
		member.setMemid(form.userid.value);
	    member.setPassword(form.password.value);
	    member.setSsn(form.ssn.value);
	    alert("유효성검사 "+member.loginValidation())
	   	if(member.joinValidation()){
	   		form.action = "${ctx}/member.do";
			form.method = "post"; //form tag만 post방식이 있다. get은 보임. post는 안보임. 비번있음 post. get이 더 빠름
	   		form.submit(); 
	   	}
	});
	</script>


</body>
</html>