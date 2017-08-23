package com.study.springmvc.service.impl.busi.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.springmvc.dal.faces.busi.product.CategoryDao;
import com.study.springmvc.dal.model.busi.product.CategoryModel;
import com.study.springmvc.service.faces.busi.product.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	private CategoryDao categoryDao;

	@Override
	public int createCategory(CategoryModel record) {
		return categoryDao.insert(record);
	}

	@Override
	public CategoryModel selectById(Long id) {
		return categoryDao.selectByPrimaryKey(id);
	}

	@Override
	public int updateCategoryModel(CategoryModel record) {
		return categoryDao.updateByPrimaryKeySelective(record);
	}
}
