<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!--_meta 作为公共模版分离出去-->
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="Bookmark" href="/icon/favicon.ico" >
    <link rel="Shortcut Icon" href="/icon/favicon.ico" />
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
    <!--/meta 作为公共模版分离出去-->

    <link href="lib/webuploader/0.1.5/webuploader.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div class="page-container">
    <form name="product-add" action="${pageContext.request.contextPath}/adminProductAddUI" method="post" class="form form-horizontal" id="product-add" enctype="multipart/form-data">
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>产品标题：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" value="" placeholder="" name="p_title" style="width:50%">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>简介描述：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" value="" placeholder="" name="p_sellPoint" style="width:50%">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>商品分类：</label>
           <div class="formControls col-xs-8 col-sm-9" style="width:19%">
           <span class="select-box">
				<select name="cid" class="select" id="category">
				</select>
			</span>
			</div>
			<label class="form-label col-xs-4 col-sm-2" style="width: auto;"><span class="c-red">*</span>热门</label>
           	<div class="formControls col-xs-8 col-sm-9" style="width:14%">
           		<span class="select-box">
					<select name="p_popular" class="select">
						<option value="1">是</option>
						<option value="2">否</option>
					</select>
				</span>
			</div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>产品展示价格：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" name="p_price" placeholder="请输入正确金额" value="" class="input-text" style="width:50%">元	
            </div>
        </div>
        <div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>市场价格：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" name="p_marketPrice" id="" placeholder="请输入正确金额" value="" class="input-text" style="width:50%">元
			</div>
		</div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>库存数量：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" name="p_num" id="num" placeholder="0~99999" value="" class="input-text" style="width:50%">件
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>购买限制数量：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" name="p_limitNum" id="limitNum" placeholder="0~9999" value="" class="input-text" style="width:50%">件
   			</div>
        </div>
        <div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>缩略图：</label>
			<div class="formControls col-xs-8 col-sm-9"> <span class="btn-upload form-group">
				<input class="input-text upload-url" type="text" name="uploadfile" id="uploadfile" readonly="" nullmsg="请添加附件！" style="width:200px" value="">
				<a href="javascript:void();" class="btn btn-primary radius upload-btn">
					<i class="Hui-iconfont"></i> 上传图片
				</a>
				<input type="file" multiple="" name="file-2" class="input-file valid">
				</span>
			</div>
		</div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">商品详情：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <textarea name="p_detail" rows="10" cols="20" style="width: 50%"></textarea>
            </div>
        </div>
        <div class="row cl">
            <div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-2">
                <input id="saveButton" class="btn btn-primary radius" type="submit" value="保存">
                <button onClick="layer_close();" class="btn btn-default radius" type="button">&nbsp;&nbsp;取消&nbsp;&nbsp;</button>
            </div>
        </div>
    </form>
</div>

<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="lib/jquery.validation/1.14.0/jquery.validate.js"></script>
<script type="text/javascript" src="lib/jquery.validation/1.14.0/validate-methods.js"></script>
<script type="text/javascript" src="lib/jquery.validation/1.14.0/messages_zh.js"></script>
<script type="text/javascript" src="lib/webuploader/0.1.5/webuploader.min.js"></script>
<script type="text/javascript">
//获取商品分类
$(function(){
	var content = "";
	$.post(
			"${pageContext.request.contextPath}/category?time=" + new Date().getTime(),
			function(data) {
				if (data.length > 0) {
					for (var i = 0; i < data.length - 1; i++) {
					    content += "<option value='"+data[i].cid+"'>" + data[i].cname + "</option>"
					}
					$("#category").html(content);
				}
	},"json")
});
$(function(){
	//保存发布
    $("#product-add").validate({
        rules:{
            p_title:{
                required:true,
            },
            p_sellPoint:{
                required:true,
            },
            p_price:{
                decimalsValue:true,
                required:true,
                maxlength:10,
            },
            p_marketPrice:{
            	decimalsValue:true,
                required:true,
                maxlength:10,
            },
            p_num:{
                digits:true,
                required:true,
                maxlength:5,
            },
            p_limitNum:{
                digits:true,
                required:true,
                maxlength:4,
            },
            p_detail:{
            	required:true,
            }
        },
        onkeyup:false,
        focusCleanup:false,
        success:"valid",
        submitHandler:function(form){
        	$("#saveButton").submit();
        }
    });
});
</script>
</body>
</html>
