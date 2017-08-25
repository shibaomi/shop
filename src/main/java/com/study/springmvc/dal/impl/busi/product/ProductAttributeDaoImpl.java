package com.study.springmvc.dal.impl.busi.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.study.springmvc.common.db.dao.mybatis.BaseDao_Mybatis;
import com.study.springmvc.dal.faces.busi.product.ProductAttributeDao;

import com.study.springmvc.dal.model.busi.product.ProductAttributeModel;

@Repository
public class ProductAttributeDaoImpl implements ProductAttributeDao {

	@Autowired
	private BaseDao_Mybatis baseDao;

	public int insert(ProductAttributeModel record){
		return baseDao.insert("ProductAttributeMapper.insert", record);
	}


	public ProductAttributeModel selectByPrimaryKey(Long id){
		return baseDao.selectOne("ProductAttributeMapper.selectByPrimaryKey", id);
	}


	public int updateByPrimaryKeySelective(ProductAttributeModel record){
		return baseDao.update("ProductAttributeMapper.updateByPrimaryKeySelective", record);
	}


	public int updateByPrimaryKey(ProductAttributeModel record){
		return baseDao.update("ProductAttributeMapper.updateByPrimaryKey", record);
	}

}
