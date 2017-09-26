<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.util.*"%>
<%@ page import="entity.*,dao.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>教师系统</title>
		<link href="css/bootstrap.min.css" rel="stylesheet">

		<!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->
    
    <%
    	//UserAccount user = UserAccountdao.getUser("2017110003");
		UserAccount user = (UserAccount)request.getSession().getAttribute("user");		
		Teacher teacher = Teacherdao.getOneTeacher(user.getUserId());
		request.getSession().setAttribute("teacher", teacher);
		%>
		<style>
		/*全局样式*/
			 .table{
				padding-left: 50px;
				padding-right: 50px;
			}
			#welcome{
				margin-top: 10px;
				margin-bottom: 10px;
			}	
		
		/*申请表样式*/
		#Apply_container {
			padding-top: 40px;
			padding-left: 80px;
			padding-right: 80px;
		}
		 #Apply_container .input-group{
			margin-bottom: 20px;
			margin-top: 20px;
		}
		
		/*个人信息修改样式*/
		#motify_container{
			padding-top: 40px;
			padding-left: 80px;
			padding-right: 80px;
		}
		 #motify_container .input-group{
			margin-bottom: 20px;
			margin-top: 20px;
		}
		/*出国内容查询样式*/
		
		</style>
		<script type="text/javascript">
		function hrefClick(){
			var  a ="<%=user.getRole()%>";

			if(a!=3)
				window.location.href="audits.jsp";
			
		}
		fun();
		</script>
		
	</head>

	<body>
		
		<div class="text-center text-primary"><h1><strong>教师出国管理系统</strong></h1></div>
		<div id="welcome">您好，<%=user.getUserName()%>先生（女士）</div>
		<div><a href="index.jsp">退出登录</a></div>
		<div>

			<!-- Nav tabs -->
			<ul class="nav nav-tabs " role="tablist">
				<li role="presentation" >
					<a href="teacherinform.jsp" >个人出国信息查询</a>
				</li>
				<li role="presentation">
					<a href="teacherapply.jsp" >出国信息申请</a>
				</li>
				<li >
					<a  href="#" onclick="hrefClick()" >审批</a>
				</li>
				<li role="presentation" class="active">
					<a href="#modify" aria-controls="modifys" role="tab" data-toggle="tab">个人信息修改</a>
				</li>
				<li role="presentation">
					<a href="#settings" aria-controls="settings" role="tab" data-toggle="tab">帮助</a>
				</li>
			</ul>

			<!-- Tab panes -->
			<div class="tab-content">
			
				<!--headline 审批表-->
				<div role="tabpanel" class="tab-pane" id="messages">	
				</div>
				<!--tail line 审批表-->
				
				<!--headline 修改表-->
				<div role="tabpanel" class="tab-pane active" id="modify">
					<p>个人信息修改</p>
		<div class="container" id="motify_container">
		<form role="form" action="servlet/TeacherMotifyServlet" method="post" >
		<div class="input-group">
			<span class="input-group-addon" id="basic-addon1"> 教师 I D： </span>
			<input type="text"  class="form-control" value="<%=teacher.gettId() %>" disabled="true">
		</div>
		<div class="input-group">
			<span class="input-group-addon" id="basic-addon1"> 姓  名  </span>
			<input type="text" name="motifyname" class="form-control" value="<%=teacher.gettName() %>">
		</div>
		<div class="input-group">
			<span class="input-group-addon" id="basic-addon1"> 性别 </span>
			<input type="text" name="motifysex" class="form-control" value="<%=teacher.gettSex() %>">
		</div>
		<div class="input-group">
			<span class="input-group-addon" id="basic-addon1"> 出生年月  </span>
			<input type="text" name="motifybirthday" class="form-control" value="<%=teacher.gettBirthday() %>">
		</div>
		<div class="input-group">
			<span class="input-group-addon" id="basic-addon1"> 职 称  </span>
			<input type="text" name="motifytitle" class="form-control" value="<%=teacher.gettTitle()%>">
		</div>
		<div class="input-group">
			<span class="input-group-addon" id="basic-addon1"> 学历  </span>
			<input type="text" name="motifyeducation" class="form-control" value="<%=teacher.gettEducation()%>">
		</div>
		<div class="input-group">
			<span class="input-group-addon" id="basic-addon1"> 所在学院  </span>
			<input type="text" name="motifycollege" class="form-control" value="<%=teacher.gettCollege()%>">
		</div>
		<div class="row">
			<div class="col-md-1">	
			</div>
			<div class="col-md-2">
			<button type="submit" class="btn btn-primary" style="cursor: pointer;">determine</button>
			</div>
			<div class="col-md-9">
			<button type="reset" name="submit" class="btn btn-primary">reset</button>
			</div>
		</div>	
		</form>
		</div>
				</div>
				<!--tail line 修改表-->
				
				<!--headline 帮助-->
				<div role="tabpanel" class="tab-pane" id="settings">
					<p>帮助</p>
				</div>
				<!--tail line 帮助-->
			</div>

		</div>
		
		<script src="js/jquery-1.11.1.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
	</body>

</html>