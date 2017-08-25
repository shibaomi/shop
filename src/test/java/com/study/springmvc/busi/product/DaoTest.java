package com.study.springmvc.busi.product;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;
import com.study.springmvc.base.BaseTest;
import com.study.springmvc.dal.faces.busi.product.SpecificationDao;
import com.study.springmvc.dal.model.busi.product.SpecificationModel;

public class DaoTest extends BaseTest{
	
	@Autowired
	private SpecificationDao specificationDao;
	
	@Test
	@Transactional
	@Rollback(true)
	public void testSaveSmsInfo() {
		SpecificationModel command=new SpecificationModel();
		command.setSpecificationCode("test");
		command.setSpecificationDesc("test");
		command.setSpecificationName("test");
		int cnt=specificationDao.insert(command);
		System.out.println(cnt+"==="+command.getId());
		SpecificationModel model=specificationDao.selectByPrimaryKey(command.getId());
		System.out.println("select1="+JSONObject.toJSONString(model));
		model.setSpecificationCode("ddd");
		System.out.println(specificationDao.updateByPrimaryKey(model));
		SpecificationModel model1=specificationDao.selectByPrimaryKey(command.getId());
		System.out.println("select2="+JSONObject.toJSONString(model1));
		model.setCreateBy("111");
		model.setSpecificationCode(null);
		System.out.println(specificationDao.updateByPrimaryKeySelective(model));
		SpecificationModel model11=specificationDao.selectByPrimaryKey(command.getId());
		System.out.println("select3="+JSONObject.toJSONString(model11));
	}
}
