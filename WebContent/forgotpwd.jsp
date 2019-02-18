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
	<div id="web" style="height: 500px;">
		<form action="" method="post">
			<div class="title">找回密码</div>
			<div id="J-code" style="display: block;">
				<!-- 1.用户名 -->
				<div class="input-tip">
					<span id="uname_error"></span>
				</div>
				<div class="form_item">
					<label>用 户 名</label> <input type="text" placeholder="请输入用户名"
						id="username" name="username" />
				</div>
				<!-- 2.邮箱 -->
				<div class="input-tip">
					<span id="email_error"></span>
				</div>
				<div class="form_item">
					<label>邮 箱</label> <input type="text" placeholder="请输入已经验证的邮箱"
						id="email" name="email" />
				</div>
				<!-- 3.验证码 -->
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
				<!--4.下一步 -->
			<input type="button" name="btn" id="btn" value="下一步" style="margin-top: 20px; cursor: pointer;">
			</div>
			<div id="J-pwd" style="display: none;">
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
				<!--6.重置 -->
				<input type="button" name="btn" id="J-reset" value="重置密码" style="margin-top: 20px; cursor: pointer;width:100%; height: 40px; color:#fff; background-color: #e22; border:0; font-size: 16px; font-family: '微软雅黑'">
			</div>
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
		<script type="text/javascript" src="js/forgotpwd.js"></script>
</body>
</html>