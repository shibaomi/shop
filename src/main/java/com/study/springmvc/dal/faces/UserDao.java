package com.study.springmvc.dal.faces;

import com.study.springmvc.dal.model.UserModel;

public interface UserDao {
	/**
	 * 根据用户id查询用户信息
	 */
	public UserModel queryUserModelById(Long id);
	
	/**
	 * 根据手机号查询用户信息
	 */
	public UserModel queryUserModelByMobile(Long mobile);
	
	/**
	 * 新增用户信息
	 */
	public int saveUserModel(UserModel user);

}
