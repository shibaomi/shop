package com.study.springmvc.service.impl.busi.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.study.springmvc.service.faces.busi.product.ProductSpecificationService;
import com.study.springmvc.dal.faces.busi.product.ProductSpecificationDao;

import com.study.springmvc.dal.model.busi.product.ProductSpecificationModel;
@Service
public class ProductSpecificationServiceImpl implements ProductSpecificationService {

	@Autowired
	private ProductSpecificationDao productSpecificationDao;

	public int insert(ProductSpecificationModel record){
		return productSpecificationDao.insert(record);
	}

	public ProductSpecificationModel selectByPrimaryKey(Long id){
		return productSpecificationDao.selectByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(ProductSpecificationModel record){
		return productSpecificationDao.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(ProductSpecificationModel record){
		return productSpecificationDao.updateByPrimaryKey(record);
	}
}
