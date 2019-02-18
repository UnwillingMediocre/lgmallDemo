package com.stodger.lgmall.dao.Impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.stodger.lgmall.dao.ProductCategoryDao;
import com.stodger.lgmall.domain.ProductCategory;
import com.stodger.lgmall.utils.DataSourceUtils;

public class ProductCategoryDaoImpl implements ProductCategoryDao{

	/**
	 * 添加商品分类
	 */
	@Override
	public int add(ProductCategory productCategory) {
		int row = 0;
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "insert into product_category values(?,?)";
		try {
			row = runner.update(sql, productCategory.getCid(), productCategory.getCname());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row;
	}
	/**
	 * 取出全部商品分类
	 */
	@Override
	public List<ProductCategory> findAllCategory() {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from product_category";
		List<ProductCategory> productCategory = null;
		try {
			productCategory = runner.query(sql, new BeanListHandler<>(ProductCategory.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return productCategory;
	}
	/**
	 * 取商品名称
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public String getproductCategoryName(String cid) {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select cname from product_category where cid=?";
		String cname = null;
		try {
			cname = (String) runner.query(sql, new ScalarHandler(), cid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cname;
	}
	/**
	 * 更新商品分类
	 */
	@Override
	public boolean updateproductCategory(ProductCategory productCategory) {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "update product_category set cname=? where cid=?";
		int row = 0;
		try {
			row = runner.update(sql, productCategory.getCname(), productCategory.getCid());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row > 0 ? true: false;
	}
}
