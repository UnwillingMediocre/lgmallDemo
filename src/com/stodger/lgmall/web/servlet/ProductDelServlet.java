package com.stodger.lgmall.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stodger.lgmall.service.ProductService;
import com.stodger.lgmall.service.impl.ProductServiceImpl;

/**
 * @author lenovo
 * @version 创建时间：2019年1月9日  下午2:37:22
 */
@WebServlet("/productDel")
public class ProductDelServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String pid = request.getParameter("id");
		
		ProductService productService = new ProductServiceImpl();
		boolean result = productService.productDel(pid);
		response.getWriter().write(result ? "OK" : "NO");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}