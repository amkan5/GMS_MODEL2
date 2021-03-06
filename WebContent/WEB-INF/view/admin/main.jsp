<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<c:set var="ctx" value="<%=application.getContextPath() %>"/>
<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8" />
	<jsp:include page="../common/head.jsp"/>
	<title>ADMIN main</title>
	<link rel="stylesheet" href="${ctx}/resources/css/style.css" />
</head>
<body>
<div id="wrapper">
	<div id="header">
		<jsp:include page="titleBox.jsp"/>
		<jsp:include page="menu.jsp"/>
	</div><!-- header end -->
	<div id="content">
		<jsp:include page="contentBox.jsp"/>
	</div>
	<div id="footer">
	   <jsp:include page="../common/footerBox.jsp"/>
	</div>
</div>
	
</body>
</html>