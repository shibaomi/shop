package com.study.springmvc.dal.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import com.study.springmvc.common.db.dao.mybatis.BaseDao_Mybatis;
import com.study.springmvc.dal.faces.UserDao;
import com.study.springmvc.dal.model.UserModel;

@Repository
public class UserDaoImpl implements UserDao{
	@Autowired
	private BaseDao_Mybatis baseDao;
	
	@Override
	public UserModel queryUserModelById(Long id) {
		return baseDao.selectOne("UserModelMapper.selectByKey", id);
	}

	@Override
	public UserModel queryUserModelByMobile(Long mobile) {
		List<UserModel> result=baseDao.selectList("UserModelMapper.selectByMobile", mobile);
		if(CollectionUtils.isEmpty(result)){
			return null;
		}
		return result.get(0);
	}

	@Override
	public int saveUserModel(UserModel user) {
		return baseDao.insert("UserModelMapper.insertUser", user);
	}

	@Override
	public int updateUserPwdByMobile(Long mobile, String pwd) {
		Map<String,Object> param=new HashMap<String,Object>();
		param.put("mobile", mobile);
		param.put("pwd", pwd);
		return baseDao.update("UserModelMapper.updateUserPwdByMobile",param);
	}
}
