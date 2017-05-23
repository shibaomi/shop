package com.study.springmvc.controller.sys.user;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.springmvc.controller.command.user.FastRegisterCommand;
import com.study.springmvc.service.faces.UserService;

@Controller
@RequestMapping(value = "sys/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	/***
	 * 快速注册（手机、邮箱、qq号、微信号、微博号等注册）
	 */
	@RequestMapping(value = "/register")
	@ResponseBody
	public void fastRegisterUser(@RequestBody @Valid FastRegisterCommand command) {
		userService.fastRegisterUser(command);
	}
	
}
