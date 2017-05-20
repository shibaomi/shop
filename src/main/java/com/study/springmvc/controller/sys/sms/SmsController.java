package com.study.springmvc.controller.sys.sms;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.springmvc.controller.command.sms.SendSmsCommand;
import com.study.springmvc.controller.command.sms.VerifySmsCommand;
import com.study.springmvc.controller.dto.sms.SendSmsDto;
import com.study.springmvc.dal.model.sms.SmsFlowModel;
import com.study.springmvc.service.faces.SmsService;

@Controller
@RequestMapping(value = "sys/sms")
public class SmsController {
	
	@Autowired
	private SmsService smsService;
	
	/***
	 * 获取短信验证码
	 * @return
	 */
	@RequestMapping(value = "/code")
	@ResponseBody
	public SendSmsDto sendMessage(@Valid @RequestBody SendSmsCommand command,BindingResult result) {
		if(result.hasErrors()){
			System.out.println(result.getAllErrors());
		}
		return smsService.sendMessage(command);
	}
	
	/***
	 * 校验短信验证码
	 * @return
	 */
	@RequestMapping(value = "/verify_code")
	@ResponseBody
	public void verifyCode(@RequestBody VerifySmsCommand command) {
		smsService.verifyMessage(command);
	}
	
	/***
	 * 根据手机号获取最新的短信验证码信息
	 */
	@RequestMapping(value = "/{mobile}/last_verify_code")
	@ResponseBody
	public SmsFlowModel verifyCode(@PathVariable("mobile") Long mobile) {
		return smsService.getLastEffectiveSmsInfoByMobile(mobile);
	}
	
}