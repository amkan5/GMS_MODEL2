<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
  <%
	String ctx = application.getContextPath();
%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>updateForm</title>
</head>
<body>
 <jsp:include page = "../common/validationForm.jsp"/>
<h3>비밀번호 변경</h3>
<form name="updateForm" action="${ctx}/member.do"
		onsubmit="retrun validationForm()" method="get">
	ID <br>
	<input type="text" name="userId"><br>
	Pass <br>
	<input type="text" name="oldPass"><br>
	NewPass <br>
	<input type="text" name="newPass"><br>
	<input type="hidden" name="action" value="Update" />
	<input type="hidden" name="page" value="updateForm" />
	<input type="submit" value="제출">
</form>
	<a herf="../../main.jsp">돌아가기</a>
</body>
</html>