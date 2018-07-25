<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
  <%
	String ctx = application.getContextPath();
%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>Document</title>
</head>
<body>
 <jsp:include page = "../common/validationForm.jsp"/>
	<h2 class="text-align">검색</h2>	
		<form name="searchId" action="${ctx}/member.do"
		onsubmit="return validationForm()" method="get">
			userID 입력 <br>
			<input type="text" name="userid"><br>
			<input type="hidden" name="action" value="retrieve" />
			<input type="hidden" name="page" value="searchIdResult"/>
			<input type="submit" value="제출">
		</form>
</body>
</html>