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
<title>${keyword}-商品搜索-乐购</title>
<!-- 基本公共样式 -->
<link href="<%=basePath%>/css/base.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath%>/css/index.css" rel="stylesheet"
	type="text/css" />
<link rel="stylesheet" href="<%=basePath%>/css/bootstrap.min.css"
	type="text/css" />
<!-- ICO图标 -->
<link rel="shortcut icon" href="<%=basePath%>/img/favicon.ico">
<style type="text/css">
a:HOVER {
	text-decoration: none;
}

.w .pageBean a {
	display: inline-block;
	width: 40px;
	height: 40px;
	line-height: 40px;
	background: #fff; border : 1px solid #ccc;
	font-size: 14px;
	border: 1px solid #ccc;
}

i {
	font-style: normal;
}

.w .pageBean .d_clas {
	pointer-events: none;
	text-decoration: none;
	color: #afafaf;
	cursor: default;
}
</style>
</head>
<body style="background-color: #fff">
	<!-- 快速导航栏 start-->
	<jsp:include page="/header.jsp"></jsp:include>
	<!-- 快速导航栏 end-->
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

		<div class="shopCar">
			<i></i><a href="cart.jsp" class="f10" style="font-size: 14px;">我的购物车</a><!-- <span>0</span> -->
		</div>
	</div>
	<!-- 中间部分 end -->

	<div class="w row">
		<!-- 商品展示 start -->
		<c:forEach items="${pageBean.dataList}" var="product">
			<div class="col-md-2"
				style="height: 330px; margin-right: 30px; margin-bottom: 40px; background-color: #fff">
				<a href="<%=basePath%>/productInfo?pid=${product.pid}"> 
					<img src="<%=basePath%>/img/${product.p_image}" style="width: 220px; height: 220px">
				</a>
				<p style="margin-left: 30px;">
					<font color="#FF0000">&yen;${product.p_price }</font>
				</p>
				<p style="margin-left: 30px;">
					<a href="<%=basePath%>/productInfo?pid=${product.pid}" style='color: green'>${product.p_title }</a>
				</p>
			</div>
		</c:forEach>
		<!-- 商品展示 end -->
	</div>
	<!-- 分页信息start -->
	<div class="w" style="text-align: center;">
		<c:if test="${pageBean != null && pageBean.totalPage != 0}">
			<div class="pageBean">
				<!-- 1.上一页 -->
				<c:if test="${pageBean.currentPage != 1}">
					<a style="width: 80px;" href="<%=basePath%>/productSearch?keyword=${keyword}&currentPage=${pageBean.currentPage - 1}&cid=${product.cid}">
						<i><</i>
						<span>上一页</span>
					</a>
				</c:if>
				<c:if test="${pageBean.currentPage == 1}">
					<a class="d_clas" style="width: 80px;" href="JavaScript:;">
						<i><</i>
						<span>上一页</span>
					</a>
				</c:if>

				<!-- 2.显示页数 -->
				<c:forEach begin="${pageBean.start}" end="${pageBean.end}" step="1"
					var="i">
					<!-- 2.1判断是否当前页 -->
					<c:if test="${pageBean.currentPage == i}">
						<span style="width: 40px; height: 40px; color: red;">${i}</span>
					</c:if>
					<c:if test="${pageBean.currentPage != i}">
						<a href="<%=basePath%>/productSearch?keyword=${keyword}&currentPage=${i}&cid=${product.cid}">${i}</a>
					</c:if>
				</c:forEach>
				<!-- 3.显示下一页 -->
				<c:if test="${pageBean.currentPage != pageBean.totalPage}">
					<a style="width: 80px;" href="<%=basePath%>/productSearch?keyword=${keyword}&currentPage=${pageBean.currentPage + 1}&cid=${product.cid}">
						<span>下一页</span>
						<i>></i>
					</a>
				</c:if>
				<c:if test="${pageBean.currentPage == pageBean.totalPage}">
					<a class="d_clas" style="width: 80px;" href="JavaScript:;">
						<span>下一页</span>
						<i>></i>
					</a>
				</c:if>
				<!-- 4.显示分页内容 -->
				<span style="margin-left: 10px">共有${pageBean.totalRecord}件商品，共${pageBean.totalPage }页
					当前为${pageBean.currentPage}页</span>
			</div>
		</c:if>
	</div>
	<!-- 分页信息end -->
	<!-- 页面尾部start-->
	<jsp:include page="/tail.jsp"></jsp:include>
	<!-- 页面尾部 end-->
	<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
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
	</script>
</body>
</html>