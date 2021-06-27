<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注册你的账号</title>

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
<body>
	<div class="wrapper">
		<div class="section-authentication-register d-flex align-items-center justify-content-center">
			<div class="row">
				<div class="col-12 col-lg-10 mx-auto">
					<div class="card radius-15">
						<div class="row no-gutters">
							<div class="col-lg-6">
								<div class="card-body p-md-5">
									<div class="text-center">
										<img src="./images/logo-icon.png" width="80" alt="">
										<h3 class="mt-4 font-weight-bold">注册你的账号</h3>
									</div>
									<div class="form-group mt-4">
										<label>账号</label>
										<input type="text" class="form-control" placeholder="设置6-12位长度账号" />
									</div>
									<div class="form-group">
										<label>密码</label>
										<input class="form-control" type="password" placeholder="设置8-12位密码，必须由大小写英文字母及数字组成" />
									</div>
									<div class="form-group">
										<label>重复密码</label>
										<input class="form-control" type="password" placeholder="重复输入的密码以确保输入正确" />
									</div>
									<div class="form-group">
										<label>邮箱地址</label>
										<input type="text" class="form-control" placeholder="请输入你的邮箱地址" />
									</div>
									<div>
										<div class="form-group">
											<label>手机号码</label>
											<input type="text" class="form-control" placeholder="请输入11位手机号码" />
										</div>
									</div>
									<div class="form-group">
										<label>Country</label>
										<select class="form-control">
											<option>India</option>
											<option>United Kingdom</option>
											<option>America</option>
											<option>Dubai</option>
										</select>
									</div>
									<div class="form-group">
										<div class="custom-control custom-checkbox">
											<input type="checkbox" class="custom-control-input" id="customCheck1">
											<label class="custom-control-label" for="customCheck1">我已阅读并同意服务协议</label>
										</div>
									</div>
									<div class="btn-group mt-3 w-100">
										<button type="button" class="btn btn-light btn-block">注册</button>
										<button type="button" class="btn btn-light"><i class="lni lni-arrow-right"></i>
										</button>
									</div>
									<hr/>
									<div class="text-center mt-4">
										<p class="mb-0">已存在账号? <a href="index.jsp">去登录</a>
										</p>
									</div>
								</div>
							</div>
							<div class="col-lg-6">
								<img src="./images/login-images/register-frent-img.jpg" class="card-img login-img h-100" alt="...">
							</div>
						</div>
						<!--end row-->
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>