<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="UTF-8">
<title>乐购(LG.COM)-正品低价、品质保障、配送及时、轻松购物！</title>
<meta name="description"
	content="乐购LG.COM-专业的综合网上购物商城,销售家电、数码通讯、电脑、家居百货、服装服饰、母婴、图书、食品等数万个品牌优质商品.便捷、诚信的服务，为您提供愉悦的网上购物体验!" />
<meta name="Keywords"
	content="网上购物,网上商城,手机,笔记本,电脑,MP3,CD,VCD,DV,相机,数码,配件,手表,存储卡,京东" />
<!-- 基本公共样式 -->
<link href="<%=basePath%>/css/base.css" rel="stylesheet" type="text/css" />
<!-- 首页样式 -->
<link href="<%=basePath%>/css/index.css" rel="stylesheet"
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
</style>
</head>
<body style="height: 2000px;">
	<!-- header部分 start -->
	<header id="close" style=" display: ">
	<div class="w">
		<div style="position: relative;">
			<a href="#"> <img src="img/head.jpg">
			</a> <i onclick="closed();" class="advert">X</i>
		</div>
	</div>
	</header>
	<!-- header部分 end -->
	<!-- 快速导航栏 start-->
	<jsp:include page="/header.jsp"></jsp:include>
	<!-- 快速导航栏 end-->
	<!-- 中间部分 start -->
	<div class="w middle">
		<div class="logo">
			<h1>
				<a id="animation" href="#">乐购(LG)</a>
			</h1>
		</div>
		<div class="form">
			<input id="msg" type="text" placeholder="智能马桶"
				onkeyup="searchWord(this)" name="keyword">
			<button style="cursor: pointer;" id="J-search" onclick='productSearch()'>
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
		<!-- 关键词 -->
		<div class="hotwords">
			<a href="#" class="f10">家电五折抢</a> <a href="#">机械革命</a> <a href="#">399减88
			</a> <a href="#">499减100</a> <a href="#">抢神券</a> <a href="#">oppo</a> <a
				href="#">魅尚萱</a> <a href="#">苹果新品</a> <a href="#">联想免息</a>
		</div>
		<!-- 小导航部分 -->
		<div class="navitems">
			<ul>
				<li><a href="#">秒杀</a></li>
				<li><a href="#">优惠券</a></li>
				<li><a href="#">PLUS会员</a></li>
				<li><a href="#">闪购</a></li>
				<li class="space"></li>
				<li><a href="#">拍卖</a></li>
				<li><a href="#">乐购服饰</a></li>
				<li><a href="#">乐购超市</a></li>
				<li><a href="#">乐购生鲜</a></li>
				<li class="space"></li>
				<li><a href="#">全球购</a></li>
				<li><a href="#">乐购金融</a></li>
			</ul>
		</div>
		<div class="advert">
			<a href="#"> <img src="img/advert.png">
			</a>
		</div>
	</div>
	<!-- 中间部分 end -->
	<!-- 中间分类部分 start-->
	<div class="w">
		<div class="gird">
			<!-- 左分类 -->
			<div class="gird_l fl">
				<ul id="category">
				</ul>
			</div>
			<!-- 中分类 -->
			<div class="gird_m fl">
				<div class="gird_mb">
					<ul class="gird_img">
						<li><a href="#"><img src="img/head_1.jpg"></a></li>
						<li><a href="#"><img src="img/head_2.jpg"></a></li>
						<li><a href="#"><img src="img/head_3.jpg"></a></li>
						<li><a href="#"><img src="img/head_4.jpg"></a></li>
						<li><a href="#"><img src="img/head_5.jpg"></a></li>
						<li><a href="#"><img src="img/head_6.jpg"></a></li>
						<li><a href="#"><img src="img/head_7.jpg"></a></li>
						<li><a href="#"><img src="img/head_8.jpg"></a></li>
					</ul>
					<a href="javascript:void(0)" class="arr_l"><</a> <a
						href="javascript:void(0)" class="arr_r">></a>
					<ul class="circle">
						<li class="current"></li>
						<li></li>
						<li></li>
						<li></li>
						<li></li>
						<li></li>
						<li></li>
						<li></li>
					</ul>
				</div>
			</div>
			<!-- 中右分类 -->
			<div class="gird_mr fl">
				<a href="#"> <img src="img/mr_advert_1.jpg"
					style="margin-top: 8px;">
				</a> <a href="#"> <img src="img/mr_advert_2.jpg"
					style="margin-top: 8px;">
				</a> <a href="#"> <img src="img/mr_advert_3.jpg"
					style="margin-top: 8px;">
				</a>
			</div>
			<!-- 右分类 -->
			<!-- 上部分 -->
			<div class="gird_r fr">
				<div class="login">
					<div class="login_t">
						<a href="login.html" target="_blank"><img
							src="img/no_login.jpg"></a>
					</div>
					<div class="login_m">
						<p class="tip">Hi~欢迎来到乐购！</p>
						<p class="user">
							<c:if test="${sessionScope.loginUsername == null}">
								<a href="login.jsp">登录</a>
								<a href="register.jsp">注册</a>
							</c:if>
							<c:if test="${sessionScope.loginUsername != null}">
								<a href="#">${sessionScope.loginUsername}</a>
								<a href="<%=basePath%>/logout">注销</a>
							</c:if>

						</p>
					</div>
					<div class="login_b">
						<a href="#" class="newer">新人福利</a> <a href="#" class="vip">PLUS会员</a>
					</div>
				</div>
				<!-- 中部分 -->
				<div class="news">
					<div class="news_t">
						<a href="#" class="discoun" onmouseover="new_discoun()">促销</a> <a
							href="#" class="notice" onmouseover="new_notice()">公告</a> <a
							href="#" class="more">更多</a>
						<div class="line"></div>
					</div>
					<div class="news_b" id="itme_discoun" style="display: block;">
						<ul>
							<li class="news_item"><a href="#">华为爆款直降</a></li>
							<li class="news_item"><a href="#">电脑数码 享白条免息</a></li>
							<li class="news_item"><a href="#">数码好物0元试用</a></li>
							<li class="news_item"><a href="#">天际厨电感恩专场豪礼免费拿</a></li>
						</ul>
						<p></p>
					</div>
					<div class="news_b" id="itme_notice" style="display: none;">
						<ul>
							<li class="news_item"><a href="#">乐购图书勋章体系改版公告</a></li>
							<li class="news_item"><a href="#">乐购PLUS会员权益更新及会费调整</a></li>
							<li class="news_item"><a href="#">乐购启用全新客服电话“950618”</a></li>
							<li class="news_item"><a href="#">关于召回普利司通（天津）轮胎有限公司2个规格乘用车轮胎的公告</a></li>
						</ul>
						<p></p>
					</div>
				</div>
				<div class="expand">
					<ul>
						<li><a href=""> <i class="item1"></i> <span>话费</span>
						</a></li>
						<li><a href=""> <i class="item2"></i> <span>机票</span>
						</a></li>
						<li><a href=""> <i class="item3"></i> <span>酒店</span>
						</a></li>
						<li><a href=""> <i class="item4"></i> <span>游戏</span>
						</a></li>
						<li><a href=""> <i class="item5"></i> <span>彩票</span>
						</a></li>
						<li><a href=""> <i class="item6"></i> <span>加油卡</span>
						</a></li>
						<li><a href=""> <i class="item7"></i> <span>电影票</span>
						</a></li>
						<li><a href=""> <i class="item8"></i> <span>火车票</span>
						</a></li>
						<li><a href=""> <i class="item9"></i> <span>众筹</span>
						</a></li>
						<li><a href=""> <i class="item10"></i> <span>白条</span>
						</a></li>
						<li><a href=""> <i class="item11"></i> <span>理财</span>
						</a></li>
						<li><a href=""> <i class="item12"></i> <span>礼品卡</span>
						</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<!-- 中间分类部分 end-->
	<!-- 秒杀-下面部分start -->
	<div class="w">
		<div class="aui-content-max">
			<div class="aui-sale-time">
				<a href="javascript:;" class="aui-sale-time-link">
					<div class="aui-sale-title">乐购秒杀</div>
					<div class="aui-sale-second">FLASH DEALS</div>
					<div class="aui-sale-icon-sd"></div>
					<div class="aui-sale-ends">本场距离结束还剩</div>
					<div class="aui-sale-count">
						<div class="aui-sale-count-item">
							<span id="hour_show">00</span>
						</div>
						<div class="aui-sale-count-item">
							<span id="minute_show">00</span>
						</div>
						<div class="aui-sale-count-item">
							<span id="second_show">00</span>
						</div>
					</div>
				</a>
			</div>
			<div class="aui-content-box">
				<div class="prev">
					<a href="javascript:void(0)"> <img src="img/prev.png" alt="">
					</a>
				</div>
				<div class="aui-content-box-ovf">
					<div class="aui-content-box-list">
						<ul>
								<li>
									<a href="#">
										<div class="aui-content-item-img">
											<img src="img/secKillImg/pd1.jpg" alt="">
										</div>
										<p class="aui-content-item-name">男士手表
										带日历夜光男表时尚潮流瑞表dw手表超薄防水石英表男学生 威利默克（WellyMerck） 瑞士男士手表-钢带黑色</p>
										<div class="aui-content-price">
											<span class="aui-content-price-new"> <i>¥</i> <span>1180.00</span>
											</span> 
											<span class="aui-content-price-origin"> <i>¥</i> <span>3360.00</span>
											</span>
										</div>
									</a>
								</li>
							<li><a href="#">
									<div class="aui-content-item-img">
										<img src="img/secKillImg/pd2.jpg" alt="">
									</div>
									<p class="aui-content-item-name">机械师T90
										144Hz电竞屏游戏本八代i7-8750H/GTX1060 6G独显吃鸡笔记本电脑
										远行版i7-8750H/8G/256G固态</p>
									<div class="aui-content-price">
										<span class="aui-content-price-new"> <i>¥</i> <span>7689.00</span>
										</span> <span class="aui-content-price-origin"> <i>¥</i> <span>9699.00</span>
										</span>
									</div>
							</a></li>
							<li><a href="#">
									<div class="aui-content-item-img">
										<img src="img/secKillImg/pd3.jpg" alt="">
									</div>
									<p class="aui-content-item-name">玉友 和田玉青玉吊坠 男女款时来运转玉石挂坠项链
										青玉时来运转</p>
									<div class="aui-content-price">
										<span class="aui-content-price-new"> <i>¥</i> <span>1999.00</span>
										</span> <span class="aui-content-price-origin"> <i>¥</i> <span>5999.00</span>
										</span>
									</div>
							</a></li>
							<li><a href="#">
									<div class="aui-content-item-img">
										<img src="img/secKillImg/pd4.jpg" alt="">
									</div>
									<p class="aui-content-item-name">大民族匠心酒
										茅台镇酱香型白酒53度陈酿老酒白酒口粮酒500ml纯粮食白酒 整箱6瓶</p>
									<div class="aui-content-price">
										<span class="aui-content-price-new"> <i>¥</i> <span>498.00</span>
										</span> <span class="aui-content-price-origin"> <i>¥</i> <span>880.00</span>
										</span>
									</div>
							</a></li>
							<li><a href="#">
									<div class="aui-content-item-img">
										<img src="img/secKillImg/pd5.jpg" alt="">
									</div>
									<p class="aui-content-item-name">三只松鼠坚果炒货零食干果果仁炭烧味炭烧腰果185g/袋</p>
									<div class="aui-content-price">
										<span class="aui-content-price-new"> <i>¥</i> <span>19.80</span>
										</span> <span class="aui-content-price-origin"> <i>¥</i> <span>39.90</span>
										</span>
									</div>
							</a></li>
							<li><a href="#">
									<div class="aui-content-item-img">
										<img src="img/secKillImg/pd6.jpg" alt="">
									</div>
									<p class="aui-content-item-name">华硕(ASUS) 飞行堡垒6
										15.6英寸游戏笔记本电脑(i7-8750H 8G 256GSSD+1T GTX1060 6G 72%NTSC
										IPS)金属电竞</p>
									<div class="aui-content-price">
										<span class="aui-content-price-new"> <i>¥</i> <span>8298.00</span>
										</span> <span class="aui-content-price-origin"> <i>¥</i> <span>8999.00</span>
										</span>
									</div>
							</a></li>
							<li><a href="#">
									<div class="aui-content-item-img">
										<img src="img/secKillImg/pd7.jpg" alt="">
									</div>
									<p class="aui-content-item-name">TCL 变频冷暖 静音省电 挂壁式 空调挂机
										怡静系列 KFRd-35GW/D-XC11Bp(A3)</p>
									<div class="aui-content-price">
										<span class="aui-content-price-new"> <i>¥</i> <span>1988.00</span>
										</span> <span class="aui-content-price-origin"> <i>¥</i> <span>2699.00</span>
										</span>
									</div>
							</a></li>
							<li><a href="#">
									<div class="aui-content-item-img">
										<img src="img/secKillImg/pd8.jpg" alt="">
									</div>
									<p class="aui-content-item-name">国花瓷 西凤
										国花瓷西凤酒5年45度500ml*6，整箱装 口感凤香型白酒</p>
									<div class="aui-content-price">
										<span class="aui-content-price-new"> <i>¥</i> <span>549.00</span>
										</span> <span class="aui-content-price-origin"> <i>¥</i> <span>6255.00</span>
										</span>
									</div>
							</a></li>
							<li><a href="#">
									<div class="aui-content-item-img">
										<img src="img/secKillImg/pd9.jpg" alt="">
									</div>
									<p class="aui-content-item-name">【京东秒杀 】蛇圣F1 无线运动蓝牙耳机
										入耳式耳塞重低音跑步降噪耳机苹果华为小米通用 黑色</p>
									<div class="aui-content-price">
										<span class="aui-content-price-new"> <i>¥</i> <span>69.00</span>
										</span> <span class="aui-content-price-origin"> <i>¥</i> <span>229.00</span>
										</span>
									</div>
							</a></li>
							<li><a href="#">
									<div class="aui-content-item-img">
										<img src="img/secKillImg/pd10.jpg" alt="">
									</div>
									<p class="aui-content-item-name">京东海外直采 德国凯斯勒 雷根特晚收甜红葡萄酒/红酒
										莱茵黑森产区 375ml 原瓶进口</p>
									<div class="aui-content-price">
										<span class="aui-content-price-new"> <i>¥</i> <span>39.00</span>
										</span> <span class="aui-content-price-origin"> <i>¥</i> <span>89.00</span>
										</span>
									</div>
							</a></li>
							<li><a href="#">
									<div class="aui-content-item-img">
										<img src="img/secKillImg/pd11.jpg" alt="">
									</div>
									<p class="aui-content-item-name">澳洲直邮原装正品Karicare可瑞康山羊奶婴幼儿配方奶粉2段900g
										2段单罐装</p>
									<div class="aui-content-price">
										<span class="aui-content-price-new"> <i>¥</i> <span>216.00</span>
										</span> <span class="aui-content-price-origin"> <i>¥</i> <span>280.00</span>
										</span>
									</div>
							</a></li>
							<li><a href="#">
									<div class="aui-content-item-img">
										<img src="img/secKillImg/pd12.jpg" alt="">
									</div>
									<p class="aui-content-item-name">碧然德（BRITA）过滤净水器家用办公户外多用式滤水壶滤芯
										超滤机纯水软水新升级Maxtra+滤芯标准版6枚装</p>
									<div class="aui-content-price">
										<span class="aui-content-price-new"> <i>¥</i> <span>149.00</span>
										</span> <span class="aui-content-price-origin"> <i>¥</i> <span>240.00</span>
										</span>
									</div>
							</a></li>
						</ul>
					</div>
				</div>
				<div class="next">
					<a href="javascript:void(0)"> <img src="img/next.png" alt="">
					</a>
				</div>
			</div>
			<div class="aui-small-ad">
				<div class="example2">
					<ul>
						<li><img src="img/secKillImg/ad2.jpg" alt="2"></li>
						<li><img src="img/secKillImg/ad3.jpg" alt="3"></li>
						<li><img src="img/secKillImg/ad1.jpg" alt="1"></li>
					</ul>
					<ol>
						<li></li>
						<li></li>
						<li></li>
					</ol>
				</div>
			</div>
		</div>
	</div>
	<!-- 秒杀-下面部分end -->
	<!-- 双12广告 start -->
	<div class="enjoy" style="display: none;">
		<div class="grid_c1 enjoy_floor enjoy_floor_a2">
			<div class="enjoy_bg"></div>
			<div class="enjoy_inner">
				<div class="enjoy_tit">
					<a class="enjoy_tit_lk" href="#"></a>
				</div>
				<div class="enjoy_act">
					<ul>
						<li class="enjoy_act_item"><a href="#"
							class="enjoy_act_lk J_log" target="_blank">
								<div class="lazyimg lazyimg_loaded enjoy_act_img">
									<img src="img/advert/542d58b30f8bf7fd.jpg" class="lazyimg_img">
								</div>
						</a></li>
						<li class="enjoy_act_item"><a href="#"
							class="enjoy_act_lk J_log" target="_blank">
								<div class="lazyimg lazyimg_loaded enjoy_act_img">
									<img src="img/advert/303ac930006dac68.jpg" class="lazyimg_img">
								</div>
						</a></li>
						<li class="enjoy_act_item"><a href="#"
							class="enjoy_act_lk J_log" target="_blank">
								<div class="lazyimg lazyimg_loaded enjoy_act_img">
									<img src="img/advert/7e800374b4649399.png" class="lazyimg_img">
								</div>
						</a></li>
						<li class="enjoy_act_item"><a href="#"
							class="enjoy_act_lk J_log" target="_blank">
								<div class="lazyimg lazyimg_loaded enjoy_act_img">
									<img src="img/advert/8bd86b8ae676c543.jpg" class="lazyimg_img">
								</div>
						</a></li>
						<li class="enjoy_act_item"><a href="#"
							class="enjoy_act_lk J_log" target="_blank">
								<div class="lazyimg lazyimg_loaded enjoy_act_img">
									<img src="img/advert/8d9d6adef392fd21.jpg" class="lazyimg_img">
								</div>
						</a></li>
					</ul>

				</div>
			</div>
		</div>
	</div>
	<!-- 双12广告 end -->
	<!-- 排行榜、	会员专辑、领券中心 部分start -->
	<div id="corechn" class="corechn1" style="display: none;">
		<div class="grid_c1 corechn1_inner">
			<div class="box top">
				<div class="box_hd">
					<a href="#">
						<h3 class="box_tit">排行榜</h3> <i class="box_hd_arrow"></i> <span
						class="box_subtit">专属你的购物指南</span>
					</a>
				</div>
				<div class="box_bd">
					<div class="top_inner">
						<div class="tab top_tab">
							<div class="tab_head">
								<div class="tab_head_item active">
									<a href="#" class="top_tab_lk">手机通讯</a>
								</div>
								<div class="tab_head_item ">
									<a href="#" class="top_tab_lk">流行男鞋</a>
								</div>
								<div class="tab_head_item">
									<a href="#" class="top_tab_lk">个护健康</a>
								</div>
								<div class="tab_head_item">
									<a href="#" class="top_tab_lk">休闲食品</a>
								</div>
								<div class="tab_head_item">
									<a href="#" class="top_tab_lk">男装</a>
								</div>

							</div>
							<div class="tab_body">
								<div class="tab_body_item" style="display: block;">
									<div class="slider top_wrapper">
										<div class="slider_list">
											<div class="slider_wrapper"
												style="opacity: 1; transform: translate3d(0px, 0px, 0px); transition: block;">
												<div class="slider_item top_list slider_active"
													data-index="0" style="float: left; width: 282.995px;">
													<div class="top_item">
														<a class="top_item_lk" href="#" target="_blank">
															<div class="lazyimg lazyimg_loaded top_item_img">
																<img src="img/rank_ad/59b85824N836bb714.jpg"
																	class="lazyimg_img">
															</div> <span class="top_item_rank top_item_rank_1">1</span> <span
															class="top_item_name">Apple iPhone X (A1865) 64GB
																银色 移动联通电信4G手机</span>
														</a>
													</div>
													<div class="top_item">
														<a class="top_item_lk" href="#" target="_blank">
															<div class="lazyimg lazyimg_loaded top_item_img">
																<img src="img/rank_ad/59e42830N9da56c41.jpg"
																	class="lazyimg_img">
															</div> <span class="top_item_rank top_item_rank_2">2</span> <span
															class="top_item_name">荣耀9i 4GB+64GB 魅海蓝
																移动联通电信4G全面屏手机 双卡双待</span>
														</a>
													</div>
													<div class="top_item">
														<a class="top_item_lk" href="#" target="_blank"
															clstag="h|keycount|core|ranking_c0103">
															<div class="lazyimg lazyimg_loaded top_item_img">
																<img src="img/rank_ad/5b1799cdN37efd6ec.jpg"
																	class="lazyimg_img">
															</div> <span class="top_item_rank top_item_rank_3">3</span> <span
															class="top_item_name">Apple iPhone 8 (A1863) 64GB
																深空灰色 移动联通电信4G手机</span>
														</a>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
								<div class="tab_body_item">
									<div class="slider top_wrapper">
										<div class="slider_list">
											<div class="slider_wrapper"
												style="opacity: 1; transform: translate3d(0px, 0px, 0px); transition: block;">
												<div class="slider_item top_list slider_active"
													data-index="0" style="float: left; width: 282.995px;">
													<div class="top_item">
														<a class="top_item_lk" href="#" target="_blank">
															<div class="lazyimg lazyimg_loaded top_item_img">
																<img src="img/rank_ad/d706976572338301.jpg"
																	class="lazyimg_img">
															</div> <span class="top_item_rank top_item_rank_1">1</span> <span
															class="top_item_name">足力健老人鞋冬季羊毛鞋男防滑保暖加绒棉鞋中老年鞋
																黑色（男款） 40</span>
														</a>
													</div>
													<div class="top_item">
														<a class="top_item_lk" href="#" target="_blank">
															<div class="lazyimg lazyimg_loaded top_item_img">
																<img src="img/rank_ad/5bff9565N7a6a8f37.jpg"
																	class="lazyimg_img">
															</div> <span class="top_item_rank top_item_rank_2">2</span> <span
															class="top_item_name">西域骆驼【京东推荐
																品牌自营】【品质男鞋-专柜同款】加绒保暖 户外休闲鞋男运动鞋登山徒步鞋 高帮军绿加绒 39</span>
														</a>
													</div>
													<div class="top_item">
														<a class="top_item_lk" href="#" target="_blank"
															clstag="h|keycount|core|ranking_c0103">
															<div class="lazyimg lazyimg_loaded top_item_img">
																<img src="img/rank_ad/5be532bdN58718039.jpg"
																	class="lazyimg_img">
															</div> <span class="top_item_rank top_item_rank_3">3</span> <span
															class="top_item_name">足力健老人鞋舒适棉鞋运动休闲中老年鞋保暖加绒冬季防滑
																深灰色（男款） 44</span>
														</a>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
								<div class="tab_body_item">
									<div class="slider top_wrapper">
										<div class="slider_list">
											<div class="slider_wrapper"
												style="opacity: 1; transform: translate3d(0px, 0px, 0px); transition: block;">
												<div class="slider_item top_list slider_active"
													data-index="0" style="float: left; width: 282.995px;">
													<div class="top_item">
														<a class="top_item_lk" href="#" target="_blank">
															<div class="lazyimg lazyimg_loaded top_item_img">
																<img src="img/rank_ad/4.jpg" class="lazyimg_img">
															</div> <span class="top_item_rank top_item_rank_1">1</span> <span
															class="top_item_name">莱弗凯（LFCare）
																莱弗凯吹风机大功率家用电吹风筒冷热风发廊理发店专用 XD-168U 下单送集风嘴</span>
														</a>
													</div>
													<div class="top_item">
														<a class="top_item_lk" href="#" target="_blank">
															<div class="lazyimg lazyimg_loaded top_item_img">
																<img src="img/rank_ad/5.jpg" class="lazyimg_img">
															</div> <span class="top_item_rank top_item_rank_2">2</span> <span
															class="top_item_name">小米生态链素士(SOOCAS)牙线棒 牙线 牙签 刮舌器
																专业护理三合一</span>
														</a>
													</div>
													<div class="top_item">
														<a class="top_item_lk" href="#" target="_blank"
															clstag="h|keycount|core|ranking_c0103">
															<div class="lazyimg lazyimg_loaded top_item_img">
																<img src="img/rank_ad/6.jpg" class="lazyimg_img">
															</div> <span class="top_item_rank top_item_rank_3">3</span> <span
															class="top_item_name">吉登（JIDENG）声波电动牙刷成人情侣软毛自动牙刷非充电
																牛奶白-标配1档款-1刷头</span>
														</a>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
								<div class="tab_body_item">
									<div class="slider top_wrapper">
										<div class="slider_list">
											<div class="slider_wrapper"
												style="opacity: 1; transform: translate3d(0px, 0px, 0px); transition: block;">
												<div class="slider_item top_list slider_active"
													data-index="0" style="float: left; width: 282.995px;">
													<div class="top_item">
														<a class="top_item_lk" href="#" target="_blank">
															<div class="lazyimg lazyimg_loaded top_item_img">
																<img src="img/rank_ad/1.jpg" class="lazyimg_img">
															</div> <span class="top_item_rank top_item_rank_1">1</span> <span
															class="top_item_name">良品铺子 _夏威夷果120g 坚果零食 干果炒货每日坚果
																夏威夷果休闲零食特产坚果炒货零食</span>
														</a>
													</div>
													<div class="top_item">
														<a class="top_item_lk" href="#" target="_blank">
															<div class="lazyimg lazyimg_loaded top_item_img">
																<img src="img/rank_ad/2.jpg" class="lazyimg_img">
															</div> <span class="top_item_rank top_item_rank_2">2</span> <span
															class="top_item_name">三只松鼠黄金椰丝球休闲零食糕点甜点特产点心小吃椰蓉球200g/袋</span>
														</a>
													</div>
													<div class="top_item">
														<a class="top_item_lk" href="#" target="_blank"
															clstag="h|keycount|core|ranking_c0103">
															<div class="lazyimg lazyimg_loaded top_item_img">
																<img src="img/rank_ad/3.jpg" class="lazyimg_img">
															</div> <span class="top_item_rank top_item_rank_3">3</span> <span
															class="top_item_name">百草味 草莓干100g 水果干办公室休闲零食送女友</span>
														</a>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
								<div class="tab_body_item">
									<div class="slider top_wrapper">
										<div class="slider_list">
											<div class="slider_wrapper"
												style="opacity: 1; transform: translate3d(0px, 0px, 0px); transition: block;">
												<div class="slider_item top_list slider_active"
													data-index="0" style="float: left; width: 282.995px;">
													<div class="top_item">
														<a class="top_item_lk" href="#" target="_blank">
															<div class="lazyimg lazyimg_loaded top_item_img">
																<img src="img/rank_ad/7.jpg" class="lazyimg_img">
															</div> <span class="top_item_rank top_item_rank_1">1</span> <span
															class="top_item_name">雷萨顿威大码男装羽绒服胖子男装时尚连帽上衣加肥加大保暖外套
																黑色 5XL</span>
														</a>
													</div>
													<div class="top_item">
														<a class="top_item_lk" href="#" target="_blank">
															<div class="lazyimg lazyimg_loaded top_item_img">
																<img src="img/rank_ad/8.jpg" class="lazyimg_img">
															</div> <span class="top_item_rank top_item_rank_2">2</span> <span
															class="top_item_name">【品牌直降】【59元1件
																99元2件138元3件】富贵鸟衬衫男秋冬新品加绒加厚长袖 S604 2XL</span>
														</a>
													</div>
													<div class="top_item">
														<a class="top_item_lk" href="#" target="_blank"
															clstag="h|keycount|core|ranking_c0103">
															<div class="lazyimg lazyimg_loaded top_item_img">
																<img src="img/rank_ad/9.jpg" class="lazyimg_img">
															</div> <span class="top_item_rank top_item_rank_3">3</span> <span
															class="top_item_name">皮尔卡丹 pierre cardin
																牛仔裤男2018秋冬新款修身弹力时尚休闲简约百搭直筒 PQ1828蓝色 40(3.1尺)</span>
														</a>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="box">
				<div class="box_hd">
					<a href="#" class="box_hd_lk">
						<h3 class="box_tit">觅me</h3> <i class="box_hd_arrow"></i> <span
						class="box_subtit">探寻生活</span>
					</a>
				</div>
				<div class="box_bd">
					<div class="mime_slider">
						<a href="#"> <img style="width: 100%"
							src="img/seek_ad/5c010f9dNe836b014.jpg">
							<p class="mime_item_name">守护宝宝健康成长，好奇纸尿裤成秘密武器</p>
							<p class="mime_item_desc">
								纸尿裤绝对是每个有宝宝的家庭的必备品，从宝宝出生到整个婴儿期，纸尿裤都是必备品也是高消耗品，相信每个妈妈都会为宝宝不断的囤货的，有了纸尿裤，不管是出门在外还是居家使用都很方便，有效的解决宝宝的方便问题，也是各位宝妈的福音。选择一款好用的纸尿裤，对于帮助宝宝安睡，呵护宝宝肌肤，预防红屁屁都至关重要。
							</p>
						</a>
					</div>
					<div class="mime_slider">
						<a href="#"> <img style="width: 100%"
							src="img/seek_ad/5c00f4ddN829dcbe5.jpg">
							<p class="mime_item_name">一加6T评测：流畅到极致，性能怪兽稳中带喜！</p>
							<p class="mime_item_desc">
								幸运的我亲身经历了中国完整互联网手机的诞生及成熟，代表厂家小米一加，我都是第一批用户，2018年的今天，小米已经不再是极客玩家的代表，变成了大众都适应的品牌。反而一加手机依然坚持着以追求最流畅为基础的拍照手机，当时一加1代在发布会上以“不将就”的一首歌，歌词中提到“不将就，做更好的自己，你一定会遇到另一个，你”，相信首歌深深的打动当时观看的无数人，“不将就”也成为一加手机的一个座右铭。
							</p>
						</a>
					</div>
					<div class="mime_slider">
						<a href="#"> <img style="width: 100%"
							src="img/seek_ad/5c010fc0N35a1457a.jpg">
							<p class="mime_item_name">舒适的居家环境，岂能败在小小的螨虫和灰尘手里</p>
							<p class="mime_item_desc">
								家是一个可以让我们卸下所有防备的地方，每天下班回到家，白天应对工作时的疲惫、紧张等情绪，都能被我们一一抛开。当然，这一切都是有前提的，那就是你看到的是一个舒适的居家环境。据研究表明，人在面对一个脏乱环境时，负面情绪会明显占据上风；而当人置身于一个舒适的环境中时，正能量情绪则会抢回主导权。那么一个舒适的居家环境，究竟是怎样的呢？
							</p>
						</a>
					</div>

				</div>
				<div>
					<ul class="circle_box">
						<li class="current_1"></li>
						<li></li>
						<li></li>
					</ul>
				</div>
			</div>
			<div class="box">
				<div class="box_hd">
					<a href="#" class="box_hd_lk">
						<h3 class="box_tit">运动户外</h3> <i class="box_hd_arrow"></i> <span
						class="box_subtit">玩所未玩</span>
					</a>
				</div>
				<div class="sort_wrapper">
					<a class="sort_large" href="#">
						<div class="lazyimg lazyimg_loaded sort_large_img" style="">
							<img src="img/ad/a1fa7d1b1fb91116.jpg" class="lazyimg_img"
								style="width: 100%; height: 150px;">
						</div>
					</a> <a class="sort_middle" href="">
						<div class="lazyimg lazyimg_loaded sort_large_img" style="" id="b">
							<img src="img/ad/5baf3106Ncf82be13.jpg" class="lazyimg_img">
						</div>
					</a> <a class="sort_middle" href="">
						<div class="lazyimg lazyimg_loaded sort_large_img" style="" id="c">
							<img src="img/ad/8e554fa6876d57af.jpg" class="lazyimg_img">
						</div>
					</a>
				</div>
			</div>
		</div>
	</div>
	<!-- 排行榜、	会员专辑、领券中心 部分end -->
	<!-- 页面尾部start-->
	<jsp:include page="/tail.jsp"></jsp:include>
	<!-- 页面尾部 end-->
	<!-- js引入 -->
	<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
	<script type="text/javascript" src="js/img_show.js"></script>
	<script type="text/javascript" src="js/index.js"></script>
	<script type="text/javascript" src="js/banner.js"></script>
	<script type="text/javascript" src="js/ad.js"></script>
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
			$("#msg").val($(obj).html().replace(/^(\s|\u00A0)+/,'').replace(/(\s|\u00A0)+$/,''));
			$("#J-prompt").css("display", "none");
		}
		//提示文字处理
		function searchWord(obj) {
			var word = $(obj).val();
			var content = "";
			$.post(
					"${pageContext.request.contextPath}/searchWord",
					{
						word : word
					},
					function(data) {
						if (data.length > 0) {
							for (var i = 0; i < data.length; i++) {
								content += "<div style='height:20px; padding:5px;cursor:pointer;overflow: hidden;' onclick='clickFn(this)' onmouseover='overFn(this)' onmouseout='outFn(this)'>"
												+ data[i] + "</div>";
								}
									$("#J-prompt").html(content);
									$("#J-prompt").css("display", "block");
								}
					},
					"json")
		}
		//获取商品分类
		$(function(){
			var content = "";
			$.post(
					"${pageContext.request.contextPath}/category",
					function(data) {
						if (data.length > 0) {
							for (var i = 0; i < data.length - 1; i++) {
								content += "<li ><a href='${pageContext.request.contextPath}/productList?cid="+data[i].cid+"'>" + data[i].cname + "</li>";
							}
							$("#category").html(content);
						}
			},"json")
		});
	</script> 
</body>
</html>