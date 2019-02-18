//关键字搜索
function productSearch() {
	var word = $("#msg").val();
	$.ajax({
		url : "/lgmall/productSearch?time=" + new Date().getTime(),
		type : "post",
		data:{
			keyword:word,
			type:1
		},
		success : function(data) {
			window.location.href = "product_list.jsp";
		}
	});
}
$(function() {
	var intDiff = parseInt(600000);// 倒计时总秒数量
	window.load = getTime(intDiff);
});

// 秒杀倒计时
function getTime(intDiff) {
	window.setInterval(function() {
		var day = 0, hour = 0, minute = 0, second = 0;// 时间默认值
		if (intDiff > 0) {
			day = Math.floor(intDiff / (60 * 60 * 24));
			hour = Math.floor(intDiff / (60 * 60)) - (day * 24);
			minute = Math.floor(intDiff / 60) - (day * 24 * 60) - (hour * 60);
			second = Math.floor(intDiff) - (day * 24 * 60 * 60)
					- (hour * 60 * 60) - (minute * 60);
		}
		if (hour <= 9)
			hour = '0' + hour;
		if (minute <= 9)
			minute = '0' + minute;
		if (second <= 9)
			second = '0' + second
			// $('#hour_show').html('<s></s>'+hour);
		$('#minute_show').html('<s></s>' + minute);
		$('#second_show').html('<s></s>' + second);
		intDiff--;
		if(hour == 0 && minute == 0 && second == 0){
			$.ajax({
				url:"/lgmall/productSecKill?time=" + new Date().getTime(),
				type:'post'
			});
		}
	}, 1000);
}

// 商品滚动
$(function() {
	$(".next a").click(function() {
		nextscroll()
	});
	function nextscroll() {
		var vcon = $(".aui-content-box-list ");
		var offset = ($(".aui-content-box-list li").width()) * -4;
		vcon.stop().animate({
			left : offset
		}, "slow", function() {
			for (var i = 0; i < 4; i++) {
				var firstItem = $(".aui-content-box-list ul li").first();
				vcon.find("ul").append(firstItem);
				$(this).css("left", "0px");
				circle();
			}
		});
	}
	;
	function circle() {
		var currentItem = $(".aui-content-box-list ul li").first();
		var currentIndex = currentItem.attr("index");
		$(".circle li").removeClass("circle-cur");
		$(".circle li").eq(currentIndex).addClass("circle-cur");
	}
	$(".prev a").click(function() {
		var vcon = $(".aui-content-box-list ");
		var offset = ($(".aui-content-box-list li").width() * -4);
		for (var i = 0; i < 4; i++) {
			var lastItem = $(".aui-content-box-list ul li").last();
			vcon.find("ul").prepend(lastItem);
			vcon.css("left", offset);
			vcon.animate({
				left : "0px"
			}, "slow", function() {
				circle();
			});
		}
	});
});

// ad自动滚动
$(function() {
	$(".example2").luara({
		width : "194",
		height : "275",
		interval : 3500,
		selected : "seleted",
		deriction : "left"
	});

});

// 内容切换
$(function() {
	var msgs = [ "黑五海囤节", "家电五折抢" ];
	window.setInterval(function() {
		var index = Math.floor(Math.random() * (msgs.length));
		var list = document.getElementsByClassName("hotwords")[0];
		list.getElementsByClassName("f10")[0].innerHTML = msgs[index];
	}, 3000);
});

// 关闭广告
function closed() {
	var close = document.getElementById("close");
	close.style.display = "none";
}

// 停留
function sleep(delay) {
	var start = (new Date()).getTime();
	while ((new Date()).getTime() - start < delay) {
		continue;
	}
}

// 加载动画
function cartoon() {
	$("#animation").css("background-image",
			"url(../fjd/img/5b5edd53N433c624a.gif)");
	sleep(200);
	$("#logo_scene_text").css("opacity", "1");
	$("#logo_scene_btn").css("opacity", "1");
}

