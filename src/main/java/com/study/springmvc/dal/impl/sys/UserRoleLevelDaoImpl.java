package com.study.springmvc.dal.impl.sys;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.study.springmvc.common.db.dao.mybatis.BaseDao_Mybatis;
import com.study.springmvc.dal.faces.sys.UserRoleLevelDao;

import com.study.springmvc.dal.model.sys.user.UserRoleLevelModel;

@Repository
public class UserRoleLevelDaoImpl implements UserRoleLevelDao {

	@Autowired
	private BaseDao_Mybatis baseDao;

	public int insert(UserRoleLevelModel record){
		return baseDao.insert("UserRoleLevelMapper.insert", record);
	}


	public UserRoleLevelModel selectByPrimaryKey(Long id){
		return baseDao.selectOne("UserRoleLevelMapper.selectByPrimaryKey", id);
	}


	public int updateByPrimaryKeySelective(UserRoleLevelModel record){
		return baseDao.update("UserRoleLevelMapper.updateByPrimaryKeySelective", record);
	}


	public int updateByPrimaryKey(UserRoleLevelModel record){
		return baseDao.update("UserRoleLevelMapper.updateByPrimaryKey", record);
	}

}
