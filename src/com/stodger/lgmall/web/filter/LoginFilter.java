package com.stodger.lgmall.web.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter( filterName = "/loginFilter",
			urlPatterns = {"/submitOrder","/orderList"},
			initParams = {
					@WebInitParam(name = "loginPage",value = "login.jsp")
			}
	)
public class LoginFilter implements Filter {
	private FilterConfig config;
    
	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		this.config = fConfig;
	}
	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		//1.获取初始参数
		String loginPage = config.getInitParameter("loginPage");
		
		//2.获取请求页面和session
		HttpServletRequest req = (HttpServletRequest)request;
		String requestPath = req.getServletPath();
		HttpSession session = req.getSession();
		
		//3.判断用户是否登录
		if(session.getAttribute("loginUsername") == null && !requestPath.endsWith(loginPage)){
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}else{
			//4.放行
			chain.doFilter(request, response);
		}
		
	}
	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		this.config = null;
	}
}
