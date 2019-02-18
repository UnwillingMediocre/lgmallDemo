package com.stodger.lgmall.service;

import java.util.List;

import com.stodger.lgmall.domain.ProductCategory;

public interface ProductCategoryService {
	boolean add(ProductCategory productCategory);
	List<ProductCategory> findAllCategory();
	String getproductCategoryName(String cid);
	boolean updateproductCategory(ProductCategory productCategory);
}
