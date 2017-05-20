package com.study.springmvc.common.sms;

public interface SmsMessageInterface {
	
	/**
	 * 发送短信，返回验证码
	 */
	public String sendMessage(Long mobile);
}
