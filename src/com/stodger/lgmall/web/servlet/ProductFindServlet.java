package com.stodger.lgmall.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stodger.lgmall.domain.Product;
import com.stodger.lgmall.service.ProductService;
import com.stodger.lgmall.service.impl.ProductServiceImpl;

/**
 * @author lenovo
 * @version 创建时间：2019年1月9日  下午1:18:40
 */
@WebServlet("/productFindt")
public class ProductFindServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String keyword = request.getParameter("keyword");
		ProductService productService = new ProductServiceImpl();
		int totalRecord = productService.getProductTotal(keyword);
		List<Product> productList = productService.productList(keyword, 0, totalRecord);
		
		request.getSession().setAttribute("productList", productList);
		request.getSession().setAttribute("productCount", productList.size());
		response.sendRedirect("admin/product-list.jsp");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}