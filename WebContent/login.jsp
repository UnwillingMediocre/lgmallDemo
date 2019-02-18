<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="UTF-8">
<title>乐购-欢迎登录</title>
<!-- ICO图标 -->
<link rel="shortcut icon" href="<%=basePath%>/img/favicon.ico">
<!-- 引入css -->
<link rel="stylesheet" href="<%=basePath%>/css/login.css" />
<style type="text/css">
.lheader .logo a {
	display: inline-block;
	background: url("img/logo_2.png") no-repeat;
	width: 170px;
    height: 100px;
	line-height: 100px;
	margin-right: 20px;
}
</style>
</head>
<body>
	<div class="lheader">
		<div class="w clearfix">
			<div class="fl">
				<div class="logo fl">
					<a href="index.jsp" class="bglogo"></a> <b></b>
				</div>
			</div>
			<!-- <div class="fr">
				<i></i>&nbsp;<a href="#" style="padding-bottom: 0px;">登录页面，调查问卷</a>
			</div> -->
		</div>
	</div>
	<div class="lcontainer">
		<div class="lts">
			<i></i>依据《网络安全法》，为保障您的账户安全和正常使用，请尽快完成手机号验证！ 新版<a href="#">《乐购隐私政策》</a>已上线，将更有利于保护您的个人隐私。
		</div>
		<div class="bg">
			<div class="loginw">
				<div class="login">
					<div class="warn">
						<i class="icon_tips"></i>乐购不会以任何理由要求您转账汇款，谨防诈骗。
					</div>
					<div class="login_method">
						<div class="login_l fl">
							<a href="javascript:;" id="sm" class="active">扫码登录</a>
						</div>
						<div class="spacer">|</div>
						<div class="login_r fr">
							<a href="javascript:;" id="zh">账户登录</a>
						</div>
					</div>
					<div class="sm_login_box" id="sm_box">
						<div class="ewm">
							<div class="ewmbox">
								<img src="img/show.png" alt="扫一扫" id="show_img" /> <img
									src="img/phone-orange.png" alt="手机" id="phone_orange" />
							</div>
						</div>
						<div class="pane clearfix">
							<ul>
								<li>打开<a href="#" target="_blank">手机京东</a></li>
								<li>扫描二维码</li>
							</ul>
						</div>
						<div class="qr">
							<ul>
								<li><i class="qr1"></i><span>免输入</span></li>
								<li><i class="qr2"></i><span>更快</span></li>
								<li><i class="qr3"></i><span>更安全</span></li>
							</ul>
						</div>
					</div>
					<div class="zh_login_box" id="zh_box">
						<div class="msg">
							<i></i>
						</div>
						<div class="form">
							<form id="formLogin" method="post" action="">
								<div class="zh_box">
									<label for="loginName" class="name_icon"></label> <input
										type="text" placeholder="邮箱/用户名/已验证手机" id="loginName"
										id="CheckMsg" />
								</div>
								<div class="pw_box">
									<label for="loginPw" class="pw_icon"></label> <input
										type="password" placeholder="密码" id="loginPw" id="CheckMsg" />
								</div>
								<p>
									<a href="forgotpwd.jsp" class="fr">忘记密码</a>
								</p>
								<div class="loginLine">
									<input type="button" value="登&nbsp;&nbsp;录"
										onclick="return check(this.form);" class="loginBtn" />
								</div>
							</form>

						</div>
					</div>
					<div class="dsf">
						<div class="fl">
							<ul>
								<li><i class="qq"></i><a href="#" target="_blank">QQ</a><span
									class="spacer">|</span></li>
								<li><i class="weixin"></i><a href="#" target="_blank">微信</a></li>
							</ul>
						</div>
						<div class="fr">
							<ul>
								<li><i class="ljzc"></i> <a href="register.jsp"
									target="_blank">立即注册</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="footer">
		<div class="w">
			<p>
				<a href="#" target="_blank">关于我们</a> <span>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;</span>
				<a href="#" target="_blank">联系我们</a> <span>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;</span>
				<a href="#" target="_blank">人才招聘</a> <span>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;</span>
				<a href="#" target="_blank">商家入驻</a> <span>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;</span>
				<a href="#" target="_blank">广告服务</a> <span>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;</span>
				<a href="#" target="_blank">手机乐购</a> <span>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;</span>
				<a href="#" target="_blank">友情链接</a> <span>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;</span>
				<a href="#" target="_blank">销售联盟</a> <span>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;</span>
				<a href="#" target="_blank">乐购社区</a> <span>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;</span>
				<a href="#" target="_blank">乐购公益</a> <span>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;</span>
				<a href="#" target="_blank">English Site</a>
			</p>
			<div class="copyright">
				<p>Copyright&nbsp;©&nbsp;2018-2018&nbsp;&nbsp;乐购JD.com&nbsp;版权所有</p>
			</div>
		</div>
	</div>
	<!-- 引入js -->
	<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
	<script type="text/javascript" src="admin/lib/layer/2.4/layer.js"></script>
	<script type="text/javascript" src="js/refreshImg.js"></script>
	<script type="text/javascript" src="js/login.js"></script>
	<script type="text/javascript">
		//刷新更换背景图片
		window.onload = function() {
			var imgs = [ "/lgmall/img/login_bg.jpg",
					"/lgmall/img/login_bg_2.jpg", "/lgmall/img/login_bg_3.jpg",
					"/lgmall/img/login_bg_4.jpg" ];
			var colors = [ "##30004A", "#DE9C3C", "#e93854", "#D91930" ];
			var img = document
					.getElementsByClassName(".lcontainer .bg .loginw");
			var index = Math.floor(Math.random() * (imgs.length));
			$(".lcontainer .bg").css("background-color", colors[index]);
			$(".lcontainer .bg .loginw").css({
				"background" : "url(" + imgs[index] + ")no-repeat",
				"background-color" : colors[index]
			});
		}
	</script>
</body>
</html>