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
<title>用户管理</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 用户中心 <span class="c-gray en">&gt;</span> 用户管理 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
	<form action="${pageContext.request.contextPath}/searchUser">
		<div class="text-c">
			<input type="text" class="input-text" style="width:250px" placeholder="输入会员名称" id="" name="searchName">
			<button type="submit" class="btn btn-success radius" id="" name=""><i class="Hui-iconfont">&#xe665;</i> 搜用户</button>
		</div>
	</form>
	<div class="cl pd-5 bg-1 bk-gray mt-20"><span class="r">共有数据：<strong>${userCount}</strong> 条</span> </div>
	<div class="mt-20">
	<table class="table table-border table-bordered table-hover table-bg table-sort">
		<thead>
			<tr class="text-c">
				<th width="80">ID</th>
				<th width="100">用户名</th>
				<th width="100">姓名</th>
				<th width="40">性别</th>
				<th width="90">手机</th>
				<th width="150">邮箱</th>
				<th width="70">状态</th>
				<th width="100">操作</th>
			</tr>
		</thead>
		<tbody>
				<c:forEach items="${userList}" var="user" varStatus="i" step="1">
				<tr class="text-c">
					<td>${i.index + 1}</td>
					<td><u style="cursor:pointer" class="text-primary" onclick="member_show('${user.username}','member-show.jsp','${user.uid}','360','400')">${user.username}</u></td>
					<td>${user.name}</td>
					<c:if test='${user.sex == "male"}'>
        				<td>男</td>
        			</c:if>
         			<c:if test='${user.sex == "female"}'>
        				<td>女</td>
        			</c:if>
					<td>${user.phone}</td>
					<td>${user.email}</td>
					<td class="td-status" id="state">
						<c:if test="${user.state == 0}">
							<span class="label label-success radius">未激活</span>
						</c:if>
						<c:if test="${user.state == 1}">
							<span class="label label-success radius">已激活</span>
						</c:if>
						<c:if test="${user.state == 2}">
							<span class="label label-success radius">已删除</span>
						</c:if>
					</td>
					<td class="td-manage">
						<c:if test="${user.state != 2}">
							<a style="text-decoration:none" class="ml-5" onClick="change_password('修改密码','change-password.jsp','${user.uid}','600','270')" href="javascript:;" title="修改密码">
								<i class="Hui-iconfont">&#xe63f;</i>
							</a>
							<a style="text-decoration:none" class="ml-5" onClick="membert_del(this,'${user.uid}')" href="javascript:;" title="删除">
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
$(function(){
	$('.table-sort').dataTable({
		"aaSorting": [[ 1, "desc" ]],//默认第几个排序
		"bStateSave": true,//状态保存
		"aoColumnDefs": [
		  //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
		  {"orderable":false,"aTargets":[2,4,5,6,7]}// 制定列不参与排序
		]
	});
});
/*用户-查看*/
function member_show(title,url,id,w,h){
	$.ajax({
		url:"${pageContext.request.contextPath}/userInfo?time=" + new Date().getTime(),
		type:'post',
		data:{id:id},
		success:function(data){
			layer_show(title,url,w,h);
		}
	});
}
/*密码-修改*/
function change_password(title,url,id,w,h){
	$.ajax({
		url:"${pageContext.request.contextPath}/changePass?time=" + new Date().getTime(),
		type:'post',
		data:{id:id},
		success:function(data){
			layer_show(title,url,w,h);
		}
	});
	
}
/*用户-删除*/
function membert_del(obj,id){
	layer.confirm('确认要删除吗？',function(index){
		$.ajax({
			type: 'POST',
			url: "${pageContext.request.contextPath}/delUser?time=" + new Date().getTime(),
			data:{id:id},
			dataType: 'json',
			success: function(data){ 
				if(data.ok){
					layer.msg(data.msg,{icon:1,time:1000});
					location.href="member-list.jsp";
				}else{
					layer.msg(data.msg,{icon:1,time:1000});
				}
			},
			error:function(data) {
				console.log(data.msg);
			}
		});		
	});
}
</script> 
</body>
</html>