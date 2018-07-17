<%@page import="service.MemberServiceImpl"%>
<%@page import="service.MemberService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "domain.*" %>
  <%
	String ctx = application.getContextPath();
%>
   	<button><a href="<%= ctx %>/member/userLoginForm.do">로그인하러가기</a></button>
 