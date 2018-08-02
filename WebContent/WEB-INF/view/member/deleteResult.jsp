<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="service.MemberServiceImpl"%>
<%@ page import = "domain.*" %>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>deleteResult</title>
	<jsp:include page="../common/head.jsp"/>
</head>
<body>
<jsp:include page = "../common/validationForm.jsp"/>
<h3>회원탈퇴</h3>
<form name="deleteForm" id="deleteForm">
	ID <br>
	<input type="text" name="userId"><br>
	Pass <br>
	<input type="text" name="Pass"><br>
	<input type="hidden" name="action" value="delete" />
	<input type="submit" value="제출">
</form>
</body>
</html>