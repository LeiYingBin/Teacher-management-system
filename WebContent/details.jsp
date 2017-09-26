<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.util.*"%>
<%@ page import="entity.*,dao.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>

	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>教师出国管理系统</title>
		<link href="css/bootstrap.min.css" rel="stylesheet">

		<!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->
		
	<style>
		.modal-body .input-group{
			margin-top: 10px;
			margin-bottom: 10px;
		}
	</style>
	</head>

	<body>
		<h1>详细信息</h1>
		<a href="teacherinform.jsp">返回</a>
		<%
		List<AbroadApplyRecord> applys =AbroadApplyRecorddao.getAllApply();
		int j = Integer.parseInt(request.getParameter("Number"));
		AbroadApplyRecord apply = new AbroadApplyRecord();
		for(int i=0;i<applys.size();i++){	
			if(applys.get(i).getSerialNum()==j)
				 apply = applys.get(i);
		}
		request.getSession().setAttribute("motifyapply", apply);
		%>	
		<div class="container " id="Apply_container">
		<form role="form" action="servlet/ApplyMotifyServlet" method="post">
		<div class="input-group">
			<span class="input-group-addon" id="basic-addon1"> 教师 I D </span>
			<input type="text" name="applyid" class="form-control" value="<%=apply.getUserId() %>" disabled="disabled" >
		</div>
		<div class="input-group">
			<span class="input-group-addon" id="basic-addon1"> 编 号 </span>
			<input type="text" name="applynum" class="form-control" value="<%=apply.getSerialNum() %>" disabled="disabled" >
		</div>
		<div class="input-group">
			<span class="input-group-addon" id="basic-addon1"> 姓  名  </span>
			<input type="text" name="applyname" class="form-control" value="<%=apply.getUserName() %>" disabled="disabled" >
		</div>
		<div class="input-group">
			<span class="input-group-addon" id="basic-addon1">申请时间</span>
			<input type="text" class="form-control" value="<%=apply.getApplyTime() %>" disabled="disabled" >
		</div>
		<div class="input-group">
			<span class="input-group-addon" id="basic-addon1">出行国家</span>
			<input type="text" name="applycountry" class="form-control" value="<%=apply.getCountry() %>" >
		</div>
		
		<div class="input-group">
			<span class="input-group-addon" id="basic-addon1">出行原因</span>
			<input type="text" name="applyreasontype" class="form-control" value="<%=apply.getReasontype() %>" >
		</div>
		<div class="input-group">
			<span class="input-group-addon" id="basic-addon1">出国时间</span>
			<input type="text" name="applybegintime" class="form-control" value="<%=apply.getBeginTime() %>" >
		</div>
		<div class="input-group">
			<span class="input-group-addon" id="basic-addon1">返回时间</span>
			<input type="text" name="applyendtime" class="form-control"  value="<%=apply.getEndTime() %>">
		</div>
		<div class="input-group">
			<span class="input-group-addon" id="basic-addon1">资金来源</span>
			<input type="text" name="applyfundsource" class="form-control"  value="<%=apply.getFundSource() %>">
		</div>
		<div class="input-group">
			<span class="input-group-addon" id="basic-addon1">出国状态</span>
			<input type="text" name="applyabroadstate"  class="form-control"  value="<%=apply.getAbroadState() %>" disabled="disabled">
		</div>
		<div class="input-group">
			<span class="input-group-addon" id="basic-addon1">审核状态</span>
			<input type="text" name="applyauditstate" id="111" class="form-control"  value="<%=apply.getAuditState() %>" disabled="disabled">
		</div>
		<div class="input-group">
			<span class="input-group-addon" id="basic-addon1">出行内容</span>
			<textarea cols="100" name="applyreasondetail"  rows="3" class="form-control" aria-describedby="basic-addon1" ><%=apply.getReasonDetails() %></textarea>
		</div>
		<div class="row">
			<div class="col-md-1">	
			</div>
			<div class="col-md-2">
			<button type="submit" id="submit" class="btn btn-default" style="cursor: pointer;">保存修改</button>
			</div>
			<div class="col-md-9">
			<button  type="reset" id="submit1" class="btn btn-primary">放弃修改</button>
			</div>
		</div>
			
		</form>
		
		</div>
		<div >
			<a href="servlet/ApplyDeleteServlet?number=<%=j %>"  type="submit"  id="submit2" class="btn btn-danger center">删除</a>
		</div>
		
		<script src="js/jquery-1.11.1.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
		
		<script>
			fun=function(){
				var  a = document.getElementById("111").value;
				if(a=="通过"){
					$("#submit").attr({"disabled":"disabled"});
					$("#submit1").attr({"disabled":"disabled"});
					$("#submit2").attr({"disabled":"disabled"});
				}
			}
			fun();
		</script>

	</body>

</html>