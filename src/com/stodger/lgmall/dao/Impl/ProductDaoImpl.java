package com.stodger.lgmall.dao.Impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.stodger.lgmall.dao.ProductDao;
import com.stodger.lgmall.domain.OrderItem;
import com.stodger.lgmall.domain.Product;
import com.stodger.lgmall.utils.DataSourceUtils;

public class ProductDaoImpl implements ProductDao{

	/**
	 * 根据关键字查找商品标题
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<Object> findProductByWord(String word) {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from product where p_title like ? and p_soldintime is not null limit ?,?";
		List<Object> productList = null;
		try {
			productList = (List<Object>) runner.query(sql, new ColumnListHandler("p_title"), "%" + word + "%", 0, 10);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return productList;
	}
	/**
	 * 根据商品关键字查找总数量
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public int getProductTotal(String keyword) {
		Long result = null;
		try {
			result = (Long) new QueryRunner(DataSourceUtils.getDataSource()).query("select count(*) from product where p_title like ? and p_soldintime is not null", new ScalarHandler(), "%" + keyword + "%");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result.intValue();
	}
	
	/**
	 * 根据关键字查找商品
	 */
	@Override
	public List<Product> findProduct(String keyword, int startIntdex, int currentCount) {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from product where p_title like ? and p_soldintime is not null limit ?,?";
		List<Product> productList = null;
		try {
			productList = runner.query(sql, new BeanListHandler<>(Product.class), "%" + keyword + "%",startIntdex, currentCount);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return productList;
	}
	/**
	 * 根据商品id查找商品详细信息
	 */
	@Override
	public Product getProductInfo(String pid) {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from product where pid=? and  p_soldintime is not null";
		Product product = null;
		try {
			product = runner.query(sql, new BeanHandler<>(Product.class), pid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return product;
	}
	/**
	 * 更新商品数量
	 */
	@Override
	public void updateNum(List<OrderItem> orderItem) {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "update product set p_num=? where pid=?";
		try {
			for(OrderItem itme : orderItem){
				runner.update(sql, itme.getProduct().getP_num() - itme.getCount(), itme.getProduct().getPid());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 * 秒杀
	 */
	@Override
	public List<Product> productSecKill(int start, int end) {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from product where  p_soldintime is not null limit ?,?";
		List<Product> productList = null;
		try {
			productList = runner.query(sql, new BeanListHandler<>(Product.class),start, end);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return productList;
	}
	/**
	 * 根据cid查找商品数量
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public int getProductCategoryTotal(String cid) {
		Long result = null;
		try {
			result = (Long) new QueryRunner(DataSourceUtils.getDataSource()).query("select count(*) from product where cid=? and  p_soldintime is not null", new ScalarHandler(), cid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result.intValue();
	}
	/**
	 * 根据cid取出商品
	 */
	@Override
	public List<Product> productCategoryList(String cid, int startIndex, int currentCount) {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from product where cid=? and p_soldintime is not null limit ?,?";
		List<Product> productList = null;
		try {
			productList = runner.query(sql, new BeanListHandler<>(Product.class), cid, startIndex, currentCount);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return productList;
	}
	/**
	 * 全部商品
	 */
	@Override
	public List<Product> allProduct() {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from product";
		List<Product> product = null;
		try {
			product = runner.query(sql, new BeanListHandler<>(Product.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return product;
	}
	/**
	 * 商品下架
	 */
	@Override
	public boolean productSoldoutTime(String pid, String p_soldOutTime) {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "update product set p_soldouttime=?,p_soldintime=? where pid=?";
		int row = 0;
		try {
			row = runner.update(sql, p_soldOutTime,null,pid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row > 0 ? true : false;
	}
	/**
	 * 商品发布
	 */
	@Override
	public boolean productSoldinTime(String pid, String p_soldInTime) {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "update product set p_soldouttime=?,p_soldintime=? where pid=?";
		int row = 0;
		try {
			row = runner.update(sql, null, p_soldInTime, pid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row > 0 ? true : false;
	}
	/**
	 * 商品删除
	 */
	@Override
	public boolean productDel(String pid) {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "update product set p_soldouttime=?,p_soldintime=? where pid=?";
		int row = 0;
		try {
			row = runner.update(sql, null, null, pid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row > 0 ? true : false;
	}
	/**
	 * 添加商品
	 */
	@Override
	public boolean addProduct(Product product) {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "insert into product(pid,p_title,cid,p_sellpoint,p_price,p_marketprice,p_num,p_limitnum,p_image,p_detail,p_soldintime,p_popular)value(?,?,?,?,?,?,?,?,?,?,?,?)";
		int row = 0;
		try {
			row = runner.update(sql, product.getPid(), product.getP_title(), product.getCid(), product.getP_sellPoint(),product.getP_price(),product.getP_marketPrice(),product.getP_num(),product.getP_limitNum(),product.getP_image(),product.getP_detail(),product.getP_soldInTime(), product.getP_popular());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row > 0 ? true : false;
	}
	@Override
	public boolean updateProduct(Product product) {
			QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
			String sql = "update product set p_title=?,p_sellpoint=?,p_price=?,p_marketprice=?,p_num=?,p_limitnum=?,p_image=?,p_detail=?,p_soldintime=?,p_popular=? where pid=? and cid=?";
			int row = 0;
			try {
				row = runner.update(sql,product.getP_title(),product.getP_sellPoint(),product.getP_price(),product.getP_marketPrice(),product.getP_num(),product.getP_limitNum(),product.getP_image(),product.getP_detail(),product.getP_soldInTime(), product.getP_popular(),product.getPid(),product.getCid());
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return row > 0 ? true : false;
	}
}
