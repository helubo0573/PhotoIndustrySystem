<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>加入公司</title>
<link rel="icon" href="${pageContext.request.contextPath}/images/favicon-32x32.png" type="image/png" />
<!-- loader-->
<!-- <link href="./css/pace.min.css" rel="stylesheet" />
<script src="./js/pace.min.js"></script> -->
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
<!-- Icons CSS -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/icons.css" />
<!-- App CSS -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/app.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/city-picker/css/city-picker.css?dd=202107142">
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
										<img src="${pageContext.request.contextPath}/images/logo-icon.png" width="80" alt="">
										<h3 class="mt-4 font-weight-bold">创建或加入门店</h3>
									</div>
									<div class="form-group mt-4">
										<div class="custom-control custom-radio custom-control-inline">
											<input class="form-check-input" name="companytype" type="radio" id="join" value="0" checked onchange="changetype('0')">
											<label class="form-check-label" for="join">加入公司</label>
										</div>
										<div class="custom-control custom-radio custom-control-inline">
											<input class="form-check-input" name="companytype" type="radio" id="create" value="1"  onchange="changetype('1')"> 
											<label class="form-check-label" for="create">建立公司</label>
										</div>
									</div>
									<div id="join-div" class="companytype-div">
										<form id="join-form" action="">
											<input type="hidden" name="joinCompanyId" id="joinCompanyId">
											<div class="form-group">
												<div class="class="trigger Free">
													<button type="button" class="btn btn-light radius-30 px-5" data-toggle="modal" data-target="#searchCompany">
														<i class="lni lni-magnifier" style="cursor: pointer;">查找门店</i>
													</button>
												</div>
											</div>
											<div class="form-group">
												<label>门店信息</label>
												<table class="table table-bordered table-dark">
													<tr>
														<th width="88px"><label>门店名称</label></th>
														<td width="300px">
															<label id="companyNameLab"></label>
														</td>
													</tr>
													<tr>
														<th><label>所在地</label></th>
														<td>
															<label id="companyLocationLab"></label>
														</td>
													</tr>
													<tr>
														<th><label>详细地址</label></th>
														<td>
															<label id="companyAddressLab"></label>
														</td>
													</tr>
												</table>
											</div>
											<div class="btn-group mt-3 w-100">
												<button type="button" class="btn btn-light" onclick="joinCompany()">提交加入申请</button>
											</div>
										</form>
									</div>
									<div id="create-div" class="companytype-div" style="display: none;" >
										<form id="create-form" action="">
											<div class="form-group">
												<label>门店名称</label>
												<input class="form-control" name="companyName" placeholder="填写你的门店名称" maxlength="12"/>
											</div>
											<div class="form-group">
												<label>营业执照编号</label>
												<input class="form-control" name="companyId" placeholder="填写营业执照上的统一社会信用代码" />
											</div>
											<div class="form-group">
												<label>所在地</label>
												<div style="position: relative;">
													<input class="form-control" readonly data-code type="text" value="" placeholder="请点击选择所在地区" id="createCLocation">
												</div>
											</div>
											<div class="form-group">
												<label>详细地址</label>
												<input type="text" class="form-control" name="detailAddress" id="detailAddress" placeholder="请填写门店详细地址" />
											</div>
											<div class="form-group">
												<label>门店员工人数</label>
												<input class="form-control" name="numberEmployee" type="number" placeholder="请输入门店的大概员工数" />
											</div>
											<div class="btn-group mt-3 w-100">
												<button type="button" class="btn btn-light" onclick="createCompany()">保存</button>
											</div>
										</form>
									</div>
									<hr/>
								</div>
							</div>
							<div class="col-lg-6">
								<img src="${pageContext.request.contextPath}/images/login-images/register-frent-img.jpg" class="card-img login-img h-100" alt="...">
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="modal fade" id="searchCompany" tabindex="-1" role="dialog" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered" style="width: 400px">
			<div class="modal-content radius-30">
				<div class="modal-header border-bottom-0">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body" style="height: 400px;">
					<h3 class="text-center">输入查询信息</h3>
					<div class="form-group">
						<label>门店名称</label>
						<input type="text" class="form-control" id="s-companyname" />
					</div>
					<div class="form-group" style="height: 200px">
						<label>门店所在地</label>
						<div style="position: relative;">
							<input class="form-control" readonly data-code type="text" value="" placeholder="请点击选择所在地区" id="s-companyLocation">
						</div>
					</div>
					<div class="form-group">
						<button type="button" class="btn btn-light radius-30 btn-block" onclick="searchCompany()">查询</button>
					</div>
					<hr/>
				</div>
			</div>
		</div>
	</div>
	<div class="modal fade" id="companyListDiv" tabindex="-1" role="dialog" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered modal-lg" style="width: 400px;">
			<div class="modal-content bg-seccuse border-0">
				<div class="modal-header border-bottom-0">
					<h5 class="modal-title">找到多个门店,请点击选择</h5>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">	
					<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<table class="table table-hover table-dark" id="companyListTable">
						<thead>
							<tr>
								<th>名称</th>
								<th>地址</th>
							</tr>
						</thead>
						<tbody></tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/plugins/jquery/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/plugins/city-picker/js/city-picker.data.js?d=202107173"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/plugins/city-picker/js/city-picker.js?d=2021071411"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/plugins/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/plugins/bootstrapConfirm.js"></script>
