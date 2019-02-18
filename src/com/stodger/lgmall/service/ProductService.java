package com.stodger.lgmall.service;

import java.util.List;

import com.stodger.lgmall.domain.OrderItem;
import com.stodger.lgmall.domain.Product;

public interface ProductService {
	List<Object> findProductByWord(String word);
	List<Product> productList(String keyword, int startIntdex, int currentCount);
	int getProductTotal(String keyword);
	Product getProductInfo(String pid);
	void updateNum(List<OrderItem> orderItem);
	List<Product> productSecKill();
	List<Product> productCategoryList(String cid, int startIndex, int currentCount);
	int getProductCategoryTotal(String cid);
	List<Product> allProduct();
	boolean productSoldoutTime(String pid);
	boolean productSoldinTime(String pid);
	boolean productDel(String pid);
	boolean addProduct(Product product);
	boolean updateProduct(Product product);
}
