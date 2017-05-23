package com.study.springmvc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.springmvc.controller.command.user.FastRegisterCommand;
import com.study.springmvc.dal.faces.UserDao;
import com.study.springmvc.dal.model.UserModel;
import com.study.springmvc.service.faces.UserService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;

	@Override
	public UserModel queryUserModelById(Long id) {
		return userDao.queryUserModelById(id);
	}

	@Override
	public UserModel queryUserModelByMobile(Long mobile) {
		return userDao.queryUserModelByMobile(mobile);
	}

	@Override
	public Long fastRegisterUser(FastRegisterCommand register) {
		UserModel user=new UserModel();
		userDao.saveUserModel(user);
		return user.getId();
	}
}
