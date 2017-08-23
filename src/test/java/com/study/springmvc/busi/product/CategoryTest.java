package com.study.springmvc.busi.product;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.study.springmvc.base.BaseTest;
import com.study.springmvc.common.constant.common.CommonState;
import com.study.springmvc.common.constant.product.CategoryLevel;
import com.study.springmvc.dal.model.busi.product.CategoryModel;
import com.study.springmvc.service.faces.busi.product.CategoryService;

public class CategoryTest extends BaseTest{
	
	@Autowired
	private CategoryService categoryService;
	
	@Test
	@Transactional
	@Rollback(true)
	public void testSaveSmsInfo() {
		CategoryModel command=new CategoryModel();
		command.setCategoryName("test");
		command.setCategoryCode("test");
		command.setCategoryDesc("test");
		command.setCategoryLevel(CategoryLevel.ROOT);
		command.setCategoryParentId(-1l);
		command.setParentsId("-1");
		command.setCategoryStatus(CommonState.ENABLED);
		int id=categoryService.createCategory(command);
		assertNotNull(id);
		System.out.println(id);
	}
}
