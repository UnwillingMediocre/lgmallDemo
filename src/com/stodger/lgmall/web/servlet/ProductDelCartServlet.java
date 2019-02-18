package com.stodger.lgmall.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stodger.lgmall.domain.Cart;
import com.stodger.lgmall.service.CartService;
import com.stodger.lgmall.service.impl.CartServiceImpl;

/**
 * @author Stodger
 * @version 创建时间：2019年1月5日  下午4:09:53
 */
@WebServlet("/delCart")
public class ProductDelCartServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String pid = request.getParameter("pid");
		
		Cart cart = (Cart)request.getSession().getAttribute("cart");
		
		CartService cartService = new CartServiceImpl();
		cart = cartService.delCart(cart, pid);
		request.getSession().setAttribute("cart", cart);
		response.sendRedirect("cart.jsp");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}