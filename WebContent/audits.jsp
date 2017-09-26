<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.util.*"%>
<%@ page import="entity.*,dao.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>审批</title>
<link href="css/bootstrap.min.css" rel="stylesheet">

		<!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<h1>出国信息审批</h1>
<%
List<AbroadApplyRecord> auditsapplys = new ArrayList<AbroadApplyRecord>();
auditsapplys =  AbroadApplyRecorddao.getAudits();
request.getSession().setAttribute("auditsapplys", auditsapplys);

%>

<div>
	<a href="teacherinform.jsp">返回</a>
</div>
				<div role="tabpanel" class="tab-pane active" id="home">
					
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
							<th>审核</th>
						</tr>
						<% 
						if(auditsapplys!=null){
						for(int i=auditsapplys.size()-1;i>=0;i--){ 
							AbroadApplyRecord apply = auditsapplys.get(i);
							
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
							<a type="submit" href="servlet/ApplyAuditsServlet?number=<%="1,"+apply.getSerialNum() %>"  class="btn btn-default" >通过</a>
							<a type="submit" href="servlet/ApplyAuditsServlet?number=<%="0,"+apply.getSerialNum() %>" class="btn btn-danger" >不通过</a>
							</td>
							<%
						}
							} 
							%>
						</tr>
					</table>
					
					</div>
				</div>
<script src="js/jquery-1.11.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>