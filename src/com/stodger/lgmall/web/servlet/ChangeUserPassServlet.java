package com.stodger.lgmall.web.servlet;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stodger.lgmall.domain.User;
import com.stodger.lgmall.service.UserService;
import com.stodger.lgmall.service.impl.UserServiceImpl;
import com.stodger.lgmall.utils.EncryptUtil;

/**
 * @author lenovo
 * @version 创建时间：2019年1月8日  下午4:23:51
 */
@WebServlet("/changeUserPass")
public class ChangeUserPassServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		User user= (User)request.getSession().getAttribute("userChangePass");
		String pass = request.getParameter("newpassword");
		try {
			if(pass != null){
				user.setPassword(EncryptUtil.md5Encrypt(pass));
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		UserService userService = new UserServiceImpl();
		
		userService.fotgotPassword(user);
		response.sendRedirect("admin/member-list.jsp");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}