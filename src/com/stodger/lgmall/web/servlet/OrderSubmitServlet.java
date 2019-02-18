package com.stodger.lgmall.web.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stodger.lgmall.domain.Cart;
import com.stodger.lgmall.domain.CartItem;
import com.stodger.lgmall.domain.DeliveryAddress;
import com.stodger.lgmall.domain.Order;
import com.stodger.lgmall.domain.OrderItem;
import com.stodger.lgmall.domain.User;
import com.stodger.lgmall.service.DeliveryAddressService;
import com.stodger.lgmall.service.OrderService;
import com.stodger.lgmall.service.UserService;
import com.stodger.lgmall.service.impl.DeliveryAddressServiceImpl;
import com.stodger.lgmall.service.impl.Discount;
import com.stodger.lgmall.service.impl.OrderServiceImpl;
import com.stodger.lgmall.service.impl.UserServiceImpl;
import com.stodger.lgmall.utils.CommonsUtils;

/**
 * @author Stodger
 * @version ����ʱ�䣺2019��1��6��  ����8:43:48
 */
@WebServlet("/submitOrder")
public class OrderSubmitServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String username = (String)request.getSession().getAttribute("loginUsername");
		//1.��ȡ�û�����
		User user = new User();
		if(username != null){
			UserService userService = new UserServiceImpl();
			user = userService.userInfo(username);
		}
		
		//2.��ȡ�ջ���ַ��Ϣ
		DeliveryAddress deliveryAddress = null;
		String uid = user.getUid(); //�û�ID
		String did = CommonsUtils.getRandomId('D'); //�ջ���ַID
		if(uid != null){
			DeliveryAddressService deliveryAddressService = new DeliveryAddressServiceImpl();
			deliveryAddress = deliveryAddressService.addressInfo(did, user.getUid());
		}
		if(deliveryAddress == null){
			deliveryAddress = new DeliveryAddress();
			deliveryAddress.setDid(did);
			deliveryAddress.setUid(uid);
		}
		//3.��ȡsession��cart����
		Cart cart = (Cart)request.getSession().getAttribute("cart");
		//4.����Orderʵ��
		Order order = new Order();
		order.setOid(CommonsUtils.getRandomId('O'));
		order.setUser(user);
		order.setDeliveryAddress(deliveryAddress);
		if(cart != null){
			order.setTotal(cart.getTotal());
		}
		order.setState(0);
		order.setOrderTime(new Date());
		Discount discount = new Discount(order.getTotal());
		double money = discount.getMoney();
		order.setCoupon(order.getTotal() - money);
		order.setTotal(money);
		System.out.println(order.getTotal());
		System.out.println(order.getCoupon());
		
		//5.ȡ��Ʒ������
		Map<String, CartItem> cartItems = cart.getCartItems();
		for(Map.Entry<String, CartItem> entry : cartItems.entrySet()){
			CartItem cartItem = entry.getValue();
			OrderItem orderItem = new OrderItem();
			orderItem.setItemid(CommonsUtils.getRandomId('I'));
			orderItem.setProduct(cartItem.getProduct());
			orderItem.setCount(cartItem.getBuyNum());
			orderItem.setSubtotal(cartItem.getSubtotal());
			orderItem.setOrder(order);
			
			order.getOrderItems().add(orderItem);
		}
		
		//6.����service��
		OrderService orderService = new OrderServiceImpl();
		orderService.orderSubmit(order);
		
		request.getSession().setAttribute("order", order);
		request.getSession().removeAttribute("cart");
		response.sendRedirect("order_info.jsp");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}