<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<title>乐购注册</title>
<meta charset="utf-8">
<!-- ICO图标 -->
<link rel="shortcut icon" href="img/favicon.ico">
<!-- 引入css -->
<link rel="stylesheet" href="<%=basePath%>/css/login.css" />
<link href="<%=basePath%>/css/register.css" rel="stylesheet"
	type="text/css" />
<link href="admin/lib/layer/2.4/skin/layer.css" rel="stylesheet"
	type="text/css" />
</head>
<body>
	<div id="web">
		<form action="" method="post">
			<div class="title">欢迎注册乐购账号</div>
			<!-- 1.姓名 -->
			<div class="input-tip">
				<span id="name_error"></span>
			</div>
			<div class="form_item">
				<label>姓 名</label> <input type="text" placeholder="您的真实姓名" id="name"
					name="name" />
			</div>
			<!-- 2.性别 -->
			<div class="input-tip">
				<span id="sex_error"></span>
			</div>
			<div class="form_item">
				<label>性 别</label> <input
					style="width: 40px; height: auto; margin-top: 15px;" type="radio"
					value="male" id="sex1" name="sex" checked="checked" />男 <input
					style="width: 40px; height: auto; margin-top: 15px;" type="radio"
					value="female" id="sex2" name="sex" />女
			</div>
			<!-- 3.用户名 -->
			<div class="input-tip">
				<span id="uname_error"></span>
			</div>
			<div class="form_item">
				<label>用 户 名</label> <input type="text" placeholder="您的账户名和登录名"
					id="username" name="username" />
			</div>
			<!-- 4.设置密码 -->
			<div class="input-tip">
				<span id="password_error"></span>
			</div>
			<div class="form_item">
				<label>设 置 密 码</label> <input type="password"
					placeholder="建议至少使用两种字符组合" id="password" name="password" />
			</div>
			<!-- 5.确认密码 -->
			<div class="input-tip">
				<span id="confirm_password_error"></span>
			</div>
			<div class="form_item">
				<label>确 认 密 码</label> <input type="password" placeholder="请再次输入密码"
					id="confirm_password" name="confirm_password" />
			</div>
			<!-- 6.邮箱 -->
			<div class="input-tip">
				<span id="email_error"></span>
			</div>
			<div class="form_item">
				<label>邮 箱</label> <input type="text" placeholder="建议使用常用邮箱"
					id="email" name="email" />
			</div>
			<!-- 7.手机号 -->
			<div class="input-tip">
				<span id="phone_error"></span>
			</div>
			<div class="form_item">
				<label>中国 + 86</label> <input type="text" placeholder="建议使用常用手机"
					id="phone" name="phone" />
			</div>
			<!-- 8.验证码 -->
			<div class="input-tip">
				<span id="code_error"></span>
			</div>
			<div class="form_item">
				<label>验 证 码</label> <input type="text" value=""
					placeholder="请输入验证码" id="code" /> <label class="code"> <img
					style="margin-left: -30px; margin-top: 5px;" id="img"
					onclick="changeImg()"
					src="${pageContext.request.contextPath}/checkImg">
				</label>
			</div>
			<!-- 9.乐购用户注册协议 -->
			<div class="input-tip">
				<span></span>
			</div>
			<div style="color: #333; font-size: 12px; margin-bottom: 5px;">
				<input type="checkbox" name="agreen" id="agreen" /> 我已阅读并同意 <a
					style="color: #38f">《乐购用户注册协议》</a>
			</div>
			<!-- 10.注册按钮 -->
			<input type="button" name="btn" id="btn" value="立即注册" style="cursor: pointer;">
		</form>
	</div>
	<div class="footer" style="margin-top: 10px;">
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
		<!-- 引入js -->
		<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
		<script type="text/javascript" src="admin/lib/layer/2.4/layer.js"></script>
		<script type="text/javascript" src="js/refreshImg.js"></script>
		<script type="text/javascript" src="js/register.js"></script>
</body>
</html>