package com.study.springmvc.dal.impl.busi.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.study.springmvc.common.db.dao.mybatis.BaseDao_Mybatis;
import com.study.springmvc.dal.faces.busi.product.ProductDao;

import com.study.springmvc.dal.model.busi.product.ProductModel;

@Repository
public class ProductDaoImpl implements ProductDao {

	@Autowired
	private BaseDao_Mybatis baseDao;

	public int insert(ProductModel record){
		return baseDao.insert("ProductMapper.insert", record);
	}


	public ProductModel selectByPrimaryKey(Long id){
		return baseDao.selectOne("ProductMapper.selectByPrimaryKey", id);
	}


	public int updateByPrimaryKeySelective(ProductModel record){
		return baseDao.update("ProductMapper.updateByPrimaryKeySelective", record);
	}


	public int updateByPrimaryKey(ProductModel record){
		return baseDao.update("ProductMapper.updateByPrimaryKey", record);
	}

}
