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
<title>建材列表</title>
<link rel="stylesheet" href="lib/zTree/v3/css/zTreeStyle/zTreeStyle.css" type="text/css">
</head>
<body class="pos-r">
<!-- <div class="pos-a" style="width:200px;left:0;top:0; bottom:0; height:100%; border-right:1px solid #e5e5e5; background-color:#f5f5f5; overflow:auto;">
	<ul id="treeDemo" class="ztree"></ul>
</div> -->
<div>
	<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 产品管理 <span class="c-gray en">&gt;</span> 产品列表 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
	<div class="page-container">
		<form action="${pageContext.request.contextPath}/productFindt">
			<div class="text-c">
			 	<input type="text" name="keyword" id="" placeholder=" 产品名称" style="width:250px" class="input-text">
				<button name="" id="" class="btn btn-success" type="submit"><i class="Hui-iconfont">&#xe665;</i> 搜产品</button>
			</div>
		</form>
		<div class="cl pd-5 bg-1 bk-gray mt-20"> 
			<span class="l">
				<a class="btn btn-primary radius" onclick="product_add('添加产品','product-add.jsp')" href="javascript:;">
					<i class="Hui-iconfont">&#xe600;</i>
				添加产品
				</a>
			</span>
			<span class="r">共有数据：<strong>${productCount}</strong> 条</span>
		</div>
		<div class="mt-20">
			<table class="table table-border table-bordered table-bg table-hover table-sort">
				<thead>
					<tr class="text-c">
						<th width="40">ID</th>
						<th width="60">缩略图</th>
						<th>产品名称</th>
						<th width="100">单价</th>
						<th width="100">库存</th>
						<th width="100">是否热门</th>
						<th width="60">发布状态</th>
						<th width="100">操作</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${productList}" var="product" varStatus="i" step="1">
						<tr class="text-c va-m">
							<td>${i.index + 1}</td>
							<td><img width="60" class="product-thumb" src="${pageContext.request.contextPath}/img/${product.p_image}"></td>
							<td class="text-l"><a style="text-decoration:none" onClick="product_show('哥本哈根橡木地板','product-show.html','10001')" href="javascript:;">${product.p_title}</a></td>
							<td><span class="price">${product.p_price}</span> 元</td>
							<td><span class="price">${product.p_num}</span></td>
							<td >
								<c:if test='${product.p_popular == 0}'>
									<span class="label label-success radius">否</span>
								</c:if>
								<c:if test='${product.p_popular == 1}'>
									<span class="label label-success radius">是</span>
								</c:if>
							</td>
							<td class="td-status">
								<c:if test='${product.p_soldInTime != null}'>
									<span class="label label-success radius">已发布</span>
								</c:if>
								<c:if test='${product.p_soldOutTime != null}'>
									<span class="label label-defaunt radius">已下架</span>
								</c:if>
								<c:if test='${product.p_soldOutTime == null && product.p_soldInTime == null}'>
									<span class="label label-defaunt radius">已删除</span>
								</c:if>
							</td>
							<td class="td-manage">
								<c:if test='${product.p_soldOutTime != null || (product.p_soldOutTime == null && product.p_soldInTime == null)}'>
									<a style="text-decoration:none" onClick="product_start(this,'${product.pid}')" href="javascript:;" title="发布"><i class="Hui-iconfont">&#xe603;</i></a>
								</c:if>
								<c:if test='${product.p_soldInTime != null}'>
								<a style="text-decoration:none" onClick="product_stop(this,'${product.pid}')" href="javascript:;" title="下架">
									<i class="Hui-iconfont">&#xe6de;</i>
								</a> 
								</c:if>
								
								<a style="text-decoration:none" class="ml-5" onClick="product_edit('产品编辑','product-edit.jsp','${product.pid}')" href="javascript:;" title="编辑">
									<i class="Hui-iconfont">&#xe6df;</i>
								</a> 
							<c:if test='${product.p_soldInTime != null}'>
								<a style="text-decoration:none" class="ml-5" onClick="product_del(this,'${product.pid}')" href="javascript:;" title="删除">
									<i class="Hui-iconfont">&#xe6e2;</i>
								</a>
							</c:if>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>

