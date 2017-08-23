package com.study.springmvc.dal.impl.busi.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.springmvc.common.db.dao.mybatis.BaseDao_Mybatis;
import com.study.springmvc.dal.faces.busi.product.CategoryDao;
import com.study.springmvc.dal.model.busi.product.CategoryModel;

@Repository
public class CategoryDaoImpl implements CategoryDao{

	@Autowired
	private BaseDao_Mybatis baseDao;

	@Override
	public int insert(CategoryModel record) {
		return baseDao.insert("CategoryModelMapper.insert", record);
	}

	@Override
	public CategoryModel selectByPrimaryKey(Long id) {
		return baseDao.selectOne("CategoryModelMapper.selectByPrimaryKey", id);
	}

	@Override
	public int updateByPrimaryKeySelective(CategoryModel record) {
		return baseDao.update("CategoryModelMapper.updateByPrimaryKeySelective", record);
	}

	@Override
	public int updateByPrimaryKey(CategoryModel record) {
		return baseDao.update("CategoryModelMapper.updateByPrimaryKey", record);
	}
}
