package com.stodger.lgmall.web.servlet;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
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
import com.stodger.lgmall.utils.CommonsUtils;
import com.stodger.lgmall.utils.EncryptUtil;
import com.stodger.lgmall.utils.MailUtils;

import net.sf.json.JSONObject;

/**
 * @author Stodger
 * @version ����ʱ�䣺2018��12��23��  ����5:13:16
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		//1.��ȡ������
		String name = request.getParameter("name");
		String sex = request.getParameter("sex");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String newCode = request.getParameter("code");
		String oldCode = (String)request.getSession().getAttribute("code");
		User user = new User();
		//2.�����û�����
		user.setUid(CommonsUtils.getRandomId('U'));
		user.setName(name);
		user.setSex(sex);
		user.setUsername(username);
		user.setEmail(email);
		user.setPhone(phone);
		user.setState(0);
		String activeCode = CommonsUtils.getUUId();
		user.setCode(activeCode);
		//3.�û��������
		try {
			if(password != null)
				user.setPassword(EncryptUtil.md5Encrypt(password));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		LGResult rusult = new LGResult();
		//4.У����֤��
		rusult = CheckUtil.codeCheck(newCode, oldCode);
		if(rusult.getOk()){
			//5.�����ݴ���service��
			UserService userService = new UserServiceImpl();
			rusult = userService.register(user);
			//6.�ʼ����͵�����
			String emailMsg = "��ϲ����LGMallע��ɹ���������������ӽ��м����û�"
					+ "<a href='http://www.stodger.club:8080/lgmall/active?activeCode="+activeCode+"'>"
							+ "http://www.stodger.club:8080/lgmall/active?activeCode="+activeCode+"</a>";
			//7.ע��ɹ��������ʼ�
			if(rusult.getOk()){
				try {
					MailUtils.sendMail(user.getEmail(), emailMsg);
				} catch (AddressException e) {
					e.printStackTrace();
				} catch (MessagingException e) {
					e.printStackTrace();
				}
			}
		}
		//8.�����ص�����ת����JSON
		JSONObject josn = JSONObject.fromObject(rusult);
		response.getWriter().print(josn);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}