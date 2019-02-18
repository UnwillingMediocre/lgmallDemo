package com.stodger.lgmall.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stodger.lgmall.domain.PageBean;
import com.stodger.lgmall.service.ProductCategoryService;
import com.stodger.lgmall.service.ProductService;
import com.stodger.lgmall.service.impl.ProductCategoryServiceImpl;
import com.stodger.lgmall.service.impl.ProductServiceImpl;

/**
 * @author lenovo
 * @version 创建时间：2019年1月8日  上午8:57:09
 */
@WebServlet("/productList")
public class ProductCategoryList extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		//1.获取数据
		String cid = request.getParameter("cid");
		ProductService productService = new ProductServiceImpl();
		ProductCategoryService productCategoryService = new ProductCategoryServiceImpl();
		String keyword = productCategoryService.getproductCategoryName(cid);
		
		String currentPageStr = (String)request.getParameter("currentPage");
		if(currentPageStr == null)
			currentPageStr = "1";
		int currentPage = Integer.parseInt(currentPageStr);
		//2.商品分页
		PageBean pageBean =null;
		int currentCount = 20;
		int totalRecord = productService.getProductCategoryTotal(cid);
		pageBean = new PageBean(currentPage, currentCount, totalRecord);
		int startIndex = pageBean.getStartIntdex();
		pageBean.setDataList(productService.productCategoryList(cid, startIndex, currentCount));
		request.getSession().setAttribute("pageBean", pageBean);
		request.getSession().setAttribute("keyword", keyword);
		request.getSession().setAttribute("cid", cid);
		request.getRequestDispatcher("productcategorylist.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}