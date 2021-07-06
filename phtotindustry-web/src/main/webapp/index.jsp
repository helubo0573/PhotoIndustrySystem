<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>欢迎使用我的影楼管理系统</title>
	<!--favicon-->
	<link rel="icon" href="./images/favicon-32x32.png" type="image/png" />
	<!-- loader-->
	<link href="./css/pace.min.css" rel="stylesheet" />
	<script src="./js/pace.min.js"></script>
	<!-- Bootstrap CSS -->
	<link rel="stylesheet" href="./css/bootstrap.min.css" />
	<!-- Icons CSS -->
	<link rel="stylesheet" href="./css/icons.css" />
	<!-- App CSS -->
	<link rel="stylesheet" href="./css/app.css" />
</head>
<body onkeydown="keyLogin()"> 
	<!-- wrapper -->
	<div class="wrapper">
		<div class="section-authentication-login d-flex align-items-center justify-content-center">
			<div class="row">
				<div class="col-12 col-lg-10 mx-auto">
					<div class="card radius-15">
						<div class="row no-gutters">
							<div class="col-lg-6">
								<div class="card-body p-md-5">
									<div class="text-center">
										<img src="./images/logo-icon.png" width="80" alt="">
										<h3 class="mt-4 font-weight-bold">欢 迎 使 用</h3>
									</div>
									<div class="form-group mt-4">
										<label>账号</label>
										<input type="text" id="username" class="form-control" placeholder="请输入 用户名/邮箱/电话号码" />
									</div>
									<div class="form-group">
										<label>密码</label>
										<input type="password" id="password" class="form-control" placeholder="输入账号密码" />
									</div>
									<div class="form-row">
										<div class="form-group col">
											<div class="custom-control custom-switch">
												<input type="checkbox" class="custom-control-input" id="customSwitch1" checked>
												<label class="custom-control-label" for="customSwitch1">记住我</label>
											</div>
										</div>
										<div class="form-group col text-right"> <a href="authentication-forgot-password.html"><i class='bx bxs-key mr-2'></i>忘记密码?</a>
										</div>
									</div>
									<div class="btn-group mt-3 w-100">
										<button type="button" class="btn btn-light btn-block" onclick="login()">登录</button>
									</div>
									<hr>
									<div class="text-center">
										<p class="mb-0">还没有账号? <a href="register.jsp">点此注册</a>
										</p>
									</div>
								</div>
							</div>
							<div class="col-lg-6">
								<img src="./images/login-images/login-frent-img.jpg" class="card-img login-img h-100" alt="...">
							</div>
						</div>
						<!--end row-->
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- end wrapper -->
</body>
<script src="./plugins/jquery/jquery-3.3.1.min.js"></script>
<script src="./plugins/encrypt.js"></script>
<script type="text/javascript">
$(function(){
	if (window != top) top.location.href = location.href;
})
function keyLogin(){
 if (event.keyCode==13)  //回车键的键值为13
   $("#loginbt").click(); //调用登录按钮的登录事件
}
function login(){
	var username=$("#username").val().trim();
	var password=$("#password").val().trim();
	//var checkcode=$("#code-input").val().trim();
	if(username==""){
		alert("用户名不能为空");
		return;
	}
	if(password==""){
		alert("密码不能为空");
		return;
	}
	$.ajax({
		contenType:'application/json',
		Type:'POST',
		dataType:'json',
		url:"user/login.do",
		data:"username="+username+"&password="+hex_md5(password),
		success:function(data){
			if(data.code==200){
				layer.msg(data.msg)
				window.location="manage/mainpage.do";
			}else{
				layer.msg(data.msg,{time:3000,btn:['确定']})
				var times = (new Date()).getTime();
				var urls="user/getimgcode.do?timestamp="+times;
				$("#codeimg").attr("src",urls)
			}
		},
		error:function(data){
			alert(data.msg);				
		}
	})
}
</script>
</html>