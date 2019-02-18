package com.stodger.lgmall.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.stodger.lgmall.domain.LGResult;
import com.stodger.lgmall.domain.Product;
import com.stodger.lgmall.service.CartService;
import com.stodger.lgmall.service.ProductService;
import com.stodger.lgmall.service.impl.CartServiceImpl;
import com.stodger.lgmall.service.impl.ProductServiceImpl;

/**
 * @author lenovo
 * @version 创建时间：2019年1月5日  下午3:00:03
 */
@WebServlet("/checkByNum")
public class CheckByNumServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		//1.获取数据
		String byNum = request.getParameter("byNum");
		String pid = request.getParameter("pid");
		
		//2.根据pid获取商品信息
		ProductService productService = new ProductServiceImpl();
		Product product = productService.getProductInfo(pid);
		
		//3.调用service层
		CartService cartService = new CartServiceImpl();
		LGResult lgResult = new LGResult();
		lgResult = cartService.checkByNum(product, byNum);
		
		//4.转换成json格式
		Gson gson = new Gson();
		String result = gson.toJson(lgResult);
		
		//5.返回数据
		response.getWriter().write(result);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}