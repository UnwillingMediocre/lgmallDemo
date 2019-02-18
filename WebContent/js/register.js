//用户注册信息校验
$(function(){
	var name_reg = /^[\u4e00-\u9fa5]{2,5}$/;
	var name_ok = false;
	//姓名失去焦点
	$("#name").focus(function(){
		$(this).attr("placeholder", "");
		$(this).parent().css("border-color", "#999");
		$("#name_error").css("color", "#c5c5c5");
		$("#name_error").html("支持中文,2-5个字符");
	});
	$("#name").blur(function(){
		if ($(this).val() == "") {
			$(this).attr("placeholder", "您的真实姓名");
			$("#name_error").html("");
			name_ok = false;
		} else if ($(this).val().length < 2 || $(this).val().length > 5) {
			// 长度不对
			$("#name_error").html("长度只能在2-5个字符之间");
			$("#name_error").css("color", "red");
			$(this).parent().css("border-color", "red");
			name_ok = false;
		} else if (!$(this).val().match(name_reg)) {
			// 有特殊字符
			$("#name_error").html("格式错误, 仅支持中文字符");
			$("#name_error").css("color", "red");
			$(this).parent().css("border-color", "red");
			name_ok = false;
		} else {
			name_ok = true;
		}
	});
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
			$(this).attr("placeholder", "您的账户名和登录名");
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
		$("#email_error").html("验证完后，用来激活用户");
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
	// 手机号码输入框获取焦点
	var phone_reg = /^1[3|4|5|7|8]\d{9}$/;
	var phone_ok = false;
	$("#phone").focus(function(){
		$(this).attr("placeholder", "");
		$(this).parent().css("border-color", "#999");
		$("#phone_error").css("color", "#c5c5c5");
		$("#phone_error").html("验证完成后, 可以使用该手机登录和找回密码");
	});
	$("#phone").blur(function(){
		if ($(this).val() == "") {
			$(this).attr("placeholder", "建议使用常用手机");
			$("#phone_error").html("");
			phone_ok = false;
		} else if ($(this).val().length != 11) {
			// 长度不对
			$("#phone_error").html("格式有错");
			$("#phone_error").css("color", "red");
			$(this).parent().css("border-color", "red");
			phone_ok = false;
		} else if (!$(this).val().match(phone_reg)) {
			// 输入的不是手机号码
			$("#phone_error").html("格式有错");
			$("#phone_error").css("color", "red");
			$(this).parent().css("border-color", "red");
			phone_ok = false;
		} else {
			phone_ok = true;
		}
	});
 
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
	// 是否同意协议
	$("#agreen").click(function(){
		if ($(this).attr('checked')) {
			$(this).attr('checked', false);
		} else {
			$(this).attr('checked', true);
		}
	});
	
	//ajax验证注册用户
	$("#btn").click(function(event){
		var sex = $('input[name="sex"]:checked').val();
		if($("#agreen").attr('checked') && name_ok && uname_ok && pwd_ok && confirm_pwd_ok && email_ok && phone_ok && code_ok){
			$.ajax({
				url:"/lgmall/register?time=" + new Date().getTime(),
				type:"post",
				dataType: 'json',
				data:{
					name:$("#name").val(),  //姓名
					sex:sex, //性别
					username:$("#username").val(), //用户名
					password:$("#password").val(), //密码
					email:$("#email").val(), //邮箱
					phone:$("#phone").val(), //手机号
					code:$("#code").val() //验证码
				},
				success:function(data){
					if(data.ok){
						window.location.href = "registerSuccess.jsp";
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
});