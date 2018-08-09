<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>updateForm</title>
	<jsp:include page="../common/head.jsp"/>
</head>
<body>
 <jsp:include page = "../common/validationForm.jsp"/>
<h3>비밀번호 변경</h3>
<form id="updateForm" name="updateForm" action="${ctx}/member.do">
	ID : ${user.memId} <br>
	<input type="hidden" name="memId" value="${user.memId}">
	Pass <br>
	<input type="text" name="oldPass" value="${user.password}"><br>
	NewPass <br>
	<input id = password type="text" name="newPass"><br>
	이름 : ${user.name}<br>
	현재 소속팀 : ${user.teamId}<br>
			<input type = "radio" id="teamId_1" name="teamid"
				value="a" /> 놀자
			<input type = "radio" id="teamId_2" name="teamid"
				value="h"/> 지은이	
			<input type = "radio" id="teamId_3" name="teamid"
				value="s"/> 터틀킹
			<input type = "radio"id="teamId_4"  name="teamid"
				value="c"/> 코딩스타
			<br>
	 프로젝트역할 ${user.roll}<br>
			<select name="roll" id="roll">
				<option value="Leader">팀장</option>
				<option value="front">프론트개발</option>
				<option value="back">백단개발</option>
				<option value="android">안드로이드개발</option>
				<option value="minfe">민폐</option>
			 </select><br>
	
<!-- <input type="hidden" name="page" value="my_page" />  -->
<input type="button" id="updateConformBtn" value="수정확인">

</form>

<Script>
var form = document.getElementById('updateForm'); //document의 object로 만든 객체. dom객체
 for(var i=1;i<=4;i++){
if(document.getElementById('teamId_'+i).value==='${user.teamId}'){
	document.getElementById('teamId_'+i).checked ='checked';
}
} 
var roll = document.getElementById('roll');
for(var i=0;i<roll.options.length;i++){
	if(roll.options[i].value==='${user.roll}'){
		roll.options[i].setAttribute("selected","selected");
	}
} 
/* form.roll.setAttribute("selected","selected"); */
//window.location.herf -> browser. bom객체 (익스플로어 )
document.getElementById('updateConformBtn')
.addEventListener('click',function(){
	alert('updateForm시작');
	if(form.newPass.value===''){
		form.oldPass.value = ${user.password}+"/"+${user.password};
	}else{
		form.oldPass.value = ${user.password}+"/"+form.newPass.value;
	}
	var node = document.createElement('input');
	node.setAttribute('type','hidden');
	node.setAttribute('name','action');
	node.setAttribute('value','update');					
	form.appendChild(node);
  form.action = "${ctx}/member.do";
  form.method = "post"; 
  form.submit();
  alert("updateForm입력완료"); //생각해보니까 roll이랑, teamid변경시 어따보냄?? 
});


		
</Script>
</body>
</html>