package com.stodger.lgmall.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stodger.lgmall.domain.ProductCategory;
import com.stodger.lgmall.service.ProductCategoryService;
import com.stodger.lgmall.service.impl.ProductCategoryServiceImpl;
import com.stodger.lgmall.utils.CommonsUtils;

/**
 * @author Stodger
 * @version 创建时间：2018年12月25日 上午10:36:17
 */
@WebServlet("/productCategoryAdd")
public class ProductCategoryAddServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String productCategoryName = request.getParameter("categoryName");
		
		ProductCategoryService productCategoryService = new ProductCategoryServiceImpl();
		ProductCategory productCategory = new ProductCategory();
		productCategory.setCid(CommonsUtils.getRandomId('C'));
		productCategory.setCname(productCategoryName);
		productCategoryService.add(productCategory);
		List<ProductCategory> productCategoryList = (List<ProductCategory>)request.getSession().getAttribute("productCategoryList");
		productCategoryList.add(productCategory);
		request.getSession().setAttribute("productCategoryCount",productCategoryList.size());
		//response.sendRedirect("admin/product-category-list.jsp");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}