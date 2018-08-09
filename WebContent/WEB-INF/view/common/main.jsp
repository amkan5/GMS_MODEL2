<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<c:set var="ctx" value="<%=application.getContextPath() %>"/> --%>
<!-- common 메인임  -->
<!doctype html>
<html lang="en">
	<jsp:include page="head.jsp"/>
<body>
<div id="wrapper">
	<div id="header">
		<jsp:include page="titleBox.jsp"/>
		<jsp:include page="loginBox.jsp"/>
		<jsp:include page="menuBox.jsp"/>
	</div><!-- header end -->
	<div id="content">
		<jsp:include page="contentBox.jsp"/>
	</div>
	<div id="footer">
		<jsp:include page="footerBox.jsp"/>
	</div>
	
</div>
<script>
	common.main('${ctx}');
	</script>
</body>
</html>