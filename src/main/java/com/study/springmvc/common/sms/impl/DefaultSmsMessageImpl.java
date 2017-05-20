package com.study.springmvc.common.sms.impl;

import org.springframework.stereotype.Component;

import com.study.springmvc.common.sms.SmsMessageInterface;
import com.study.springmvc.common.utils.VerifyCodeUtils;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DefaultSmsMessageImpl implements SmsMessageInterface{

	@Override
	public String sendMessage(Long mobile) {
		log.info("发送短信的手机号={}",mobile);
		String code=VerifyCodeUtils.generateVerifyCode(4);
		log.info("手机号={}的短信验证码={}",mobile,code);
		return code;
	}

}
