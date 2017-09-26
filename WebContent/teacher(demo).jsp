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
		UserAccount user = (UserAccount)request.getSession().getAttribute("user");
    	String id = user.getUserId();
		List<AbroadApplyRecord> applys =AbroadApplyRecorddao.getMyApply(user.getUserId());
		
		Teacher teacher = Teacherdao.getOneTeacher(id);
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

			if(a=="审核")
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
				<li role="presentation" class="active">
					<a href="#home" aria-controls="home" role="tab" data-toggle="tab">个人出国信息查询</a>
				</li>
				<li role="presentation">
					<a href="#profile" aria-controls="profile" role="tab" data-toggle="tab">出国信息申请</a>
				</li>
				<li>
					<a  href="#" onclick="hrefClick()" >审批</a>
				</li>
				<li role="presentation">
					<a href="#modify" aria-controls="modifys" role="tab" data-toggle="tab">个人信息修改</a>
				</li>
				<li role="presentation">
					<a href="#settings" aria-controls="settings" role="tab" data-toggle="tab">帮助</a>
				</li>
			</ul>

			<!-- Tab panes -->
			<div class="tab-content">
				<!-- headline出国内容查询表 dependence Apply,Applydao-->
				<div role="tabpanel" class="tab-pane active" id="home">
					<p2>信息查询</p2>
					<div class="table-responsive">
					<table class="table table-bordered table-hover">
						<tr>
							<th>ID</th>
							<th>编号</th>
							<th>姓名</th>
							<th>出国国家</th>
							<th>出国原因</th>
							<th>出国时间</th>
							<th>返回时间</th>
							<th>资金来源</th>
							<th>出国状态</th>
							<th>出国内容</th>
							<th>审核状态</th>
							<th>详细内容</th>
						</tr>
						<% 
						if(applys!=null){
						for(int i=applys.size()-1;i>=0;i--){ 
							AbroadApplyRecord apply = applys.get(i);
						%>
						<tr>
							<td><%=apply.getUserId() %></td>
							<td><%=apply.getSerialNum() %></td>
							<td><%=apply.getUserName() %></td>
							<td><%=apply.getCountry() %></td>
							<td><%=apply.getReasontype() %></td>
							<td><%=apply.getBeginTime() %></td>
							<td><%=apply.getEndTime() %></td>
							<td><%=apply.getFundSource()%></td>
							<td><%=apply.getAbroadState() %></td>
							<td><%=apply.getReasonDetails() %></td>
							<td><%=apply.getAuditState() %></td>
							<td>
							<!-- 把number赋值给name，唯一标识每一行 -->
							 <a href="details.jsp?Number=<%=apply.getSerialNum()%>">详细内容</a>
							</td>
							<%
						}
							} 
							%>
						</tr>
					</table>
					
					</div>
				</div>
				<!--tail line 出国内容查询表 dependence Apply,Applydao-->
			
			
			
			
				<!--headline：申请出国表  dependence User-->
				<div role="tabpanel" class="tab-pane" id="profile">
					<p2>申请</p2>
					<div class="container" id="Apply_container">
		<form role="form"  action="servlet/ApplyAddServlet" method="post" accept-charset="utf-8" onsubmit="document.charset='utf-8';">
		<div class="input-group">
			<span class="input-group-addon" id="basic-addon1"> 教师 I D </span>
			<input type="text" name="applyid" class="form-control" value="<%=teacher.gettId()%>" >
		</div>
		<div class="input-group">
			<span class="input-group-addon" id="basic-addon1"> 姓  名  </span>
			<input type="text" name="applyname" class="form-control" value="<%=teacher.gettName() %>" >
		</div>
		<div class="input-group">
			<span class="input-group-addon" id="basic-addon1">出行国家</span>
			<input type="text" name="applycountry" class="form-control" placeholder="美国" >
		</div>
		<div class="input-group">
			<span class="input-group-addon" id="basic-addon1">出国原因</span>
			<input type="text" name="applyreasontype" class="form-control" placeholder="会议，留学，访谈" >
		</div>
		<div class="input-group">
			<span class="input-group-addon" id="basic-addon1">出行时间</span>
			<input type="text" name="applybegintime" class="form-control" placeholder="2017-02-01" >
		</div>
		<div class="input-group">
			<span class="input-group-addon" id="basic-addon1">返回时间</span>
			<input type="text" name="applyendtime" class="form-control" placeholder="2017-04-06" >
		</div>
		<div class="input-group">
			<span class="input-group-addon" id="basic-addon1">资金来源</span>
			<input type="text" name="applyfundsource" class="form-control" placeholder="公费（自费）" >
		</div>
		<div class="input-group">
			<span class="input-group-addon" id="basic-addon1">出行内容</span>
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
				
				<!--headline 修改表-->
				<div role="tabpanel" class="tab-pane" id="modify">
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