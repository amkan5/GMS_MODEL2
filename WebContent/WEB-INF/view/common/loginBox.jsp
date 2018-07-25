<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="login-box">
	<a id="moveLoginForm" >LOGIN</a>
			&nbsp;&nbsp;
	<a onclick="common.move('member','move','joinForm')">JOIN</a>
		</div>
<script>/* 
var moveLoginForm = document.getElementById('moveLoginForm');
moveLoginForm.addEventClickLisner('click',function(){
	alert('클릭 이벤트 체크 !!');
	common.move('member','move','userLoginForm');
}); 한번밖에 안쓰니까 */

document.getElementById('moveLoginForm')
 .addEventListener('click',function(){
 alert('클릭 이벤트 체크 !!');
 common.move('member','move','userLoginForm');
 });	
 
 
</script>