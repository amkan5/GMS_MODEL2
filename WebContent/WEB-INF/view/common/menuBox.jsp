<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id ="menu-box">
<ul id="menu">
			<li><a href="${ctx}/common.do?">HOME</a></li>
			<li><a href="">ABOUT</a></li>
			<li><a onclick = "new Common().move('admin','move','main')">ADMIN</a></li>
	</ul>
</div>