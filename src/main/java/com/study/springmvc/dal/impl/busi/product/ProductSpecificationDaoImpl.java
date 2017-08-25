package com.study.springmvc.dal.impl.busi.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.study.springmvc.common.db.dao.mybatis.BaseDao_Mybatis;
import com.study.springmvc.dal.faces.busi.product.ProductSpecificationDao;

import com.study.springmvc.dal.model.busi.product.ProductSpecificationModel;
@Repository
public class ProductSpecificationDaoImpl implements ProductSpecificationDao {

	@Autowired
	private BaseDao_Mybatis baseDao;

	public int insert(ProductSpecificationModel record){
		return baseDao.insert("ProductSpecificationMapper.insert", record);
	}


	public ProductSpecificationModel selectByPrimaryKey(Long id){
		return baseDao.selectOne("ProductSpecificationMapper.selectByPrimaryKey", id);
	}


	public int updateByPrimaryKeySelective(ProductSpecificationModel record){
		return baseDao.update("ProductSpecificationMapper.updateByPrimaryKeySelective", record);
	}


	public int updateByPrimaryKey(ProductSpecificationModel record){
		return baseDao.update("ProductSpecificationMapper.updateByPrimaryKey", record);
	}

}
