package com.stodger.lgmall.dao;

import java.util.List;
import java.util.Map;

import com.stodger.lgmall.domain.Order;
import com.stodger.lgmall.domain.OrderItem;

public interface OrderDao {
	void addOrder(Order order);
	void addOrderItem(Order order);
	void confirmOrder(Order order);
	List<Order> findAllOrders(String uid);
	List<Map<String,Object>> findAllOrderItemByOid(String oid);
	List<Order> showAllOrder();
	List<Map<String, Object>> findOrderInfo(String oid);
}
