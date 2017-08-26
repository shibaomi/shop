package com.study.springmvc.service.impl.busi.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.study.springmvc.service.faces.busi.product.SpecificationOptionService;
import com.study.springmvc.dal.faces.busi.product.SpecificationOptionDao;

import com.study.springmvc.dal.model.busi.product.SpecificationOptionModel;

@Service
public class SpecificationOptionServiceImpl implements SpecificationOptionService {

	@Autowired
	private SpecificationOptionDao specificationOptionDao;

	public int insert(SpecificationOptionModel record){
		return specificationOptionDao.insert(record);
	}

	public SpecificationOptionModel selectByPrimaryKey(Long id){
		return specificationOptionDao.selectByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(SpecificationOptionModel record){
		return specificationOptionDao.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(SpecificationOptionModel record){
		return specificationOptionDao.updateByPrimaryKey(record);
	}
}
