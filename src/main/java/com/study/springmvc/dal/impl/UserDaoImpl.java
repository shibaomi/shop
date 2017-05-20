package com.study.springmvc.dal.impl;

import java.util.List;

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
	
	private static String SELECT_BY_ID="UserModelMapper.selectByKey";
	private static String SELECT_BY_MOBILE="UserModelMapper.selectByMobile";

	@Override
	public UserModel queryUserModelById(Long id) {
		return baseDao.selectOne(SELECT_BY_ID, id);
	}

	@Override
	public UserModel queryUserModelByMobile(Long mobile) {
		List<UserModel> result=baseDao.selectList(SELECT_BY_MOBILE, mobile);
		if(CollectionUtils.isEmpty(result)){
			return null;
		}
		return result.get(0);
	}
}
