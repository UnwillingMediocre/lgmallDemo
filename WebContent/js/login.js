/*扫码登录和账号登录切换*/
$(function() {
	$("#sm").click(function() {
		$(this).addClass("active");
		$("#zh").removeClass("active");
		$("#sm_box").css("display", "block");
		$("#zh_box").css("display", "none");
	})
	$("#zh").click(function() {
		$(this).addClass("active");
		$("#sm").removeClass("active");
		$("#zh_box").css("display", "block");
		$("#sm_box").css("display", "none");
	})
});

// 验证表单是否为空，若为空则将焦点聚焦在input表单上，否则表单通过，登录成功
function check(form){
	
	var accountName = $("#loginName").val();
	var password = $("#loginPw").val();
	if (!accountName && !password) {
		showMsg("请输入用户名和密码111");
		console.log(123);
		$(".zh_box .name_icon").css({
			"border-right" : "1px solid red",
			"background-position" : "0 -96px"
		});
		$(".zh_login_box input").css("border", "1px solid red");
		$(".pw_box .pw_icon").css({
			"border-right" : "1px solid red",
			"background-position" : "-48px -96px"
		});
		form.loginName.focus();
		$(".zh_box .name_icon").css({
			"border-right" : "1px solid #BDBDBD",
			"background-position" : "0 0"
		});
		$(".zh_login_box .zh_box input").css("border", "1px solid #BDBDBD");
		return;
	}
	if (!accountName) {
		showMsg("请输入用户名");
		form.loginName.focus();
		return;
	}
	if (!password) {
		showMsg("请输入密码");
		form.loginPw.focus();
		return;
	}
	if (password != "" && accountName != "") {
		//ajax登录验证 默认为true async=[true | false]
		$.ajax({
			url : "/lgmall/login?tiem=" + new Date().getTime(),
			type : "post",
			dataType : "json",
			data : {
				username : accountName,
				password : password
			},
			success : function(data) {
				if (data.ok) {
					window.location.href = "index.jsp";
				} else {
					var date = new Date().getTime();
					$("#img").attr("src", "/lgmall/checkImg?time" + date);
					layer.msg(data.msg);
				}
			}
		});
	}
}

// 错误信息提醒
function showMsg(msg) {
	$(".msg").html(
			"<i></i>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + msg)
			.css({
				visibility : 'visible',
			});
	;
}
// “用户名”输入框失去焦点
$(function() {
	$("#loginName").focusout(function() {
		if ($("#loginName").val() == "") {
			$(".zh_login_box .zh_box input").css("border", "1px solid red");
			$(".zh_box .name_icon").css({
				"border-right" : "1px solid red",
				"background-position" : "0 -96px"
			});
		}
	});
});
// “密码”输入框失去焦点
$(function() {
	$("#loginPw").focusout(function() {
		if ($("#loginPw").val() == "") {
			$(".pw_box .pw_icon").css({
				"border-right" : "1px solid red",
				"background-position" : "-48px -96px"
			});
			$(".zh_login_box .pw_box input").css("border", "1px solid red");
		}
	});
});
// “用户名”输入框获得焦点
$(function() {
	$("#loginName").focusin(function() {
		$(".zh_box .name_icon").css({
			"border-right" : "1px solid #BDBDBD",
			"background-position" : "0 0px"
		});
		$(".zh_login_box .zh_box input").css("border", "1px solid #BDBDBD");
	});
});
// “密码”输入框获得焦点
$(function() {
	$("#loginPw").focusin(function() {
		$(".pw_box .pw_icon").css({
			"border-right" : "1px solid #BDBDBD",
			"background-position" : "-48px 0"
		});
		$(".zh_login_box .pw_box input").css("border", "1px solid #BDBDBD");
	});
});