<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="static/h-ui/js/H-ui.min.js"></script> 
<script type="text/javascript" src="static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="lib/zTree/v3/js/jquery.ztree.all-3.5.min.js"></script>
<script type="text/javascript" src="lib/My97DatePicker/4.8/WdatePicker.js"></script> 
<script type="text/javascript" src="lib/datatables/1.10.0/jquery.dataTables.min.js"></script> 
<script type="text/javascript" src="lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript">
var setting = {
	view: {
		dblClickExpand: false,
		showLine: false,
		selectedMulti: false
	},
	data: {
		simpleData: {
			enable:true,
			idKey: "id",
			pIdKey: "pId",
			rootPId: ""
		}
	},
	callback: {
		beforeClick: function(treeId, treeNode) {
			var zTree = $.fn.zTree.getZTreeObj("tree");
			if (treeNode.isParent) {
				zTree.expandNode(treeNode);
				return false;
			} else {
				return true;
			}
		}
	}
};

$('.table-sort').dataTable({
	"aaSorting": [[ 1, "desc" ]],//默认第几个排序
	"bStateSave": true,//状态保存
	"aoColumnDefs": [
	  {"orderable":false,"aTargets":[1,2,3,7]}// 制定列不参与排序
	]
});
/*产品-添加*/
function product_add(title,url){
	var index = layer.open({
		type: 2,
		title: title,
		content: url
	});
	layer.full(index);
}
/*产品-查看*/
function product_show(title,url,id){
	var index = layer.open({
		type: 2,
		title: title,
		content: url
	});
	layer.full(index);
}
/*产品-下架*/
function product_stop(obj,id){
	layer.confirm('确认要下架吗？',function(index){
		$.ajax({
			url:"${pageContext.request.contextPath}/productSoldoutTime?time=" + new Date().getTime(),
			type:'post',
			data:{id:id},
			success:function(){
				$(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" onClick="product_start(this,'+id+')" href="javascript:;" title="发布"><i class="Hui-iconfont">&#xe603;</i></a>');
				$(obj).parents("tr").find(".td-status").html('<span class="label label-defaunt radius">已下架</span>');
				$(obj).remove();
				layer.msg('已下架!',{icon: 5,time:1000});
			}
		});
	});
}

/*产品-发布*/
function product_start(obj,id){
	layer.confirm('确认要发布吗？',function(index){
		$.ajax({
			url:"${pageContext.request.contextPath}/productSoldInTime?time=" + new Date().getTime(),
			type:'post',
			data:{id:id},
			success:function(){
				$(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" onClick="product_stop(this,'+id+')" href="javascript:;" title="下架"><i class="Hui-iconfont">&#xe6de;</i></a>');
				$(obj).parents("tr").find(".td-status").html('<span class="label label-success radius">已发布</span>');
				$(obj).remove();
				layer.msg('已发布!',{icon: 6,time:1000});
			}
		});
	});
}

/*产品-编辑*/
function product_edit(title,url,id){
	$.ajax({
		url:"${pageContext.request.contextPath}/productInfoShow?time=" + new Date().getTime(),
		type:'post',
		data:{id:id},
		success:function(){
			var index = layer.open({
				type: 2,
				title: title,
				content: url
			});
			layer.full(index);
		}
	})	
}

/*产品-删除*/
function product_del(obj,id){
	layer.confirm('确认要删除吗？',function(index){
		$.ajax({
			type: 'POST',
			url: "${pageContext.request.contextPath}/productDel?time=" + new Date().getTime(),
			data:{id:id},
			success: function(data){
				$(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" onClick="product_start(this,'+id+')" href="javascript:;" title="发布"><i class="Hui-iconfont">&#xe603;</i></a>');
				$(obj).parents("tr").find(".td-status").html('<span class="label label-defaunt radius">已删除</span>');
				$(obj).remove();
				layer.msg('已删除!',{icon:1,time:1000});
			}
		});		
	});
}
</script>
</body>
</html>