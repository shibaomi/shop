package com.study.springmvc.service.faces;

import com.study.springmvc.common.db.page.QueryCondition;
import com.study.springmvc.common.utils.Page;
import com.study.springmvc.dal.model.UserModel;

public interface UserService {
	/**
	 * 根据用户id查询用户信息
	 */
	public UserModel queryUserModelById(Long id);
	
	/**
	 * 保存或更新用户信息
	 */
	public Long saveOrUpdateUserModel(UserModel user);
	
	/**
	 * 删除用户信息
	 */
	public void deleteUserById(Long id);
	
	/**
	 * 分页查询用户列表
	 */
	public Page<UserModel> queryPageUserModel(QueryCondition query);
}
