package com.study.springmvc.controller.sys.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.springmvc.common.db.page.QueryCondition;
import com.study.springmvc.common.utils.Page;
import com.study.springmvc.controller.command.FastRegisterCommand;
import com.study.springmvc.dal.model.UserModel;
import com.study.springmvc.dal.model.sms.SmsFlowModel;
import com.study.springmvc.service.faces.UserService;

@Controller
@RequestMapping(value = "sys/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	/***
	 * 手机快速注册
	 */
	@RequestMapping(value = "/{mobile}/last_verify_code")
	@ResponseBody
	public void verifyCode(@PathVariable("mobile") Long mobile) {
//		smsService.getLastEffectiveSmsInfoByMobile(mobile);
	}
	
}
