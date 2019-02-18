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
	 * ���ݹؼ��ֲ�����Ʒ����
	 */
	@Override
	public List<Object> findProductByWord(String word) {
		List<Object> productList = productDao.findProductByWord(word);
		return productList;
	}
	
	/**
	 * ���ݹؼ��ֲ�����Ʒ������
	 */
	@Override
	public int getProductTotal(String keyword) {
		return productDao.getProductTotal(keyword);
	}
	
	/**
	 * ���ݹؼ��ֲ�����Ʒ
	 */
	@Override
	public List<Product> productList(String keyword, int startIntdex, int currentCount) {
		List<Product> productList =  productDao.findProduct(keyword, startIntdex, currentCount);
		return productList;
	}
	
	/**
	 * ������Ʒid������Ʒ��ϸ��Ϣ
	 */
	@Override
	public Product getProductInfo(String pid) {
		return productDao.getProductInfo(pid);
	}
	/**
	 * ������Ʒ����
	 */
	@Override
	public void updateNum(List<OrderItem> orderItem) {
		productDao.updateNum(orderItem);
		
	}
	/**
	 * ��ɱ��Ʒ
	 */
	@Override
	public List<Product> productSecKill() {
		Random random = new Random();
		
		int start = random.nextInt(100);
		int end = random.nextInt(1000) + start;
		return productDao.productSecKill(start, end);
	}
	/**
	 * ȡ��Ʒ�������
	 */
	@Override
	public int getProductCategoryTotal(String cid) {
		return productDao.getProductCategoryTotal(cid);
	}
	/**
	 * ȡ��Ʒ�������Ʒ
	 */
	@Override
	public List<Product> productCategoryList(String cid, int startIndex, int currentCount) {
		
		return productDao.productCategoryList(cid, startIndex,currentCount);
	}
	/**
	 * ȫ����Ʒ
	 */
	@Override
	public List<Product> allProduct() {
		return productDao.allProduct();
	}
	/**
	 * ��Ʒ�¼�
	 */
	@Override
	public boolean productSoldoutTime(String pid) {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		return productDao.productSoldoutTime(pid, formatter.format(date));
	}
	/**
	 * ��Ʒ����
	 */
	@Override
	public boolean productSoldinTime(String pid) {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		return productDao.productSoldinTime(pid, formatter.format(date));
	}
	/**
	 * ��Ʒɾ��
	 */
	@Override
	public boolean productDel(String pid) {
		return productDao.productDel(pid);
	}
	/**
	 * �����Ʒ
	 */
	@Override
	public boolean addProduct(Product product) {
		return  productDao.addProduct(product);
	}
	/**
	 * ������Ʒ
	 */
	@Override
	public boolean updateProduct(Product product) {
		return productDao.updateProduct(product);
	}

}
