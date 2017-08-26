package com.study.springmvc.service.impl.busi.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.study.springmvc.service.faces.busi.product.AttributeService;
import com.study.springmvc.dal.faces.busi.product.AttributeDao;

import com.study.springmvc.dal.model.busi.product.AttributeModel;

@Service
public class AttributeServiceImpl implements AttributeService {

	@Autowired
	private AttributeDao attributeDao;

	public int insert(AttributeModel record){
		return attributeDao.insert(record);
	}

	public AttributeModel selectByPrimaryKey(Long id){
		return attributeDao.selectByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(AttributeModel record){
		return attributeDao.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(AttributeModel record){
		return attributeDao.updateByPrimaryKey(record);
	}
}
