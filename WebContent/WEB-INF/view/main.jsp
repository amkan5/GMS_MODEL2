<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<c:set var="ctx" value="<%=application.getContextPath() %>"/>

<!doctype html>
<html lang="en">
<head>
	<jsp:include page="common/head.jsp"/>
</head>
<body>
<div id="wrapper">
	<div id="header">
		<jsp:include page="common/titleBox.jsp"/>
		<div id="login-box">
			<a href="${ctx}/member.do?action=move&page=userLoginForm">LOGIN</a>
			&nbsp;&nbsp;<a href="${ctx}/member.do?action=move&page=joinForm">JOIN</a>
		</div>
			<jsp:include page="common/menuBox.jsp"/>
	</div><!-- header end -->
	<div id="content">
		<jsp:include page="common/contentBox.jsp"/>
	</div>
	<div id="footer">
		<jsp:include page="common/footerBox.jsp"/>
	</div>
	
</div>

</body>
</html>