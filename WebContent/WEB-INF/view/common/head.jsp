<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<head>
<meta charset="UTF-8" />
	<title>main</title>
	<link rel="stylesheet" href="${ctx}/resources/css/style.css" />
	<script>
	var common = new (function Common(){
		this.move = function (domain, action, page){
			/* console.log('중복 테스트 성공'); */
			/* alert('클릭 테스트 성공!!'); */ //자바스크립트의 syso
			 location.href = "${ctx}/"+domain
			 				+".do?action=" + action
			 				+"&page=" + page; 
		}
	});
	var member = new (function (){
		var memId,ssn,password;
		this.setMemid = function(x){
			this.userid = x;
		}
		this.setSsn = function(x){
			this.ssn = x;
		}
		this.setPassword = function(x){
			this.password = x;
		}
		this.getMemid = function(){
			return this.userid;
		}
		this.getSsn = function(){
			return this.ssn;
		}
		this.getPassword = function(){
			return this.password;
		}
		this.loginValidation = function (){ //anonymous function
			if(this.memId===""){
				 alert("Please provide your name!" );
				 return false;
			}else if(this.password===""){
				alert("Please provide your password");
				 return false;
			}else{
				return true;
			}
		}
		this.joinValidation = function (){
			return false;
		}
	});
	// 이건 var member = new Member랑 같은 맥락임 
	</script>
</head>