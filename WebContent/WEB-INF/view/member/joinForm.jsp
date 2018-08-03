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
		<form id="joinForm" name="joinForm">
			ID <br>
			<input type="text" name="userid" value=""><br>
			Pass <br>
			<input type="text" name="password" value="1" ><br>
			이름 <br>
			<input type="text" name="name" value="" ><br>
			주민번호<br>
			<input type="text" name="ssn" value="950713-1" ><br>
			소속팀<br>
			<input type ="radio" name="teamid"
				value="none" checked="checked" /> 없음
			<input type = "radio" name="teamid"
				value="a"/> 놀자
			<input type = "radio" name="teamid"
				value="h"/> 지은이	
			<input type = "radio" name="teamid"
				value="s"/> 터틀킹
			<input type = "radio" name="teamid"
				value="c"/> 코딩스타
			<br>
			프로젝트역할<br>
			<select name="roll" id="roll">
				<option value="Leader">팀장</option>
				<option value="front" selected="selected">프론트개발</option>
				<option value="back" >백단개발</option>
				<option value="android" >안드로이드개발</option>
				<option value="minfe">민폐</option>
			 </select><br>
			수강과목<br>
			<input type="checkbox" name="subject"
			 value="java"  /> java<br>
			 <input type="checkbox" name="subject" value="clang" /> c언어<br>
			 <input type="checkbox" name="subject" value="JSP" /> JSP<br>
			 <input type="checkbox" name="subject" value="PHP" /> PHP<br>
			 <input type="checkbox" name="subject" value="nodejs" checked="checked"/> nodejs<br>
			 <input type="checkbox" name="subject" value="Linux" /> Linux<br>
			 <input type="checkbox" name="subject" value="html" /> Html<br>
			 <input type="checkbox" name="subject" value="spring"  /> spring<br>
			  
			  
			<!-- <input type ="hidden" name="gender"  />
			<input type ="hidden" name="age"/>
			<input type="hidden" name="action" value="join" /> -->
			<!-- <input type ="hidden" name="page" value="userLoginForm" /> -->
			<input id="joinFormBtn" type="button" value="제출">
		</form><br>
	</div>
	<script>
   	document.getElementById("joinFormBtn")
	.addEventListener('click',function (){
		var form = document.getElementById('joinForm');
		var x = service.nullChecker(
				{
				 userid:document.joinForm.userid.value,
				 password:document.joinForm.password.value,
				 name:document.joinForm.name.value,
				 ssn:document.joinForm.ssn.value
					});  
	    if(x.checker){
	    	var form = document.getElementById('joinForm');
	    	form.action = "${ctx}/member.do";
			form.method = "post";
			member.join({
				 userid:document.joinForm.userid.value,
				 password:document.joinForm.password.value,
				 name:document.joinForm.name.value,
				 ssn:document.joinForm.ssn.value
					}); 
			//document.joinForm.age.value = member.getAge();
			//document.joinForm.gender.value = member.getGender();
			alert(member.getAge());
			 var json = [{'name': 'action',
						'value': 'join'},
						{'name':'age',
							'value': member.getAge()},
						{'name':'gender',
								'value':member.getGender()}
						];
	/* 		var json2 = {'type':'hidden','name':'age',
						'value': member.getAge()}  */
		  for (var i=0;i<3;i++){ 
			var node = document.createElement('input');
			node.setAttribute('type','hidden');
			node.setAttribute('name',json[i].name);
			node.setAttribute('value',json[i].value);
		 form.appendChild(node); 
		  }
		alert(json[0].value);
			form.submit(); 
		}else{
			alert(x.text);
		}
	});
	</script>


</body>
</html>