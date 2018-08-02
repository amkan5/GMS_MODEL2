<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="service.MemberServiceImpl"%>
<%@ page import = "domain.*" %>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>updateResult</ztitle>
	<jsp:include page="../common/head.jsp"/>
</head>
<body>
<form id="deleteForm" name="deleteForm" action ="${ctx}/member.do"></form>

<div id="wrapper">
	<div id="header">
		<jsp:include page="../common/titleBox.jsp"/>
		<jsp:include page="../common/loginBox.jsp"/>
		<jsp:include page="../common/menuBox.jsp"/>
	</div><!-- header end -->
	<div id="content">
		<jsp:include page="../common/contentBox.jsp"/>
		 비밀번호 재입력
	</div>
	<div id="footer">
		<jsp:include page="../common/footerBox.jsp"/>
	</div>
</div>
</body>
</html>