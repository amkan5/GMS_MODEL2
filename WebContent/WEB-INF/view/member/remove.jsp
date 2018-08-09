<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>delete</title>
	<link rel="stylesheet" href="${ctx}/resources/css/style.css" />
	<jsp:include page="../common/head.jsp"/>
</head>
<body>
<div id="wrapper">
	<div id="header">
		<jsp:include page="../common/titleBox.jsp"/>
		<jsp:include page="../common/loginBox.jsp"/>
		<jsp:include page="../common/menuBox.jsp"/>
	</div><!-- header end -->
	<div id="content">
		<jsp:include page="../common/contentBox.jsp"/>
	
	<form name="deleteForm" id="deleteForm">
	ID : ${user.memId} <br>
	비밀번호 재확인<br>
	<input id = "password" type="text" name="password"><br>
	<!--  <input type="hidden" name="action" value="delete" /> 
	보여주기 위한 애가 아니라 넘기기위한 애라 화면에 있으면 안됨. 화면에는 보여주는 애만 --> 
	<input type="button" id="deleteConformBtn" value="수정확인">
	</form>
	
	</div>
	<div id="footer">
		<jsp:include page="../common/footerBox.jsp"/>
	</div>
</div>
	<script>
	var form = document.getElementById('deleteForm'); //돔객체 
	document.getElementById('deleteConformBtn')
	.addEventListener('click',function(){
		if(form.password.value==="${user.password}"){
			form.action = "${ctx}/member.do";
			form.method = "post";
			//node.innerHTML = '<input type="hidden" name="action" value="delete"/>'; 오리지날방법
			//노드란 객체에 html을 넣어라. add attribute하지말공
			//태그도 element에 하나
							//기존에 위에있던 히든 액션을 내려와서 썼으니 동적임.							
		/* setNode.json({'node':node,'type':'hidden',
					'name':'action','value':'delete'}); */	
			var node = document.createElement('input');
			node.setAttribute('type',x.type),
			node.setAttribute('name',x.name),
			node.setAttribute('value',x.value); 
			form.appendChild(node); //위에 객체만 만들어있는애를 폼에 넣어주기 위해. 
			form.submit();
		}
		else{
			alert("비밀번호가 다릅니다 ");
		}	
	})
	
	</script>
</body>
</html>