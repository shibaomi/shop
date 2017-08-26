package com.study.springmvc.service.impl.busi.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.study.springmvc.service.faces.busi.product.ProductAttributeService;
import com.study.springmvc.dal.faces.busi.product.ProductAttributeDao;

import com.study.springmvc.dal.model.busi.product.ProductAttributeModel;

@Service
public class ProductAttributeServiceImpl implements ProductAttributeService {

	@Autowired
	private ProductAttributeDao productAttributeDao;

	public int insert(ProductAttributeModel record){
		return productAttributeDao.insert(record);
	}

	public ProductAttributeModel selectByPrimaryKey(Long id){
		return productAttributeDao.selectByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(ProductAttributeModel record){
		return productAttributeDao.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(ProductAttributeModel record){
		return productAttributeDao.updateByPrimaryKey(record);
	}
}
