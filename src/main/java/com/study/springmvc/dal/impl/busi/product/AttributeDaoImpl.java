package com.study.springmvc.dal.impl.busi.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.study.springmvc.common.db.dao.mybatis.BaseDao_Mybatis;
import com.study.springmvc.dal.faces.busi.product.AttributeDao;

import com.study.springmvc.dal.model.busi.product.AttributeModel;

@Repository
public class AttributeDaoImpl implements AttributeDao {

	@Autowired
	private BaseDao_Mybatis baseDao;

	public int insert(AttributeModel record){
		return baseDao.insert("AttributeMapper.insert", record);
	}


	public AttributeModel selectByPrimaryKey(Long id){
		return baseDao.selectOne("AttributeMapper.selectByPrimaryKey", id);
	}


	public int updateByPrimaryKeySelective(AttributeModel record){
		return baseDao.update("AttributeMapper.updateByPrimaryKeySelective", record);
	}


	public int updateByPrimaryKey(AttributeModel record){
		return baseDao.update("AttributeMapper.updateByPrimaryKey", record);
	}

}
