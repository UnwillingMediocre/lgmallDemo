package com.stodger.lgmall.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.stodger.lgmall.service.ProductService;
import com.stodger.lgmall.service.impl.ProductServiceImpl;

/**
 * @author Stodger
 * @version ����ʱ�䣺2019��1��2��  ����9:43:41
 */
@WebServlet("/searchWord")
public class SearchWordServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		//1.��ȡ�ؼ���
		String word = request.getParameter("word");
		//2.����service��
		ProductService productService = new ProductServiceImpl();
		List<Object> productList = productService.findProductByWord(word);
		System.out.println("szie:" + productList.size());
		//3.��Gsonת������תJson
		Gson gson = new Gson();
		String json = gson.toJson(productList);
		response.getWriter().write(json);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}