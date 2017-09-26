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
		List<AbroadApplyRecord> applys =AbroadApplyRecorddao.getAllApply();
		
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
				<li role="presentation" class="dropdown active">
					 <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">出国信息查询 <span class="caret"></span></a>
					<ul class="dropdown-menu">
         			   <li><a href="teacherinform.jsp" >个人出国信息查询</a></li>
        			   <li><a href="#home2" aria-controls="home2" role="tab" data-toggle="tab">全体出国信息查询</a></li>
         			</ul>
					 
				</li>
				<li role="presentation">
					<a href="teacherapply.jsp" >出国信息申请</a>
				</li>
				<li>
					<a  href="#" onclick="hrefClick()" >审批</a>
				</li>
				<li role="presentation">
					<a href="teachermodify.jsp" >个人信息修改</a>
				</li>
				<li role="presentation">
					<a href="#settings" aria-controls="settings" role="tab" data-toggle="tab">帮助</a>
				</li>
			</ul>

			<!-- Tab panes -->
			<div class="tab-content">
			<!-- headline全体出国内容查询表 dependence Apply,Applydao-->
			
				
			
				<div role="tabpanel" class="tab-pane active" id="home2">
					<div><p2>全体出国信息查询</p2></div>
					<!-- 查找功能 -->
				<form class="navbar-form navbar-left"  action="servlet/SelectInformServlet">
      		  <div role="form" class="form-group">
        	  <input name="selectid" type="text" class="form-control" placeholder="请输入id">
  			  </div>
       		 <button type="submit" class="btn btn-default" style="cursor: pointer;">Submit</button>
      		</form>
				<!-- 查找功能 -->
					<%
					String sid = "";
					if(request.getSession().getAttribute("selectid")!=null)
					sid=(String)request.getSession().getAttribute("selectid");
					if(sid.equals("")){
					 applys =AbroadApplyRecorddao.getAllApply();
					}else
						applys = AbroadApplyRecorddao.getMyApply(sid);
					%>
					<div class="table-responsive">
					<table class="table table-bordered table-hover">
						<tr>
							<th>ID</th>
							<th>编号</th>
							<th>姓名</th>
							<th>出国国家</th>
							<th>申请时间</th>
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
						for(int i=0;i<applys.size();i++){ 
							AbroadApplyRecord apply = applys.get(i);
						%>
						<tr>
							<td><%=apply.getUserId() %></td>
							<td><%=apply.getSerialNum() %></td>
							<td><%=apply.getUserName() %></td>
							<td><%=apply.getCountry() %></td>
							<td><%=apply.getApplyTime() %></td>
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
				
				<!--tail line 全体出国内容查询表 dependence Apply,Applydao-->
			
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