package com.stodger.lgmall.web.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.config.AlipayConfig;
import com.stodger.lgmall.domain.Order;
import com.stodger.lgmall.domain.OrderItem;
import com.stodger.lgmall.service.OrderService;
import com.stodger.lgmall.service.ProductService;
import com.stodger.lgmall.service.impl.OrderServiceImpl;
import com.stodger.lgmall.service.impl.ProductServiceImpl;

/**
 * @author lenovo
 * @version ����ʱ�䣺2019��1��7��  ����9:02:50
 */
@WebServlet("/paySuccess")
public class PaySuccessServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		//��ȡ֧����GET����������Ϣ
		Map<String,String> params = new HashMap<String,String>();
		Map<String,String[]> requestParams = request.getParameterMap();
		for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) requestParams.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i]
						: valueStr + values[i] + ",";
			}
			//����������δ����ڳ�������ʱʹ��
			valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
			params.put(name, valueStr);
		}
		
		try {
			boolean signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key, AlipayConfig.charset, AlipayConfig.sign_type);
			if(signVerified){
				//2.��ȡ��������
				Order order = (Order)request.getSession().getAttribute("order");
				OrderService orderServcie = new OrderServiceImpl();
				order.setPayTime(new Date());
				order.setState(1);
				orderServcie.confirmOrder(order);
				List<OrderItem> orderItem = order.getOrderItems();
				ProductService produuctService = new ProductServiceImpl();
				//��������
				produuctService.updateNum(orderItem);
				response.sendRedirect("pay_success.jsp");
			}
		} catch (AlipayApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //����SDK��֤ǩ��
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}