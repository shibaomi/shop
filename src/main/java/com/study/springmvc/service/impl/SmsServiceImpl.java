package com.study.springmvc.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.study.springmvc.common.constant.sms.SmsConstant;
import com.study.springmvc.common.constant.sms.SmsState;
import com.study.springmvc.common.constant.sms.SmsType;
import com.study.springmvc.common.exception.BusiException;
import com.study.springmvc.common.sms.SmsMessageInterface;
import com.study.springmvc.controller.command.sms.SendSmsCommand;
import com.study.springmvc.controller.command.sms.VerifySmsCommand;
import com.study.springmvc.controller.dto.sms.SendSmsDto;
import com.study.springmvc.dal.faces.SmsDao;
import com.study.springmvc.dal.model.UserModel;
import com.study.springmvc.dal.model.sms.SmsFlowModel;
import com.study.springmvc.service.faces.SmsService;
import com.study.springmvc.service.faces.UserService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class SmsServiceImpl implements SmsService {

	@Autowired
	private SmsDao smsDao;
	
	@Autowired
	private SmsMessageInterface smsMessageInterface;
	
	@Autowired
	private UserService uerService;
	
	@Override
	@Transactional
	public SendSmsDto sendMessage(SendSmsCommand command) {
		if(SmsType.FAST_MOBILE_REGISTER.equals(command.getSmsType())){
			//手机快速注册发送短信验证码
			return sendSmsForFastRegister(command);
		}else if(SmsType.FORGET_PWD.equals(command.getSmsType())){
			//手机找回密码发送短信验证
			return sendSmsForForgetPwd(command);
		}
		return null;
	}
	
	private SendSmsDto commonSendSms(SendSmsCommand command){
		//返回短信结果
		SendSmsDto result=new SendSmsDto();
		//获取验证码
		String verifyCode=smsMessageInterface.sendMessage(command.getMobile());
		//短信验证码获取成功，更新其他超时验证码状态为超时
		smsDao.updateAllSmsFlowStateFromInitToTimeOut(command.getMobile());
		//快速手机注册发送短信
		SmsFlowModel sms=new SmsFlowModel(command,verifyCode);
		smsDao.saveSmsInfo(sms);
		result.setFlowNo(sms.getFlowNo());
		return result;
	}
	
	//快速注册校验发送短信信息
	private SendSmsDto sendSmsForFastRegister(SendSmsCommand command){
		UserModel user=uerService.queryUserModelByMobile(command.getMobile());
		if(user!=null){
			log.error("手机号={}的用户已存在",command.getMobile());
			throw new BusiException("手机号已注册");
		}
		//发送短信验证码
		return commonSendSms(command);
	}
	
	//忘记密码校验发送短信信息
	private SendSmsDto sendSmsForForgetPwd(SendSmsCommand command){
		UserModel user=uerService.queryUserModelByMobile(command.getMobile());
		if(user==null){
			log.error("手机号={}的用户不存在",command.getMobile());
			throw new BusiException("用户信息不存在");
		}
		//发送短信验证码
		return commonSendSms(command);
	}

	@Override
	@Transactional
	public void verifyMessage(VerifySmsCommand command) {
		if(SmsType.FAST_MOBILE_REGISTER.equals(command.getSmsType())){
			//快速注册手机短信校验
			checkFastRegister( command);
		}else if(SmsType.FORGET_PWD.equals(command.getSmsType())){
			//忘记密码短信校验
			checkForgetPwd(command);
		}
		//短信校验成功更改短信验证码的状态为校验成功
		smsDao.updateSmsFlowState(command.getFlowNo(),SmsState.CHECK_SUCCESS);
	}
	
	//通用短信校验数据
	private void commonCheckSms(SmsFlowModel sms,VerifySmsCommand command){
		if(sms==null){
			log.error("手机号={}，短信流水={}的短信流水不存在",command.getMobile(),command.getFlowNo());
			throw new BusiException("短信流水不存在");
		}
		if(!sms.getMobile().equals(command.getMobile())){
			log.error("手机号={}，短信流水={}的短信手机号不一致，实际手机号={}",command.getMobile(),command.getFlowNo(),sms.getMobile());
			throw new BusiException("手机号已变动");
		}
		if(new Date().getTime()-sms.getCreateTime().getTime()>SmsConstant.SMS_TIME_OUT){
			log.error("手机号={}，短信流水={}，验证码={}的短信验码超时失效",command.getMobile(),command.getFlowNo(),
					command.getVerifyCode());
			throw new BusiException("验证码失效");
		}
		if(!SmsState.INIT.equals(sms.getState())){
			log.error("手机号={}，短信流水={}，验证码={}的短信验码状态失效,状态={}",command.getMobile(),command.getFlowNo(),
					command.getVerifyCode(),sms.getState());
			throw new BusiException("验证码失效");
		}
		if(!sms.getVerifyCode().toLowerCase().equals(command.getVerifyCode().toLowerCase())){
			log.error("手机号={}，短信流水={}，验证码={}的短信验证失败，实际验证码={}",command.getMobile(),command.getFlowNo(),
					command.getVerifyCode(),sms.getVerifyCode());
			throw new BusiException("验证码错误");
		}
		if(!sms.getSmsType().equals(command.getSmsType())){
			log.error("手机号={}，短信流水={}，短信类型={}的短信类型非法，请求验证短信类型={}",command.getMobile(),command.getFlowNo(),
					sms.getSmsType(),command.getSmsType());
			throw new BusiException("短信验证码与操作不匹配");
		}
	}
	//快速注册手机短信校验
	private void checkFastRegister(VerifySmsCommand command){
		SmsFlowModel sms=smsDao.getSmsInfoById(command.getFlowNo());
		commonCheckSms(sms,command);
		
	}
	
	//忘记密码手机短信校验
	private void checkForgetPwd(VerifySmsCommand command){
		SmsFlowModel sms=smsDao.getSmsInfoById(command.getFlowNo());
		commonCheckSms(sms,command);
	}

	@Override
	public SmsFlowModel getLastEffectiveSmsInfoByMobile(Long mobile) {
		return smsDao.getLastEffectiveSmsInfoByMobile(mobile);
	}

	@Override
	public SmsFlowModel getSmsInfoById(Long id) {
		return smsDao.getSmsInfoById(id);
	}

}
