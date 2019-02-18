//用户注册信息校验
$(function(){
	var uname_reg = /^[\dA-Za-z_\-]{4,20}$/;
	var uname_ok = false;
	// 用户名输入框获取焦点
	$("#username").focus(function(){
		$(this).attr("placeholder", "");
		$(this).parent().css("border-color", "#999");
		$("#uname_error").css("color", "#c5c5c5");
		$("#uname_error").html("支持字母, 数字, \"-\", \"_\", 的组合, 4-20个字符");
	});
	$("#username").blur(function(){
		if ($(this).val() == "") {
			$(this).attr("placeholder", "请输入用户名");
			$("#uname_error").html("");
			uname_ok = false;
		} else if ($(this).val().length < 4 || $(this).val().length > 20) {
			// 长度不对
			$("#uname_error").html("长度只能在4-20个字符之间");
			$("#uname_error").css("color", "red");
			$(this).parent().css("border-color", "red");
			uname_ok = false;
		} else if (!$(this).val().match(uname_reg)) {
			// 有特殊字符
			$("#uname_error").html("格式错误, 仅支持字母, 数字, \"-\", \"_\"的组合");
			$("#uname_error").css("color", "red");
			$(this).parent().css("border-color", "red");
			uname_ok = false;
		} else {
			uname_ok = true;
		}
	});
 
	var pwd_reg = /^(?![A-Z]+$)(?![a-z]+$)(?!\d+$)(?![\W_]+$)\S{6,20}$/;
	var pwd_ok = false;
	// 密码输入框获取焦点
	$("#password").focus(function(){
		$(this).attr("placeholder", "");
		$(this).parent().css("border-color", "#999");
		$("#password_error").css("color", "#c5c5c5");
		$("#password_error").html("建议使用字母, 数字和符号两种及以上的组合, 6-20个字符");
	});
	$("#password").blur(function(){
		if ($(this).val() == "") {
			$(this).attr("placeholder", "建议至少使用两种字符组合");
			$("#password_error").html("");
			pwd_ok = false;
		} else if ($(this).val().length < 6 || $(this).val().length > 20) {
			// 长度不对
			$("#password_error").html("长度只能在6-20个字符之间");
			$("#password_error").css("color", "red");
			$(this).parent().css("border-color", "red");
			pwd_ok = false;
		} else if (!$(this).val().match(pwd_reg)) {
			// 不是两种及以上的组合
			$("#password_error").html("有被盗风险, 建议使用字母, 数字和符号两种及以上组合");
			$("#password_error").css("color", "red");
			$(this).parent().css("border-color", "red");
			pwd_ok = false;
		} else {
			pwd_ok = true;
		}
	});
 
	// 再次密码输入框获取焦点
	var confirm_pwd_ok = false;
	$("#confirm_password").focus(function(){
		$(this).attr("placeholder", "");
		$(this).parent().css("border-color", "#999");
		$("#confirm_password_error").css("color", "#c5c5c5");
		$("#confirm_password_error").html("请再次输入密码");
	});
	$("#confirm_password").blur(function(){
		if ($(this).val() == "") {
			$(this).attr("placeholder", "请再次输入密码");
			$("#confirm_password_error").html("");
			confirm_pwd_ok = false;
		} else if ($(this).val() != $("#password").val()) {
			// 再次输入的密码不一致
			$("#confirm_password_error").html("两次输入的密码不一致");
			$("#confirm_password_error").css("color", "red");
			$(this).parent().css("border-color", "red");
			confirm_pwd_ok = false;
		} else {
			confirm_pwd_ok = true;
		}
	});
	//邮箱输入框获取焦点
	var email_reg = /^([(A-Za-z)|(0-9)(\w|\-)]+)@([0-9a-z]+\.([[a-zA-Z]{2,4}))$/;
	var email_ok = false;
	$("#email").focus(function(){
		$(this).attr("placeholder", "");
		$(this).parent().css("border-color", "#999");
		$("#email_error").css("color", "#c5c5c5");
		$("#email_error").html("输入已经验证的邮箱");
	});
	$("#email").blur(function(){
		if(!$(this).val().match(email_reg)){
			$("#email_error").html("格式有错");
			$("#email_error").css("color", "red");
			$(this).parent().css("border-color", "red");
			email_ok = false;
		}else{
			email_ok = true;
		}
	})
 
	// 验证码输入框获取焦点
	var code_ok = false;
	$("#code").focus(function(){
		$(this).attr("placeholder", "");
		$(this).parent().css("border-color", "#999");
		$("#code_error").css("color", "#c5c5c5");
		$("#code_error").html("看不清? 点击更换验证码");
	});
	$("#code").blur(function(){
		if ($(this).val() == "") {
			$("#code_error").html("验证码不能为空");
			$("#code_error").css("color", "red");
			$(this).parent().css("border-color", "red");
			code_ok = false;
		} else {
			code_ok = true;
		}
	});
	
	//ajax验证用户名、邮箱
	$("#btn").click(function(event){
		if(uname_ok && email_ok && code_ok){
			$.ajax({
				url:"/lgmall/usernameCode?time=" + new Date().getTime(),
				type:"post",
				dataType:"json",
				data:{
					username:$("#username").val(), //用户名
					email:$("#email").val(), //邮箱
					code:$("#code").val() //验证码
				},
				success:function(data){
					if(data.ok){
						$("#J-code").css("display","none");
						$("#J-pwd").css("display","block");
					}else{
						var date = new Date().getTime();
						$("#img").attr("src", "/lgmall/checkImg?time" + date);
						layer.msg(data.msg);
					}
				}
			});
		}else{
			layer.msg("请输入正确用户信息！");
		}
	});
	//ajax验证修改密码
	$("#J-reset").click(function(event){
		if(pwd_ok && confirm_pwd_ok){
			$.ajax({
				url:"/lgmall/forgotPassword?time=" + new Date().getTime(),
				type:"post",
				data:{
					password:$("#password").val(), //密码
				},
				success:function(data){
					if(data == "true"){
						layer.msg("修改成功");
						window.location.href = "login.jsp";
					}else{
						var date = new Date().getTime();
						$("#img").attr("src", "/lgmall/checkImg?time" + date);
						layer.msg("修改失败");
					}
				}
			});
		}else{
			layer.msg("请输入正确用户信息！");
		}
	});
});