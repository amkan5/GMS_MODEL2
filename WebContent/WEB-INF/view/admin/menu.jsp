<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id ="menu-box">
			<ul id="menu">
				<li><a onclick = "new Common().move('member','move','memberlist')">회원목록</a></li>
				<li><a onclick = "new Common().move('member','move','searchIdForm')">회원검색</a></li>
				<li><a onclick = "new Common().move('member','move','searchTeamForm')">팀이름검색</a></li>
				<li><a onclick = "new Common().move('member','move','updateForm')">비밀번호변경</a></li>
				<li><a onclick = "new Common().move('member','move','deleteForm')">삭제</a></li>
			</ul>
		</div>