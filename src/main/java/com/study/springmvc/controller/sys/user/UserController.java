package com.study.springmvc.controller.sys.user;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.springmvc.controller.command.user.FastRegisterCommand;
import com.study.springmvc.controller.command.user.ForgetPwdCommand;
import com.study.springmvc.service.faces.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description="用户信息管理接口",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
@Controller
@RequestMapping(value = "sys/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	/***
	 * 快速注册（手机、邮箱、qq号、微信号、微博号等注册）
	 */
	@ApiOperation(value = "快速注册,目前只支持手机注册") 
	@RequestMapping(value = "/register",method=RequestMethod.POST,consumes={MediaType.APPLICATION_JSON_UTF8_VALUE})
	@ResponseBody
	public void fastRegisterUser(@RequestBody @Valid FastRegisterCommand command) {
		userService.fastRegisterUser(command);
	}
	
	/***
	 * 找回密码（手机、邮箱等找回密码）
	 */
	@ApiOperation(value = "找回密码,目前只支持手机短信验证找回密码") 
	@RequestMapping(value = "/forget_pwd",method=RequestMethod.POST,consumes={MediaType.APPLICATION_JSON_UTF8_VALUE})
	@ResponseBody
	public void forgetPwd(@RequestBody @Valid ForgetPwdCommand command) {
		userService.forgerPwdByMobile(command);
	}
	
}
