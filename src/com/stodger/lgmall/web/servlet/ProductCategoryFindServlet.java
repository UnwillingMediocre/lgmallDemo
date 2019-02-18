package com.stodger.lgmall.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stodger.lgmall.domain.ProductCategory;
import com.stodger.lgmall.service.ProductCategoryService;
import com.stodger.lgmall.service.impl.ProductCategoryServiceImpl;

/**
 * @author lenovo
 * @version 创建时间：2019年1月9日  上午8:57:00
 */
@WebServlet("/productCategoryFind")
public class ProductCategoryFindServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String cid = request.getParameter("id");
		
		ProductCategoryService productCategoryService = new ProductCategoryServiceImpl();
		String cname = productCategoryService.getproductCategoryName(cid);
		ProductCategory productCategory = new ProductCategory();
		productCategory.setCid(cid);
		productCategory.setCname(cname);
		
		request.getSession().setAttribute("productCategory", productCategory);
		response.getWriter().write("OK");
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}