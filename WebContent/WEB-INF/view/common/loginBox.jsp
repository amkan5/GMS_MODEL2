<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<div id="login-box">
			<c:choose>
			<c:when test = "${user.memId != null}">
				<a class ="logins" id="LogOut">LogOut</a>
			</c:when>
			<c:otherwise>
			<a class ="logins" id="Login">Login</a>
			</c:otherwise>
			</c:choose>
			&nbsp;&nbsp;
			
	<a id="moveJoinForm">JOIN</a>
		</div>
<script>
/* 
var moveLoginForm = document.getElementById('moveLoginForm');
moveLoginForm.addEventClickLisner('click',function(){
	alert('클릭 이벤트 체크 !!');
	common.move('member','move','userLoginForm');
}); 한번밖에 안쓰니까 */

for(var i of document.querySelectorAll('.logins')){
		i.addEventListener('click',function(){
		if(this.getAttribute('id')=='LogOut'){
			alert('로그아웃 이벤트 체크 !!');
			router.move({context:'${ctx}',
						domain : 'member',
						action: 'login',
						page: 'logout'})
		}else{
			alert('로그인 클릭 이벤트 체크 !!');
			 router.move({context:'${ctx}',
						domain : 'member',
						action: 'move',
						page: 'login'})
						}
		})}
; 


/* document.getElementById('moveLoginForm')
 .addEventListener('click',function(){
alert('로그인 클릭 이벤트 체크 !!');
 router.move({context:'${ctx}',
			domain : 'member',
			action: 'move',
			page: 'login'})
			});

document.getElementById('moveLogOutForm')
.addEventListener('click',function(){
alert('로그아웃 이벤트 체크 !!');
router.move({context:'${ctx}',
			domain : 'member',
			action: 'logout',
			page: 'login'})
			});  */
			
/* document.getElementById('moveJoinForm')
 .addEventListener('click',function(){
 alert('조인 클릭 이벤트 체크 !!');
 new Common().move('${ctx}','member','move','joinForm');
 });
  */
 document.getElementById('moveJoinForm')
 .addEventListener('click',function(){
  alert('조인 클릭 이벤트 체크 !!');
  router.move({context:'${ctx}',
	  			domain : 'member',
	  			action: 'move',
	  			page: 'add'})
 				});


</script>