package com.stodger.lgmall.web.servlet;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stodger.lgmall.domain.LGResult;
import com.stodger.lgmall.domain.User;
import com.stodger.lgmall.service.UserService;
import com.stodger.lgmall.service.impl.UserServiceImpl;
import com.stodger.lgmall.utils.EncryptUtil;

import net.sf.json.JSONObject;

/**
 * @author lenovo
 * @version ����ʱ�䣺2018��12��28��  ����2:15:13
 */
@WebServlet("/forgotPassword")
public class ForgotPasswordServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		//1.��ȡ����
		String username = (String)request.getSession().getAttribute("tempUsername");
		String password = request.getParameter("password");
		
		//2.��������
		User user = new User();
		user.setUsername(username);
		//3.�������
		try {
			user.setPassword(EncryptUtil.md5Encrypt(password));
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//4.����service��
		boolean rusult = false;
		UserService userService = new UserServiceImpl();
		rusult = userService.fotgotPassword(user);
		//5.�����ص�����ת����JSON
		/*JSONObject josn = JSONObject.fromObject(rusult);*/
		response.getWriter().write(rusult ? "true" : "false");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}