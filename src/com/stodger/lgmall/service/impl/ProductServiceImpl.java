package com.stodger.lgmall.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import com.stodger.lgmall.dao.ProductDao;
import com.stodger.lgmall.dao.Impl.ProductDaoImpl;
import com.stodger.lgmall.domain.OrderItem;
import com.stodger.lgmall.domain.Product;
import com.stodger.lgmall.service.ProductService;

public class ProductServiceImpl implements ProductService{
	private ProductDao productDao = new ProductDaoImpl();
	
	/**
	 * 根据关键字查找商品标题
	 */
	@Override
	public List<Object> findProductByWord(String word) {
		List<Object> productList = productDao.findProductByWord(word);
		return productList;
	}
	
	/**
	 * 根据关键字查找商品总数量
	 */
	@Override
	public int getProductTotal(String keyword) {
		return productDao.getProductTotal(keyword);
	}
	
	/**
	 * 根据关键字查找商品
	 */
	@Override
	public List<Product> productList(String keyword, int startIntdex, int currentCount) {
		List<Product> productList =  productDao.findProduct(keyword, startIntdex, currentCount);
		return productList;
	}
	
	/**
	 * 根据商品id查找商品详细信息
	 */
	@Override
	public Product getProductInfo(String pid) {
		return productDao.getProductInfo(pid);
	}
	/**
	 * 更新商品数量
	 */
	@Override
	public void updateNum(List<OrderItem> orderItem) {
		productDao.updateNum(orderItem);
		
	}
	/**
	 * 秒杀商品
	 */
	@Override
	public List<Product> productSecKill() {
		Random random = new Random();
		
		int start = random.nextInt(100);
		int end = random.nextInt(1000) + start;
		return productDao.productSecKill(start, end);
	}
	/**
	 * 取商品分类个数
	 */
	@Override
	public int getProductCategoryTotal(String cid) {
		return productDao.getProductCategoryTotal(cid);
	}
	/**
	 * 取商品分类的商品
	 */
	@Override
	public List<Product> productCategoryList(String cid, int startIndex, int currentCount) {
		
		return productDao.productCategoryList(cid, startIndex,currentCount);
	}
	/**
	 * 全部商品
	 */
	@Override
	public List<Product> allProduct() {
		return productDao.allProduct();
	}
	/**
	 * 商品下架
	 */
	@Override
	public boolean productSoldoutTime(String pid) {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		return productDao.productSoldoutTime(pid, formatter.format(date));
	}
	/**
	 * 商品发布
	 */
	@Override
	public boolean productSoldinTime(String pid) {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		return productDao.productSoldinTime(pid, formatter.format(date));
	}
	/**
	 * 商品删除
	 */
	@Override
	public boolean productDel(String pid) {
		return productDao.productDel(pid);
	}
	/**
	 * 添加商品
	 */
	@Override
	public boolean addProduct(Product product) {
		return  productDao.addProduct(product);
	}
	/**
	 * 更新商品
	 */
	@Override
	public boolean updateProduct(Product product) {
		return productDao.updateProduct(product);
	}

}
