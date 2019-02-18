<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<!--[if lt IE 9]>
<script type="text/javascript" src="lib/html5shiv.js"></script>
<script type="text/javascript" src="lib/respond.min.js"></script>
<![endif]-->
<link href="static/h-ui/css/H-ui.min.css" rel="stylesheet"
	type="text/css" />
<link href="static/h-ui.admin/css/H-ui.login.css" rel="stylesheet"
	type="text/css" />
<link href="static/h-ui.admin/css/style.css" rel="stylesheet"
	type="text/css" />
<link href="lib/Hui-iconfont/1.0.8/iconfont.css" rel="stylesheet"
	type="text/css" />
<!-- ICO图标 -->
<link rel="icon" type="text/css" href="favicon.ico">
<!--[if IE 6]>
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>LG后台登录</title>
</head>
<body>
	<input type="hidden" id="TenantId" name="TenantId" value="" />
	<div class="header">LGMall 后 台 管 理 系 统</div>
	<div class="loginWraper" >
		<div style="position: absolute; z-index: -1; top: 0px; left: 0px; bottom: 0px; right: 0px; overflow: hidden; background-size: cover; background-repeat: no-repeat; background-position: 50% 50%; background-image: none;">
			<video autoplay loop muted style="margin: auto; position: absolute; z-index: -1; top: 50%; left: 50%; transform: translate(-50%, -50%); visibility: visible; width: auto; height: 796px;">
				<source src="lib/video/Ipad.mp4" type="video/mp4">
			</video>
		</div>
		<div id="loginform" class="loginBox">
			<form class="form form-horizontal" action="" method="post">
				<div class="row cl">
					<label class="form-label col-xs-3"><i class="Hui-iconfont">&#xe60d;</i></label>
					<div class="formControls col-xs-8">
						<input id="J_username" name="username" type="text" placeholder="账户"
							class="input-text size-L">
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-3"><i class="Hui-iconfont">&#xe60e;</i></label>
					<div class="formControls col-xs-8">
						<input id="J_password" name="password" type="password" placeholder="密码"
							class="input-text size-L">
					</div>
				</div>
				<div class="row cl">
					<div class="formControls col-xs-8 col-xs-offset-3">
						<input id="J_code" class="input-text size-L" type="text" placeholder="验证码" style="width: 150px;">
						<div
							style="height: 40px; width: 110px; float: left; padding-left: 160px; margin-top: -40px;">
							<img id="img" src="${pageContext.request.contextPath}/checkImg"> <a
								id="kanbuq" href="javascript:changeImg()">看不清，换一张</a>
						</div>

					</div>
				</div>
				<div class="row cl">
					<div class="formControls col-xs-8 col-xs-offset-3">
						<input id="J_login" name="" type="button"  class="btn btn-success radius size-L"
							value="&nbsp;登&nbsp;&nbsp;&nbsp;&nbsp;录&nbsp;"> <input
							name="" type="reset" class="btn btn-default radius size-L"
							value="&nbsp;取&nbsp;&nbsp;&nbsp;&nbsp;消&nbsp;">
					</div>
				</div>
			</form>
		</div>
	</div>
	<div class="footer">Copyright © 2018-2018 乐购LG.com 版权所有</div>
	<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script>
	<script type="text/javascript" src="static/h-ui/js/H-ui.min.js"></script>
	<script type="text/javascript" src="lib/layer/2.4/layer.js"></script>
	<script type="text/javascript" src="js/index.js"></script>
	<script type="text/javascript">
	function changeImg(){
		var date = new Date().getTime();
		$("#img").attr("src", "/lgmall/checkImg?time" + date);
	}
	$("#J_login").click(function(){
		$("#J_login").val("登录中...");
	    $("#J_login").attr("disabled","disabled");
	    var name = $("#J_username").val();
	    var pass = $("#J_password").val();
	    var code = $("#J_code").val();
	    if(name == "" || pass == ""){
	    	layer.msg("用户名或密码不能为空!");
	    	$("#J_login").css("width","94.41px");
	    	$("#J_login").val("登    录");
	    	$("#J_login").removeAttr("disabled");
	    	return;
	    }
	    if(code == ""){
	    	layer.msg("验证码不能为空！");
	    	$("#J_login").css("width","94.41px");
	    	$("#J_login").val("登    录");
	    	$("#J_login").removeAttr("disabled");
	    	return;
	    }
	    var regex = /^[0-9A-Za-z_]+$/;
	    if(!regex.exec(name)){
	    	layer.msg("用户名格式有误！");
	    	$("#J_login").css("width","94.41px");
	    	$("#J_login").val("登    录");
	    	$("#J_login").removeAttr("disabled");
	    	return;
	    }
	    $.ajax({
	    	url: "${pageContext.request.contextPath}/adminLogin?time=" + new Date().getTime(),
	    	type:"Post",
	    	data:{ 
	    		username:name,
	    		password:pass,
	    		inputcode:code
	    	},
	    	success:function(date){
	    		if(date == "true"){
	    			window.location.href = "index.jsp";
	    		}else{
	    			changeImg();
	    			layer.msg(date);
	    	    	$("#J_login").css("width","94.41px");
	    	    	$("#J_login").val("登    录");
	    	    	$("#J_login").removeAttr("disabled");
	    		}
	    	},
	    	error:function(XMLHttpRequest){
	            layer.alert('数据处理失败! 错误码:'+XMLHttpRequest.status);
	            $("#J_login").css("width","94.41px");
	        	$("#J_login").val("登    录");
	            $("#J_login").removeAttr("disabled");
	        }
	    });
	});
	</script>
</body>
</html>