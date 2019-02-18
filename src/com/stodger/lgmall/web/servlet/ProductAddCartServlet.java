package com.stodger.lgmall.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stodger.lgmall.domain.Cart;
import com.stodger.lgmall.domain.CartItem;
import com.stodger.lgmall.domain.Product;
import com.stodger.lgmall.service.CartService;
import com.stodger.lgmall.service.ProductService;
import com.stodger.lgmall.service.impl.CartServiceImpl;
import com.stodger.lgmall.service.impl.ProductServiceImpl;

/**
 * @author lenovo
 * @version 创建时间：2019年1月4日  下午9:53:42
 */
@WebServlet("/addCart")
public class ProductAddCartServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String pid = request.getParameter("pid");
		String buyNum = request.getParameter("buyNum");
		
		ProductService productService = new ProductServiceImpl();
		Product product = productService.getProductInfo(pid);
		
		double subtotal = product.getP_price() * Integer.parseInt(buyNum);
		CartItem cartItem = new CartItem();
		cartItem.setProduct(product);
		cartItem.setBuyNum(Integer.parseInt(buyNum));
		cartItem.setSubtotal(subtotal);
		
		Cart cart = (Cart)request.getSession().getAttribute("cart");
		if(cart == null){
			cart = new Cart();
		}
		
		CartService cartService = new CartServiceImpl();
		cart = cartService.addCartProduct(cart, cartItem, product);
		request.getSession().setAttribute("cart", cart);
		request.getRequestDispatcher("product_list.jsp").forward(request, response);
		//response.sendRedirect("product_list.jsp");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}