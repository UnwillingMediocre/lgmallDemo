package com.stodger.lgmall.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stodger.lgmall.domain.Product;
import com.stodger.lgmall.domain.ProductCategory;
import com.stodger.lgmall.service.ProductCategoryService;
import com.stodger.lgmall.service.ProductService;
import com.stodger.lgmall.service.impl.ProductCategoryServiceImpl;
import com.stodger.lgmall.service.impl.ProductServiceImpl;

/**
 * @author lenovo
 * @version 创建时间：2019年1月9日  下午5:01:27
 */
@WebServlet("/productInfoShow")
public class ProductInfoShowServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String pid = request.getParameter("id");
		
		ProductService productService = new ProductServiceImpl();
		Product productInfo = productService.getProductInfo(pid);
		ProductCategoryService productCategoryService = new ProductCategoryServiceImpl();
		List<ProductCategory> productCategoryList = productCategoryService.findAllCategory();
		System.out.println(productCategoryList.get(0).getCid());
		request.getSession().setAttribute("productInfo", productInfo);
		request.getSession().setAttribute("productCategoryList", productCategoryList);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}