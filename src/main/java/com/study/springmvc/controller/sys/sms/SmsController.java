package com.study.springmvc.controller.sys.sms;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.springmvc.controller.command.sms.SendSmsCommand;
import com.study.springmvc.controller.command.sms.VerifySmsCommand;
import com.study.springmvc.controller.dto.sms.SendSmsDto;
import com.study.springmvc.dal.model.sms.SmsFlowModel;
import com.study.springmvc.service.faces.SmsService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(description="手机短信接口",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
@Controller
//produces:指定响应数据的内容类型，仅当request请求头中的(Accept)类型中包含该指定类型才返回
@RequestMapping(value = "sys/sms",produces={MediaType.APPLICATION_JSON_UTF8_VALUE})
public class SmsController {
	
	@Autowired
	private SmsService smsService;
	
	/***
	 * 获取短信验证码
	 * @return
	 */
	@ApiOperation(value = "获取短信验证码") 
	@RequestMapping(value = "/code",method=RequestMethod.POST,consumes={MediaType.APPLICATION_JSON_UTF8_VALUE})
	@ResponseBody
	public SendSmsDto sendMessage(@RequestBody @Valid SendSmsCommand command) {
		return smsService.sendMessage(command);
	}
	
	/***
	 * 校验短信验证码
	 * @return
	 */
	@ApiOperation(value = "校验短信验证码") 
	@RequestMapping(value = "/verify_code",method=RequestMethod.POST,consumes={MediaType.APPLICATION_JSON_UTF8_VALUE})
	@ResponseBody
	public void verifyCode(@RequestBody @Valid VerifySmsCommand command) {
		smsService.verifyMessage(command);
	}
	
	/***
	 * 根据手机号获取最新的短信验证码信息
	 */
	@ApiOperation(value = "根据手机号获取最新的短信验证码信息") 
	@RequestMapping(value = "/{mobile}/last_verify_code",method=RequestMethod.GET)
	@ResponseBody
	public SmsFlowModel verifyCode(@ApiParam(value = "手机号",required=true,example="15201857832") @PathVariable(value="mobile",required=true) Long mobile) {
		return smsService.getLastEffectiveSmsInfoByMobile(mobile);
	}
}
