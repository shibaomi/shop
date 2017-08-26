package com.study.springmvc.service.impl.busi.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.study.springmvc.service.faces.busi.product.BrandService;
import com.study.springmvc.dal.faces.busi.product.BrandDao;

import com.study.springmvc.dal.model.busi.product.BrandModel;

@Service
public class BrandServiceImpl implements BrandService {

	@Autowired
	private BrandDao brandDao;

	public int insert(BrandModel record){
		return brandDao.insert(record);
	}

	public BrandModel selectByPrimaryKey(Long id){
		return brandDao.selectByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(BrandModel record){
		return brandDao.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(BrandModel record){
		return brandDao.updateByPrimaryKey(record);
	}
}
