package com.study.springmvc.service.impl.busi.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.study.springmvc.service.faces.busi.product.AttributeOptionService;
import com.study.springmvc.dal.faces.busi.product.AttributeOptionDao;

import com.study.springmvc.dal.model.busi.product.AttributeOptionModel;

@Service
public class AttributeOptionServiceImpl implements AttributeOptionService {

	@Autowired
	private AttributeOptionDao attributeOptionDao;

	public int insert(AttributeOptionModel record){
		return attributeOptionDao.insert(record);
	}

	public AttributeOptionModel selectByPrimaryKey(Long id){
		return attributeOptionDao.selectByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(AttributeOptionModel record){
		return attributeOptionDao.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(AttributeOptionModel record){
		return attributeOptionDao.updateByPrimaryKey(record);
	}
}
