package com.study.springmvc.service.impl.busi.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.study.springmvc.service.faces.busi.product.CategoryService;
import com.study.springmvc.dal.faces.busi.product.CategoryDao;

import com.study.springmvc.dal.model.busi.product.CategoryModel;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDao categoryDao;

	public int insert(CategoryModel record){
		return categoryDao.insert(record);
	}

	public CategoryModel selectByPrimaryKey(Long id){
		return categoryDao.selectByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(CategoryModel record){
		return categoryDao.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(CategoryModel record){
		return categoryDao.updateByPrimaryKey(record);
	}
}
