<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>乐购购物车</title>
<link rel="stylesheet" href="<%=basePath%>/css/bootstrap.min.css"
	type="text/css" />
<!-- 引入自定义css文件 style.css -->
<link rel="stylesheet" href="<%=basePath%>/css/style.css"
	type="text/css" />
<!-- ICO图标 -->
<link rel="shortcut icon" href="<%=basePath%>/img/favicon.ico">
<style>
body {
	margin-top: 20px;
	margin: 0 auto;
}

.carousel-inner .item img {
	width: 100%;
	height: 300px;
}

font {
	color: #3164af;
	font-size: 18px;
	font-weight: normal;
	padding: 0 10px;
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

<body style="background-color: #fff">
	<!-- 引入header.jsp -->
	<jsp:include page="/header.jsp"></jsp:include>
	<!-- 中间部分 start -->
	<div class="w middle" style="height: 100px;">
		<div class="form">
			<input id="msg" type="text" placeholder="智能马桶" value="${keyword}"
				onkeyup="searchWord(this)" style="border: 2px solid red;">
			<button style="cursor: pointer;" id="J-search"
				onclick='productSearch()'>
				<i></i>
			</button>
			<!-- 提示框 -->
			<div id="J-prompt"
				style="width: 522px; background-color: #fff; z-index: 999; position: absolute; top: 43px; border: 1px solid #ccc; display: none">
			</div>
		</div>
	</div>
	<!-- 中间部分 end -->
	<!-- 判断购物车中是否有商品 -->
	<c:if test="${!empty cart.cartItems }">
		<div class="container">
			<div class="row">
				<div style="margin: 0 auto; margin-top: 10px; width: 950px;">
					<strong style="font-size: 16px; margin: 5px 0;">购物车详情</strong>
					<table class="table table-bordered">
						<tbody>
							<tr class="warning">
								<th style="text-align: center;">图片</th>
								<th style="text-align: center;">商品</th>
								<th style="text-align: center;">价格</th>
								<th style="text-align: center;">数量</th>
								<th style="text-align: center;">小计</th>
								<th style="text-align: center;">操作</th>
							</tr>

							<c:forEach items="${cart.cartItems }" var="entry">

								<tr class="active">
									<td width="60" width="40%"><input type="hidden" name="id"
										value="22"> <img
										src="${pageContext.request.contextPath }/img/${entry.value.product.p_image}"
										width="70" height="60"></td>
									<td width="30%"><a
										target="_blank">${entry.value.product.p_title}</a></td>
									<td width="20%" class="info">￥${entry.value.product.p_price}</td>
									<td width="10%" class="info">${entry.value.buyNum }</td>
									<td width="15%" class="info"><span class="subtotal">￥${entry.value.subtotal }</span></td>
									<td class="info"><a href="javascript:;" onclick="delProFromCart('${entry.value.product.pid}')"
										class="delete">删除</a></td>
								</tr>

							</c:forEach>

						</tbody>
					</table>
				</div>
			</div>

			<div style="margin-right: 130px;">
				<div style="text-align: right;">
					&nbsp; 商品金额: <strong style="color: #ff6600;">￥${cart.total }元</strong>
				</div>
				<div
					style="text-align: right; margin-top: 10px; margin-bottom: 10px;">
					<a href="javascript:;" onclick="clearCart()" id="clear"
						class="clear" style="font-size: 16px;">清空购物车</a> 
						<a href="${pageContext.request.contextPath}/submitOrder">
						<input type="button" width="100" value="提交订单" name="submit" border="0" style="cursor: pointer; background: url('./img/register.gif') no-repeat scroll 0 0 rgba(0, 0, 0, 0); height: 35px; width: 100px; color: white;">
					</a>
				</div>
			</div>
		</div>
	</c:if>
	<c:if test="${empty cart.cartItems }">
		<div align="center" style="background-color: #f7f7f7;">
			<img alt="" src="${pageContext.request.contextPath }/img/cart-empty.png">
		</div>
	</c:if>

	<!-- 引入footer.jsp -->
	<jsp:include page="/tail.jsp"></jsp:include>
	<!-- js引入 -->
	<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
	<script type="text/javascript" src="admin/lib/layer/2.4/layer.js"></script>
	<script type="text/javascript" src="js/index.js"></script>
	<script type="text/javascript">
		//鼠标移入
		function overFn(obj) {
			$(obj).css("background", "#DBEAF9");
		}
		//鼠标移出
		function outFn(obj) {
			$(obj).css("background", "#fff");
		}

		//选中
		function clickFn(obj) {
			$("#msg").val(
					$(obj).html().replace(/^(\s|\u00A0)+/, '').replace(
							/(\s|\u00A0)+$/, ''));
			$("#J-prompt").css("display", "none");
		}
		//提示文字处理
		function searchWord(obj) {
			var word = $(obj).val();
			var content = "";
			$.post(
				"${pageContext.request.contextPath}/searchWord",
				{word : word},
				function(data) {
					if (data.length > 0) {
						for (var i = 0; i < data.length; i++) {
							content += "<div style='height:30px; padding:5px;cursor:pointer;overflow: hidden;' onclick='clickFn(this)' onmouseover='overFn(this)' onmouseout='outFn(this)'>"
												+ data[i] + "</div>";
						}
						$("#J-prompt").html(content);
						$("#J-prompt").css("display", "block");
					}
				}, "json")
		}
		//删除购物车某件商品
		function delProFromCart(pid) {
			layer.confirm("您是否要删除该项？", {
				btn: ['确认','取消']},function(){
					location.href = "${pageContext.request.contextPath }/delCart?pid="+ pid + "&time=" + new Date().getTime();
				}
			)
		}
		//清空购物车
		function clearCart() {
			layer.confirm("您是否要清空购物车？", {
				btn: ['确认','取消']},function(){
					location.href = "${pageContext.request.contextPath }/clearCart?time=" + new Date().getTime();
				}
			)
		}
	</script>
</body>

</html>