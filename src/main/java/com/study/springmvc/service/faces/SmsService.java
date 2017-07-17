package com.study.springmvc.service.faces;

import com.study.springmvc.controller.command.sms.SendSmsCommand;
import com.study.springmvc.controller.command.sms.VerifySmsCommand;
import com.study.springmvc.controller.dto.sms.SendSmsDto;
import com.study.springmvc.dal.model.sms.SmsFlowModel;

/***
 * 短信管理服务
 * @author shibaomi
 */
public interface SmsService {
	
	/**
	 * 发送短信验证码吗
	 */
	SendSmsDto sendMessage(SendSmsCommand command);
	
	/**
	 * 校验短信验证码
	 */
	void verifyMessage(VerifySmsCommand command);
	
	/**
	 * 根据手机号查询最新有效的短信消息
	 */
	public SmsFlowModel getLastEffectiveSmsInfoByMobile(Long mobile);
	
	/**
	 * 根据流水id查询短信消息
	 */
	public SmsFlowModel getSmsInfoById(Long id);

}
