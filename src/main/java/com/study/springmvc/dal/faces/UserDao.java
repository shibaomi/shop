package com.study.springmvc.dal.faces;

import java.util.List;
import java.util.Map;

import com.study.springmvc.common.constant.Constant.DictState;
import com.study.springmvc.common.db.page.QueryCondition;
import com.study.springmvc.common.utils.Page;
import com.study.springmvc.dal.model.UserModel;

public interface UserDao {
	/**
	 * 根据用户id查询用户信息
	 */
	public UserModel queryUserModelById(Long id);
	
	/**
	 * 保存用户信息
	 */
	public int saveUserModel(UserModel user);
	
	/**
	 * 更新用户信息
	 */
	public int updateUserModel(UserModel user);
	
	/**
	 * 删除用户信息
	 */
	public int deleteUserById(Long id);
	
	/**
	 * 根据userNo、NICK_NAM、certiType、certiNo、mobile、email、status、id查询存在的用户信息
	 */
	public List<UserModel> selectUserExist(Map<String,Object> map);
	
	/**
	 * 更新用户状态
	 */
	public int updateUserState(Long id,DictState state,Long updateUserId);
	
	/**
	 * 分页查询用户列表
	 */
	public Page<UserModel> queryPageUserModel(QueryCondition query);

}
