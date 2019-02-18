package com.stodger.lgmall.dao;

import java.util.List;

import com.stodger.lgmall.domain.OrderItem;
import com.stodger.lgmall.domain.Product;

public interface ProductDao {
	List<Object> findProductByWord(String word);
	List<Product> findProduct(String keyword, int startIntdex, int currentCount);
	int getProductTotal(String keyword);
	Product getProductInfo(String pid);
	void updateNum(List<OrderItem> orderItem);
	List<Product> productSecKill(int start, int end);
	int getProductCategoryTotal(String cid);
	List<Product> productCategoryList(String cid, int startIndex, int currentCount);
	List<Product> allProduct();
	boolean productSoldoutTime(String pid, String p_soldOutTime);
	boolean productSoldinTime(String pid, String p_soldInTime);
	boolean productDel(String pid);
	boolean addProduct(Product product);
	boolean updateProduct(Product product);
	
}
