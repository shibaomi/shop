package com.study.springmvc.dal.impl.busi.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.study.springmvc.common.db.dao.mybatis.BaseDao_Mybatis;
import com.study.springmvc.dal.faces.busi.product.SpecificationDao;

import com.study.springmvc.dal.model.busi.product.SpecificationModel;

@Repository
public class SpecificationDaoImpl implements SpecificationDao {

	@Autowired
	private BaseDao_Mybatis baseDao;

	public int insert(SpecificationModel record){
		return baseDao.insert("SpecificationMapper.insert", record);
	}


	public SpecificationModel selectByPrimaryKey(Long id){
		return baseDao.selectOne("SpecificationMapper.selectByPrimaryKey", id);
	}


	public int updateByPrimaryKeySelective(SpecificationModel record){
		return baseDao.update("SpecificationMapper.updateByPrimaryKeySelective", record);
	}


	public int updateByPrimaryKey(SpecificationModel record){
		return baseDao.update("SpecificationMapper.updateByPrimaryKey", record);
	}

}
