package com.stodger.lgmall.web.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.config.AlipayConfig;
import com.stodger.lgmall.domain.DeliveryAddress;
import com.stodger.lgmall.domain.Order;
import com.stodger.lgmall.domain.OrderItem;
import com.stodger.lgmall.service.DeliveryAddressService;
import com.stodger.lgmall.service.OrderService;
import com.stodger.lgmall.service.ProductService;
import com.stodger.lgmall.service.impl.DeliveryAddressServiceImpl;
import com.stodger.lgmall.service.impl.OrderServiceImpl;
import com.stodger.lgmall.service.impl.ProductServiceImpl;
import com.stodger.lgmall.utils.CommonsUtils;

/**
 * @author lenovo
 * @version 创建时间：2019年1月7日  下午12:55:21
 */
@WebServlet("/confirmOrder")
public class OrderConfirmServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		//1.获取表单数据
		String oid = request.getParameter("oid");
		String uid = request.getParameter("uid");
		String did = request.getParameter("did");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String postalcode = request.getParameter("postalcode");
		String telephone = request.getParameter("telephone");
		
		//2.获取订单数据
		Order order = (Order)request.getSession().getAttribute("order");	
		//获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
        //设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(AlipayConfig.return_url);
        alipayRequest.setNotifyUrl(AlipayConfig.notify_url);
        //商户订单号，商户网站订单系统中唯一订单号，必填
        String out_trade_no = oid;
        //付款金额，必填
        String total_amount = String.valueOf(order.getTotal());
        //订单名称，必填
        String subject = "乐购商场";
        //商品描述，可空
        String body = "商品描述";
        alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\"," 
                + "\"total_amount\":\""+ total_amount +"\"," 
                + "\"subject\":\""+ subject +"\"," 
                + "\"body\":\""+ body +"\"," 
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
        //请求
        String result = null;
		try {
			result = alipayClient.pageExecute(alipayRequest).getBody();
			response.setContentType("text/html;charset=" + AlipayConfig.charset);
	        response.getWriter().write(result);//直接将完整的表单html输出到页面
	        response.getWriter().flush();
	        response.getWriter().close();
		} catch (AlipayApiException e) {
			e.printStackTrace();
			response.getWriter().write("捕获异常出错");
	        response.getWriter().flush();
	        response.getWriter().close();
		}
		//3.创建DeliveryAddress实例
		DeliveryAddress deliveryAddress = new DeliveryAddress();
		deliveryAddress.setDid(did);
		deliveryAddress.setName(name);
		deliveryAddress.setPostalcode(postalcode);
		deliveryAddress.setTel(telephone);
		deliveryAddress.setUid(uid);
		deliveryAddress.setAddress(address);
		if(order != null){
			//更新地址
			DeliveryAddressService deliveryAddressService = new DeliveryAddressServiceImpl();
			deliveryAddressService.updateAddress(deliveryAddress);
			deliveryAddress.setTel(CommonsUtils.getStrReplace(telephone));
			order.setDeliveryAddress(deliveryAddress);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}