<script type="text/javascript">
$(function(){
	$("#s-companyLocation").citypicker();
})
function changetype(type){
	$(".companytype-div").hide();
	if(type==0){
		$("#join-div").show();
	}else{
		$("#create-div").show();
		$("#createCLocation").citypicker();
	}
}
function createCompany(){
	if(checkCompanyInfo()){
		$.ajax({
			contenType:'application/json',
			Type:'POST',
			dataType:'json',
			data:$("#create-form").serialize()+"&location="+$("#createCLocation").attr("data-code"),
			url:"../company/createcompany.do",
			success:function(data){
				alert(data.msg)
				if(data.code==200){
					window.location="homepage.do";
				}
			}
		})
	}
}
function joinCompany(){
	$.ajax({
		contenType:'application/json',
		Type:'POST',
		dataType:'json',
		data:$("#join-form").serialize(),
		url:"../company/joincompany.do",
		success:function(data){
			alert(data.msg)
			if(data.code==200){
				window.location="homepage.do";
			}
		}
	})
}
function checkCompanyInfo(){
	
	return true;
}
function checkCompanys(){
	var cname=$("#s-companyname").val().trim();
	var clocation=$("#s-companyLocation").attr("data-code").trim();
	if(cname==""){
		alert("请填写门店名称");
		return false;
	}
	if(clocation==""){
		alert("请选择门店所在地")
	}
	return true;	
}
function searchCompany(){
	if(checkCompanys()){
		$.ajax({
			contenType:'application/json',
			Type:'POST',
			dataType:'json',
			data:"companyname="+$("#s-companyname").val().trim()+"&companylocation="+$("#s-companyLocation").attr("data-code").trim(),
			url:"../company/searchcompany.do",
			success:function(data){
				if(data.msg==200){
					if(data.size==0){
						alert("未搜索到相关门店！")
					}else{
						if(data.size>5){
								alert("搜索到的门店过多，请尝试填写更详细的门店名称以缩小搜索范围")
						}else{
							$('#searchCompany').modal('hide')
							if(data.size==1){
								setCompanyinfo(data.data[0].id,data.data[0].companyName,data.data[0].companyLocation,data.data[0].detailAddress)
							}else{
								$("#companyListDiv").modal('show')
								$.each(data.data,function(index,company){
									$("#companyListTable tbody").append("<tr onclick='setCompanysInfo(\""+this.id+"\",\""+this.companyName+"\",\""+this.companyLocation+"\",\""+this.detailAddress+"\")'><td><lable>"+this.companyName+"</lable></td><td><lable>"+this.detailAddress+"</lable></td></tr>")
								})
							}
						}
					}
					
				}
			}
		})
	}
}
function setCompanysInfo(companyid,cName,cLocation,cAddress){
	$("#companyListDiv").modal('hide');
	setCompanyinfo(companyid,cName,cLocation,cAddress);
	$("#companyListTable tbody").empty();
}
function setCompanyinfo(companyid,cName,cLocation,cAddress){
	$("#joinCompanyId").val(companyid)
	$("#companyNameLab").text(cName)
	$("#companyLocationLab").text(outputDetailInfo(cLocation));
	$("#companyAddressLab").text(cAddress)
}
$("#searchCompany").on('show.bs.modal', function () {
	$("#s-companyLocation").citypicker();
})

</script>
</html>