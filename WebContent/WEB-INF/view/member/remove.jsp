<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

	<div id="content" style="width:100% height:300px">
		<form name="deleteForm" id="deleteForm">
		ID : ${user.memId} <br>
		비밀번호 재확인<br>
		<input id = "password" type="text" name="password"><br>
	<!--  <input type="hidden" name="action" value="delete" /> 
	보여주기 위한 애가 아니라 넘기기위한 애라 화면에 있으면 안됨. 화면에는 보여주는 애만 --> 
	<input type="button" id="deleteConformBtn" value="수정확인">
	</form>
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
			//태그도 element에 하나 기존에 위에있던 히든 액션을 내려와서 썼으니 동적임.							
		 /* setNode.json({'node':node,'type':'hidden',
					'name':'action','value':'delete'});  */	
			var node = document.createElement('input');
			node.setAttribute('type',"hidden"),
			node.setAttribute('name',"action"),
			node.setAttribute('value',"remove");
			form.appendChild(node);  //위에 객체만 만들어있는애를 폼에 넣어주기 위해.  */
			form.submit();
		}
		else{
			alert("비밀번호가 다릅니다 ");
		}	
	})
	
	</script>
</body>
</html>