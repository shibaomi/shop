package com.study.springmvc.service.faces;

import com.study.springmvc.controller.command.user.FastRegisterCommand;
import com.study.springmvc.controller.command.user.ForgetPwdCommand;
import com.study.springmvc.controller.command.user.LoginCommand;
import com.study.springmvc.dal.model.UserModel;

public interface UserService {
	/**
	 * 根据用户id查询用户信息
	 */
	public UserModel queryUserModelById(Long id);
	
	/**
	 * 根据手机号查询用户信息
	 */
	public UserModel queryUserModelByMobile(Long mobile);
	
	/**
	 * 用户快速注册
	 */
	public Long fastRegisterUser(FastRegisterCommand register);
	
	/**
	 * 用户手机找回密码
	 */
	public void forgerPwdByMobile(ForgetPwdCommand forgetPwdCommand);
	
	/**
	 * 登录
	 */
	public UserModel login(LoginCommand command);
}
