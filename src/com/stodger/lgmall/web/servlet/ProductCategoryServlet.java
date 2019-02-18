package com.stodger.lgmall.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.stodger.lgmall.domain.ProductCategory;
import com.stodger.lgmall.service.ProductCategoryService;
import com.stodger.lgmall.service.impl.ProductCategoryServiceImpl;

/**
 * @author lenovo
 * @version 创建时间：2019年1月8日  上午8:39:35
 */
@WebServlet("/category")
public class ProductCategoryServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		ProductCategoryService productCategoryService = new ProductCategoryServiceImpl();
		List<ProductCategory> productCategoryList = productCategoryService.findAllCategory();
		
		Gson gson = new Gson();
		String result = gson.toJson(productCategoryList);
		response.getWriter().write(result);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}