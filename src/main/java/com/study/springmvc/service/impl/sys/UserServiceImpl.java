package com.study.springmvc.service.impl.sys;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.springmvc.common.constant.sms.SmsStatus;
import com.study.springmvc.common.constant.sms.SmsType;
import com.study.springmvc.common.constant.user.FastRegisterType;
import com.study.springmvc.common.constant.user.ForgetPwdType;
import com.study.springmvc.common.constant.user.UserLevel;
import com.study.springmvc.common.constant.user.UserRole;
import com.study.springmvc.common.constant.user.UserStatus;
import com.study.springmvc.common.exception.BusiException;
import com.study.springmvc.controller.command.sys.user.FastRegisterCommand;
import com.study.springmvc.controller.command.sys.user.ForgetPwdCommand;
import com.study.springmvc.controller.command.sys.user.LoginCommand;
import com.study.springmvc.dal.faces.sys.UserDao;
import com.study.springmvc.dal.model.sys.sms.SmsFlowModel;
import com.study.springmvc.dal.model.sys.user.UserModel;
import com.study.springmvc.dal.model.sys.user.UserRoleLevelModel;
import com.study.springmvc.service.faces.sys.SmsService;
import com.study.springmvc.service.faces.sys.UserRoleLevelService;
import com.study.springmvc.service.faces.sys.UserService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private SmsService smsService;
	
	@Autowired
	private UserRoleLevelService userRoleLevelService;

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
		if(!FastRegisterType.MOBILE.name().equals(register.getAccountType())){
			log.error("暂不支持【{}】类型的快速注册",register.getAccountType());
			throw new BusiException("注册类型暂不支持");
		}
		SmsFlowModel sms=smsService.getSmsInfoById(Long.valueOf(register.getVerifyNum() ));
		if(sms==null){
			log.error("快速注册短信验证流水【{}】未查到",register.getVerifyNum());
			throw new BusiException("短信注册流水非法");
		}
		if(!SmsType.FAST_MOBILE_REGISTER.equals(sms.getSmsType())){
			log.error("快速注册短信类型【{}】非法，不是快速注册类型",sms.getSmsType());
			throw new BusiException("短信验证流水类型非法");
		}
		if(!register.getAccountNo().equals(sms.getMobile()+"")){
			log.error("快速注册手机号不一致，注册手机号：【{}】，获取短信的手机号：【{}】",register.getAccountNo(),
					sms.getMobile());
			throw new BusiException("注册手机号和获取短信验证码手机号不一致");
		}
		if(!SmsStatus.CHECK_SUCCESS.equals(sms.getSmsStatus())){
			log.error("快速注册短信状态不正确：【{}】",sms.getSmsStatus());
			throw new BusiException("快速注册短信未验证通过");
		}
		UserModel user=new UserModel(register);
		userDao.saveUserModel(user);
		userDao.updateUserNoById(user.getId(), "U"+String.format("%06d", user.getId()));
		UserRoleLevelModel rl=new UserRoleLevelModel(user.getId(),UserRole.C_CONSUMER,UserLevel.C_Level1);
		userRoleLevelService.insert(rl);
		return user.getId();
	}

	@Override
	public void forgerPwdByMobile(ForgetPwdCommand forgetPwdCommand) {
		if(!ForgetPwdType.MOBILE.name().equals(forgetPwdCommand.getForgetPwdType())){
			log.error("暂不支持【{}】类型的找回密码",forgetPwdCommand.getForgetPwdType());
			throw new BusiException("找回密码类型暂不支持");
		}
		SmsFlowModel sms=smsService.getSmsInfoById(Long.valueOf(forgetPwdCommand.getVerifyNum()));
		if(sms==null){
			log.error("手机找回密码短信验证流水【{}】未查到",forgetPwdCommand.getVerifyNum());
			throw new BusiException("找回密码短信流水非法");
		}
		if(!SmsType.FORGET_PWD.equals(sms.getSmsType())){
			log.error("找回密码短信类型【{}】非法，不是手机找回密码类型",sms.getSmsType());
			throw new BusiException("短信验证流水类型非法");
		}
		if(!forgetPwdCommand.getAccountNo().equals(sms.getMobile()+"")){
			log.error("找回密码手机号不一致，验证手机号：【{}】，获取短信的手机号：【{}】",forgetPwdCommand.getAccountNo(),
					sms.getMobile());
			throw new BusiException("找回密码手机号和获取短信验证码手机号不一致");
		}
		if(!SmsStatus.CHECK_SUCCESS.equals(sms.getSmsStatus())){
			log.error("找回密码短信状态不正确：【{}】",sms.getSmsStatus());
			throw new BusiException("找回密码短信未验证通过");
		}
		userDao.updateUserPwdByMobile(Long.valueOf(forgetPwdCommand.getAccountNo()),
				forgetPwdCommand.getPwd());
	}

	@Override
	public UserModel login(LoginCommand command) {
		List<UserStatus> status=new ArrayList<UserStatus>();
		status.add(UserStatus.ENABLED);
		status.add(UserStatus.FROZEN);
		UserModel user=this.userDao.queryByAccountNo(command.getAccountNo(),status);
		if(user==null){
			log.error("登录账号：【{}】的用户未查到",command.getAccountNo());
			throw new BusiException("用户信息不存在或密码错误");
		}
		if(!user.getPwdLogin().equals(command.getPwd())){
			log.error("登录账号：【{}】的用户密码错误",command.getAccountNo());
			throw new BusiException("用户信息不存在或密码错误");
		}
		return user;
	}
}
