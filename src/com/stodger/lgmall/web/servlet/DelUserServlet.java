package com.stodger.lgmall.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.stodger.lgmall.domain.LGResult;
import com.stodger.lgmall.domain.User;
import com.stodger.lgmall.service.UserService;
import com.stodger.lgmall.service.impl.UserServiceImpl;

/**
 * @author lenovo
 * @version 创建时间：2019年1月8日  下午3:32:22
 */
@WebServlet("/delUser")
public class DelUserServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String uid = request.getParameter("id");
		
		UserService userService = new UserServiceImpl();
		LGResult lgResult = new LGResult();
		lgResult = userService.delUser(uid);
		List<User> userList = (List<User>) request.getSession().getAttribute("userList");
		for(int i = 0; i < userList.size(); i++){
			if(userList.get(i).getUid().equals(uid)){
				userList.get(i).setState(2);
			}
		}
		Gson gson = new Gson();
		String result = gson.toJson(lgResult);
		response.getWriter().write(result);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}