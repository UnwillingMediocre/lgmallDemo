package com.stodger.lgmall.service.impl;

import java.util.List;

import com.stodger.lgmall.dao.ProductCategoryDao;
import com.stodger.lgmall.dao.Impl.ProductCategoryDaoImpl;
import com.stodger.lgmall.domain.ProductCategory;
import com.stodger.lgmall.service.ProductCategoryService;

public class ProductCategoryServiceImpl implements ProductCategoryService{
	private static final boolean OK = true;
	private static final boolean NO = false;
	
	ProductCategoryDao productCategoryDao = new ProductCategoryDaoImpl();
	
	/**
	 * 添加商品分类
	 */
	@Override
	public boolean add(ProductCategory productCategory) {
		boolean result = NO;
		int tempResult = productCategoryDao.add(productCategory);
		if(tempResult > 0){
			result = OK;
		}
		return result;
	}
	/**
	 * 取出全部商品分类
	 */
	@Override
	public List<ProductCategory> findAllCategory() {
		return productCategoryDao.findAllCategory();
	}
	/**
	 * 取商品分类名称
	 */
	@Override
	public String getproductCategoryName(String cid) {
		return productCategoryDao.getproductCategoryName(cid);
	}
	/**
	 * 更新商品分类
	 */
	@Override
	public boolean updateproductCategory(ProductCategory productCategory) {
		boolean result = NO;
		result = productCategoryDao.updateproductCategory(productCategory);
		return result;
	}

}
