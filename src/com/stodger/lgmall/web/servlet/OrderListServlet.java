package com.stodger.lgmall.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.stodger.lgmall.domain.Order;
import com.stodger.lgmall.domain.OrderItem;
import com.stodger.lgmall.domain.Product;
import com.stodger.lgmall.domain.User;
import com.stodger.lgmall.service.OrderService;
import com.stodger.lgmall.service.UserService;
import com.stodger.lgmall.service.impl.OrderServiceImpl;
import com.stodger.lgmall.service.impl.UserServiceImpl;

/**
 * @author lenovo
 * @version 创建时间：2019年1月7日  下午10:35:15
 */
@WebServlet("/orderList")
public class OrderListServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String username = (String)request.getSession().getAttribute("loginUsername");
		//1.获取用户数据
		User user = new User();
		if(username != null){
			UserService userService = new UserServiceImpl();
			user = userService.userInfo(username);
		}
		OrderService orderService = new OrderServiceImpl();
		List<Order> orderList = orderService.findAllOrders(user.getUid());
		if(orderList != null){
			for(Order order : orderList){
				String oid = order.getOid();
				List<Map<String,Object>> MapList = orderService.findAllOrderItemByOid(oid);
				for(Map<String,Object> map : MapList){
					try {
						OrderItem orderItem = new OrderItem();
						BeanUtils.populate(orderItem, map);
						Product product = new Product();
						BeanUtils.populate(product, map);
						orderItem.setProduct(product);
						order.getOrderItems().add(orderItem);
					} catch (IllegalAccessException | InvocationTargetException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		request.setAttribute("orderList", orderList);
		/*response.sendRedirect("order_list.jsp");*/
		request.getRequestDispatcher("order_list.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}