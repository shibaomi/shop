package com.study.springmvc.service.impl.busi.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.study.springmvc.service.faces.busi.product.SpecificationService;
import com.study.springmvc.dal.faces.busi.product.SpecificationDao;

import com.study.springmvc.dal.model.busi.product.SpecificationModel;

@Service
public class SpecificationServiceImpl implements SpecificationService {

	@Autowired
	private SpecificationDao specificationDao;

	public int insert(SpecificationModel record){
		return specificationDao.insert(record);
	}

	public SpecificationModel selectByPrimaryKey(Long id){
		return specificationDao.selectByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(SpecificationModel record){
		return specificationDao.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(SpecificationModel record){
		return specificationDao.updateByPrimaryKey(record);
	}
}
