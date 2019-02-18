package com.stodger.lgmall.dao.Impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import com.stodger.lgmall.dao.OrderDao;
import com.stodger.lgmall.domain.Order;
import com.stodger.lgmall.domain.OrderItem;
import com.stodger.lgmall.utils.DataSourceUtils;

public class OrderDaoImpl implements OrderDao{
	/**
	 * 添加订单数据
	 */
	@Override
	public void addOrder(Order order) {
		QueryRunner runner = new QueryRunner();
		Connection con = null;
		try {
			con = (Connection) DataSourceUtils.getConnection();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		String sql = "insert into orders(oid,uid,did,total,coupon,state,ordertime)value(?,?,?,?,?,?,?)";
		String oid = order.getOid();
		String uid = order.getUser().getUid();
		String did = order.getDeliveryAddress().getDid();
		double total = order.getTotal();
		double coupon = order.getCoupon();
		int statu = order.getState();
		Date orderTime = order.getOrderTime();
		System.out.println(orderTime);
		try {
			runner.update(con, sql, oid, uid, did, total, coupon, statu, orderTime);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 添加订单项数据
	 */
	@Override
	public void addOrderItem(Order order) {
		QueryRunner runner = new QueryRunner();
		Connection con = null;
		try {
			con = (Connection) DataSourceUtils.getConnection();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		String sql ="insert into orderItem(itemid,pid,oid,count,subtotal)value(?,?,?,?,?)";
		List<OrderItem> orderItems = order.getOrderItems();
		for(OrderItem item : orderItems){
			String itemid = item.getItemid();
			String pid = item.getProduct().getPid();
			String oid = item.getOrder().getOid();
			int count = item.getCount();
			double subTotal = item.getSubtotal();
			try {
				runner.update(con, sql, itemid, pid, oid, count, subTotal);
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
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "update orders set state=?,paytime=? where oid=?";
		try {
			runner.update(sql, order.getState(), order.getPayTime(), order.getOid());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 查询该用户所有订单
	 */
	@Override
	public List<Order> findAllOrders(String uid) {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from orders where uid=?";
		List<Order> orderList = null;
		try {
			orderList = runner.query(sql, new BeanListHandler<>(Order.class), uid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return orderList;
	}
	/**
	 * 查询该用户所有订单中的订单项
	 */
	@Override
	public List<Map<String,Object>> findAllOrderItemByOid(String oid) {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select i.count,i.subtotal,p.p_image,p.p_title,p.p_price from orderItem i, product p where i.pid=p.pid and i.oid=?";
		List<Map<String,Object>> mapList = null;
		try {
			mapList = runner.query(sql, new MapListHandler(), oid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mapList;
	}
	/**
	 * 显示所有订单
	 */
	@Override
	public List<Order> showAllOrder() {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from orders";
		List<Order> orderList = null;
		try {
			orderList = runner.query(sql, new BeanListHandler<>(Order.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return orderList;
	}
	/**
	 * 根据oid查询订单详细
	 */
	@Override
	public List<Map<String, Object>> findOrderInfo(String oid) {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select i.count,i.subtotal,p.p_title,p.p_image,p.p_price,d.name,d.address from orderitem i,product p, orders o, delivery_address d where i.pid=p.pid and o.did=d.did and i.oid = o.oid and o.oid=?";
		List<Map<String,Object>> mapList = null;
		try {
			mapList = runner.query(sql, new MapListHandler(), oid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mapList;
	}
}
