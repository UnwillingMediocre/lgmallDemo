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
<title>${productInfo.p_title}【详情】-乐购</title>
<!-- 基本公共样式 -->
<link href="<%=basePath%>/css/base.css" rel="stylesheet" type="text/css" />
<!-- 首页样式 -->
<link href="<%=basePath%>/css/index.css" rel="stylesheet"
	type="text/css" />
<link rel="stylesheet" href="<%=basePath%>/css/bootstrap.min.css"
	type="text/css" />
<link rel="stylesheet" href="<%=basePath%>/css/style.css"
	type="text/css" />
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

body {
	margin-top: 20px;
	margin: 0 auto;
}

.carousel-inner .item img {
	width: 100%;
	height: 300px;
}

#cart, #order:HOVER {
	text-decoration: none;
	color: #fff !important;
}
</style>
</head>
<body style="background-color: #fff">
	<!-- 快速导航栏 start -->
	<jsp:include page="header.jsp"></jsp:include>
	<!-- 快速导航栏 end -->
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
	<div class="container" style="margin-top: 30px;">
		<div class="row">
			<div style="margin: 0 auto; width: 950px;">
				<div class="col-md-6"
					style="width: 430px; border: 1px solid #ccc; float: left;"
					align="center">
					<img style="opacity: 1; width: 400px; height: 350px;" title=""
						class="medium" src="img/${productInfo.p_image}">
				</div>
				<div class="col-md-6" style="float: right;">
					<div>
						<strong>${productInfo.p_title}</strong>
					</div>
					<div style="margin: 10px 0 10px 0;">
						乐&nbsp;&nbsp;购&nbsp;&nbsp;价&nbsp;&nbsp;<strong
							style="color: #ef0101;">￥${productInfo.p_price}</strong>
					</div>

					<div style="margin: 10px 0 10px 0;">
						促&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;销&nbsp;&nbsp;&nbsp;<a
							target="_blank" title="限时抢购 " style="background-color: #f07373;">限时抢购</a>
					</div>
					<div style="margin: 10px 0 10px 0;">
						优&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;惠&nbsp;&nbsp;&nbsp;<a
							target="_blank" title="限时优惠" style="background-color: #f07373;">满300减50，满1000减200</a>
					</div>

					<div
						style="padding: 10px; border: 1px solid #e7dbb1; width: 330px; margin: 15px 0 10px 0;; background-color: #fffee6;">
						<div
							style="border-bottom: 1px solid #faeac7; margin-top: 20px; padding-left: 10px;">
							购买数量: <input id="buyNum" name="buyNum" value="1" maxlength="4"
								size="10" type="text">
						</div>

						<div style="margin: 20px 0 10px 100px; text-align: center;">
							<a id="cart" href="javascript:void(0);" onclick="addCart()"
								style="display: inline-block; width: 100px; height: 50px; background: #df3033; line-height: 50px; font-size: 18px; color: #fff">加入购物车
							</a>
						</div>
					</div>

				</div>
			</div>
			<div class="clear"></div>
			<div style="width: 950px; margin: 0 auto;">
				<div
					style="background-color: #d3d3d3; width: 900px; padding: 10px 10px; margin: 10px 0 10px 0;">
					<strong>商品介绍</strong>
				</div>
				<div>
					<img src="img/${productInfo.p_image}">
				</div>
				<div style="background-color: #d3d3d3; width: 900px;">
					<table class="table table-bordered">
						<tbody>
							<tr class="active">
								<th><strong>商品评论</strong></th>
							</tr>
							<tr class="warning">
								<th>暂无商品评论信息 <a>[发表商品评论]</a></th>
							</tr>
						</tbody>
					</table>
				</div>

				<div style="background-color: #d3d3d3; width: 900px;">
					<table class="table table-bordered">
						<tbody>
							<tr class="active">
								<th><strong>商品咨询</strong></th>
							</tr>
							<tr class="warning">
								<th>暂无商品咨询信息 <a>[发表商品咨询]</a></th>
							</tr>
						</tbody>
					</table>
				</div>
			</div>

		</div>
	</div>
	<!-- 页面尾部 start -->
	<jsp:include page="tail.jsp"></jsp:include>
	<!-- 页面尾部 end -->
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
								content += "<div style='height:20px; padding:5px;cursor:pointer;overflow: hidden;' onclick='clickFn(this)' onmouseover='overFn(this)' onmouseout='outFn(this)'>" + data[i] + "</div>";
							}
							$("#J-prompt").html(content);
							$("#J-prompt").css("display", "block");
						}
					}, "json")
		}
		//校验购买数量
		$("#buyNum").blur(function() {
					var buyNum = $("#buyNum").val();
					if (parseInt(buyNum) < 1) {
						$("#buyNum").val(1);
						layer.msg("购买数量不能小于1");
						return;
					}
					$.ajax({
							url : "${pageContext.request.contextPath}/checkByNum?time=" + new Date().getTime(),
							dataType : 'json',
							type : "post",
							data : {
									byNum : buyNum,
									pid : "${productInfo.pid}"
							},
							success : function(data) {
								if (!data.ok) {
									$("#buyNum").val(data.msg);
									layer.msg("购买数量不能大于"+ data.msg);
									return;
								}
							}
					});
		});
		function addCart() {
			//获得购买的商品的数量
			var buyNum = $("#buyNum").val();
			layer.confirm("您是否要将商品添加的购物车？", {
				btn: ['确认','取消']},function(){
					location.href = "${pageContext.request.contextPath}/addCart?pid=${productInfo.pid}&buyNum="
						+ buyNum;
				}
			)
		}
	</script>
</body>
</html>