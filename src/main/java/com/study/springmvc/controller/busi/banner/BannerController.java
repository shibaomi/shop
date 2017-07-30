package com.study.springmvc.controller.busi.banner;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.springmvc.controller.command.sys.user.FastRegisterCommand;
import com.study.springmvc.controller.command.sys.user.ForgetPwdCommand;
import com.study.springmvc.controller.command.sys.user.LoginCommand;
import com.study.springmvc.controller.common.JwtUtils;
import com.study.springmvc.dal.model.sys.user.UserModel;
import com.study.springmvc.service.faces.sys.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description="轮播图管理接口",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
@Controller
public class BannerController {
	
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
	
	/***
	 * 登录接口，支持用户编号、证件号、手机登录
	 */
	@ApiOperation(value = "登录接口，支持用户编号、证件号、手机登录") 
	@RequestMapping(value = "/login",method=RequestMethod.POST,consumes={MediaType.APPLICATION_JSON_UTF8_VALUE})
	@ResponseBody
	public UserModel login(@RequestBody @Valid LoginCommand command,HttpServletResponse response) {
		UserModel user=userService.login(command);
		response.setHeader("token", JwtUtils.createJWT(user));
		return user;
	}
	
}
