package com.stodger.lgmall.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stodger.lgmall.domain.Product;
import com.stodger.lgmall.service.ProductService;
import com.stodger.lgmall.service.impl.ProductServiceImpl;

/**
 * @author Stodger
 * @version 创建时间：2019年1月3日  下午5:34:17
 */
@WebServlet("/productInfo")
public class ProductInfoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		//1.获取数据
		String pid = request.getParameter("pid");
		
		//2.调用service层
		ProductService productService = new ProductServiceImpl();
		Product productInfo = productService.getProductInfo(pid);
		
		request.getSession().setAttribute("productInfo", productInfo);
		request.getRequestDispatcher("product_info.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}