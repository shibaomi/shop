package com.study.springmvc.dal.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.springmvc.common.constant.Constant.DictState;
import com.study.springmvc.common.db.dao.mybatis.BaseDao_Mybatis;
import com.study.springmvc.common.db.page.QueryCondition;
import com.study.springmvc.common.utils.Page;
import com.study.springmvc.dal.faces.UserDao;
import com.study.springmvc.dal.model.UserModel;

@Repository
public class UserDaoImpl implements UserDao{
	@Autowired
	private BaseDao_Mybatis baseDao;
	
	private static String SELECT_BY_ID="UserModelMapper.selectByKey";
	private static String INSERT_SQL="UserModelMapper.insertUser";
	private static String UPDATE_SQL="UserModelMapper.updateUser";
	private static String DELETE_BY_ID="UserModelMapper.deleteByKey";
	private static String SELECT_EXIST_USER="UserModelMapper.selectUserExist";
	private static String UPDATE_STATE_SQL="UserModelMapper.updateUserState";
	private static String SELECT_LIST="UserModelMapper.selectList";

	public int saveUserModel(UserModel user) {
		return baseDao.insert(INSERT_SQL, user);
	}

	@Override
	public UserModel queryUserModelById(Long id) {
		return baseDao.selectOne(SELECT_BY_ID, id);
	}

	@Override
	public int updateUserModel(UserModel user) {
		return baseDao.update(UPDATE_SQL, user);
	}

	@Override
	public int deleteUserById(Long id) {
		return baseDao.delete(DELETE_BY_ID, id);
	}

	@Override
	public List<UserModel> selectUserExist(Map<String, Object> map) {
		return baseDao.selectList(SELECT_EXIST_USER, map);
	}

	@Override
	public int updateUserState(Long id,DictState state,Long updateUserId) {
		Map<String,Object> params=new HashMap<String,Object>();
		params.put("id", id);
		params.put("updateBy", updateUserId);
		params.put("status", state.toString());
		return baseDao.update(UPDATE_STATE_SQL, params);
	}

	@Override
	public Page<UserModel> queryPageUserModel(QueryCondition query) {
		Page<UserModel> page=baseDao.selectPageList(SELECT_LIST, query);
		return page;
	}
}
