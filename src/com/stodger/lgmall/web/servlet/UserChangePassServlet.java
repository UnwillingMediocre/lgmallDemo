package com.stodger.lgmall.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stodger.lgmall.domain.User;
import com.stodger.lgmall.service.UserService;
import com.stodger.lgmall.service.impl.UserServiceImpl;

/**
 * @author lenovo
 * @version ����ʱ�䣺2019��1��8��  ����4:13:40
 */
@WebServlet("/changePass")
public class UserChangePassServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String uid = request.getParameter("id");
		UserService userService = new UserServiceImpl();
		User user = userService.findUserInfo(uid);
		
		request.getSession().setAttribute("userChangePass", user);
		response.getWriter().write("OK");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}