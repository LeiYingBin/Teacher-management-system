<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%
   String path = request.getContextPath();
   String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
	<head>
		<!-- Page title -->
		<title>login failure</title>
		<!-- End of Page title -->
	</head>
	<body>
	<div id="container">
		<div id="box">
		     登录失败！请检查用户或者密码!<br>
		  <a href="index.jsp">返回登录</a>   
		</div>
	</div>
	</body>
</html>