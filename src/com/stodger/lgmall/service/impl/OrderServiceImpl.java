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
			//1.��������
			DataSourceUtils.startTransaction();
			//��Ӷ���
			orderDao.addOrder(order);
			//��Ӷ�����
			orderDao.addOrderItem(order);
			
		} catch (SQLException e) {
			//2.�ع�
			try {
				DataSourceUtils.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			//3.�ύ����
			try {
				DataSourceUtils.commitAndRelease();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * ȷ�϶���
	 */
	@Override
	public void confirmOrder(Order order) {
			//ȷ�϶���
		orderDao.confirmOrder(order);
	}
	/**
	 * ��ѯ���û������ж���
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
	 * ��ʾ���ж���
	 */
	@Override
	public List<Order> showAllOrder() {
		return orderDao.showAllOrder();
	}
	/**
	 * ������ϸ
	 */
	@Override
	public List<Map<String, Object>> findOrderInfo(String oid) {
		return orderDao.findOrderInfo(oid);
	}
}
