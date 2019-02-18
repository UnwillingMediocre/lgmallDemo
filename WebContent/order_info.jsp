<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>订单支付-乐购</title>
<!-- 基本公共样式 -->
<link href="<%=basePath%>/css/base.css" rel="stylesheet" type="text/css" />
<!-- 首页样式 -->
<link href="<%=basePath%>/css/index.css" rel="stylesheet"
	type="text/css" />
<link rel="stylesheet" href="<%=basePath%>/css/bootstrap.min.css" type="text/css" />
<!-- 引入自定义css文件 style.css -->
<link rel="stylesheet" href="<%=basePath%>/css/style.css" type="text/css" />
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
table tbody .active .info{
	text-align: center;
	vertical-align: middle;
}
</style>
</head>

<body style="background-color: #fff">
	<!-- 引入header.jsp -->
	<jsp:include page="/header.jsp"></jsp:include>
	<!-- 搜索框 start -->
	<div class="w middle" style="height: 100px;">
		<div class="form">
			<input id="msg" type="text" placeholder="智能马桶"
				onkeyup="searchWord(this)" name="keyword"
				style="border: 2px solid red;">
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
	<!-- 搜索框 end -->
	<div class="container">
		<div class="row">
		<!-- 订单详情 start -->
			<div style="margin: 0 auto; margin-top: 10px; width: 950px;">
				<strong>订单详情</strong>
				<table class="table table-bordered">
					<tbody>
						<tr class="warning">
							<th colspan="5">订单编号:${order.oid }</th>
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
								<td width="60" width="40%" class="info">
									<img src="${pageContext.request.contextPath }/img/${orderItem.product.p_image}" width="70" height="60">
								</td>
								<td width="30%"><a target="_blank">${orderItem.product.p_title}</a></td>
								<td width="20%" class="info">￥${orderItem.product.p_price}</td>
								<td width="10%" class="info">${orderItem.count}</td>
								<td width="15%" class="info"><span class="subtotal">￥${orderItem.subtotal}</span></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<!-- 订单详情  end-->
			<!-- 金额信息 start -->
			<div style="text-align: right; margin-right: 120px; margin-left: auto;">
				<ul>
					<li>
						<span style="font-size: 14px;">订单金额:</span>
						<strong style="color: #ff6600; font-size: 14px;min-width: 130px;display: inline-block;">${order.total + order.coupon}元</strong>
					</li>
					<li>
						<span style="font-size: 14px;">优惠金额:</span>
						<strong style="color: #ff6600; font-size: 14px;min-width: 130px;display: inline-block;">-${order.coupon}元</strong>
					</li>
					<li>
						<span style="font-size: 14px;">应付总额:</span>
						<strong style="color: #f10215; font-size: 20px;min-width: 130px;display: inline-block;">${order.total}元</strong>
					</li>
				</ul>
			</div>
		</div>
		<!-- 金额信息 end -->
		
		<div>
			<hr/>
			<!-- 收货地址 start -->
			<form id="orderForm" class="form-horizontal" action="${pageContext.request.contextPath }/confirmOrder" method="post"
				style="margin-top: 5px; margin-left: 150px;">
				<!-- method的名字 通过表单提交 -->
				<input type="hidden" name="method" value="confirmOrder">
				<!-- 传递订单oid -->
				<input type="hidden" name="oid" value="${order.oid }">
				<!-- 传递用户oid -->
				<input type="hidden" name="uid" value="${order.deliveryAddress.uid}">
				<input type="hidden" name="oid" value="${order.oid }">
				<!-- 传递用户oid -->
				<input type="hidden" name="did" value="${order.deliveryAddress.did}">
				<div class="form-group">
					<label class="col-sm-1 control-label">地址</label>
					<div class="col-sm-5">
						<input type="text" class="form-control" id="address" name="address"  placeholder="请输入收货地址" value="${order.deliveryAddress.address}">
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-1 control-label">邮编</label>
					<div class="col-sm-5">
						<input type="text" class="form-control" id="postalcode" name="postalcode" placeholder="请输入邮编号" value="${order.deliveryAddress.postalcode}">
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-1 control-label">收货人</label>
					<div class="col-sm-5">
						<input type="text" class="form-control" id="name" name="name" placeholder="请输收货人" value="${order.deliveryAddress.name}">
					</div>
				</div>
				<div class="form-group">
					<label id="confirmpwd" class="col-sm-1 control-label">电话</label>
					<div class="col-sm-5">
						<input type="text" class="form-control" id="telephone" name="telephone" placeholder="请输入联系方式"  value="${order.deliveryAddress.tel}">
					</div>
				</div>
				<hr/>
				<!-- 收货地址 end -->
				<div style="margin-top: 5px; margin-left: 150px;">
					<p style="text-align: right; margin-right: 100px;">
						<a href="javascript:;" onclick="confirmOrder()">
							<img src="./img/finalbutton.gif" width="204" height="51" border="0" />
						</a>
					</p>
					<hr />
				</div>
			</form>
		</div>
	</div>
	<!-- 引入footer.jsp -->
	<jsp:include page="/tail.jsp"></jsp:include>
	<!-- js引入 -->
	<script src="js/jquery-1.11.3.min.js" type="text/javascript"></script>
	<script src="js/jquery.validate.min.js" type="text/javascript"></script>
	<script src="http://static.runoob.com/assets/jquery-validation-1.14.0/dist/localization/messages_zh.js"></script>
	<script src="js/bootstrap.min.js" type="text/javascript"></script>
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
								content += "<div style='height:30px; padding:5px;cursor:pointer;overflow: hidden;' onclick='clickFn(this)' onmouseover='overFn(this)' onmouseout='outFn(this)'>" + data[i] + "</div>";
							}
							$("#J-prompt").html(content);
							$("#J-prompt").css("display", "block");
						}
					}, "json")
		}
		function confirmOrder(){
			var name = $("#name").val();
			var address = $("#address").val();
			var postalcode = $("#postalcode").val();
			var telephone = $("#telephone").val();
			if(name == "" || name == null){
				layer.msg("请输入收货人姓名");
				return;
			}else if(postalcode.lenght != 6 &&(postalcode == "" || postalcode == null)){
				layer.msg("请输入正确邮编号");
				return;
			}else if(telephone.length != 11 && (telephone == "" || telephone == null)){
				layer.msg("请输入正确手机号");
				return;
			}else if(address == "" || address == null){
				layer.msg("请输入收货人地址");
				return;
			}else{
				$("#orderForm").submit();	
			}
		}
	</script>
</body>
</html>