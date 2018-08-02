<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id ="menu-box">
<ul id="menu">
			<li><a href="${ctx}/common.do?">HOME</a></li>
			<li><a href="">ABOUT</a></li>
			<li><a id = "moveToAdmin">ADMIN</a></li>
	</ul>
</div>
<script>
document.getElementById('moveToAdmin') //# 빼먹지말자 
 .addEventListener('click',function(){
/*  alert('로그인 클릭 이벤트 체크 !!'); */
 admin.check("${ctx}");
 });	 
</script>