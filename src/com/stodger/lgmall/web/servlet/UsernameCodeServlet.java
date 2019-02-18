package com.stodger.lgmall.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stodger.lgmall.domain.LGResult;
import com.stodger.lgmall.domain.User;
import com.stodger.lgmall.service.UserService;
import com.stodger.lgmall.service.impl.UserServiceImpl;
import com.stodger.lgmall.utils.CheckUtil;

import net.sf.json.JSONObject;

/**
 * @author Stodger
 * @version 创建时间：2018年12月28日  下午1:30:44
 */
@WebServlet("/usernameCode")
public class UsernameCodeServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		//1.获取数据
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String newCode = request.getParameter("code");
		String oldCode = (String)request.getSession().getAttribute("code");
		LGResult rusult = new LGResult();
		//2.校验验证码
		rusult = CheckUtil.codeCheck(newCode, oldCode);
		//3.校验成功，则调用service层
		if(rusult.getOk()){
			User user = new User();
			user.setUsername(username);
			user.setEmail(email);
			UserService userService = new UserServiceImpl();
			rusult = userService.usernameCode(user);
			request.getSession().setAttribute("tempUsername",username);
		}
		//4.将返回的数据转换成JSON
		JSONObject josn = JSONObject.fromObject(rusult);
		response.getWriter().print(josn);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
