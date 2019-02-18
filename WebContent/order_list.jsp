<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>我的订单</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap.min.css" type="text/css" />
<script src="${pageContext.request.contextPath }/js/jquery-1.11.3.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/js/bootstrap.min.js" type="text/javascript"></script>
<!-- 引入自定义css文件 style.css -->
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/style.css" type="text/css" />
<!-- ICO图标 -->
<link rel="shortcut icon" href="${pageContext.request.contextPath }/img/favicon.ico">
<style>
body {
	margin-top: 20px;
	margin: 0 auto;
}

.carousel-inner .item img {
	width: 100%;
	height: 300px;
}
table tbody .active .info{
	text-align: center;
	vertical-align: middle;
}
table tbody .active .info a{
	display: inline-block; 
	border-radius: 5px; 
	background: #31B0D5; 
	color: white; 
	width: 60px; 
	height: 30px; 
	line-height:30px; 
	border: 0px; 
	outline: 0px; 
	font-size: 15px;
}
table tbody .active .info a:HOVER{
	text-decoration: none;
	color: #fff!important;
}
</style>
</head>

<body style="background: #fff">
	<!-- 引入header.jsp -->
	<jsp:include page="/header.jsp"></jsp:include>
	<div style="height: 100px;">
	</div>
	<div class="container">
		<div class="row">
			<div style="margin: 0 auto; margin-top: 10px; width: 950px;">
				<strong>我的订单</strong>
				<table class="table table-bordered">
					<c:forEach items="${orderList}" var="order">
						<tbody>
							<tr class="success">
								<th colspan="5">
									<span>订单编号:${order.oid }&nbsp;&nbsp;</span>
									<c:if test="${order.state == 0}">
										<a href="#">待付款</a>
									</c:if>
									<c:if test="${order.state == 1}">
										<span>待发货</span>
									</c:if>
									<c:if test="${order.state == 2}">
										<span>待收货</span>
									</c:if>
								</th>
							</tr>
							<tr class="warning">
								<th style="text-align: center;">图片</th>
								<th style="text-align: center;">商品</th>
								<th style="text-align: center;">价格</th>
								<th style="text-align: center;">数量</th>
								<th style="text-align: center;">小计</th>
							</tr>
							<c:forEach items="${order.orderItems}" var="orderItem">
								<tr class="active">
									<td class="info" width="60" width="40%">
										<img src="${pageContext.request.contextPath }/img/${orderItem.product.p_image}" width="70" height="60">
									</td>
									<td width="30%"><a target="_blank">${orderItem.product.p_title}</a></td>
									<td width="20%" class="info">￥${orderItem.product.p_price}</td>
									<td width="10%" class="info">${orderItem.count}</td>
									<td width="15%" class="info"><span class="subtotal">￥${orderItem.subtotal}</span></td>
								</tr>
							</c:forEach>
						</tbody>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
	<!-- 引入footer.jsp -->
	<jsp:include page="/tail.jsp"></jsp:include>
	
</body>

</html>