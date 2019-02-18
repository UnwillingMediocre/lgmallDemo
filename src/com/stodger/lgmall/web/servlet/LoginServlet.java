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
 * @author Stodger
 * @version 创建时间：2018年12月24日  下午8:44:02
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		//1.获取数据
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(username);
		//2.设置数据
		User user = new User();
		user.setUsername(username);
		try {
			if(password != null)
				user.setPassword(EncryptUtil.md5Encrypt(password));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		//3.调用service层
		UserService userService = new UserServiceImpl();
		LGResult result = new LGResult();
		result = userService.login(user);
		if(result.getOk()){
			request.getSession().setAttribute("loginUsername", username);
		}
		
		//4.返回json数据
		JSONObject json = JSONObject.fromObject(result);
		response.getWriter().print(json);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}