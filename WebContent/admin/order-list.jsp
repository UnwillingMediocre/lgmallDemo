<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<!--[if lt IE 9]>
<script type="text/javascript" src="lib/html5shiv.js"></script>
<script type="text/javascript" src="lib/respond.min.js"></script>
<![endif]-->
<link rel="stylesheet" type="text/css" href="static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="static/h-ui.admin/css/style.css" />
<!--[if IE 6]>
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>订单列表</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 订单管理 <span class="c-gray en">&gt;</span> 订单列表 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
	<div class="cl pd-5 bg-1 bk-gray mt-20"> 
		<span class="r">共有数据：<strong>${orderCount}</strong> 条</span> 
	</div>
	<div class="mt-20">
		<table class="table table-border table-bordered table-bg table-hover table-sort">
			<thead>
				<tr class="text-c">
					<th width="40">ID</th>
					<th width="120">订单编号</th>
					<th width="60">支付金额</th>
					<th width="60">优惠金额</th>
					<th width="120">提交时间</th>
					<th width="120">支付时间</th>
					<th width="120">成交时间</th>
					<th width="60">当前状态</th>
					<th width="100">操作</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${orderList}" var="order" varStatus="i" step="1">
				<tr class="text-c">
					<td>${i.index + 1}</td>
					<td><a href="javascript:;" onClick="order_info('订单详细','order-info.jsp','${order.oid}','800','400')">${order.oid}</a></td>
					<td>${order.total}</td>
					<td class="text-c">${order.coupon}</td>
					<td class="text-c">${order.orderTime}</td>
					<td class="text-c">${order.payTime}</td>
					<td class="text-c">${order.closingtime}</td>
					<td class="td-status">
						<c:if test="${order.state == 0}">
							<span class="label label-success radius">待支付</span>
						</c:if>
						<c:if test="${order.state == 1}">
							<span class="label label-success radius">待发货</span>
						</c:if>
						<c:if test="${order.state == 2}">
							<span class="label label-success radius">待收货</span>
						</c:if>
					</td>
					<td class="td-manage">
						<a style="text-decoration:none" onClick="express('#','${order.oid}',600,270)" href="javascript:;" title="发货">
							<i class="Hui-iconfont">&#xe669;</i>
						</a> 
					</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
</div>

<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="static/h-ui/js/H-ui.min.js"></script> 
<script type="text/javascript" src="static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="lib/My97DatePicker/4.8/WdatePicker.js"></script> 
<script type="text/javascript" src="lib/datatables/1.10.0/jquery.dataTables.min.js"></script> 
<script type="text/javascript" src="lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript">
$('.table-sort').dataTable({
	"aaSorting": [[ 1, "desc" ]],//默认第几个排序
	"bStateSave": true,//状态保存
	"aoColumnDefs": [
	  //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
	  {"orderable":false,"aTargets":[1,5,8]}// 制定列不参与排序
	]
});

/*订单详细*/
function order_info(title,url,id,w,h){
	$.ajax({
		url:"${pageContext.request.contextPath}/orderInfo?time=" + new Date().getTime(),
		type:'post',
		data:{id:id},
		success:function(){
			layer_show(title,url,w,h);
		}
	});
}
/*快递*/
function express(){
	layer.msg("待开发");
}
</script>
</body>
</html>