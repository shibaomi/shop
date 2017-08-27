package com.study.springmvc.service.impl.sys;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.study.springmvc.service.faces.sys.UserRoleLevelService;
import com.study.springmvc.dal.faces.sys.UserRoleLevelDao;

import com.study.springmvc.dal.model.sys.user.UserRoleLevelModel;

@Service
public class UserRoleLevelServiceImpl implements UserRoleLevelService {

	@Autowired
	private UserRoleLevelDao userRoleLevelDao;

	public int insert(UserRoleLevelModel record){
		return userRoleLevelDao.insert(record);
	}

	public UserRoleLevelModel selectByPrimaryKey(Long id){
		return userRoleLevelDao.selectByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(UserRoleLevelModel record){
		return userRoleLevelDao.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(UserRoleLevelModel record){
		return userRoleLevelDao.updateByPrimaryKey(record);
	}
}
