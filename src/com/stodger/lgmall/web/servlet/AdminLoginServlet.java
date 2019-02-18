package com.stodger.lgmall.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.stodger.lgmall.service.AdminService;
import com.stodger.lgmall.service.impl.AdminServiceImpl;

/**
 * @author lenovo
 * @version 创建时间：2018年12月15日  下午10:33:55
 */
@WebServlet("/adminLogin")
public class AdminLoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String newCode = request.getParameter("inputcode");
		HttpSession session = request.getSession();
		String oldCode = (String) session.getAttribute("code");
		AdminService adminService = new AdminServiceImpl();
		String result = adminService.adminLogin(username, password, newCode, oldCode);
		response.getWriter().write(result);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}