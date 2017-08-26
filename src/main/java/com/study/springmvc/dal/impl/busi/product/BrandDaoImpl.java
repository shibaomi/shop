package com.study.springmvc.dal.impl.busi.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.study.springmvc.common.db.dao.mybatis.BaseDao_Mybatis;
import com.study.springmvc.dal.faces.busi.product.BrandDao;

import com.study.springmvc.dal.model.busi.product.BrandModel;

@Repository
public class BrandDaoImpl implements BrandDao {

	@Autowired
	private BaseDao_Mybatis baseDao;

	public int insert(BrandModel record){
		return baseDao.insert("BrandMapper.insert", record);
	}

	public BrandModel selectByPrimaryKey(Long id){
		return baseDao.selectOne("BrandMapper.selectByPrimaryKey", id);
	}

	public int updateByPrimaryKeySelective(BrandModel record){
		return baseDao.update("BrandMapper.updateByPrimaryKeySelective", record);
	}

	public int updateByPrimaryKey(BrandModel record){
		return baseDao.update("BrandMapper.updateByPrimaryKey", record);
	}

}
