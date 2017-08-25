package com.study.springmvc.dal.impl.busi.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.study.springmvc.common.db.dao.mybatis.BaseDao_Mybatis;
import com.study.springmvc.dal.faces.busi.product.AttributeOptionDao;

import com.study.springmvc.dal.model.busi.product.AttributeOptionModel;

@Repository
public class AttributeOptionDaoImpl implements AttributeOptionDao {

	@Autowired
	private BaseDao_Mybatis baseDao;

	public int insert(AttributeOptionModel record){
		return baseDao.insert("AttributeOptionMapper.insert", record);
	}


	public AttributeOptionModel selectByPrimaryKey(Long id){
		return baseDao.selectOne("AttributeOptionMapper.selectByPrimaryKey", id);
	}


	public int updateByPrimaryKeySelective(AttributeOptionModel record){
		return baseDao.update("AttributeOptionMapper.updateByPrimaryKeySelective", record);
	}


	public int updateByPrimaryKey(AttributeOptionModel record){
		return baseDao.update("AttributeOptionMapper.updateByPrimaryKey", record);
	}

}
