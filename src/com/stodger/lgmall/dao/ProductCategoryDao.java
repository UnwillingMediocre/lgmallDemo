package com.stodger.lgmall.dao;

import java.util.List;

import com.stodger.lgmall.domain.ProductCategory;

public interface ProductCategoryDao {
  int add(ProductCategory productCategory);
  List<ProductCategory> findAllCategory();
  String getproductCategoryName(String cid);
  boolean updateproductCategory(ProductCategory productCategory);
}
