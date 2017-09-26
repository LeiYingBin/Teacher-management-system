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
		     已经成功修改个人信息<br>
		  <a href="teachermodify.jsp">返回</a>   
		</div>
	</div>
	</body>
</html>