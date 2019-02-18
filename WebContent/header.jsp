<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- 基本公共样式 -->
<link href="<%=basePath%>/css/base.css" rel="stylesheet" type="text/css" />
<!-- 首页样式 -->
<%-- <link href="<%=basePath%>/css/index.css" rel="stylesheet"
	type="text/css" /> --%>
<!-- ICO图标 -->
<link rel="shortcut icon" href="<%=basePath%>/img/favicon.ico">
<style type="text/css">
.enjoy_bg {
	width: 1350px;
	height: 335px;
	background-image: url(img/advert/bg.png);
}

.enjoy_bg {
	position: absolute;
	top: 0;
	outline: 0;
	background-position: right top;
	background-repeat: no-repeat;
}

@font-face {
	font-family: 'icomoon';
	src: url('fonts/icomoon.eot?qmsx84');
	src: url('fonts/icomoon.eot?qmsx84#iefix') format('embedded-opentype'),
		url('fonts/icomoon.ttf?qmsx84') format('truetype'),
		url('fonts/icomoon.woff?qmsx84') format('woff'),
		url('fonts/icomoon.svg?qmsx84#icomoon') format('svg');
	font-weight: normal;
	font-style: normal;
}

.bigContainer {
	min-width: 1190px;
}

.footerRecommend01 {
	height: 94px;
	background-color: #F5F5F5;
	margin-top: 20px;
}

.footerRecommend02 img {
	float: left;
	display: inline-block;
	width: 220px;
	height: 54px;
	margin: 20px 66px 0 10px;
}

.floatL {
	float: left;
}

.floatR {
	float: right;
}
/* 页脚 */
.footer {
	font-size: 12px;
	line-height: 20px;
	text-align: center;
	margin-top: 20px;
	padding-bottom: 38px;
}

.footer a {
	color: #999;
}

.footer a:hover {
	color: #C81623
}

.footerColLine {
	font-size: 12px;
	line-height: 12px;
	display: inline-block;
	height: 12px;
	border-left: 1px solid #AFAFAF;
	margin: 0 10px;
	position: relative;
	top: 2px;
}

.footerColLine02 {
	margin: 0 5px;
}

.footerText {
	font-size: 12px;
	line-height: 20px;
	color: #999;
}

.footerIcon2 {
	position: relative;
	padding-left: 26px;
}

.footerIcon {
	display: inline-block;
	width: 20px;
	height: 20px;
	position: absolute;
	left: 0;
	top: -6px;
	background-repeat: no-repeat;
	background-image: url(img/d05.png);
}

.footerLine06 a {
	display: inline-block;
	width: 103px;
	height: 32px;
	margin-right: 12px;
}

.footerLine01, .footerLine05 {
	margin-bottom: 10px;
}
</style>
</head>
<body>
	<!-- 快速导航栏 start-->
	<div class="shortcut">
		<div class="w">
			<ul class="fl">
				<li><a href="index.jsp">乐购首页</a></li>
			</ul>
			<ul class="fl city">
				<li><i class="f10"></i><a href="#">湖南</a></li>
			</ul>
			<ul class="fr">
				<li>
					<c:if test="${sessionScope.loginUsername == null}">
						<a href="login.jsp">你好，请登录</a>
						<a href="register.jsp" class="f10">免费注册</a>
					</c:if> 
					<c:if test="${sessionScope.loginUsername != null}">
						<a href="javascript:;">${sessionScope.loginUsername}</a>
						<a href="<%=basePath%>/logout">注销</a>
					</c:if> 
				</li>
				<li class="space"></li>
				<li><a href="${pageContext.request.contextPath}/orderList">我的订单</a></li>
				<li class="space"></li>
				<li class="myjd"><a href="#">我的乐购</a><i></i>
					<div class="shortcut_jd">
						<div class="jd_t">
							<div class="shortcut_jdt_l">
								<ul>
									<li><a href="#">待处理订单</a></li>
									<li><a href="#">返修退换货</a></li>
									<li><a href="#">降价商品</a></li>
								</ul>
							</div>
							<div class="shortcut_jdt_r">
								<ul>
									<li><a href="#">消息</a></li>
									<li><a href="#">我的问答</a></li>
									<li><a href="#">我的关注</a></li>
								</ul>
							</div>
						</div>
						<div class="jd_b">
							<div class="shortcut_jdb_l">
								<ul>
									<li><a href="#">我的乐豆</a></li>
									<li><a href="#">我的白条</a></li>
								</ul>
							</div>
							<div class="shortcut_jdb_r">
								<ul>
									<li><a href="#">我的优惠券</a></li>
									<li><a href="#">我的理财</a></li>
								</ul>
							</div>
						</div>
					</div></li>
				<li class="space"></li>
				<li><a href="#">乐购会员</a></li>
				<li class="space"></li>
				<li class="company"><a href="#">企业采购</a><i></i>
					<div class="shortcut_company">
						<div class="company_all">
							<ul>
								<li><a href="#">企业购</a></li>
								<li><a href="#">商用场景馆</a></li>
								<li><a href="#">工业品</a></li>
								<li><a href="#">礼品卡</a></li>
							</ul>
						</div>
					</div></li>
				<li class="space"></li>
				<li class="customer"><a href="#">客户服务</a><i></i>
					<div class="shortcut_CB">
						<div class="shortcut_customer_t">
							<ul>
								<li class="shortcut_customer">客户</li>
								<li class="item"><a href="#">帮助中心</a></li>
								<li class="item"><a href="#">售后服务</a></li>
								<li class="item"><a href="#">在线客服</a></li>
								<li class="item"><a href="#">意见建议</a></li>
								<li class="item"><a href="#">电话客服</a></li>
								<li class="item"><a href="#">客服邮箱</a></li>
								<li class="item"><a href="#">金融咨询</a></li>
								<li class="item"><a href="#">全球售客服</a></li>
							</ul>
						</div>
						<div class="shortcut_business_b">
							<ul>
								<li class="shortcut_business">商户</li>
								<li class="item"><a href="#">合作招商</a></li>
								<li class="item"><a href="#">学习中心</a></li>
								<li class="item"><a href="#">商家后台</a></li>
								<li class="item"><a href="#">京麦工作台</a></li>
								<li class="item"><a href="#">商家帮助</a></li>
								<li class="item"><a href="#">规则平台</a></li>
							</ul>
						</div>
					</div></li>
				<li class="space"></li>
				<li><a href="#">网站导航</a><i></i></li>
				<li class="space"></li>
				<li><a href="#" class="mobile">手机乐购 <img
						src="img/mobile_qrcode.png">
				</a></li>
			</ul>
		</div>
	</div>
	<!-- 快速导航栏 end-->
</body>
</html>