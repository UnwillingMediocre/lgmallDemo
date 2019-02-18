package com.stodger.lgmall.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.stodger.lgmall.domain.PageBean;
import com.stodger.lgmall.domain.Product;
import com.stodger.lgmall.service.ProductService;
import com.stodger.lgmall.service.impl.ProductServiceImpl;

/**
 * @author Stodger
 * @version 创建时间：2019年1月2日  下午2:36:49
 */
@WebServlet("/productSearch")
public class ProductSearchServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		//1.获取数据
		String keyword = request.getParameter("keyword");
		String currentPageStr = (String)request.getParameter("currentPage");
		String type = (String)request.getParameter("type");
		if(currentPageStr == null)
			currentPageStr = "1";
		int currentPage = Integer.parseInt(currentPageStr);
		//2.商品分页
		PageBean pageBean =null;
		int currentCount = 20;
		
		//3.调用service层
		ProductService productService = new ProductServiceImpl();
		int totalRecord = productService.getProductTotal(keyword);
		pageBean = new PageBean(currentPage, currentCount, totalRecord);
		int startIntdex = pageBean.getStartIntdex();
		pageBean.setDataList(productService.productList(keyword, startIntdex, currentCount));
		
		request.getSession().setAttribute("pageBean", pageBean);
		request.getSession().setAttribute("keyword", keyword);
		if(type == null){
			request.getRequestDispatcher("product_list.jsp").forward(request, response);
		}else{
			response.getWriter().write("true");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}