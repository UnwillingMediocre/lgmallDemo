package com.stodger.lgmall.web.servlet;

import java.io.IOException;
import java.util.List;

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
 * @version ����ʱ�䣺2019��1��8��  ����5:21:08
 */
@WebServlet("/searchUser")
public class SearchUserServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String searchName = request.getParameter("searchName");
		System.out.println(searchName);
		UserService userServcie = new UserServiceImpl();
		List<User> userList = userServcie.searchUser(searchName);
		request.getSession().setAttribute("userList", userList);
		request.getSession().setAttribute("userCount", userList.size());
		response.sendRedirect("admin/member-list.jsp");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}