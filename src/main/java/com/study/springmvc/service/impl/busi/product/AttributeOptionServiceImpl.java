package com.study.springmvc.service.impl.busi.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.springmvc.dal.faces.busi.product.AttributeOptionDao;
import com.study.springmvc.dal.model.busi.product.AttributeOptionModel;
import com.study.springmvc.service.faces.busi.product.AttributeOptionService;

@Service
public class AttributeOptionServiceImpl implements AttributeOptionService{
	
	@Autowired
	private AttributeOptionDao attributeOptionService;
	
	@Override
	public int insert(AttributeOptionModel record) {
		return attributeOptionService.insert(record);
	}

	@Override
	public AttributeOptionModel selectByPrimaryKey(Long id) {
		return attributeOptionService.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(AttributeOptionModel record) {
		return attributeOptionService.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(AttributeOptionModel record) {
		return attributeOptionService.updateByPrimaryKey(record);
	}

}
