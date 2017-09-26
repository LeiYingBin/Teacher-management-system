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
				<li role="presentation" class="active">
					<a href="#profile" aria-controls="profile" role="tab" data-toggle="tab">出国信息申请</a>
				</li>
				<li >
					<a  href="#" onclick="hrefClick()" >审批</a>
				</li>
				<li role="presentation" >
					<a href="teachermodify.jsp" >个人信息修改</a>
				</li>
				<li role="presentation">
					<a href="#settings" aria-controls="settings" role="tab" data-toggle="tab">帮助</a>
				</li>
			</ul>

			<!-- Tab panes -->
			<div class="tab-content">
				<!--headline：申请出国表  dependence User-->
				<div role="tabpanel" class="tab-pane active" id="profile">
					<p2>申请</p2>
					<div class="container" id="Apply_container">
		<form role="form"  action="servlet/ApplyAddServlet" method="post" accept-charset="utf-8" onsubmit="document.charset='utf-8';">
		<div class="input-group">
			<span class="input-group-addon" > 教师 I D </span>
			<input type="text" name="applyid" class="form-control" value="<%=teacher.gettId()%>"  >
		</div>
		<div class="input-group">
			<span class="input-group-addon" > 姓  名  </span>
			<input type="text" name="applyname" class="form-control" value="<%=teacher.gettName() %>" >
		</div>
		<div class="input-group">
			<span class="input-group-addon" >出行国家</span>
			<input type="text" name="applycountry" class="form-control" placeholder="美国" >
		</div>
		<div class="input-group">
			<span class="input-group-addon" >出国原因</span>
			<input type="text" name="applyreasontype" class="form-control" placeholder="会议，留学，访谈" >
		</div>
		<div class="input-group">
			<span class="input-group-addon" >出行时间</span>
			<input id="begintime" type="text" name="applybegintime" class="form-control" placeholder="2017-02-01" >
		</div>
		<div class="input-group">
			<span class="input-group-addon" >返回时间</span>
			<input id="endtime" type="text" name="applyendtime" class="form-control" placeholder="2017-04-06" >
		</div>
		<div class="input-group">
			<span class="input-group-addon" >资金来源</span>
			<input type="text" name="applyfundsource" class="form-control" placeholder="公费（自费）" >
		</div>
		<div class="input-group">
			<span class="input-group-addon" >出行内容</span>
			<textarea cols="100" name="applyreasondetail"  rows="3" class="form-control" aria-describedby="basic-addon1 placeholder="出国的内容描述"></textarea>
		</div>
		<div class="row">
			<div class="col-md-1">	
			</div>
			<div class="col-md-2">
			<button type="submit" class="btn btn-primary" style="cursor: pointer;">submit</button>
			</div>
			<div class="col-md-9">
			<button type="reset" name="reset" class="btn btn-primary">reset</button>
			</div>
		</div>	
		</form>
		</div>
					
				</div>
				<!--tail line:申请出国表  -->
				
				
				
				<!--headline 审批表-->
				<div role="tabpanel" class="tab-pane" id="messages">	
				</div>
				<!--tail line 审批表-->
				<!--headline 帮助-->
				<div role="tabpanel" class="tab-pane" id="settings">
					<p>帮助</p>
				</div>
				<!--tail line 帮助-->
			</div>

		</div>
		<script>
    	var b = document.getElementById("begintime");
    	
    	b.onblur = function(){
    		bt=b.value;
    		if(bt=="")
    		alert("请填写出行时间");
    	}
    	
    </script>
	<script type="text/javascript">
		var b = document.getElementById("begintime");
		var e = document.getElementById("endtime");
        e.onblur = function(){
        	bt = b.value;
    		et=e.value;
    		if(et==""){
    			alert("请填写返回时间");
    		}	
    		else{
    			var begintime= new Date(Date.parse(bt)); 
    			var endtime= new Date(Date.parse(et)); 	
				if(begintime>endtime)
				alert("出行时间晚于返回时间");
    		}
			
		}
    </script>
		
		<script src="js/jquery-1.11.1.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
	</body>

</html>