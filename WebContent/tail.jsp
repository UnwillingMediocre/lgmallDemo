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
<link href="<%=basePath%>/css/index.css" rel="stylesheet"
	type="text/css" />
<style type="text/css">
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
	<!-- 底部推广栏 -->
	<div class="bigContainer footerRecommend01">
		<div class="w footerRecommend02 clearFix">
			<img src="./img/d01.png" /> <img src="./img/d02.png" /> <img
				src="./img/d03.png" /> <img src="./img/d04.png" />
		</div>
	</div>
	<!-- 页脚 -->
	<div class="bigContainer">
		<div class="container footer">
			<ul class="footerLine01">
				<a href="#">关于我们</a>
				<span class="footerColLine"></span>
				<a href="#">联系我们</a>
				<span class="footerColLine"></span>
				<a href="#">联系客服</a>
				<span class="footerColLine"></span>
				<a href="#">商家入驻</a>
				<span class="footerColLine"></span>
				<a href="#">营销中心</a>
				<span class="footerColLine"></span>
				<a href="#">手机乐购</a>
				<span class="footerColLine"></span>
				<a href="#">友情链接</a>
				<span class="footerColLine"></span>
				<a href="#">销售联盟</a>
				<span class="footerColLine"></span>
				<a href="#">乐购社区</a>
				<span class="footerColLine"></span>
				<a href="#">风险监测</a>
				<span class="footerColLine"></span>
				<a href="#">乐购公益</a>
				<span class="footerColLine"></span>
				<a href="#">English Site</a>
				<span class="footerColLine"></span>
				<a href="#">Contact Us</a>
			</ul>
			<div class="footerLine02">
				<a class="footerIcon2" href="#"><span class="footerIcon"></span>京公网安备
					11000002000088号 </a> <span class="footerColLine footerColLine02"></span>
				<span class="footerText">乐ICP证070359号</span> <span
					class="footerColLine footerColLine02"></span> <a href="#">互联网药品信息服务资格证编号(京)-经营性-2014-0008</a>
				<span class="footerColLine footerColLine02"></span> <span
					class="footerText">新出发京零 字第大120007号</span>
			</div>
			<div class="footerLine03">
				<span class="footerText">互联网出版许可证编号新出网证(京)字150号</span> <span
					class="footerColLine footerColLine02"></span> <a href="#">出版物经营许可证</a>
				<span class="footerColLine footerColLine02"></span> <a href="#">网络文化经营许可证京网文[2018]2148-348号</a>
				<span class="footerColLine footerColLine02"></span> <span
					class="footerText">违法和不良信息举报电话：4006561155</span>
			</div>
			<div class="footerLine04">
				<span class="footerText">Copyright © 2018 - 2018 乐购LG.com
					版权所有</span> <span class="footerColLine footerColLine02"></span> <span
					class="footerText">消费者维权热线：4006067733</span>
			</div>
			<div class="footerLine05">
				<span class="footerText">乐购旗下网站：</span> <a href="#">乐购钱包</a>
			</div>
			<div class="footerLine06">
				<a href="#"><img src="img/d31.png" /></a> <a href="#"><img
					src="img/d32.png" /></a> <a href="#"><img src="img/d33.jpg" /></a> <a
					href="#"><img src="img/d34.png" /></a> <a href="#"><img
					src="img/d35.jpg" /></a> <a href="#"><img src="img/d36.jpg" /></a>
			</div>
		</div>
	</div>
</body>
</html>