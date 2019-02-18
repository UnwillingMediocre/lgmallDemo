package com.stodger.lgmall.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stodger.lgmall.domain.Order;
import com.stodger.lgmall.service.OrderService;
import com.stodger.lgmall.service.impl.OrderServiceImpl;

/**
 * @author lenovo
 * @version 创建时间：2019年1月10日  上午12:22:41
 */
@WebServlet("/orderAll")
public class OrderAllServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		OrderService orderService = new OrderServiceImpl();
		List<Order> orderList = orderService.showAllOrder();
		request.getSession().setAttribute("orderList", orderList);
		request.getSession().setAttribute("orderCount", orderList.size());
		response.sendRedirect("admin/order-list.jsp");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}