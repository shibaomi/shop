package com.study.springmvc.dal.impl.busi.product;

import org.springframework.beans.factory.annotation.Autowired;

import com.study.springmvc.common.db.dao.mybatis.BaseDao_Mybatis;
import com.study.springmvc.dal.faces.busi.product.BrandDao;
import com.study.springmvc.dal.model.busi.product.BrandModel;

public class BrandDaoImpl implements BrandDao{

	@Autowired
	private BaseDao_Mybatis baseDao;
	
	@Override
	public int saveBrandModel(BrandModel brand) {
		return baseDao.insert("BannerModelMapper.insertBanner", brand);
	}

	@Override
	public int updateBrandModel(BrandModel brand) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public BrandModel queryBrandModelById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
