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
	 * �����Ʒ����
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
	 * ȡ��ȫ����Ʒ����
	 */
	@Override
	public List<ProductCategory> findAllCategory() {
		return productCategoryDao.findAllCategory();
	}
	/**
	 * ȡ��Ʒ��������
	 */
	@Override
	public String getproductCategoryName(String cid) {
		return productCategoryDao.getproductCategoryName(cid);
	}
	/**
	 * ������Ʒ����
	 */
	@Override
	public boolean updateproductCategory(ProductCategory productCategory) {
		boolean result = NO;
		result = productCategoryDao.updateproductCategory(productCategory);
		return result;
	}

}
