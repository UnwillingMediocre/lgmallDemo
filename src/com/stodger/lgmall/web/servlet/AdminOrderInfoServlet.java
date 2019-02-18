package com.stodger.lgmall.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.stodger.lgmall.domain.DeliveryAddress;
import com.stodger.lgmall.domain.OrderItem;
import com.stodger.lgmall.domain.Product;
import com.stodger.lgmall.service.OrderService;
import com.stodger.lgmall.service.impl.OrderServiceImpl;

/**
 * @author lenovo
 * @version 创建时间：2019年1月10日  上午9:18:50
 */
@WebServlet("/orderInfo")
public class AdminOrderInfoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String oid = request.getParameter("id");
		
		OrderService orderService = new OrderServiceImpl();
		DeliveryAddress deliveryAddress = new DeliveryAddress();
		List<OrderItem> orderInfoList = new ArrayList<OrderItem>();
		List<Map<String, Object>> mapList = orderService.findOrderInfo(oid);
		if(mapList != null){
			for(Map<String, Object> map : mapList){
				try {
					OrderItem orderItem = new OrderItem();
					BeanUtils.populate(orderItem, map);
					Product product = new Product();
					BeanUtils.populate(product, map);
					orderItem.setProduct(product);
					orderInfoList.add(orderItem);
					BeanUtils.populate(deliveryAddress, map);
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
		}
		
			request.getSession().setAttribute("orderInfoList", orderInfoList);
			request.getSession().setAttribute("orderOid",oid);
			request.getSession().setAttribute("deliveryAddressInfo", deliveryAddress);
			System.out.println(deliveryAddress.getAddress());
			System.out.println(deliveryAddress.getName());
			System.out.println(orderInfoList.get(0).getProduct().getP_image());
			
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}