// logo
function restore() {
	$("#animation").css("background-image", "url(../fjd/img/logo_1.png)");
	document.getElementById("logo_scene_text").style.opacity = 0;
	$("#logo_scene_btn").css("opacity", "0");
}
// 标签切换
function new_discoun() {
	var left = parseInt($(".news_t .line").css('left'));
	document.getElementById('itme_notice').style.display = "none";
	document.getElementById('itme_discoun').style.display = "block";
	for (var i = left; i >= -3; i -= 0.5) {
		$(".news_t .line").css('left', i + 'px');
	}
}

function new_notice() {
	var left = parseInt($(".news_t .line").css('left'));
	document.getElementById('itme_notice').style.display = "block";
	document.getElementById('itme_discoun').style.display = "none";
	for (var i = left; i <= 50; i += 0.5) {
		$(".news_t .line").css('left', i + 'px');
	}
}
// 双12广告
$(function() {
	var enjoyScroll = parseInt($(".enjoy").offset().top);
	$(window).scroll(function() {
		if ($(this).scrollTop() >= 750) {
			$(".enjoy").slideDown(1000);
		} else {
			$(".enjoy").slideUp(1000);
		}
	});
});
// 滑动导航条
$(document).ready(function() {
	$(".myjd").hover(function() {
		$(".shortcut_jd").fadeIn(800);
	}, function() {
		$(".shortcut_jd").fadeOut(1000);
	});
});

$(document).ready(function() {
	$(".company").hover(function() {
		$(".shortcut_company").fadeIn(800);
	}, function() {
		$(".shortcut_company").fadeOut(1000);
	});
});

$(document).ready(function() {
	$(".customer").hover(function() {
		$(".shortcut_CB").fadeIn(800);
	}, function() {
		$(".shortcut_CB").fadeOut(1000);
	});
});
// tab切换
$(function() {
	$('.box_bd .top_inner .tab .tab_head div').mousemove(
			function() {
				$(this).addClass('active').siblings().removeClass('active');
				$('.tab_body>div:eq(' + $(this).index() + ')').show()
						.siblings().hide();
			})
});

$(function() {
	// 手动控制轮播图
	$('.box_bd .mime_slider').eq(0).show();

	$('.circle_box li').mouseover(
			function() {
				$(this).addClass('current_1').siblings().removeClass(
						'current_1');
				var index = $(this).index();
				i = index;
				$('.box_bd .mime_slider').eq(index).stop().fadeIn(300)
						.siblings().stop().fadeOut(300);
			})
	// 自动播放
	var i = 0;
	var t = setInterval(move, 5000);
	// 自动播放核心函数
	function move() {
		i++;
		if (i == 3) {
			i = 0;
		}
		$('.circle_box li').eq(i).addClass('current_1').siblings().removeClass(
				'current_1');
		$('.box_bd .mime_slider').eq(i).fadeIn(300).siblings().fadeOut(300);
	}

	// 向右播放核心函数
	function moveL() {
		i--;
		if (i == -1) {
			i = 2;
		}
		$('.circle li').eq(i).addClass('current').siblings().removeClass(
				'current');
		$('.box_bd .mime_slider').eq(i).fadeIn(300).siblings().fadeOut(300);
	}
	// 鼠标移入移除
	$('.box_bd').hover(function() {
		clearInterval(t);
	}, function() {
		t = setInterval(move, 5000);
	})
});

// 飞入动画
$(function() {
	$(window)
			.scroll(
					function() {
						if ($(this).scrollTop() >= 1000) {
							document.getElementById("corechn").style.display = "block";
							document.getElementById("corechn").style.animation = "bounceInLeft 0.5s 0.25s linear forwards";
							document.getElementById("b").style.animation = "bounceInLeft 1.1s 0.85s linear forwards";
							document.getElementById("c").style.animation = "bounceInRight 0.9s 0.65s linear forwards";
						}
					});
});