package com.stodger.lgmall.service.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.stodger.lgmall.dao.OrderDao;
import com.stodger.lgmall.dao.Impl.OrderDaoImpl;
import com.stodger.lgmall.domain.DeliveryAddress;
import com.stodger.lgmall.domain.Order;
import com.stodger.lgmall.domain.OrderItem;
import com.stodger.lgmall.service.DeliveryAddressService;
import com.stodger.lgmall.service.OrderService;
import com.stodger.lgmall.service.ProductService;
import com.stodger.lgmall.utils.DataSourceUtils;

public class OrderServiceImpl implements OrderService {
	OrderDao orderDao = new OrderDaoImpl();
	
	@Override
	public void orderSubmit(Order order) {
		try {
			//1.开启事务
			DataSourceUtils.startTransaction();
			//添加订单
			orderDao.addOrder(order);
			//添加订单项
			orderDao.addOrderItem(order);
			
		} catch (SQLException e) {
			//2.回滚
			try {
				DataSourceUtils.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			//3.提交事务
			try {
				DataSourceUtils.commitAndRelease();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 确认订单
	 */
	@Override
	public void confirmOrder(Order order) {
			//确认订单
		orderDao.confirmOrder(order);
	}
	/**
	 * 查询该用户的所有订单
	 */
	@Override
	public List<Order> findAllOrders(String uid) {
		return orderDao.findAllOrders(uid);
	}

	@Override
	public List<Map<String,Object>> findAllOrderItemByOid(String oid) {
		return orderDao.findAllOrderItemByOid(oid);
	}
	/**
	 * 显示所有订单
	 */
	@Override
	public List<Order> showAllOrder() {
		return orderDao.showAllOrder();
	}
	/**
	 * 订单详细
	 */
	@Override
	public List<Map<String, Object>> findOrderInfo(String oid) {
		return orderDao.findOrderInfo(oid);
	}
}
