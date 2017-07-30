package com.study.springmvc.controller.sys.user;

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
import com.study.springmvc.service.faces.sys.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

//@Controller
//@RequestMapping(value = "sys/user")
public class UserController {
	
	@Autowired
	private UserService userService;
}
