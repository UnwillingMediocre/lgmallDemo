<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>乐购商场</title>
<link href="css/public.css" type="text/css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="css/pay.css" />
<link rel="stylesheet" type="text/css" href="css/buyConfirm.css" />
<!-- ICO图标 -->
<link rel="shortcut icon" href="<%=basePath%>/img/favicon.ico">
</head>
<body style="background-color: #fff;">
	<!-- 快速导航栏 start-->
	<jsp:include page="/header.jsp"></jsp:include>
	<!-- 快速导航栏 end-->
	<div style="height: 100px;">
	</div>
	<div class="border_top_cart">
		<div class="container payment-con">
			<form target="_blank" action="#" id="pay-form" method="post">
				<div class="order-info">
					<div class="msg">
						<h3>您的订单已支付成功！</h3>
						<p></p>

						<p class="post-date">等待发货</p>
					</div>
					<div class="info">
						<p>
							金额：<span class="pay-total">${order.total}元</span>
						</p>
						<p>订单：${order.oid}</p>
						<p>
							配送：${order.deliveryAddress.name} <span class="line">/</span>
							${order.deliveryAddress.tel}<span class="line">/</span>
							${order.deliveryAddress.address}
						</p>
					</div>
					<div class="icon-box">
						<i class="iconfont"><img src="img/yes_ok.png"></i>
					</div>
				</div>
			</form>
		</div>
	</div>
	<!-- 页面尾部start-->
	<jsp:include page="/tail.jsp"></jsp:include>
	<!-- 页面尾部 end-->
</body>
</html>
