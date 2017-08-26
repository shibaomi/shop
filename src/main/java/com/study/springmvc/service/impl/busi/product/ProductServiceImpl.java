package com.study.springmvc.service.impl.busi.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.study.springmvc.service.faces.busi.product.ProductService;
import com.study.springmvc.dal.faces.busi.product.ProductDao;

import com.study.springmvc.dal.model.busi.product.ProductModel;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;

	public int insert(ProductModel record){
		return productDao.insert(record);
	}

	public ProductModel selectByPrimaryKey(Long id){
		return productDao.selectByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(ProductModel record){
		return productDao.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(ProductModel record){
		return productDao.updateByPrimaryKey(record);
	}
}
