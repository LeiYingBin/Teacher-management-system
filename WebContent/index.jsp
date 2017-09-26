<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
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
			body {
				padding-top: 50px;
				padding-bottom: 40px;
				color: #5a5a5a;
			}
			
			#imagelogin{
				width: 800;
				height: 600;
				background-image: url(images/login.jpg);
				background-repeat: no-repeat;
				background-position: 100px 100px;
			}
			.form-horizontal{
				margin-top: 70px;
			}
			
		</style>

	</head>

	<body>
		<nav class="navbar navbar-default navbar-fixed-top">
			<div class="container">
				<!-- Brand and toggle get grouped for better mobile display -->
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
					<div class="navbar-brand " href="#" ><strong>教师出国管理系统</strong></div>
				</div>

				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
					<ul class="nav nav-tabs" role="tablist">
						<li role="presentation" class="active">
							<a href="#home" aria-controls="home" role="tab" data-toggle="tab">教师登录</a>
						</li>
						<li role="presentation">
							<a href="#profile" aria-controls="profile" role="tab" data-toggle="tab" >管理员</a>
						</li>
					</ul>

					<div class="tab-content">						
						<div role="tabpanel" class="tab-pane active" id="home">
							<!--
                            	作者：785626267@hotmail.com
                            	时间：2017-03-18
                            	描述：教师登录界面
                           -->
							<form class="form-horizontal" action="servlet/LoginServlet" method="post">
								<div class="form-group">
									<label  class="col-sm-2 control-label">ID：</label>
									<div class="col-sm-6">
										<input  class="form-control" name="ID" type="text" value="2017110003" placeholder="ID">
									</div>
									<div class="col-sm-4"></div>
								</div>
								<div class="form-group">
									<label for="inputPassword3"  class="col-sm-2 control-label">密码：</label>
									<div class="col-sm-6">
										<input type="password" name="password" class="form-control"   placeholder="Password">
									</div>
									<div class="col-sm-4"></div>
								</div>
								<div class="form-group">
									<div class="col-sm-offset-2 col-sm-10">
										<div class="checkbox">
											<label>
          										<input type="checkbox"> 记住密码
        									</label>
										</div>
									</div>
								</div>
								<div class="form-group">
									<div class="col-sm-offset-2 col-sm-10">
										<button type="submit" class="btn btn-primary" style="cursor: pointer;">登录</button>
									</div>
								</div>
							</form>
						</div>
						<div role="tabpanel" class="tab-pane" id="profile">
							<!--
                            	作者：785626267@hotmail.com
                            	时间：2017-03-18
                            	描述：管理员登录界面
                            -->
							<form class="form-horizontal" action="servlet/LoginServlet" method="post">
								<div class="form-group">
									<label for="inputEmail3" class="col-sm-2 control-label">管理员：</label>
									<div class="col-sm-6">
										<input  class="form-control" id="inputEmail3" placeholder="ID">
									</div>
									<div class="col-sm-4"></div>
								</div>
								<div class="form-group">
									<label for="inputPassword3" class="col-sm-2 control-label">密码：</label>
									<div class="col-sm-6">
										<input type="password" class="form-control" id="inputPassword3" placeholder="Password">
									</div>
									<div class="col-sm-4"></div>
								</div>
								<div class="form-group">
									<div class="col-sm-offset-2 col-sm-10">
										<div class="checkbox">
											<label>
          										<input type="checkbox"> 记住密码
        									</label>
										</div>
									</div>
								</div>
								<div class="form-group">
									<div class="col-sm-offset-2 col-sm-10">
										<button type="submit" class="btn btn-default">登录</button>
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
				<!-- /.navbar-collapse -->
			</div>
			<!-- /.container-fluid -->
		</nav>

		<script src="js/jquery-1.11.1.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
	</body>

</html>