<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
		<div id="content-box">
		<div id="searchBox">
		<input type="button" id='searchBtn' value="검색"/> 
		<input type="text" id='searchWord' placeholder="검색어 입력"/>
		<select name="searchSelect" id="searchOption">
				<option value="option">검색조건</option>
				<option value="memid">아이디</option>
				<option value="name">이름</option>
				<option value="teamId">팀명</opsion>
			 </select>
		
		<!-- get으로보내 보안필요없잖 -->
		</div>
			<table id="contentBoxTab">
			<tr id="contentBoxMeta">
				<td>아이디</td>
				<td>이 름</td>
				<td>나 이</td>
				<td>성별</td>
				<td>역 할</td>
				<td>팀 명</td>
			</tr>
			<c:forEach items="${list}" var="member" > 
			<tr>
				<td>${member.memId}</td>
				<td><a <%-- href="${ctx}/admin.do?action=retrieve&page=memberDetail&userid=${member.memId}" --%> 
				class= "username"  id="${member.memId}">
				${member.name}</a> </td>
				<td>${member.age}</td>
				<td>${member.gender}</td>
				<td>${member.roll}</td>
				<td>${member.teamId}</td>
			</tr>
			</c:forEach>
			<tr id='page'>
			 <td colspan ="6">
			 	<%-- 전체 회원수 : ${count} --%>
			 	<ul class="pageBox">
			 	 <c:forEach begin="${beginPage}" end="${endPage}" step="1" varStatus="i"> 
			 		<li>
			 		<span><a class="pageNums" id="${i.index}" >${i.index}</a></span> 
			 		</li>
			 		</c:forEach> 
			 		<c:if test="${existNext}">  
			 		<li>다음▶</li>
			 		</c:if>
			 	</ul>
			 	   
			</tr>
		</table>
		
		</div>
	<script>
	admin.main('${ctx}');
	
	
	//클릭없이 바로 뿌려줘야해 userid도 넘겨줘야하는데? 흠... <input type="text" name="userid" value="">
	 
	
	//document.getElementById('contentBoxMeta').className = 'bgColorisYellow'; 오리지널 
	//나중엔 다 함수에 의한 호출만 쓰니까 아래처럼 바꾸는거. 
	/* 
	

	
	 */
	
/*걍혼자해본거 	document.getElementById('${member.memId}')
	 .addEventListener('click',function(){
	  alert('넘어간다요');
	  	var node = documnet.createElement('input');
	  	node.setAttribute('type','hidden');
	  	node.setAttribute('name',)
	  	node.setAttribute('value','update');
	  	
	  	form.action = "${ctx}/madmin.do";
	    form.method = "get"; 
		  form.submit();
	 				});  */

			
						 
			
	</script>