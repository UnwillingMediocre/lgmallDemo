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
 * @version ����ʱ�䣺2019��1��7��  ����12:55:21
 */
@WebServlet("/confirmOrder")
public class OrderConfirmServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		//1.��ȡ������
		String oid = request.getParameter("oid");
		String uid = request.getParameter("uid");
		String did = request.getParameter("did");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String postalcode = request.getParameter("postalcode");
		String telephone = request.getParameter("telephone");
		
		//2.��ȡ��������
		Order order = (Order)request.getSession().getAttribute("order");	
		//��ó�ʼ����AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
        //�����������
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(AlipayConfig.return_url);
        alipayRequest.setNotifyUrl(AlipayConfig.notify_url);
        //�̻������ţ��̻���վ����ϵͳ��Ψһ�����ţ�����
        String out_trade_no = oid;
        //���������
        String total_amount = String.valueOf(order.getTotal());
        //�������ƣ�����
        String subject = "�ֹ��̳�";
        //��Ʒ�������ɿ�
        String body = "��Ʒ����";
        alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\"," 
                + "\"total_amount\":\""+ total_amount +"\"," 
                + "\"subject\":\""+ subject +"\"," 
                + "\"body\":\""+ body +"\"," 
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
        //����
        String result = null;
		try {
			result = alipayClient.pageExecute(alipayRequest).getBody();
			response.setContentType("text/html;charset=" + AlipayConfig.charset);
	        response.getWriter().write(result);//ֱ�ӽ������ı�html�����ҳ��
	        response.getWriter().flush();
	        response.getWriter().close();
		} catch (AlipayApiException e) {
			e.printStackTrace();
			response.getWriter().write("�����쳣����");
	        response.getWriter().flush();
	        response.getWriter().close();
		}
		//3.����DeliveryAddressʵ��
		DeliveryAddress deliveryAddress = new DeliveryAddress();
		deliveryAddress.setDid(did);
		deliveryAddress.setName(name);
		deliveryAddress.setPostalcode(postalcode);
		deliveryAddress.setTel(telephone);
		deliveryAddress.setUid(uid);
		deliveryAddress.setAddress(address);
		if(order != null){
			//���µ�ַ
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